package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath = "//a[contains(text(),'New Customer')]")
    @CacheLookup
    WebElement newCustomer;

    @FindBy(xpath = "//tbody/tr[4]/td[2]/input[1]")
    @CacheLookup
    WebElement custName;

    @FindBy(xpath = "//tbody/tr[5]/td[2]/input[1]")
    @CacheLookup
    WebElement genderMale;

    @FindBy(xpath = "//tbody/tr[5]/td[2]/input[2]")
    @CacheLookup
    WebElement genderFeMale;

    @FindBy(xpath = "//input[@id='dob']")
    @CacheLookup
    WebElement dobDatePicker;

    @FindBy(xpath = "//tbody/tr[7]/td[2]/textarea[1]")
    @CacheLookup
    WebElement address;

    @FindBy(xpath = "//tbody/tr[8]/td[2]/input[1]")
    @CacheLookup
    WebElement city;

    @FindBy(xpath = "//tbody/tr[9]/td[2]/input[1]")
    @CacheLookup
    WebElement state;

    @FindBy(xpath = "//tbody/tr[10]/td[2]/input[1]")
    @CacheLookup
    WebElement pin;

    @FindBy(xpath = "//tbody/tr[11]/td[2]/input[1]")
    @CacheLookup
    WebElement mobileNo;

    @FindBy(xpath = "//tbody/tr[12]/td[2]/input[1]")
    @CacheLookup
    WebElement email;

    @FindBy(xpath = "//tbody/tr[13]/td[2]/input[1]")
    @CacheLookup
    WebElement password;

    @FindBy(xpath = "//tbody/tr[14]/td[2]/input[1]")
    @CacheLookup
    WebElement submitButton;

    @FindBy(xpath = "//tbody/tr[14]/td[2]/input[2]")
    @CacheLookup
    WebElement resetButton;

    // Registered customer page
    @FindBy(xpath = "//tbody/tr[4]/td[1]")
    @CacheLookup
    WebElement customerIdAttribute;

    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    @CacheLookup
    WebElement customerIdValue;

    @FindBy(xpath = "//tbody/tr[5]/td[1]")
    @CacheLookup
    WebElement customerNameAttribute;

    @FindBy(xpath = "//tbody/tr[5]/td[2]")
    @CacheLookup
    WebElement customerNameValue;

    @FindBy(xpath = "//tbody/tr[12]/td[1]")
    @CacheLookup
    WebElement customerMobAttribute;

    @FindBy(xpath = "//tbody/tr[12]/td[2]")
    @CacheLookup
    WebElement customerMobValue;

    @FindBy(xpath = "//tbody/tr[13]/td[1]")
    @CacheLookup
    WebElement customerEmailAttribute;

    @FindBy(xpath = "//tbody/tr[13]/td[2]")
    @CacheLookup
    WebElement customerEmailValue;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    @CacheLookup
    WebElement continueButton;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    @CacheLookup
    WebElement homeButton;

    // ***********************************

    public String getCustomerId()
    {
        return customerIdValue.getText();
    }

    public void clickOnNewCustomer()
    {
        newCustomer.click();
    }

    public void setCustomerName(String cname)
    {
        custName.sendKeys(cname);
    }

    public void selectGender(String gender)
    {
        if(gender.equalsIgnoreCase("male"))
        {
            genderMale.click();
        }
        else
        {
            genderFeMale.click();
        }
    }

    public void setDOBDate(String dd, String mm, String yyyy)
    {
        dobDatePicker.sendKeys(dd);
        dobDatePicker.sendKeys(mm);
        dobDatePicker.sendKeys(yyyy);
    }

    public void setAddress(String address1)
    {
        address.sendKeys(address1);
    }

    public void setCity(String city1)
    {
        city.sendKeys(city1);
    }

    public void setState(String state1)
    {
        state.sendKeys(state1);
    }

    public void setPin(String pin1)
    {
        pin.sendKeys(String.valueOf(pin1));
    }

    public void setMobileNo(String mNo)
    {
        mobileNo.sendKeys(mNo);
    }

    public void setEmail(String email1)
    {
        email.sendKeys(email1);
    }

    public void setPassword(String password1)
    {
        password.sendKeys(password1);
    }

    public void clickOnSubmit()
    {
        submitButton.click();
    }

    public void clickOnReset()
    {
       resetButton.click();
    }
}
