package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	//return driver
	public WebDriver driver;
	//threadlocal for parallel execution
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();  //creates a local copy of webdriver
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser:"+browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());							 //creates a local copy of webdriver
		}
		
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		
		else if(browser.equals("safari")) {
			//WebDriverManager.Safaridriver().setup();					//We dont have binary for safari. webdriver Predefined in selenium.
			tlDriver.set(new SafariDriver());
		}
		
		else
			System.out.println("browser "+browser);
		
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {					//all threads in sync during parallel exec - calling the getDriver()
		return tlDriver.get();
	}
	
}


