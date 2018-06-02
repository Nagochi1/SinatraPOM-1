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
	@FileParameters("./data/params2.csv")
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
	public void sinatraContactPageTestCase() {
		contactPage.goToSinatraContactPage();
		contactPage.sinatraContactPageElementsValidatation();
		contactPage.sendContactMessage("Juan Perez", "juan.perez@sinatra.com", "hola");
		
		loginPage.goToLoginPage();
		loginPage.sinatraLoginPageElementsValidation();
		loginPage.loginSinatraPage("frank", "sinatra");
		
		logoutPage.sinatraLogoutElementsValidation();
		logoutPage.logoutSinatraPage();
	}
	
	@Test
	public void sinatraSongsPageTestCase() {
		loginPage.goToLoginPage();
		loginPage.sinatraLoginPageElementsValidation();
		loginPage.loginSinatraPage("frank", "sinatra");
		
		songsPage.goToSinatraSongsPage();
		songsPage.sinatraSongsPageElementsValidation();

		addSongPage.goToSinatraAddSongsPage();
		addSongPage.sinatraAddSongPageElementsValidation();
		addSongPage.addSong("SongTest", 12, "05/30/2018", "SongTestLyrics");
		
		logoutPage.sinatraLogoutElementsValidation();
		logoutPage.logoutSinatraPage();
	}
	
	

}
