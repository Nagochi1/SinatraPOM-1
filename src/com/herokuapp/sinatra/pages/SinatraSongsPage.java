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

public class SinatraSongsPage {
	
	private static WebDriver driver;
	private static WebDriverWait driverWait;
	private static PageElementsValidation elementsValidation;
	private static PageElementsValidation elementValidation;
	
	private static String addSongConfirmationMessage = "Song successfully added";
	
	public SinatraSongsPage(WebDriver driver2, WebDriverWait driverWait2) {
		this.driver = driver2;
		this.driverWait = driverWait2;
		PageFactory.initElements(this.driver, this);
	}
	
	//elements:
	@FindBy(how = How.XPATH, using = "//section//h1[contains(text(),'Songs')]")
	WebElement songsLbl; //xpath: //h1[text() = 'Songs']
	
	@FindBy(how = How.XPATH, using = "//a[@href='/songs/new']")
	WebElement addSongLnk; //linkText: Create a new song
	
	@FindBy(how = How.XPATH, using = "//a[@href='/songs']")
	WebElement songsLnk;

	//methods:
	
	public void goToSinatraSongsPage() {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();
		
		if (elementValidation.elementValidation(songsLnk) == false) {
			driver.quit();
		}
		songsLnk.click();
	}
	
	public void sinatraSongsPageElementsValidation() {
		driverWait = new WebDriverWait(driver, 15);
		elementsValidation = new PageElementsValidation();
		
		WebElement[] webElementsList = {songsLbl, addSongLnk};

		if (elementsValidation.elementsValidation(webElementsList) == false) {
			driver.quit();
		}
		
	}
}
