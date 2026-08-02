package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.Home;

public class BeforeTest {
    private static final Logger logger =
            LoggerFactory.getLogger(BeforeTest.class);
    WebDriver driver;
    Home home;

    @BeforeMethod
    public void login(){
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();

        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        logger.info("Opening Chrome");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Navigating to website");
        driver.get("https://sweetshop.netlify.app");
        logger.info("Google opened successfully: https://automationexercise.com");
        home = new Home(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Closes browser & frees system resources after each test
            logger.info("Browser closed successfully.");
        }
    }
}


