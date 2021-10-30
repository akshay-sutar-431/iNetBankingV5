package test.cases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.objects.EditCustomerPage;
import page.objects.LoginPage;

public class TC_EditCustomerTest_004 extends BaseClass {

	@BeforeTest
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
	public void editCustomerWithId() throws InterruptedException {

		ecp.setCustomerId("75974");

		ecp.clickOnSubmitButton();

		if (isAlertPresent() == true) {
			Alert alert = driver.switchTo().alert(); // switch to alert window
			String text = alert.getText();

			if (text.equalsIgnoreCase("Customer does not exist!!")) {
				logger.warn("Customer ID not found");
				alert.accept();
				Assert.assertTrue(false);
				driver.switchTo().defaultContent(); // focus on main window
			} else if (text.equalsIgnoreCase("You are not authorize to edit this customer!!")) {
				logger.warn("Customer ID found but Authorization Required");
				alert.accept();
				Assert.assertTrue(true);
				driver.switchTo().defaultContent(); // focus on main window
			}

		} else {
			logger.warn("Customer ID found but Authorization Required");
			Assert.assertTrue(true);
		}
	}

	@Test
	public void editCustomerWithoutEnteringCId() {

		ecp.clickOnSubmitButton();
		
		if(isAlertPresent())
		{
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			if(text.equalsIgnoreCase("Please fill all fields"))
			{
				logger.warn("Fill all fields-Passed");
				alert.accept();
				Assert.assertTrue(true);
				driver.switchTo().defaultContent(); // focus on main window
			}
			else
			{
				logger.warn("Fill all fields-Failed");
				alert.accept();
				Assert.assertTrue(false);
				driver.switchTo().defaultContent(); // focus on main window
			}
		}
		else
		{
			logger.warn("Alert not present-Test case failed");
			Assert.assertTrue(false);
			driver.switchTo().defaultContent(); // focus on main window
		}
	}
	
	@AfterTest
	public void logout()
	{
		ecp.clickOnLogout();
	}

}
