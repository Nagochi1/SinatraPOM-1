package com.herokuapp.sinatra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.herokuapp.sinatra.utils.PageElementsValidation;

public class SinatraLogoutPage {

	private static WebDriver driver;
	private static WebDriverWait driverWait;
	private static PageElementsValidation elementValidation;

	private static String logoutconfirmationMessage = "You have now logged out";

	public SinatraLogoutPage(WebDriver driver2, WebDriverWait driverWait2) {
		this.driver = driver2;
		this.driverWait = driverWait2;
		PageFactory.initElements(this.driver, this);
	}

	//Elements
	@FindBy(how = How.XPATH, using = "//a[@href='/logout']")
	WebElement logoutLnk; 

	//Methods
	public void sinatraLogoutElementsValidation() {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();
		
		if (elementValidation.elementValidation(logoutLnk) == false) {
			driver.quit();
		}
	}

	public void logoutSinatraPage() {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();
		
		logoutLnk.click();

		WebElement confirmationMessage = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'" + logoutconfirmationMessage + "')]")));
		elementValidation = new PageElementsValidation();
		if (elementValidation.elementValidation(confirmationMessage) == false) {
			driver.quit();
		}
	}
}
