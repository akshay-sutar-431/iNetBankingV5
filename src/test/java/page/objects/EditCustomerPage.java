package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver driver;
	
	public EditCustomerPage(WebDriver driver)
	{
		this.driver=driver;
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
	WebElement clickOnSubmitButton;
	
	@FindBy(xpath = "//tbody/tr[11]/td[2]/input[2]")
	@CacheLookup
	WebElement clickOnResetButton;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	@CacheLookup
	WebElement home;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logout;
	
	/* Actions */
	
	public void clickOnLogout()
	{
		logout.click();
	}
	
	public void clickOnHome()
	{
		home.click();
	}
	
	public void clickOnEditCustomer()
	{
		editCustomer.click();
	}
	
	public void setCustomerId(String cid)
	{
		customerId.sendKeys(cid);
	}
	
	public void clickOnSubmitButton()
	{
		clickOnSubmitButton.click();
	}
	
	public void clickOnResetButton()
	{
		clickOnResetButton.click();
	}
}
