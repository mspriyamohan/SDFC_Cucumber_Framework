package com.java.tekarch.sfdc.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage extends BasePage {
	
	 @FindBy(xpath="//*[@role=\"tab\"]")
	 private WebElement tabAbout;		
	 @FindBy(id="lastName")
	 private WebElement txtLastName;
	 @FindBy(xpath=("//*[@value=\"Save All\"]"))
	 private WebElement btnSaveAll;
	
	 public EditProfilePage(WebDriver driver)
	 {
		 super(driver);
	 }
	
	 public void LoadPage() {
			PageFactory.initElements(this.driver, this);

		    //Switch to iframe by id//
			this.driver.switchTo().frame("contactInfoContentId");
			tabAbout.click();
			
			
			txtLastName.clear();
			txtLastName.sendKeys("M");
			System.out.println("lastname is entered");
			btnSaveAll.click();
			
		    this.driver.switchTo().defaultContent();
		//    this.driver.findElement(By.id("publishereditablearea")).click();	
			//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"cke_wysiwyg_frame cke_reset\"]")));

	 }
	}
