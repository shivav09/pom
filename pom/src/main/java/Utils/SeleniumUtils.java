package Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	WebDriver driver;
	Actions actions;

	public SeleniumUtils(WebDriver dvr) {
		driver = dvr;

	}

	public void pageLoadTime(long time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public WebElement findByXpath(String path) {
		return driver.findElement(By.xpath(path));
	}

	public List<WebElement> findElementsByXpath(String path) {
		return driver.findElements(By.xpath(path));
	}

	public void waitForElement(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mouseHoverAndClick(WebElement moveTo, WebElement clickElement) {
		actions = new Actions(driver);
		actions.moveToElement(moveTo).click(clickElement).build().perform();
	}

	public void mouseHoverOnElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void waitForLinkTobePresent(String expression) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(expression)));

	}

	public void waitForXpathPresent(String path) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
	}

	public void waitForElementToClickable(String path) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));

	}

	public void selectByText(String dropdownPath, String text) {
		Select select = new Select(driver.findElement(By.xpath(dropdownPath)));
		select.selectByValue(text);
	}

	public void selectByIndex(String dropDownPath, int index) {
		Select select = new Select(driver.findElement(By.xpath(dropDownPath)));
		select.selectByIndex(index);
	}

	public void selectByVisibleText(String dropDownPath, String text) {
		Select select = new Select(driver.findElement(By.xpath(dropDownPath)));
		select.selectByVisibleText(text);
	}

	public void clickOnTabKey() {
		actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).perform();
	}

	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}

	public void swithToDefault() {
		driver.switchTo().defaultContent();
	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
		javascriptExecutor.executeScript("arguments[0].style.border='2px solid yellow'", element);
	}

	public void scrollDownJavaScript() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public void scrollUpJavaScript() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

	}

	public void scrollByXYPosition(String Xposition, String Yposition) {
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
		javascriptExecutor.executeScript("window.scrollTo(" + Xposition + "," + Yposition + ")");
	}

	public void scrollToElement(WebElement webElement) {
		JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) driver);
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}

}
