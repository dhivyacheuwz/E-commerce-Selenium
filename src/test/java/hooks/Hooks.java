/*
 * This is a HOOK class 
 * used to manage setup and tear down
 */
package hooks;

import io.cucumber.java.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import factory.DriverFactory;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.LoggerUtils;
import utils.ScreenshotUtils;

public class Hooks {
	public static ExtentReports extent = ExtentManager.getInstance();
	public static ExtentTest test;

	Logger log = LoggerUtils.getLogger(Hooks.class);
	public static WebDriver driver;

	@BeforeAll
	public static void before_or_after_all() {
		DriverFactory.initbrowser(ConfigReader.get("browser"));
		DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
		DriverFactory.getDriver().manage().window().maximize();
	}

	@Before
	public void beforeScenario(Scenario scenario) {

		test = extent.createTest(scenario.getName());
		log.info("Starting Scenario: " + scenario.getName());
	}

	@After
	public void afterScenario(Scenario scenario) {

		if (scenario.isFailed()) {
			log.error("Scenario Failed: " + scenario.getName());
			test.fail("Scenario Failed");

			ScreenshotUtils.capture(DriverFactory.getDriver(), scenario.getName());

		} else {
			log.info("Scenario Passed: " + scenario.getName());
			test.pass("Scenario Passed");
		}
	}

	@AfterAll
	public static void tearDown() {
		extent.flush();
		DriverFactory.QuitDriver();

	}
}
