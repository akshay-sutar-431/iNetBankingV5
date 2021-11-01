package test.cases;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.objects.AddCustomerPage;
import page.objects.DeleteCustomerPage;
import page.objects.EditCustomerPage;
import page.objects.LoginPage;

public class TC_DeleteCustomerTest_005 extends BaseClass{

    @BeforeClass
    public void login() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(userName);
        lp.setPassword(password);
        logger.info("Username and password Provided");
        lp.clickSubmit();

        logger.info("User has logged");
        Thread.sleep(1000);
    }

    @Test
    public void deleteCustomerId() throws InterruptedException {
        DeleteCustomerPage dcp = new DeleteCustomerPage(driver);
        dcp.clickOnDeleteCustomer();
        Thread.sleep(2000);
        dcp.setCustomerId("37956");
        logger.info("Customer Id Provided");
        dcp.clickOnSubmitButton();

        if(isAlertPresent())
        {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();

            if(alertText.contains("delete this Customer?"))
            {
                alert.accept();
                //driver.switchTo().defaultContent();
                if (isAlertPresent())
                {
                    Alert alert1 = driver.switchTo().alert();
                    String text = alert1.getText();
                    if(text.contains("Customer does not exist!!"))
                    {
                        logger.info("Customer does not exist!!");
                        alert.accept();
                        driver.switchTo().defaultContent();
                        Assert.fail();
                    }
                    else if (text.contains("Customer deleted Successfully"))
                    {
                        logger.info("Customer deleted Successfully");
                        alert.accept();
                        driver.switchTo().defaultContent();
                        Assert.assertTrue(true);
                    }
                }
                else
                {
                    logger.info("Something wrong!!");
                    Assert.fail();
                }
            }
            else
            {
                alert.dismiss();
            }
        }
        else
        {
            logger.info("Alert Not present");
            Assert.fail();
        }
    }

}
