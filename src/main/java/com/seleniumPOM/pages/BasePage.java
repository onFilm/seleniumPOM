package com.seleniumPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page{

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public WebElement getElement(By locator) {
		try {
			return driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Error locating element "+ locator.toString());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void waitForElemnet(By locator) {
	try {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	} catch (Exception e) {
		System.out.println("Error while waiting for the element "+ locator.toString());
		e.printStackTrace();
	}
	}

}
