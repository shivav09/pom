package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	private WebElement loginButton;
	
	@FindBy(name="email")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	private WebElement submitBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToLoginPage(){
		loginButton.click();
	}
	public void login(String uName,String pwd){
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		submitBtn.click();
	}

}
