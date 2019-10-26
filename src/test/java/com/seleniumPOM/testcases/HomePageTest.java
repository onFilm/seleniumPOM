package com.seleniumPOM.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.seleniumPOM.pages.HomePage;
import com.seleniumPOM.pages.LoginPage;

public class HomePageTest extends BaseTest {
	
	HomePage homePage;
	
	@Test(priority=1)
	public void getLogin(){
		homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void verifyFlashText(){
		homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String flashText = homePage.getFlashText();
		System.out.println(flashText);
		Assert.assertNotEquals(flashText, "You logged into a secure area!");
	}
	
	@Test(priority=3)
	public void verifyMessageText(){
		homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String messageText = homePage.getMessageText();
		Assert.assertEquals(messageText, "Secure Area");
	}
	
	@Test(priority=4)
	public void logout(){
		homePage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		LoginPage loginPage = homePage.clickOnLogout();
	}

}
