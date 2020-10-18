package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class SampleReports {

	static ExtentTest test;
	static ExtentReports report;
	public static AndroidDriver<WebElement> driver = null;

	@BeforeClass
	public static void startTest() {
		// Create object of SimpleDateFormat class and decide the format
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String todayDate = dtf1.format(now);
		 System.out.println("Current date and time is " +todayDate);

		report = new ExtentReports(
				System.getProperty("user.dir") + "\\reports\\TestReport"  + todayDate + ".html");
		report.loadConfig(new File("src/main/resources/extent-config.xml"));
		test = report.startTest("Mobile Phone: Ashley Furniture Industries");
        
	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();
	}

	@AfterSuite
	public static void aftrSuit() {
		if (driver != null)
			driver.quit();
	}

	public static String capture(AndroidDriver<WebElement> driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("./reports/images/" + System.currentTimeMillis()+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}
	
//	@SuppressWarnings("unused")
//	private static Tesseract getTesseract() {
//		Tesseract instance = new Tesseract();
//		instance.setDatapath("/usr/local/Cellar/tesseract/4.0.0/share/tessdata");
//		instance.setLanguage("eng");
//		instance.setHocr(true);
//		return instance;
//		}

	public void reportStep(String Description, String status) throws IOException {
		if (status.equalsIgnoreCase("PASS"))
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver)) + Description);
		else if (status.equalsIgnoreCase("FAIL"))
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver)) + Description);
		else if (status.equalsIgnoreCase("WARNING"))
			test.log(LogStatus.WARNING, test.addScreenCapture(capture(driver)) + Description);
		else if (status.equalsIgnoreCase("INFO"))
			test.log(LogStatus.INFO, test + Description);
	}

}
