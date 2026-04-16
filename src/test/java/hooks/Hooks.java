/*
 * This is a HOOK class 
 * used to manage setup and tear down
 */
package hooks;

import io.cucumber.java.*;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import utils.ConfigReader;
import utils.ScreenshotUtils;

public class Hooks {

	public static WebDriver driver;
    @Before
    public void setup() {
        DriverFactory.initbrowser(ConfigReader.get("browser"));
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.capture(DriverFactory.getDriver(), scenario.getName());
        }
        DriverFactory.QuitDriver();
    }
}
