package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
    WebDriver driver;

    public NewAccountPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[contains(text(),'New Account')]")
    @CacheLookup
    WebElement newAccount;

    @FindBy(xpath="//tbody/tr[2]/td[2]/input[1]")
    @CacheLookup
    WebElement customerId;

    @FindBy(xpath="//tbody/tr[3]/td[2]/select[1]")
    @CacheLookup
    WebElement accountTypeDropdown;

    @FindBy(xpath="//tbody/tr[4]/td[2]/input[1]")
    @CacheLookup
    WebElement initialDeposit;

    @FindBy(xpath="//tbody/tr[5]/td[2]/input[1]")
    @CacheLookup
    WebElement submitButton;

    @FindBy(xpath="//tbody/tr[5]/td[2]/input[2]")
    @CacheLookup
    WebElement resetButton;

    @FindBy(xpath="//a[contains(text(),'Home')]")
    @CacheLookup
    WebElement home;

    @FindBy(xpath="//tbody/tr[4]/td[2]")
    @CacheLookup
    WebElement accountId;

    // ************* Actions *****************

    public void clickOnNewAccount()
    {
        newAccount.click();
    }

    public String getAccountId()
    {
        return accountId.getText();
    }

    public  void setCustomerId(String cid)
    {
        customerId.sendKeys(cid);
    }

    public void selectAccountType(String type)
    {
        Select select = new Select(accountTypeDropdown);

        if(type.contains("savings"))
        {
            select.selectByVisibleText("Savings");
        }
        if(type.contains("current"))
        {
            select.selectByVisibleText("Current");
        }
    }

    public void setInitialDeposit(String deposit)
    {
        initialDeposit.sendKeys(deposit);
    }

    public void clickOnSubmitButton()
    {
        submitButton.click();
    }

    public void clickOnResetButton()
    {
        resetButton.click();
    }
}
