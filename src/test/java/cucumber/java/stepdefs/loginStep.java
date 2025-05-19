package cucumber.java.stepdefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.java.tekarch.sfdc.pom.EditProfilePage;
import com.java.tekarch.sfdc.pom.HomePage;
import com.java.tekarch.sfdc.pom.LoginPage;
import com.java.tekarch.sfdc.pom.MyProfilePage;

import io.cucumber.java.en.*;

public class loginStep {

	public HomePage homepage;
	public LoginPage loginpage;
	public MyProfilePage myprofilepage;
	public EditProfilePage editprofilepage;

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		loginpage = new LoginPage("firefox");
		try {
			homepage = loginpage.LoginApp("mspriyamohan106@agentforce.com", "1GlaksAd!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user should see home page")
	public void user_should_see_home_page() {
		WebElement element = loginpage.driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[1]/h1/a"));
		Assert.assertEquals(element.getText(), "Shanmugapriya M");
		homepage.driver.close();
	}

	@When("user enter valid user name and password is not provided")
	public void user_enter_valid_user_name_and_password_is_not_provided() {
		loginpage = new LoginPage("firefox");
		try {
			loginpage.LoginApp("mspriyamohan106@agentforce.com", "");
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@Then("user should see appropriate error message")
	public void user_should_see_appropriate_error_message() {
		try {
			WebElement lblError = loginpage.getLblError();
			Assert.assertEquals(lblError.getText(), "Please enter your password.");
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@When("user enter valid username and password along with remember me checkbox clicked")
	public void user_login_remember_me() {
		loginpage = new LoginPage("firefox");
		try {
			loginpage.LoginRemember("mspriyamohan106@agentforce.com", "1GlaksAd!");
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@Then("user should see valid user name populated after logout")
	public void validate_remember_me() {
		try {
			String TxtIdentityValue = loginpage.GetTxtIdentity().getText();
			Assert.assertEquals(TxtIdentityValue, "mspriyamohan106@agentforce.com");
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@When("user enter valid username and click forgot password link")
	public void validate_forgot_pwd() {
		loginpage = new LoginPage("firefox");
		try {
			loginpage.ForgotPassword("mspriyamohan106@agentforce.com");
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@Then("user should recieve password reset email to associated email")
	public void validate_reset_email() {
		try {
			String getTxtHeaderValue = loginpage.GetTxtHeader().getText();
			Assert.assertEquals(getTxtHeaderValue, "Check Your Email");
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@When("user enter invalid username and password")
	public void invalid_login() {
		loginpage = new LoginPage("firefox");
		try {
			loginpage.LoginApp("123", "22131");
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@Then("user should see valid error message")
	public void valid_error() {
		try {
			String GetTxtLoginErrorValue = loginpage.GetTxtLoginError().getText();
			Assert.assertEquals(GetTxtLoginErrorValue,
					"Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@When("After valid login, check for the user menu drop down")
	public void valid_login() {
		loginpage = new LoginPage("firefox");
		try {
			homepage = loginpage.LoginApp("mspriyamohan106@agentforce.com", "1GlaksAd!");
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@Then("Drop down should contain expected list of menus")
	public void valid_home_menu() {
		try {
			List<WebElement> menuItems = homepage.DisplayUserMenu();
			Assert.assertEquals(menuItems.size(), 5);
			Assert.assertEquals(menuItems.get(0).getText(), "My Profile");
			Assert.assertEquals(menuItems.get(1).getText(), "My Settings");
			Assert.assertEquals(menuItems.get(2).getText(), "Developer Console");
			Assert.assertEquals(menuItems.get(3).getText(), "Switch to Lightning Experience");
			Assert.assertEquals(menuItems.get(4).getText(), "Logout");
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	
	@Then("The User Profile page should be displayed")
	public void user_profile() {
		try {
			myprofilepage = new MyProfilePage(homepage.driver);
			myprofilepage.MyProfile();
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@When("User clicks the edit button next to contact information")
	public void edit_profile() {
		try {
			editprofilepage = myprofilepage.ClickEditProfile();
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}

	@Then("Edit profile pop-up window should be displayed and update lastname in the profile page")
	public void profile_popup() {
		try {
			editprofilepage.LoadPage();
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}

	}
	
	@Then("User enter text in post and share in profile page")
	public void profile_post() {
		try {
			homepage.PostUpdate("Hi");
		}catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}
	
	@Then("User upload a file and share in profile page")
	public void profile_fileupload() {
		try {
		homepage.FileUpload("C:\\Users\\Pradeep Venugopal\\Desktop\\cover lettter.txt");
		}catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true, false);
		}
	}
	
	@Then("User upload a profile photo in profile page")
	public void profile_uploadphoto() {
		try {
			homepage.AddPhoto("C:\\Users\\Pradeep Venugopal\\Desktop\\0_SEq6IBJKG_bNW5tc.jpg");
			}catch (Exception e) {
				System.out.println(e);
				Assert.assertEquals(true, false);
			}
	}
}
