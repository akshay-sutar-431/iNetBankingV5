package test.cases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.*;

import page.objects.AddCustomerPage;
import page.objects.EditCustomerPage;
import page.objects.LoginPage;

import java.io.IOException;

public class TC_EditCustomerTest_004 extends BaseClass {

    @BeforeClass
    public void login() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(userName);
        lp.setPassword(password);
        logger.info("Username and password Provided");
        lp.clickSubmit();

        logger.info("User has logged");
        Thread.sleep(1000);

        ecp = new EditCustomerPage(driver);
        ecp.clickOnEditCustomer();
    }

    @Test
    public void editCustomerWithId() throws IOException, InterruptedException {

        ecp.setCustomerId("37956");

        ecp.clickOnSubmitButton1();

        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert(); // switch to alert window
            String text = alert.getText();

            if (text.contains("Customer does not exist")) {
                logger.warn("Customer ID not found");
                alert.accept();
                driver.switchTo().defaultContent(); // focus on main window
                Assert.fail();

            }
            else if (text.equalsIgnoreCase("You are not authorize to edit this customer!!")) {
                logger.warn("Customer ID found but Authorization Required");
                alert.accept();
                captureScreenshot(driver, "editCustomer");
                driver.switchTo().defaultContent(); // focus on main window
                Assert.assertTrue(true);

            }
            else {
                logger.warn("Customer ID Not found ");
                captureScreenshot(driver, "editCustomer");
                alert.accept();
                driver.switchTo().defaultContent(); // focus on main window
                Assert.fail();

            }
        }
        else {
            logger.warn("Customer ID found ");
            //Assert.assertTrue(true);

            // Changes allowed only for Address, city, state, number, pin, email
            ecp.setAddress("Pune");
            Thread.sleep(1000);
            logger.info("New Address Set");
            ecp.setCity("pune");
            logger.info("New City Set");
            Thread.sleep(1000);
            ecp.setPin("411033");
            logger.info("New Pin Set");
            Thread.sleep(1000);

            ecp.clickOnSubmitButton2();
            Thread.sleep(3000);
            logger.info("Clicked on Submit");

			/*
			boolean res=driver.getPageSource().contains("Customer details updated Successfully!!!");

			if(res)
			{
				logger.info("customer details updated");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Failed to edit customer");
				captureScreenshot(driver,"editCustomer");
				Assert.fail();
			}
			*/

            String vText = ecp.validateUpdatedDetails();
            if (vText.contains("Customer details updated Successfully")) {
                logger.info("customer details updated");
                Assert.assertTrue(true);
            } else {
                logger.info("Failed to edit customer");
                captureScreenshot(driver, "editCustomer");
                Assert.fail();
            }
        }
    }

    @Test
    public void editCustomerWithoutId() {

        ecp.clickOnSubmitButton2();

        // focus on main window
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();
            // focus on main window
            if (text.equalsIgnoreCase("Please fill all fields")) {
                logger.warn("Fill all fields-Passed");
                alert.accept();
                Assert.assertTrue(true);
            } else {
                logger.warn("Fill all fields-Failed");
                alert.accept();
                Assert.fail();
            }
        } else {
            logger.warn("Alert not present-Test case failed");
            Assert.fail();
        }
        driver.switchTo().defaultContent(); // focus on main window
    }

    @Test
    public void validateHomeNavigation()
    {
        ecp.clickOnHome();
    }

}
