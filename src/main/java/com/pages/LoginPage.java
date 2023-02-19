package com.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.*;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	//By Locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By submitLogin = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your Password");
	
	
	private WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	//Page actions
		public String getLoginPageTitle() {
			return driver.getTitle();
		}
		
		public boolean isForgotPwdLinkExist() {
			 return driver.findElement(forgotPwdLink).isDisplayed();
		}
	
		public void enterUserName (String username) {
			driver.findElement(emailId).sendKeys(username);
		}
		
		public void enterPassword (String pwd) {
			driver.findElement(password).sendKeys(pwd);
		}
		
		public void clickOnLogin() {
			driver.findElement(submitLogin).click();
		}
		
		public int checkLink() {
			
				List<WebElement> links = driver.findElements(By.tagName("a"));
				HttpURLConnection H = null;
				int response = 200;
				int flag = 0;
				Iterator<WebElement> it = links.iterator();
				
				while(it.hasNext()) {
					String url = it.next().getAttribute("href");				
					if(url == null || url.isEmpty()) {
						System.out.println("Empty/Null link found");
						flag = 1;
					}
				
				
					try{
						H = (HttpURLConnection)(new URL(url).openConnection());			
						H.setRequestMethod("HEAD");
						H.connect();
						response = H.getResponseCode();
						
						if(response == 400) {
							System.out.println("Broken link found");
							flag = 1;
						}
					} catch(MalformedURLException e){
						e.printStackTrace();
				} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
					return flag;		
				
			}
	}

