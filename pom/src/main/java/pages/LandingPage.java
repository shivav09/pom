package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class LandingPage extends BaseClass {

	@FindBy(xpath = "//span[@class='user-display']")
	private WebElement userDisplay;

	@FindBy(xpath = "//span[text()='Contacts']")
	private WebElement contactsTab;

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnContacts() {
		contactsTab.click();
	}

}
