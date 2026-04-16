package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	static WebDriver driver;

	public WaitUtils(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement waitForElementClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement waitForVisibility(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void type(WebDriver driver, By locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
	}

	public static void click(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public static void isElementVisible(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
		} catch (Exception e) {
			
		}
	}
	public static String getText(WebDriver driver,By locator) {
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
			
		
	}

	 public static void safeClick(WebDriver driver, By locator) {
 {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 🔥 remove ads
		((JavascriptExecutor) driver).executeScript("document.querySelectorAll('iframe').forEach(e => e.remove());");

		// wait for element
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		// scroll
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// click
		element.click();
	}
}}
