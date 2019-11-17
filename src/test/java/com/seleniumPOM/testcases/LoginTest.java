package com.seleniumPOM.testcases;

import org.testng.annotations.Test;

import com.seleniumPOM.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void getLogin(){
		page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
}
