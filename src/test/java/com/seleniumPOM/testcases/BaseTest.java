package com.seleniumPOM.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.seleniumPOM.pages.BasePage;
import com.seleniumPOM.pages.Page;
import com.seleniumPOM.utilities.DriverFactory;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public Page page;
	

	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/seleniumPOM/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setUp(){
		String browserName = prop.getProperty("browser");
		String url= prop.getProperty("url");
		driver= DriverFactory.get(browserName,url);
		page = new BasePage(driver);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
