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

public class SinatraHomePage {

	private static WebDriver driver;
	private static WebDriverWait driverWait;
	private static PageElementsValidation elementsValidation;
	private static PageElementsValidation elementValidation;

	public SinatraHomePage (WebDriver driver2, WebDriverWait driverWait2) {
		this.driver = driver2;
		this.driverWait = driverWait2;
		PageFactory.initElements(this.driver, this);
	}

	//Elements
	@FindBy(how = How.XPATH, using = "//img[@src='/images/sinatra.jpg']")
	WebElement sinatraImg; 
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(), 'Welcome')]")
	WebElement welcomeLbl;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Home']")
	WebElement homeLnk;
	
	//Methods
	public void goToSinatraHomePage() {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();
		
			
		if (elementValidation.elementValidation(homeLnk) == false) {
			driver.quit();
		}
		homeLnk.click();
	}
	
	public void sinatraHomePageElementsValidation() {

		driverWait = new WebDriverWait(driver, 20);
		elementsValidation = new PageElementsValidation();

		WebElement[] containerList = {sinatraImg,welcomeLbl};

		if (elementsValidation.elementsValidation(containerList) == false) {
			driver.quit();
		}
	}
}
