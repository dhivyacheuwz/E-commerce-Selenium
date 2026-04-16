package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import utils.WaitUtils;

public class Homepage {
	WebDriver driver;

	By view_product = By.xpath("(//*[@class='choose'])[1]");

	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void buyproduct() throws InterruptedException {
		WebElement element=driver.findElement(view_product);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		WaitUtils.safeClick(driver,view_product);

	}
}