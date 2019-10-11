package tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.media.sound.InvalidFormatException;

import Utils.ExcelData;
import baseClass.BaseClass;
import pages.ContactPage;
import pages.LandingPage;
import pages.LoginPage;

public class ContactTest extends BaseClass {

	public static LandingPage landingPage;
	public static LoginPage loginPage;
	public static ContactPage contactPage;
	public static ExcelData excelData;
	Logger log = Logger.getLogger(ContactTest.class);

	@BeforeTest
	public void setUp() {
		initialize();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
		contactPage = new ContactPage();
		excelData = new ExcelData();
		loginPage.navigateToLoginPage();
		loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		landingPage.clickOnContacts();
	}

	@DataProvider(name = "ContactDetails")
	public Object[][] contactData() throws InvalidFormatException, IOException {

		Object[][] arrayObject = excelData.getCellData("C://Users//Vallabhaneni//git//pom//pom//resources//CrmData.xls",
				"Contacts");
		return arrayObject;
	}

	@Test(dataProvider = "ContactDetails")
	public void addContacts(String fName, String lName, String email, String phoneNum) {

		contactPage.addButton();
		contactPage.addNewContact(fName, lName, email, phoneNum);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			log.error("Error in adding new contact");
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void takeFailedScreenshots(ITestResult res) {
		if (ITestResult.FAILURE == res.getStatus()) {
			takeScreenshot(res.getInstanceName());
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
