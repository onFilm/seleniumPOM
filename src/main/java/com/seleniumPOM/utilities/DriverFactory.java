package com.seleniumPOM.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/*
 * This class returns a WebDriver object using 3 overloaded .get() methods:
 * 1. get() - default
 * 2. get(String browserType)
 * 3. get(String browserType, String webURL)
 */

public class DriverFactory {
	public static WebDriver driver;

	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public static WebDriver browserSelection(String browserType){
		if (browserType.equalsIgnoreCase("Chrome")) {
			System.out.println("Opening chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("Firefox")) {
			System.out.println("Opening Firefox browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserType.equalsIgnoreCase("IE")) {
			System.out.println("Opening IE browser");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browserType.equalsIgnoreCase("random")) {
			Random rd = new Random(); // creating Random object
			if (rd.nextBoolean()) {
				System.out.println("Opening chrome browser");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else {
				System.out.println("Opening Firefox browser");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		} else {
			System.out
					.println("Could not understand input. Will open Chrome as default");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	// function that returns a default WebDriver (user does not specify)
	public static WebDriver get() {
		System.out.println("Opening chrome browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver = eventFiringWebDriver(driver);
		driver = setConfigs(driver);
		return driver;
	}

	// function that returns a WebDriver when user sends desired browser
	public static WebDriver get(String browserType) {
		browserSelection(browserType);
		driver = eventFiringWebDriver(driver);
		driver = setConfigs(driver);
		return driver;
	}

	public static WebDriver get(String browserType, String webURL) {
		browserSelection(browserType);
		driver = eventFiringWebDriver(driver);
		driver = setConfigs(driver);
		driver.get(webURL);
		return driver;
	}

	// This function returns a WebDriver with maximized window and 15 second
	// wait
	private static WebDriver setConfigs(WebDriver driver) {

		System.out.println("Setup basic WebDriver configurations");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		return driver;
	}

	private static WebDriver eventFiringWebDriver(WebDriver driver) {
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		return driver;
	}

	public static WebDriver get(String browserType, String webURL, String eventFiringWebDriverFlag) {
		browserSelection(browserType);
		
		if (eventFiringWebDriverFlag.contentEquals("true")) {
			driver = eventFiringWebDriver(driver);
		}
		
		driver = setConfigs(driver);
		driver.get(webURL);
		return driver;
	}
}
