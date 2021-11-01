package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
    WebDriver driver;

    public DeleteCustomerPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//body/div[3]/div[1]/ul[1]/li[4]/a[1]")
    @CacheLookup
    WebElement deleteCustomer;

    @FindBy(xpath = "//tbody/tr[2]/td[2]/input[1]")
    @CacheLookup
    WebElement customerId;

    @FindBy(xpath = "//tbody/tr[7]/td[2]/input[1]")
    @CacheLookup
    WebElement submitButton;

    @FindBy(xpath = "//tbody/tr[7]/td[2]/input[2]")
    @CacheLookup
    WebElement resetButton;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    @CacheLookup
    WebElement homeTextLink;

    public void clickOnDeleteCustomer()
    {
        deleteCustomer.click();
    }

    public void setCustomerId(String id)
    {
        customerId.sendKeys(id);
    }

    public void clickOnSubmitButton()
    {
        submitButton.click();
    }

    public void clickOnResetButton()
    {
        resetButton.click();
    }

    public void clickOnHomeTextLink()
    {
        homeTextLink.click();
    }
}
