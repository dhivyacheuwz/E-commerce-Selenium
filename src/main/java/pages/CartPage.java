package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import utils.WaitUtils;

public class CartPage {
	By view_cart = By.xpath("//a[@href='/view_cart']");
	By contshop = By.xpath("//*[@class='modal-content']/div[@class='modal-footer']/button");
	By proceed_checkout = By.xpath("//*[@class='btn btn-default check_out']");
	By modal = By.cssSelector("div.modal-content");
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickCheckout() {

		WaitUtils.blockAdsContinuously(driver);
		WaitUtils.waitForVisibility(driver, modal);
		WaitUtils.click(driver, contshop);
		WaitUtils.safeClick(driver, view_cart);
		WaitUtils.safeClick(driver, proceed_checkout);
	}

}
