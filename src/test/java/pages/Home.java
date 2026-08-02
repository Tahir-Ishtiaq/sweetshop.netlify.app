package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends BaseClass{
    public Home(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/sweets']")
    WebElement sweets;

    @FindBy(xpath = "//a[@href='/about']")
    WebElement about;

    @FindBy(xpath = "//a[@href='/login']")
    WebElement login;

    @FindBy(xpath = "//a[@href='/basket']")
    WebElement basket;

    public Sweets ClickOnSweets(){
        clickOn(sweets);
        return new Sweets(driver);
    }


}
