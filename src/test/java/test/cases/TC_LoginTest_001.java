package test.cases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void loginTest() throws IOException {
		//driver.get(baseUrl);
		logger.info("url is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("username entered");

		lp.setPassword(password);
		logger.info("password entered");

		lp.clickSubmit();
		logger.info("clicked on login button");

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("home page validated");
		}
		else
		{
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
		}
	}
}
