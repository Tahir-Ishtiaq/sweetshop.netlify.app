package testCases;

//cd "C:\Users\Tahir\Downloads\QA Automation\sweetshop.netlify.app"
//Get-Content target/logs/automation.log -Wait

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class TestNG extends BeforeTest{
    WebDriver driver;
    private static final Logger logger =
            LoggerFactory.getLogger(TestNG.class);

    @Test(priority = 1)
    public void AddAndCheck(){
        try{
            logger.info("Starting Testcase1 !!");
            home.clickOnOption(Sweets.class).clickOnItems(Basket.class);
            logger.info("Testcase1 successfully Passed !!");
        }catch (Exception e){
            logger.error("TestCase1 FAILED!!", e);
        }

    }

    @Test(priority = 2)
    public void OrderTheChocolate(){
        try{
            logger.info("Starting Testcase2 !!");
            home.clickOnAnyItem(Basket.class).placeOrder("Tahir", "Ishtiaq","user@test.com", "123 Street", "90210", "Tahir", "4000000000000000", "05/29", "999", "Thank you!");
            logger.info("Testcase2 Successfully Passed !!");
        } catch (Exception e){
            logger.error("TestCase2 FAILED!!", e);
        }

    }

    @Test(priority = 3)
    public void AddAndRemove(){
        try{
            logger.info("Starting Testcase3 !!");
            home.clickOnOption(Sweets.class).clickOnItems(Basket.class).EmptyCart();
            logger.info("Testcase3 Successfully Passed !!");
        }catch (Exception e){
            logger.error("TextCase3 FAILED !!", e);
        }
    }

    @Test(priority = 4)
    public void orderWtihoutDetails(){
        try{
            logger.info("Starting Testcase4 !!");
            home.clickOnAnyItem(Basket.class).orderWithoutDetails(Basket.class);
            logger.info("Testcase4 Successfully Passed !!");
        }catch (Exception e){
            logger.error("TextCase4 FAILED !!", e);
        }
    }

    @Test(priority = 5)
    public void AddingItemsAmount() {
        // 1. Get prices from Home page before navigating
        double item1Price = home.getFirstItemPrice();
        double item2Price = home.getSecondItemPrice();
        double expectedTotal = item1Price + item2Price;
        logger.info("The total is '{}'", expectedTotal);

        // 2. Add items and navigate to Basket Page
        Basket basketPage = home.clickOnAnyItem(Basket.class);

        // 3. Verify basket total matched calculated price
        double actualTotal = basketPage.getDisplayedTotal();
        logger.info("The total is '{}'", actualTotal);
        Assert.assertEquals(actualTotal, expectedTotal, 0.01, "Basket total mismatch!");
    }

    @Test(priority = 6)
    public void GettingLogin(){
        home.clickOnLogin(Login.class).GetLogin("fiveorders@sweetshop.local", "qwerty");
    }
}
