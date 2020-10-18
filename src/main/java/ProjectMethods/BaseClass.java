package ProjectMethods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utils.DataInputProvider;
import utils.SampleReports;
public class BaseClass extends SampleReports {


	public WebDriverWait wt;
    public String dataSheetName;
    public Exception e;
    static String scrShotDir = "screenshots";
	  File scrFile;
	  static File scrShotDirPath = new java.io.File("./"+ scrShotDir+ "//");
	  String destFile;


	@BeforeClass
	public void launchapp() throws MalformedURLException,InterruptedException {

		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appPackage", "com.ashleyfurniturehomestore.ecomm.debug");
			dc.setCapability("appActivity", "com.ashleyfurniturehomestore.ecomm.ui.activity.ToolbarActivity");
//			dc.setCapability("deviceName", "Galaxy J2");
//			dc.setCapability("platformVersion", "7.1.1");
			dc.setCapability("deviceName", "Android Emulator");
			dc.setCapability("fullReset",false);
			dc.setCapability("platformVersion", "8.1.0");
			dc.setCapability("platform", "Android");
			dc.setCapability("automationName", "uiautomator2");
			dc.setCapability("noReset", "true");
//			dc.setCapability("app", "D:\\Ecomm-138-(1.20-debug).apk");

			driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

  public void scrolluptodown() {
		Dimension dim = driver.manage().window().getSize();
		
		Double scrollheightstart = dim.getHeight() * 0.8;
		int scrollstart = scrollheightstart.intValue();
		
		Double scrollheightEnd = dim.getHeight() * 0.01;
		int scrollEnd = scrollheightEnd.intValue();
		
		TouchAction<?> action = new TouchAction<>(driver);
		action.press(PointOption.point(0,scrollstart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(8)))
		.moveTo(PointOption.point(0, scrollEnd)).release().perform();
  }
  public void SwipeScreen(WebElement el, AndroidDriver<WebElement> driver) throws InterruptedException {
		WebElement Panel = el;
		Dimension dimension = Panel.getSize();
		
		int Anchor = Panel.getSize().getHeight()/2; 
		
		Double ScreenWidthStart = dimension.getWidth() * 0.8;
		int scrollStart = ScreenWidthStart.intValue();
		
		Double ScreenWidthEnd = dimension.getWidth() * 0.01;
		int scrollEnd = ScreenWidthEnd.intValue();
		
		TouchAction<?> tc = new TouchAction<>(driver);
		tc.press(PointOption.point(scrollStart, Anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
		.moveTo(PointOption.point(scrollEnd, Anchor))
		.release().perform();
		
		Thread.sleep(3000);
	}
  
  public boolean switchWebview(){
		try {		
			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
				if (contextName.contains("WEBVIEW"))
					driver.context(contextName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	
	@DataProvider(name = "fetchData")
	public Object[][] getData() {
		return DataInputProvider.getAllSheetData("./Excel reports/"+dataSheetName+".xlsx");
	}

}
