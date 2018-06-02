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

public class SinatraAddSongPage {

	private static WebDriver driver;
	private static WebDriverWait driverWait;
	private static PageElementsValidation elementsValidation;
	private static PageElementsValidation elementValidation;
	
	private static String addSongConfirmationMessage = "Song successfully added";

	public SinatraAddSongPage(WebDriver driver2, WebDriverWait driverWait2) {
		this.driver = driver2;
		this.driverWait = driverWait2;
		PageFactory.initElements(this.driver, this);
	}

	//Elements
	@FindBy(how = How.XPATH, using = "//a[@href='/songs/new']")
	WebElement addSongLnk;
	
	@FindBy(how = How.ID, using = "title")
	WebElement titleSongTxt; 
	
	@FindBy(how = How.ID, using = "length")
	WebElement lengthSongTxt;
	
	@FindBy(how = How.ID, using = "released_on")
	WebElement releaseDateSongTxt;
	
	@FindBy(how = How.ID, using = "lyrics")
	WebElement lyricsSongTxt;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Save Song']")
	WebElement saveSongBtn;

	//Methods
	public void goToSinatraAddSongsPage() {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();

		

		if (elementValidation.elementValidation(addSongLnk) == false) {
			driver.quit();
		}
		addSongLnk.click();
	}

	public void sinatraAddSongPageElementsValidation() {
		driverWait = new WebDriverWait(driver, 15);
		elementsValidation = new PageElementsValidation();
		
		WebElement[] webElementsList = {titleSongTxt, lengthSongTxt, releaseDateSongTxt, lyricsSongTxt, saveSongBtn};

		if (elementsValidation.elementsValidation(webElementsList) == false) {
			driver.quit();
		}

	}
	
	public void addSong(String TITLE_SONG, int LENGTH_SONG, String RELEASE_DATE_SONG, String LYRICS_SONG) {
		driverWait = new WebDriverWait(driver, 15);
		elementValidation = new PageElementsValidation();

		titleSongTxt.clear();
		titleSongTxt.sendKeys(TITLE_SONG);
		lengthSongTxt.clear();
		lengthSongTxt.sendKeys(""+LENGTH_SONG);
		releaseDateSongTxt.clear();
		releaseDateSongTxt.sendKeys(RELEASE_DATE_SONG);
		titleSongTxt.click();
		lyricsSongTxt.clear();
		lyricsSongTxt.sendKeys(LYRICS_SONG);
		saveSongBtn.click();
		
		WebElement confirmationMessage = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'" + addSongConfirmationMessage +"')]")));

		if (elementValidation.elementValidation(confirmationMessage) == false) {
			driver.quit();
		}

	}

}
