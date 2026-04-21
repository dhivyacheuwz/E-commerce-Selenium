package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class ProductPage {

	By add_to_cart = By.xpath("(//*[contains(@class,'cart')])[2]");
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void add_cart() {

		WaitUtils.safeClick(driver, add_to_cart);

	}

}
