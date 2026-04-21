package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import factory.DriverFactory;
import utils.ConfigReader;

public class LoginPage {

	By loginLink = By.xpath("//a[text()=' Signup / Login']");
	By email = By.xpath("//input[@data-qa='login-email']");
	By password = By.xpath("//input[@data-qa='login-password']");
	By loginBtn = By.xpath("//button[@data-qa='login-button']");
	By Login_page_text = By.xpath("//div[@class='login-form']/h2");
	By feature = By.xpath("//div[@class='features_items']");
	By logoutBtn = By.xpath("//*[@href='/logout']");
	By error = By.xpath("//*[text()='Your email or password is incorrect!']");

	public void log_link() {

		DriverFactory.getDriver().findElement(loginLink).click();
	}

	public void login(String user, String pass) {

		DriverFactory.getDriver().findElement(email).sendKeys(user);
		DriverFactory.getDriver().findElement(password).sendKeys(pass);
		DriverFactory.getDriver().findElement(loginBtn).click();

	}

	public String user_login_page() throws InterruptedException {

		String landing_value = DriverFactory.getDriver().findElement(Login_page_text).getText();
		return landing_value;

	}

	public String account_created() {

		By acc = By.xpath("//div[@class='col-sm-9 col-sm-offset-1']/h2/b");
		return acc.toString();
	}

	public void logout() {

		DriverFactory.getDriver().findElement(logoutBtn).click();
	}

	public boolean homepage() {

		String expectedUrl = ConfigReader.get("expectedhome");
		String actualUrl = DriverFactory.getDriver().getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		return true;
	}

	public String errormsg() {
		return DriverFactory.getDriver().findElement(error).getText();

	}

}
