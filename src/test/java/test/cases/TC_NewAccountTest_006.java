package test.cases;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import page.objects.NewAccountPage;
import utilities.XLUtils;

import java.io.IOException;

public class TC_NewAccountTest_006 extends BaseClass {
    @Test
    public void addNewAccount() throws InterruptedException, IOException {
        login();

        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.clickOnNewAccount();
        logger.info("Clicked on New Account");
        Thread.sleep(2000);
        cid = getCustomerIdFromSheet("Added");
        logger.info("Customer Id : " + cid);
        newAccountPage.setCustomerId(cid);
        newAccountPage.selectAccountType("Savings");
        newAccountPage.setInitialDeposit("20000");
        newAccountPage.clickOnSubmitButton();
        logger.info("Customer Id and Account info provided");
        Thread.sleep(2000);

        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            String text = alert.getText();

            if (text.contains("Customer does not exist")) {
                logger.info("Customer Id does not exist!");
                driver.switchTo().defaultContent();
                Assert.fail();
            } else {
                logger.info(alert.getText());
                driver.switchTo().defaultContent();
                Assert.fail();
            }

        } else {
            if (driver.getPageSource().contains("Account Generated Successfully")) {
                logger.info("Account Generated Successfully!!");
                accountId = newAccountPage.getAccountId();
                XLUtils.setCellData(path, "sheet1", 6, cid, accountId);
                String sc = "addNewAccount" + accountId + "";
                captureScreenshot(driver, sc);
                Assert.assertTrue(true);
            } else {
                logger.info("Failed to create new Account!");
                Assert.fail();
            }

        }
    }

}
