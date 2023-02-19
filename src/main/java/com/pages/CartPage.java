package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class CartPage {
	
	private WebDriver driver;
	private String cartTitle;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginStatus() {
		String signInStatus = driver.findElement(By.xpath("//span[@class='nav-action-inner']")).getText();
		return signInStatus;
	}
	
	public void clickOnCart() {
		driver.findElement(By.id("nav-cart")).click();
	}
	
	public void proceedToBuy() {
		driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
