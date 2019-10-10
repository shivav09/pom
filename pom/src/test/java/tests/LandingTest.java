package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.LandingPage;
import pages.LoginPage;

public class LandingTest extends BaseClass {

	public static LandingPage landingPage;
	public static LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		initialize();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
		loginPage.navigateToLoginPage();
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyUserName() {
		landingPage.verifyUser();

	}

	@Test(priority = 2)
	public void navigateToContacts() {
		landingPage.clickOnContacts();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
