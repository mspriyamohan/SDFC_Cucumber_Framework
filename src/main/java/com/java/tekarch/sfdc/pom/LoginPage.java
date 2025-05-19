package com.java.tekarch.sfdc.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage extends BasePage {
    
	@FindBy(name="username")
	private WebElement txtUserName;
	@FindBy(name="pw")
	private WebElement txtPwd;
	@FindBy(id="Login")
	private WebElement btnLogin;
	@FindBy(id="error")
	private WebElement lblError;
	@FindBy(id="rememberUn")
	private WebElement chkboxRememberUn;
	@FindBy(id="userNav-arrow")
	private WebElement UserNavigation;
	@FindBy(xpath=("//a[@class='menuButtonMenuLink' and @title='Logout']"))
    private WebElement btnLogout;
	@FindBy(id="idcard-identity")
	private WebElement txtIdentity;
	@FindBy(id="forgot_password_link")
	private WebElement linkforgotpwd;
	@FindBy(id="un")
	private WebElement txtUn;
	@FindBy(id="continue")
	private WebElement btncontinue;
	@FindBy(id="header")
	private WebElement txtHeader;
    @FindBy(xpath="//div[@id='error' and @class='loginError']")
    private WebElement txtLoginError;
    
	public LoginPage(String driverType) {
		super(driverType);
	}
    
	
	public HomePage LoginApp(String userName, String password) throws InterruptedException {
		PageFactory.initElements(this.driver, this);
		this.txtUserName.clear();
		this.txtUserName.sendKeys(userName);
		this.txtPwd.clear();
		this.txtPwd.sendKeys(password);
		this.btnLogin.click();

		Thread.sleep(5000);
		return new HomePage(this.driver);
	}

	public WebElement getLblError() {
		return this.lblError;
	}
	
	public void LoginRemember(String userName, String password) throws InterruptedException{
		PageFactory.initElements(this.driver,this);
		this.txtUserName.clear();
		this.txtUserName.sendKeys(userName);
		this.txtPwd.clear();
		this.txtPwd.sendKeys(password);
		Thread.sleep(5000);
		if(!this.chkboxRememberUn.isSelected())
		{
			this.chkboxRememberUn.click();
		}
		this.btnLogin.click();
		Thread.sleep(5000);		
		this.UserNavigation.click();
		btnLogout.click();
	}
		public WebElement GetTxtIdentity() {
			return this.txtIdentity;
	}
		
	public void ForgotPassword(String userName) throws InterruptedException{
		PageFactory.initElements(this.driver,this);
		this.txtUserName.sendKeys(userName);
		this.linkforgotpwd.click();
		this.txtUn.sendKeys("mspriyamohan106@agentforce.com");
		this.btncontinue.click();
		}
	
	public WebElement GetTxtHeader() {
		return this.txtHeader;
	}
	
	public WebElement GetTxtLoginError() {
		return this.txtLoginError;
	}
	

}
