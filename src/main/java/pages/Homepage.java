package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class Homepage {
	WebDriver driver;

	By view_product = By.xpath("(//*[@class='choose']//a)[1]");

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public void buyproduct() throws InterruptedException {

		WaitUtils.safeClick(driver, view_product);

	}
}