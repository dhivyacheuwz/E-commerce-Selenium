package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

 WebDriver driver;

	public WaitUtils(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement waitForElementClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement waitForVisibility(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void type(WebDriver driver, By locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
	}

	public static void click(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}


	public static String getText(WebDriver driver,By locator) {
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
			
		
	}
	 public static  void blockAdsContinuously(WebDriver driver) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;

		    js.executeScript(
		        "setInterval(() => {" +
		        "document.querySelectorAll(\"iframe, div[id^='aswift']\").forEach(el => el.remove());" +
		        "}, 500);"
		    );
		    
		    js.executeScript(
		            "document.querySelectorAll('ins.adsbygoogle').forEach(el => {" +
		            "  if (window.getComputedStyle(el).position === 'fixed') {" +
		            "    el.remove();" +
		            "  }" +
		            "});"
		        );
		}	

	 public static void safeClick(WebDriver driver, By locator) {


		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 blockAdsContinuously(driver);

		    WebElement element = wait.until(
		        ExpectedConditions.presenceOfElementLocated(locator)
		    );

		    // Scroll into view
		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({block:'center'});", element
		    );

		    try {
		        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		    } catch (Exception e) {
		        // Fallback (this is key)
		        ((JavascriptExecutor) driver).executeScript(
		            "arguments[0].click();", element
		        );
		    }
	 }}
	 
