package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sweets extends BaseClass{
    public Sweets(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@data-name= 'Chocolate Cups']")
    WebElement firstItem;

    @FindBy(xpath = "//a[@data-name= 'Sherbert Straws']")
    WebElement secondItem;

    @FindBy(xpath = "//a[@href='/basket']")
    WebElement baskit;

    public Basket clickOnItems(){
        clickOn(firstItem);
        checkText("1");
        clickOn(secondItem);
        checkText("2");
        clickOn(baskit);
        return new Basket(driver);
    }
}
