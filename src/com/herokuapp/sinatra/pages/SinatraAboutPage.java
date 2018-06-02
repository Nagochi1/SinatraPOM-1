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

public class SinatraAboutPage {
	
	private static WebDriver driver;
	private static WebDriverWait driverWait;
	private static PageElementsValidation elementValidation;
	
	public SinatraAboutPage(WebDriver driver2, WebDriverWait driverWait2) {
		this.driver = driver2;
		this.driverWait = driverWait2;
		PageFactory.initElements(this.driver, this);
	}

	//Elements
	@FindBy(how = How.XPATH, using = "//p")
	WebElement aboutLbl;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/about']")
	WebElement contactLnk;
	
	public void goToSinatraAboutPage() {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();
		
				
		if (elementValidation.elementValidation(contactLnk) == false) {
			driver.quit();
		}
		
		contactLnk.click();
	}
	
	public void sinatraAboutPageElementsValidation() {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();
		
		if (elementValidation.elementValidation(aboutLbl) == false) {
			driver.quit();
		}
	}

}
