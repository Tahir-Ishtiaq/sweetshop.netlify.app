package testCases;

//cd "C:\Users\Tahir\Downloads\QA Automation\sweetshop.netlify.app"
//Get-Content target/logs/automation.log -Wait

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.*;

public class TestNG extends BeforeTest{
    WebDriver driver;
    private static final Logger logger =
            LoggerFactory.getLogger(TestNG.class);
    @Test
    public void AddAndCheck(){
        try{
            logger.info("Starting Testcase1 !!");
            home.clickOnOption(Sweets.class).clickOnItems();
            logger.info("Testcase1 successfully Passed !!");
        }catch (Exception e){
            logger.error("TestCase1 FAILED!!", e);
        }

    }

    @Test
    public void OrderTheChocolate(){
        home.clickOnAnyItem(Basket.class).placeOrder("Tahir", "Ishtiaq","user@test.com", "123 Street", "90210", "Tahir", "4000000000000000", "05/29", "999", "Thank you!");
    }
}
