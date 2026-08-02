package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Basket extends BaseClass{
    public Basket(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//label[@for='firstName']/following-sibling::input")
    WebElement firstName;

    @FindBy(xpath = "//label[@for='lastName']/following-sibling::input")
    WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='address']")
    public WebElement addressInput;

    @FindBy(xpath = "//input[@id='zip']")
    public WebElement zipInput;

    @FindBy(xpath = "//input[@id='cc-name']")
    public WebElement ccNameInput;

    @FindBy(xpath = "//input[@id='cc-number']")
    public WebElement ccNumberInput;

    @FindBy(xpath = "//input[@id='cc-expiration']")
    public WebElement ccExpirationInput;

    @FindBy(xpath = "//input[@id='cc-cvv']")
    public WebElement ccCvvInput;

    @FindBy(xpath = "//button[text()='Confirm Order']")
    WebElement ConfirmOrder;

    @FindBy(xpath = "//a[@onclick='emptyBasket();']")
    WebElement emptyBasket;

    public void placeOrder(String fName, String lName,String email, String address, String zip, String ccName, String ccNumber, String ccExpiration, String ccCvv, String text){
        String[] fields = {"email","address","zip","cc-name","cc-number","cc-expiration","cc-cvv"};
        String[] values = {"user@test.com", "123 Street", "90210", "Jane Doe", "4000000000000000", "05/29", "999"};
        inputValue(firstName,fName);
        inputValue(lastName, lName);
        inputValue(emailInput, email);
        inputValue(addressInput, address);
        inputValue(zipInput, zip);
        inputValue(ccNameInput, ccName);
        inputValue(ccNumberInput, ccNumber);
        inputValue(ccExpirationInput, ccExpiration);
        inputValue(ccCvvInput, ccCvv);
        clickOn(ConfirmOrder);
        checkText(text);
    }

    public void EmptyCart(){
        clickOn(emptyBasket);
        handleAlert();

    }
}
