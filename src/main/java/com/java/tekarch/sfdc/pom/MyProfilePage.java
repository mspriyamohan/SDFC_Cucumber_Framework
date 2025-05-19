package com.java.tekarch.sfdc.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends BasePage{
	
	@FindBy(xpath=("//a[@class='menuButtonMenuLink' and @title='Logout']"))
    private WebElement btnLogout;
	@FindBy(xpath=("//*[@title=\"My Profile\"]"))
	private WebElement linkMyProfile;
//	@FindBy(xpath="/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[2]/div[2]/div[1]/h3/div/div/a/img")
	private WebElement linkEditProfile;
	
	
	public MyProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public EditProfilePage ClickEditProfile() {
		this.linkEditProfile=this.driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/div/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		this.linkEditProfile.click();
		return new EditProfilePage(this.driver); 		
	}
	
	public void  MyProfile() throws InterruptedException, AWTException{
	this.driver.findElement(By.id("userNav-arrow")).click();
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	PageFactory.initElements(this.driver, this);
	this.linkMyProfile=this.driver.findElement(By.xpath("//*[@title=\"My Profile\"]"));
	linkMyProfile.click();
	Thread.sleep(1000);
      	
	//Switch to iframe by using xpath//

	}
   
}
