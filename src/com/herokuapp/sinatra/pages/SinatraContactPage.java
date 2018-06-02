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

public class SinatraContactPage {

	private static WebDriver driver;
	private static WebDriverWait driverWait;
	private static PageElementsValidation elementsValidation;
	private static PageElementsValidation elementValidation;

	private static String sendConfirmationMessage = "Thank you for your message. We";
	
	public SinatraContactPage(WebDriver driver2, WebDriverWait driverWait2) {
		this.driver = driver2;
		this.driverWait = driverWait2;
		PageFactory.initElements(this.driver, this);
	}

	//Elements
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'You can contact me')]")
	WebElement contactLbl;
	
	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	WebElement nameTxt;
	
	@FindBy(how = How.XPATH, using = "//input[@name='email']")
	WebElement emailTxt;
	
	@FindBy(how = How.XPATH, using = "//textarea[@name='message']")
	WebElement urMessageTxtAr;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Send Message']")
	WebElement sendBtn;
	
	@FindBy(how = How.XPATH, using = "//a[@href='/contact']")
	WebElement contactLnk;

	//Methods
	public void goToSinatraContactPage() {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();

		if (elementValidation.elementValidation(contactLnk) == false) {
			driver.quit();
		}
		contactLnk.click();
	}

	public void sinatraContactPageElementsValidatation() {
		driverWait = new WebDriverWait(driver, 15);
		elementsValidation = new PageElementsValidation();

		WebElement[] webElementsList = {nameTxt, emailTxt, urMessageTxtAr, sendBtn, contactLbl};

		if (elementsValidation.elementsValidation(webElementsList) == false) {
			driver.quit();
		}
	}

	public void sendContactMessage(String NAME, String EMAIL, String URMESSAGE) {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();

		nameTxt.clear();
		nameTxt.sendKeys(NAME);
		emailTxt.clear();
		emailTxt.sendKeys(EMAIL);
		urMessageTxtAr.clear();
		urMessageTxtAr.sendKeys(URMESSAGE);
		sendBtn.click();

		WebElement confirmationMessage = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'" + sendConfirmationMessage +"')]")));

		if (elementValidation.elementValidation(confirmationMessage) == false) {
			driver.quit();
		}
	}

}
