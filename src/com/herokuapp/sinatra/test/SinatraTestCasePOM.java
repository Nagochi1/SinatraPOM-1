package com.herokuapp.sinatra.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class SinatraTestCasePOM extends TestBasePOM {

	@Test
	@FileParameters("./data/params.csv")
	public void sinatraHomePageTestCase(String user, String password) {
		homePage.goToSinatraHomePage();
		homePage.sinatraHomePageElementsValidation();
		
		loginPage.goToLoginPage();
		loginPage.sinatraLoginPageElementsValidation();
		loginPage.loginSinatraPage(user, password);
		
		logoutPage.sinatraLogoutElementsValidation();
		logoutPage.logoutSinatraPage();
	}
	
	@Test
	@FileParameters("./data/params.csv")
	public void sinatraAboutPageTestCase(String user, String password) {
		aboutPage.goToSinatraAboutPage();
		aboutPage.sinatraAboutPageElementsValidation();
		
		loginPage.goToLoginPage();
		loginPage.sinatraLoginPageElementsValidation();
		loginPage.loginSinatraPage(user, password);
		
		logoutPage.sinatraLogoutElementsValidation();
		logoutPage.logoutSinatraPage();
	}
	
	@Test
	@FileParameters("./data/contactInfo.csv")
	public void sinatraContactPageTestCase(String name, String email, String urMessage) {
		contactPage.goToSinatraContactPage();
		contactPage.sinatraContactPageElementsValidatation();
		contactPage.sendContactMessage(name, email, urMessage);
		
		loginPage.goToLoginPage();
		loginPage.sinatraLoginPageElementsValidation();
		loginPage.loginSinatraPage("frank", "sinatra");
		
		logoutPage.sinatraLogoutElementsValidation();
		logoutPage.logoutSinatraPage();
	}
	
	@Test
	@FileParameters("./data/songInfo.csv")
	public void sinatraSongsPageTestCase(String songName, int lenght, String releaseOn, String lyrics) {
		loginPage.goToLoginPage();
		loginPage.sinatraLoginPageElementsValidation();
		loginPage.loginSinatraPage("frank", "sinatra");
		
		songsPage.goToSinatraSongsPage();
		songsPage.sinatraSongsPageElementsValidation();

		addSongPage.goToSinatraAddSongsPage();
		addSongPage.sinatraAddSongPageElementsValidation();
		addSongPage.addSong(songName, lenght, releaseOn, lyrics);
		
		logoutPage.sinatraLogoutElementsValidation();
		logoutPage.logoutSinatraPage();
	}
	
	

}
