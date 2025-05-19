package com.java.tekarch.sfdc.pom.tests;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.java.tekarch.sfdc.pom.EditProfilePage;
import com.java.tekarch.sfdc.pom.HomePage;
import com.java.tekarch.sfdc.pom.LoginPage;
import com.java.tekarch.sfdc.pom.MyProfilePage;

import org.testng.Assert;

public class LoginPageTest {
	
	
/*	@BeforeTest
	public void beforeTest() {
		this.loginPage = new LoginPage();
	}
	
	@AfterTest
	public void afterTest(FirefoxDriver driver) {
		this.loginPage.CloseDriver();
	}*/
	
	@Test
	public void TestLoginUnsucesssfull() {
		LoginPage login = new LoginPage("firefox");
		try {
			login.LoginApp("mspriyamohan106@agentforce.com", "");
			WebElement lblError = login.getLblError();
			Assert.assertEquals(lblError.getText(), "Please enter your password.");
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true,false);
		}
	}
	
	@Test
	public void TestLogin() {
		LoginPage login=new LoginPage("firefox");
		try {
			login.LoginApp("mspriyamohan106@agentforce.com", "1GlaksAd!");
			Thread.sleep(5000);
			WebElement element = login.driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div/div[2]/span[1]/h1/a"));
			Assert.assertEquals(element.getText(), "Shanmugapriya M");
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true,false);
		}
	}
	
	@Test
	public void LoginRemember() {
		LoginPage login=new LoginPage("firefox");
        try {
        	login.LoginRemember("mspriyamohan106@agentforce.com", "1GlaksAd!");
			Thread.sleep(5000);
			String TxtIdentityValue=login.GetTxtIdentity().getText();
			Assert.assertEquals(TxtIdentityValue,"mspriyamohan106@agentforce.com");
		}
        catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true,false);
        }
	}
	
	@Test
	public void ForgotPassword() {
		LoginPage login=new LoginPage("firefox");
        try {
        	login.ForgotPassword("mspriyamohan106@agentforce.com");
        	Thread.sleep(5000);
        	String getTxtHeaderValue=login.GetTxtHeader().getText();
			Assert.assertEquals(getTxtHeaderValue, "Check Your Email");
        }
        catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true,false);
        }

	}
	
	@Test
	public void LoginError() {
		LoginPage login=new LoginPage("firefox");
		try {
			login.LoginApp("123", "22131");
			Thread.sleep(5000);
			String GetTxtLoginErrorValue=login.GetTxtLoginError().getText();
			Assert.assertEquals(GetTxtLoginErrorValue, "Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		}
        catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true,false);
        }	
	}
	
	@Test
	public void DisplayUserMenu() {
		LoginPage login=new LoginPage("firefox");
		try {
			HomePage homepage=login.LoginApp("mspriyamohan106@agentforce.com", "1GlaksAd!");
			List<WebElement> menuItems=homepage.DisplayUserMenu();
			Assert.assertEquals(menuItems.size(), 5);
			Assert.assertEquals(menuItems.get(0).getText(),"My Profile");
			Assert.assertEquals(menuItems.get(1).getText(),"My Settings");
			Assert.assertEquals(menuItems.get(2).getText(), "Developer Console");
			Assert.assertEquals(menuItems.get(3).getText(), "Switch to Lightning Experience");
			Assert.assertEquals(menuItems.get(4).getText(), "Logout");
		}
		catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true,false);
        }
	}
	
	@Test
	public void MyProfile() {
		LoginPage login=new LoginPage("firefox");
		try {
			HomePage homepage=login.LoginApp("mspriyamohan106@agentforce.com", "1GlaksAd!");
			MyProfilePage myprofilepage=new MyProfilePage(homepage.driver);
			myprofilepage.MyProfile();
			EditProfilePage editprofilepage=myprofilepage.ClickEditProfile();
			editprofilepage.LoadPage();
			
			homepage.PostUpdate("Hi");
			homepage.FileUpload("C:\\Users\\Pradeep Venugopal\\Desktop\\cover lettter.txt");
			homepage.AddPhoto("C:\\Users\\Pradeep Venugopal\\Desktop\\0_SEq6IBJKG_bNW5tc.jpg");
			}
		catch (Exception e) {
			System.out.println(e);
			Assert.assertEquals(true,false);
        }
		
	}

}
