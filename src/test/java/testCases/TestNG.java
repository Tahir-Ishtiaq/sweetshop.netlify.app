package testCases;


import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestNG extends BeforeTest{
    WebDriver driver;
    private static final Logger logger =
            LoggerFactory.getLogger(TestNG.class);
    @Test
    public void AddAndCheck(){
        home.ClickOnSweets().clickOnItems();
    }
}
