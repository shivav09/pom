package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pages.ContactPage;
import pages.LandingPage;
import pages.LoginPage;

public class LandingTest extends BaseClass {

	public static LandingPage landingPage;
	public static LoginPage loginPage;
	public static ContactPage contactPage;
	Logger log = Logger.getLogger(LandingTest.class);

	@BeforeTest
	public void setUp() {
		initialize();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
		contactPage = new ContactPage();
		loginPage.navigateToLoginPage();
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyPageTitle() {
		Assert.assertEquals(landingPage.verifyPageTitle(), "Cogmento CRM");

	}

	@Test(priority = 2)
	public void navigateToContacts() {
		landingPage.clickOnContacts();
		waitForElement(500);
		Assert.assertTrue(contactPage.verifyContctsScreen());
		log.info("Navigated to contact screen");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
