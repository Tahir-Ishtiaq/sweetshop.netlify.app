package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Sweets;
public class Home extends BaseClass{
    public Home(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/sweets']")
    public WebElement sweets;

    @FindBy(xpath = "//a[@href='/about']")
    public WebElement about;

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement login;

    @FindBy(xpath = "//a[@href='/basket']")
    public WebElement basket;

    @FindBy(xpath = "//a[@data-name= 'Chocolate Cups']")
    public WebElement firstItem;

    public <T extends BaseClass> T clickOnOption( Class<T> Class) {
        clickOn(sweets);
        return selectClass(Class);
    }

    public <T extends BaseClass>T clickOnAnyItem(Class<T> Class){
        //clickOn(Sweets.firstItem);
        clickOn(firstItem);
        clickOn(basket);
        return selectClass(Class);

    }

}
