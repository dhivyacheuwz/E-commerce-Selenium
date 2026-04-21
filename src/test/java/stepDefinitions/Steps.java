
package stepDefinitions;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.model.Log;

import factory.DriverFactory;
import hooks.Hooks;
import io.cucumber.java.en.*;
import model.PaymentData;
import pages.CartPage;
import pages.CheckoutPage;
import pages.Homepage;
import pages.LoginPage;
import pages.Paymentpage;
import pages.ProductPage;
import utils.ConfigReader;
import utils.ExcelUtils;
import utils.JsonReader;
import utils.LoggerUtils;
import utils.ScreenshotUtils;

public class Steps {
	WebDriver driver = DriverFactory.getDriver();
	LoginPage login = new LoginPage();
	Homepage home = new Homepage(driver);
	ProductPage pro = new ProductPage(driver);
	CartPage cart = new CartPage(driver);
	CheckoutPage Checkout = new CheckoutPage(driver);
	Paymentpage Payment = new Paymentpage(driver);
	Logger log = LoggerUtils.getLogger(Steps.class);

	@Given("^user is on login page$")
	public void open() throws InterruptedException {
		login.log_link();
		try {
			log.info("User is on login page");
			Hooks.test.info("User is on login page");
			assert login.user_login_page().toString().equals("Login to your account");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("^user enters data from excel and logs in$")
	public void loginStep() throws InterruptedException {
		log.info("Entering credentials");
		Hooks.test.info("User is entering login credential");
		String path = System.getProperty("user.dir") + ConfigReader.get("ExcelFileLocation");
		Object[][] data = ExcelUtils.getTestData(path, "Sheet1");

		System.out.println("Data length: " + data.length);

		for (int i = 0; i < data.length; i++) {

			String Username = data[i][0].toString();
			String Password = data[i][1].toString();
			String Expected = data[i][2].toString();

			System.out.println(Username + " | " + Password + " | " + Expected);

			// Perform login
			login.login(Username, Password);
			if (Expected.equalsIgnoreCase("success")) {
				login.homepage();
				if (i != data.length - 1) {
					login.logout();
				}
			} else {
				login.errormsg();
				ScreenshotUtils.capture(driver, Username);
				System.out.println(login.errormsg());
			}
		}

	}

	@When("user adds a product to cart")
	public void user_adds_a_product_to_cart() throws InterruptedException {
		log.info("looking a product details");
		Hooks.test.info("looking a product in detail");
		home.buyproduct();
		System.out.println("product clicked");

	}

	@When("user proceeds to checkout")
	public void user_proceeds_to_checkout() throws InterruptedException {
		log.info("Adding a product to cart");
		Hooks.test.info("Adding a product to cart");
		pro.add_cart();

	}

	@When("user enters checkout details")
	public void user_enter_checkout_details() throws InterruptedException {
		log.info("user clicks checkout");
		Hooks.test.info("user clicks checkout");
		cart.clickCheckout();
		Checkout.clickCheckout();
	}

	@And("user enter payment details from json")
	public void user_enter_payment_details_from_json() throws InterruptedException {

		log.info("user enter payment details");
		Hooks.test.info("user enter payment details");
		String path = System.getProperty("user.dir") + ConfigReader.get("JsonPay");
		List<PaymentData> payments = JsonReader.getPaymentData(path);

		for (PaymentData data : payments) {
			Payment.enterPaymentDetails(data);
			Payment.clickPay();
		}
	}

	@Then("Order is placed successfully")
	public void Order_is_placed_successfully() throws InterruptedException {

		log.info("order placed successfully after payment");
		Hooks.test.info("order placed successfully after payment");
		Payment.isPaymentSuccessful();

	}
}
