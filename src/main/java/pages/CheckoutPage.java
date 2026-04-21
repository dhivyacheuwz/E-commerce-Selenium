package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtils;

public class CheckoutPage {

	By place_order = By.xpath("//*[@class='btn btn-default check_out']");
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCheckout() {

		WaitUtils.blockAdsContinuously(driver);
		WaitUtils.safeClick(driver, place_order);

	}
}
