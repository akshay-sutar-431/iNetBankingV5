package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
    WebDriver driver;

    public EditCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Edit Customer')]")
    @CacheLookup
    WebElement editCustomer;

    @FindBy(xpath = "//tbody/tr[6]/td[2]/input[1]")
    @CacheLookup
    WebElement customerId;

    @FindBy(xpath = "//tbody/tr[11]/td[2]/input[1]")
    @CacheLookup
    WebElement submitButton1;

    @FindBy(xpath = "//tbody/tr[11]/td[2]/input[2]")
    @CacheLookup
    WebElement resetButton1;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    @CacheLookup
    WebElement home;

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    @CacheLookup
    WebElement logout;

    @FindBy(xpath = "//tbody/tr[7]/td[2]/textarea")
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
    WebElement submitButton2;

    @FindBy(xpath = "//tbody/tr[13]/td[2]/input[2]")
    @CacheLookup
    WebElement resetButton2;

    //p[contains(text(),'Customer details updated Successfully!!!')]
    @FindBy(xpath = "//p[contains(text(),'Customer details updated Successfully!!!')]")
    @CacheLookup
    WebElement updateTextValidate;

    /* Actions */

    public void clickOnLogout() {
        logout.click();
    }

    public void clickOnHome() {
        home.click();
    }

    public void clickOnEditCustomer() {
        editCustomer.click();
    }

    public void setCustomerId(String cid) {
        customerId.sendKeys(cid);
    }

    public void clickOnSubmitButton1() {
        submitButton1.click();
    }

    public void clickOnResetButton1() {
        resetButton2.click();
    }

    public void setAddress(String address1) {
        address.clear();
        address.sendKeys(address1);
    }

    public void setCity(String city1) {
        city.clear();
        city.sendKeys(city1);
    }

    public void setState(String state1) {
        state.clear();
        state.sendKeys(state1);
    }

    public void setPin(String pin1) {
        pin.clear();
        pin.sendKeys(pin1);
    }

    public void setMobileNo(String mob) {
        mobileNo.clear();
        mobileNo.sendKeys(mob);
    }

    public void setEamil(String email1) {
        email.clear();
        email.sendKeys(email1);
    }

    public void clickOnSubmitButton2() {
        submitButton2.click();
    }

    public void clickOnResetButton2() {
        resetButton2.click();
    }

    public String validateUpdatedDetails() {
        return updateTextValidate.getText();
    }
}
