package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import utils.WaitUtils;

public class CartPage {
	By view_cart=By.xpath("//*[@class='modal-content']/div[2]/p[2]/a");
	By proceed_checkout=By.xpath("//*[@class='btn btn-default check_out']");
	WebDriver driver;
	
	  public CartPage(WebDriver driver) {
	        this.driver = driver;
	    }
	  public void clickCheckout() {
		  
		  try {
			   WaitUtils.waitForVisibility(
			        driver, By.xpath("//div[contains(@class,'modal-content')]")
			    );
			} catch (Exception e) {
			    System.out.println("Modal not appeared");
			}
	        WaitUtils.safeClick(driver,view_cart);
	        WaitUtils.safeClick(driver,proceed_checkout);
	    }

}
