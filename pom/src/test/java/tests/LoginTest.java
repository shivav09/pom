package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	static LoginPage loginPage;
	
	@BeforeTest
	public void setUp(){
		initialize();
		loginPage= new LoginPage();
	}

	@Test
	public void loginToCrm(){
		loginPage.navigateToLoginPage();
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
