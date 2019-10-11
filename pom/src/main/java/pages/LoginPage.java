package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class LoginPage extends BaseClass {

	Logger log = Logger.getLogger(LoginPage.class);

	@FindBy(xpath = "//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	private WebElement loginButton;

	@FindBy(name = "email")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	private WebElement submitBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void navigateToLoginPage() {
		loginButton.click();
	}

	public void login(String uName, String pwd) {

		try {
			userName.sendKeys(uName);
			password.sendKeys(pwd);
			submitBtn.click();
			waitForElement(500);
			log.info("Logged in Successfully");
		} catch (Exception e) {
			log.debug("Failed to login to system");
			e.printStackTrace();
		}
	}

}
