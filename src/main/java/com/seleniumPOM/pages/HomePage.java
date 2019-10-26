package com.seleniumPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// objects or elements
	public By flash = By.id("flash");
	public By message = By.tagName("h2");
	public By logoutBtn = By.xpath("//a[@class='button secondary radius']");
	
	// actions
	
	public String getFlashText(){
		return getElement(flash).getText();
	}
	
	public String getMessageText(){
		return getElement(message).getText();
	}
	
	public LoginPage clickOnLogout(){
		getElement(logoutBtn).click();
		
		return getInstance(LoginPage.class); 
	}
	
}
