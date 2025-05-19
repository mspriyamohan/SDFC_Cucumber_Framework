package com.java.tekarch.sfdc.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;

	public BasePage(String driverType) {
		if (driverType == "firefox") {
			WebDriverManager.firefoxdriver().setup();
			this.driver = new FirefoxDriver();
		} else if (driverType == "chrome") {
			WebDriverManager.chromedriver().setup();
			this.driver = new ChromeDriver();
		}
		this.driver.get("https://login.salesforce.com/");
	}
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void CloseDriver() {
		this.driver.close();
	}

}
