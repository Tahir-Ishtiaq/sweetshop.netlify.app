package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sweets extends BaseClass{
    public Sweets(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@data-name= 'Chocolate Cups']")
    public   WebElement firstItem;

    @FindBy(xpath = "//a[@data-name= 'Sherbert Straws']")
    public  WebElement secondItem;

    @FindBy(xpath = "//a[@href='/basket']")
    WebElement baskit;

    public <T extends BaseClass>T clickOnItems(Class<T> Class){
        clickOn(firstItem);
        checkText("1");
        clickOn(secondItem);
        checkText("2");
        clickOn(baskit);
        return selectClass(Class);
    }
}
