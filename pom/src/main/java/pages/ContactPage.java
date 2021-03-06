package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class ContactPage extends BaseClass {

	@FindBy(name = "first_name")
	private WebElement firstName;

	@FindBy(name = "last_name")
	private WebElement lastName;

	@FindBy(xpath = "//label[text()='Email']//following::input[1]")
	private WebElement emailId;

	@FindBy(xpath = "//input[@placeholder='Number']")
	private WebElement phoneNo;

	@FindBy(xpath = "//button[text()='ave']")
	private WebElement saveBtn;

	@FindBy(xpath = "//button[text()='New']")
	private WebElement addBtn;

	@FindBy(xpath = "//div[text()='Contacts']")
	private WebElement contactsScreen;

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	public void addButton() {
		addBtn.click();
	}

	public Boolean verifyContctsScreen() {
		return contactsScreen.isDisplayed();
	}

	public void addNewContact(String fName, String lName, String email, String phoneNum) {
		try {
			firstName.sendKeys(fName);
			lastName.sendKeys(lName);
			emailId.sendKeys(email);
			phoneNo.sendKeys(phoneNum);
			saveBtn.click();
			waitForElement(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
