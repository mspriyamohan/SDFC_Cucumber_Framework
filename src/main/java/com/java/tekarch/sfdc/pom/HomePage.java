package com.java.tekarch.sfdc.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;



public class HomePage extends BasePage{
	
	@FindBy(xpath=("//a[@class='menuButtonMenuLink' and @title='Logout']"))
    private WebElement btnLogout;
	//@FindBy(xpath="//*[@role=\"textbox\"]")
	private WebElement txtPost;
	//@FindBy(id="publishersharebutton")
	private WebElement btnPublisherShare;
//	@FindBy(id="publisherAttachContentPost")
	private WebElement btnFileTab;
	//@FindBy(id="chatterUploadFileAction")
	private WebElement btnUploadFile;
	//@FindBy(id="chatterFile")
	private WebElement btnBrowseFile;
//	@FindBy(id="photoSection")
	private WebElement btnphotoSection;
//	@FindBy(id="uploadLink")
	private WebElement btnUploadlink;
	private WebElement btnPhoto;

	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public List<WebElement> DisplayUserMenu() {
	this.driver.findElement(By.id("userNav-arrow")).click();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	PageFactory.initElements(this.driver, this);
	List<WebElement> menuItems = driver.findElements(By.cssSelector("#userNav-menuItems > a"));
	return menuItems;
		
	}
		
	public void PostUpdate(String textToPost) throws InterruptedException {
	  //  this.driver.switchTo().defaultContent();
		Thread.sleep(2000);

		this.driver.findElement(By.id("publishereditablearea")).click();	
		this.driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"cke_wysiwyg_frame cke_reset\"]")));
		this.txtPost=this.driver.findElement(By.xpath("//*[@role=\"textbox\"]"));
		txtPost.sendKeys(textToPost);
	    System.out.println("Text is entered");
	    this.driver.switchTo().defaultContent();
	    this.btnPublisherShare=this.driver.findElement(By.id("publishersharebutton"));
	    btnPublisherShare.click();
	    System.out.println("Entered text is displayed");		
	}	   
	
	public void FileUpload(String filepath) throws InterruptedException, AWTException {
	
	    Thread.sleep(5000);
	    this.btnFileTab=this.driver.findElement(By.id("publisherAttachContentPost"));
	    btnFileTab.click();       
	    System.out.println("Click on file link");
	    
	    this.btnUploadFile=this.driver.findElement(By.id("chatterUploadFileAction"));
	    btnUploadFile.click();
	    System.out.println("Upload a file from computer is selected");
	    
	    this.btnBrowseFile=this.driver.findElement(By.id("chatterFile"));
	    btnBrowseFile.sendKeys(filepath);
	    Robot robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    this.btnPublisherShare=this.driver.findElement(By.id("publishersharebutton"));
	    btnPublisherShare.click();
	    System.out.println("File uploaded is displayed");
	    
	    Thread.sleep(5000);
	    
	}
	
	    public void AddPhoto(String filePath) throws AWTException, InterruptedException {

	    Actions actions=new Actions(driver);
	    this.btnphotoSection=this.driver.findElement(By.id("photoSection"));
	    actions.moveToElement(btnphotoSection).build().perform();
	    
	    this.btnUploadlink=this.driver.findElement(By.id("uploadLink"));
	    btnUploadlink.click();
	    System.out.println("Add photo link is clicked");

	    this.driver.switchTo().frame("uploadPhotoContentId");
	    Thread.sleep(5000);
	    this.btnPhoto=this.driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile"));
	    this.btnPhoto.sendKeys(filePath);
	   // Robot robot = new Robot();
	   // robot.keyPress(KeyEvent.VK_ENTER);
	    Thread.sleep(5000);
	    this.driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn")).click();
	    this.driver.switchTo().defaultContent();
	    this.driver.switchTo().frame("uploadPhotoContentId");
	    Thread.sleep(5000);

	    this.driver.findElement(By.id("j_id0:j_id7:save")).click();

			
		}

}
