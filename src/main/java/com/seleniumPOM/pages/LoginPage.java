package com.seleniumPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
	
	//page locators - using By class (not using page factory)

	private By usename = By.id("username");
	private By pwd = By.id("password");
	private By loginBtn = By.xpath("//button[@class='radius']");
	
	//constructor
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//Actions
	
	public WebElement getUsename() {
		return getElement(usename);
	}

	public WebElement getPwd() {
		return getElement(pwd);
	}

	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	public void setUsername(String username) {
		getUsename().sendKeys(username);
	}
	
	public void setPassword(String password) {
		getPwd().sendKeys(password);
	}

	public void clickSubmit() {
		getLoginBtn().click();
	}
	
	public HomePage doLogin(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickSubmit();
		
		return getInstance(HomePage.class);
	}
	
}
