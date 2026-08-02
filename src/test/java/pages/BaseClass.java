package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;

public class BaseClass {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BaseClass(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.info("BaseClass initialized successfully.");
    }

    private void prepareElement(WebElement element) {
        try {
            logger.info("Preparing Elemet to perfrom an expected action on it.");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='2px solid Red'", element);
            Thread.sleep(1000);
            js.executeScript("arguments[0].style.border=''", element);
            logger.info("Element Prepared!");
        } catch (Exception e) {
            logger.error("Unable to Prepare Element due to ", e);
            Thread.currentThread().interrupt();
        }
    }

    public void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }}

    public void inputValue(WebElement locator, String input) {
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
            logger.info("Providing input text: '{}'", input);
            scrollToElement(element);
            prepareElement(element);
            element.clear();
            for (String letter : input.split("")) {
                element.sendKeys(letter);
                pause(50);
            }
            logger.info("Successfully provided input.");
        } catch (Exception e) {
            logger.error("Failed to provide input to the element!", e);
            throw e;
        }
    }

    public void clickOn(WebElement locator) {
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
            scrollToElement(element);
            prepareElement(element);
            pause(1000);
            logger.info("Clicking on the element!");
            element.click();
            handleGoogleVignette();
        } catch (Exception e) {
            logger.error("Unable to click on expected element", e);
            throw e;
        }
    }

    private void handleGoogleVignette() {
        try{
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("#google_vignette")) {
                logger.warn("Google Vignette Ad detected! Forcing page refresh to bypass.");
                driver.navigate().refresh();
            }}
        catch (Exception e){
            logger.error("Unable to handle google Add!", e);
        }
        }

    public void selectDropdownByVisibleText(WebElement locator, String text) {
        logger.info("Selecting from drop down.'{}'",text);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
        prepareElement(element);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
        logger.info("'{}' from Dropdown is selected.", text);
    }

    public void handleAlert() {
        try {
            logger.info("Alert pop-up!");
            // 1. Wait for the alert pop-up to physically appear
            wait.until(ExpectedConditions.alertIsPresent());
            // 2. Switch focus from the webpage to the pop-up box
            Alert alert = driver.switchTo().alert();
            // 3. Click the 'OK' button
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert appeared: " + e.getMessage());
        }
    }

    public void scrollToElement(WebElement locator) {
        try {
            logger.info("Scrolling to expected element");
            // 1. Ensure the element exists in the HTML DOM first
            WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
            // 2. Execute JavaScript to scroll it perfectly into the center of the viewport
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            // Give the smooth scroll animation a split second to finish moving
            Thread.sleep(600);
        } catch (Exception e) {
            logger.error("Could not scroll to element: ",e);
        }
    }

    public void checkText(String text){
        logger.info("Verifying if page contains text: '{}'", text);
        Assert.assertTrue(driver.getPageSource().contains(text),
                "Expected text not found on page: " + text);
        logger.info("Text '{}' found", text);
    }


    public <T extends BaseClass> T selectClass( Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            logger.error("Unable to navigate to page: " + pageClass.getSimpleName(), e);
            throw new RuntimeException("Page instantiation failed: " + pageClass.getName(), e);
        }
    }
}
