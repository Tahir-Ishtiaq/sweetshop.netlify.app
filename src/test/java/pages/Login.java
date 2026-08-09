package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BaseClass{
    public Login(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@id='exampleInputEmail']")
    WebElement email;
    @FindBy(xpath = "//input[@id='exampleInputPassword']")
    WebElement password;
    @FindBy(xpath = "//button[@id='btn_login']")
    WebElement loginButton;

    public void GetLogin(String user, String pass){
        inputValue(email, user);
        inputValue(password, pass);
        clickOn(loginButton);
        if(!(user == "fiveorders@sweetshop.local") || !(pass == "qwerty")){
            checkText("Use one of the demo email addresses shown in the tooltip.");
        }
    }

    public void ClickOnlogin(String text){
        clickOn(loginButton);
        checkText(text);
    }
}
