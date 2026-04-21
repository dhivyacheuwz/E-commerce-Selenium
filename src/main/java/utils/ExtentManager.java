package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		if (extent == null) {

			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

			String path = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";

			ExtentSparkReporter spark = new ExtentSparkReporter(path);
			spark.config().setReportName("Automation Report");
			spark.config().setDocumentTitle("Test Results");

			extent = new ExtentReports();
			extent.attachReporter(spark);
		}

		return extent;
	}
}