package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import model.PaymentData;
import utils.WaitUtils;

public class Paymentpage {

	WebDriver driver;

	By name = By.xpath("//*[@name='name_on_card']");
	By cardnumber = By.xpath("//*[@name='card_number']");
	By cvc = By.xpath("//*[@name='cvc']");
	By Expmonth = By.xpath("//*[@name='expiry_month']");
	By Expyear = By.xpath("//*[@name='expiry_year']");
	By pay = By.xpath("//*[@id='submit']");
	By successMsg = By.xpath("//*[text()='Order Placed!']");

	public Paymentpage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterPaymentDetails(PaymentData data) {

	
			WaitUtils.blockAdsContinuously(driver);
			WaitUtils.type(driver, name, data.getNameOnCard());
			WaitUtils.type(driver, cardnumber, data.getCardNumber());
			WaitUtils.type(driver, cvc, data.getCvv());
			WaitUtils.type(driver, Expmonth, data.getExpiryMonth());
			WaitUtils.type(driver, Expyear, data.getExpiryYear());
	
	}

	public void clickPay() {
		
			WaitUtils.blockAdsContinuously(driver);
			WaitUtils.safeClick(driver, pay);
		
	}

	// 🔍 Validation Methods
	public void isPaymentSuccessful() {
		
			WaitUtils.blockAdsContinuously(driver);
			System.out.println(WaitUtils.getText(driver, successMsg));
		
	}

}
