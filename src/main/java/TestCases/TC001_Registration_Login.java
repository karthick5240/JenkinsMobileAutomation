package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ProjectMethods.BaseClass;
import net.sourceforge.tess4j.TesseractException;

public class TC001_Registration_Login extends BaseClass {

	public WebDriverWait wt;
	public String frstname;
	public String lstname;
	public String username;

	
	@BeforeTest
	public void setData() {
		dataSheetName = "TC001_Login";
	}

	@Test(dataProvider = "fetchData")
	public void launchapplication(String fname,String lname,String email,String cnfemail,
								  String password,String cnfpassword,String npwd,
								  String cnfpwd,String profilelname) throws InterruptedException, IOException, TesseractException {

		String appid = "com.ashleyfurniturehomestore.ecomm.debug";
		if (driver.isAppInstalled(appid)) {
			System.out.println("Application is installed successfully");
		} else {
			System.out.println("Application is not Installed properly");
		}

		Thread.sleep(8000);


		try {
			
			List<WebElement> more = driver
					.findElementsById("com.ashleyfurniturehomestore.ecomm.debug:id/bottom_navigation_container");
			more.get(4).click();
			reportStep("The menu page is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The menu page is not tapped successfully", "FAIL");
		}

		Thread.sleep(6000);
		try {
			wt = new WebDriverWait(driver, 30);
			wt.until(ExpectedConditions.elementToBeClickable(
					driver.findElementByXPath("//android.widget.Button[@text='Create an Account']")));
			WebElement createaccount = driver.findElementByXPath("//android.widget.Button[@text='Create an Account']");
			createaccount.click();
			reportStep("The Create account is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The Create button is not tapped successfully", "FAIL");
		}
		Thread.sleep(5000);

		try {
			WebElement firstname = driver.findElementByXPath("//android.widget.EditText[@text='First Name*']");
			firstname.sendKeys(fname);
			String frstname = firstname.getText();
			System.out.println(frstname);
			reportStep("The Firstname is entered", "PASS");
		} catch (Exception e) {
			reportStep("The Firstname text is not entered", "FAIL");
		}

		try {
			Thread.sleep(5000);
			WebElement lastname = driver.findElementByXPath("//android.widget.EditText[@text='Last Name*']");
			lastname.sendKeys(lname);
			reportStep("The lastname is entered", "PASS");
		} catch (Exception e) {
			reportStep("The lastname text is not entered", "FAIL");
		}

		try {
			WebElement emails = driver.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_email");
			emails.sendKeys(email);
			reportStep("The email is entered successfully", "PASS");
		} catch (Exception e) {
			reportStep("The email is not entered", "FAIL");
		}
		try {
			WebElement cnfrmemail = driver
					.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_confirm_email");
			cnfrmemail.sendKeys(cnfemail);
			reportStep("The confirmation email is entered successfully", "PASS");
		} catch (Exception e) {
			reportStep("The confirmation email is entered successfully", "FAIL");
		}

		try {
			WebElement pwdreg = driver.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_password");
			pwdreg.sendKeys(password);
			reportStep("The password is entered successfully", "PASS");
		} catch (Exception e) {
			reportStep("The password is not entered", "FAIL");
		}

		try {
			WebElement cnfrmpwd = driver.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_confirm_password");
			cnfrmpwd.sendKeys(cnfpassword);
			reportStep("The confirmation password is entered successfully", "PASS");
		} catch (Exception e) {
			reportStep("The confirmation password is not entered", "FAIL");
		}

		try {
			WebElement ageselect = driver
					.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/checkbox_legal_age_confirmation");
			ageselect.click();
			reportStep("The age select is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The age select is tapped successfully", "FAIL");
		}

		try {
			WebElement sales = driver.findElementById(
					"com.ashleyfurniturehomestore.ecomm.debug:id/checkbox_receive_offers_confirmation");
			sales.click();
			reportStep("The Sales button is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The Sales button isn tapped successfully", "FAIL");
		}

		try {
			WebElement createacct = driver.findElementByXPath("//android.widget.Button[@text='Create Account']");
			createacct.click();
			reportStep("The create account button is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The create account button is not tapped successfully", "FAIL");
		}
		


//		try {
//			WebElement toast = driver.findElementByClassName("android.widget.Toast");
//            String actual = toast.getText();
//            Assert.assertEquals(actual, "Account Created successfully");
//			reportStep("Account toast message should be displayed", "PASS");
//		} catch (Exception e) {
//			reportStep("Account Toast message is not displayed", "FAIL");
//		}
		Thread.sleep(10000);
		try {
			WebElement profile = driver
					.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/button_my_profile");
			profile.click();
			reportStep("The My profile button is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The My profile button is not tapped successfully", "FAIL");
		}
		
		Thread.sleep(10000);
		try {
			WebElement changepwd = driver
					.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/button_change_password");
			changepwd.click();
			reportStep("The change password button is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The change password button is not tapped successfully", "FAIL");
		}

		try {
			WebElement currpwd = driver
					.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_current_password");
			currpwd.sendKeys(password);
			reportStep("The current password is entered successfully", "PASS");
		} catch (Exception e) {
			reportStep("The current password is not entered successfully", "FAIL");
		}

		try {
			WebElement newpwd = driver
					.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_new_password");
			newpwd.sendKeys(npwd);
			reportStep("The New password is entered successfully", "PASS");
		} catch (Exception e) {
			reportStep("The New password is entered successfully", "FAIL");
		}

		try {
			WebElement cnfnewpwd = driver
					.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_confirm_new_password");
			cnfnewpwd.sendKeys(cnfpwd);
			reportStep("The confirm new password is entered successfully", "PASS");
		} catch (Exception e) {
			reportStep("Theconfirm new password is entered successfully", "FAIL");
		}

		try {
			WebElement save = driver.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/button_save");
			save.click();
			reportStep("The save button is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The save button is not tapped successfully", "FAIL");
		}
	
//		 Thread.sleep(5000);
//		try {
//			WebElement toast = driver.findElementByClassName("android.widget.Toast");
//            String actual = toast.getText();
//            Assert.assertEquals("Profile Updated",actual);
//			reportStep("Profile Toast message should be displayed.", "PASS");
//		} catch (Exception e) {
//			reportStep("Profile Toast message is not displayed.", "FAIL");
//		}

		Thread.sleep(5000);

		try {
			WebElement lastname = driver
					.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_last_name");
			lastname.clear();
			lastname.sendKeys(profilelname);
			String lstname = lastname.getText();
			System.out.println(lstname);
			String username = frstname.concat(lstname);
			System.out.println(username);
			reportStep("The Lastname is entered successfully", "PASS");
		} catch (Exception e) {
			reportStep("The Lastname is not entered successfully", "FAIL");
		}
		

		try {
			WebElement cnfirmemail = driver
					.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_confirm_email");
			cnfirmemail.sendKeys(email);
			reportStep("The confirmation email is updated successfully in the profile screen.", "PASS");
		} catch (Exception e) {
			reportStep("The confirmation email is not updated successfully in the profile screen.", "FAIL");
		}

		try {
			WebElement save = driver.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/button_save");
			save.click();
			reportStep("The save button is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The save button is not tapped successfully", "FAIL");
		}
		Thread.sleep(12000);
//		
//		try {
//			WebElement toast = driver.findElementByClassName("android.widget.Toast");
//            String actual = toast.getText();
//            Assert.assertEquals(actual, "Password Successfully Changed");
//			reportStep("Profile toast message is sucessfully validated", "PASS");
//		} catch (Exception e) {
//			reportStep("Profile toast message is not sucessfully validated", "FAIL");
//		}
		try {
			WebElement logout = driver.findElementByXPath("//android.widget.Button[@text='Log Out']");
			logout.click();
			reportStep("The Logout button is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The Logout button is not tapped successfully", "FAIL");
		}
    	Thread.sleep(6000);
		try {
			WebElement login = driver.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/button_log_in");
			login.click();
			reportStep("The login button is tapped successfully", "PASS");
		} catch (Exception e) {
			reportStep("The login button is not tapped successfully", "FAIL");
		}
		
		
		//Enter the email address
        try {
			WebElement emailaddr = driver.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_email");
			emailaddr.sendKeys(email);
			reportStep("The Email address is entered successfully", "PASS");
        }catch(Exception e) {
        	reportStep("The Email address is not entered successfully","FAIL");
        }

        //Enter the Email
        try {
			WebElement pwdlog = driver.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/edittext_password");
			pwdlog.sendKeys(npwd);
			reportStep("The password is entered successfully", "PASS");
        }catch(Exception e) {
        	reportStep("The password is not entered successfully","FAIL");
        }
        //Enter the Password
        try {
			WebElement loginbutton = driver.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/button_log_in");
			loginbutton.click();
			reportStep("The Login button is tapped successfully", "PASS");
        }catch(Exception e) {
        	reportStep("The Login button is not tapped successfully","FAIL");
        }

        Thread.sleep(15000);
    	
	 	WebElement userprofile = driver.findElementById("com.ashleyfurniturehomestore.ecomm.debug:id/textview_user_name");
    	String profilename = userprofile.getText();
    	if(!profilename.equals(username)) {
			System.out.println("User Profile name is matched");
		}else{
			System.out.println("User Profile name is not matched");
		}
        Thread.sleep(15000);

       
	}
}
