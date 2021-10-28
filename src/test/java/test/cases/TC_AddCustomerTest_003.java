package test.cases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.AddCustomerPage;
import page.objects.LoginPage;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClass{

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(userName);
        lp.setPassword(password);
        logger.info("Username and password Provided");
        lp.clickSubmit();

        logger.info("User has logged");
        Thread.sleep(1000);

        AddCustomerPage acp = new AddCustomerPage(driver);

        acp.clickOnNewCustomer();
        Thread.sleep(1000);
        logger.info("Providing Customer Details");
        acp.setCustomerName("Akshay");
        Thread.sleep(1000);
        acp.selectGender("Male");
        Thread.sleep(1000);
        acp.setAddress("Solapur Near Post");
        Thread.sleep(1000);
        acp.setCity("Solapur");
        Thread.sleep(1000);
        acp.setDOBDate("10","01","1999");
        Thread.sleep(1000);
        acp.setState("Maharashtra");
        Thread.sleep(1000);
        acp.setPin("413208");
        Thread.sleep(1000);
        String email = randomString()+"@gmail.com";

        acp.setEmail(email);
        Thread.sleep(1000);
        acp.setPassword("qAvAvEb");
        Thread.sleep(1000);
        acp.setMobileNo("9874563210");
        Thread.sleep(1000);
        acp.clickOnSubmit();
        Thread.sleep(1000);

        boolean res=driver.getPageSource().contains("Customer Registered Successfully");

        if(res==true)
        {
            Assert.assertTrue(true);
            logger.info("validating customer is added");
        }
        else
        {
            captureScreenshot(driver,"addNewCustomer");
            logger.info("validating customer is Not added");
            Assert.assertTrue(false);
        }
    }

    public String randomString()
    {
        String st=RandomStringUtils.randomAlphabetic(6);
        return st;
    }
    public String randomStringNum()
    {
        String st=RandomStringUtils.randomAlphanumeric(10);
        return st;
    }
}
