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

public class SinatraLoginPage {

	private static WebDriver driver;
	private static WebDriverWait driverWait;
	private static PageElementsValidation elementsValidation;
	private static PageElementsValidation elementValidation;

	private static String loginConfirmationMessage = "You are now logged in as";

	public SinatraLoginPage (WebDriver driver2, WebDriverWait driverWait2) {
		this.driver = driver2;
		this.driverWait = driverWait2;
		PageFactory.initElements(this.driver, this);
	}

	//Elements
	@FindBy(how = How.XPATH, using = "//a[@href='/login']")
	WebElement loginLink;
	
	@FindBy(how = How.ID, using = "username")
	WebElement usernameTxt; 
	
	@FindBy(how = How.ID, using = "password")
	WebElement passwordTxt;           
	
	@FindBy(how = How.XPATH, using = "//input[@value='Log In']")
	WebElement loginBtn;

	//Methods
	
	public void goToLoginPage() {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();
		
		if (elementValidation.elementValidation(loginLink) == false) {
			driver.quit();
		}
		
		loginLink.click();
	}
	
	public void sinatraLoginPageElementsValidation() {
		driverWait = new WebDriverWait(driver, 15);
		elementsValidation = new PageElementsValidation();

		WebElement[] webElementsList = {usernameTxt,passwordTxt,loginBtn};

		if (elementsValidation.elementsValidation(webElementsList) == false) {
			driver.quit();
		}
	}

	public void loginSinatraPage(String USER_NAME, String PASSWORD) {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();
		
		usernameTxt.clear();
		usernameTxt.sendKeys(USER_NAME);
		passwordTxt.clear();
		passwordTxt.sendKeys(PASSWORD);
		loginBtn.click();

		WebElement confirmationMessage = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'" +loginConfirmationMessage +"')]")));

		if (elementValidation.elementValidation(confirmationMessage) == false) {
			driver.quit();
		}

	}
}
