package Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import baseClass.BaseClass;

public class ExtentReportNg extends BaseClass implements ITestListener {

	public ExtentReports extent;
	public ExtentTest extentTest;
	public Utilities utils;

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
		extent.close();

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		utils = new Utilities();
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Shiva Vallabhaneni");
		extent.addSystemInfo("User Name", "shivav09");
		extent.addSystemInfo("Environment", "Windows 10");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
			try {
				String screenshotPath = utils.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		extent.endTest(extentTest);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "TEST CASE SKIPPED IS " + result.getName());
		}
		extent.endTest(extentTest);
	}

	@Override
	public void onTestStart(ITestResult res) {
		extentTest = extent.startTest(res.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "TEST CASE PASSED IS " + result.getName());
			// To add screenshot for passed test cases un-comment the below the
			// code
			/*
			 * try { String screenshotPath = utils.getScreenshot(driver,
			 * result.getName()); extentTest.log(LogStatus.PASS,
			 * extentTest.addScreenCapture(screenshotPath)); } catch
			 * (IOException e) { e.printStackTrace(); }
			 */
		}
		extent.endTest(extentTest);
	}

}
