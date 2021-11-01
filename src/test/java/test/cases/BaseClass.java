package test.cases;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import page.objects.EditCustomerPage;
import page.objects.LoginPage;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    ReadConfig rc = new ReadConfig();

    public String baseUrl = rc.getApplicationURL();
    public String userName = rc.getUserName();
    public String password = rc.getPassword();
    public String chromepath = rc.getChromePath();
    public String iepath = rc.getIEPath();
    public String firefoxpath = rc.getFirefoxPath();
    public String cid ;
    String accountId;

    public static WebDriver driver;

    EditCustomerPage ecp;

    public static Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {
        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromepath);
            driver = new ChromeDriver();
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", firefoxpath);
            driver = new FirefoxDriver();
        }

        if (br.equals("ie")) {
            System.setProperty("webdriver.ie.driver", iepath);
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //logger.info("url is opened");

        logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("log4j.properties");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void captureScreenshot(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ne) {
            return false;
        }
    }

    public void login() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(userName);
        lp.setPassword(password);
        logger.info("Username and password Provided");
        lp.clickSubmit();

        logger.info("User has logged");
        Thread.sleep(1000);
    }
}
