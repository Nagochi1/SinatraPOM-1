package com.herokuapp.sinatra.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.herokuapp.sinatra.pages.SinatraAboutPage;
import com.herokuapp.sinatra.pages.SinatraAddSongPage;
import com.herokuapp.sinatra.pages.SinatraContactPage;
import com.herokuapp.sinatra.pages.SinatraHomePage;
import com.herokuapp.sinatra.pages.SinatraLoginPage;
import com.herokuapp.sinatra.pages.SinatraLogoutPage;
import com.herokuapp.sinatra.pages.SinatraSongsPage;

public class TestBasePOM {

	private static String DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static String DRIVER_PATH ="C:\\test_automation\\driver\\chromedriver.exe";

	private static WebDriver driver;
	private static WebDriverWait driverWait;

	protected SinatraHomePage homePage;
	protected SinatraLoginPage loginPage;
	protected SinatraLogoutPage logoutPage;	
	protected SinatraAboutPage aboutPage;
	protected SinatraContactPage contactPage;
	protected SinatraSongsPage songsPage;
	protected SinatraAddSongPage addSongPage;

	@Before
	public void setUp() {
		System.setProperty(DRIVER_PROPERTY, DRIVER_PATH);

		driver = new ChromeDriver();
		driver.get("http://songs-by-sinatra.herokuapp.com/");

		homePage = new SinatraHomePage(driver, driverWait);
		loginPage = new SinatraLoginPage(driver, driverWait);
		logoutPage = new SinatraLogoutPage(driver, driverWait);
		aboutPage = new SinatraAboutPage(driver, driverWait);
		contactPage = new SinatraContactPage(driver, driverWait);
		songsPage = new SinatraSongsPage(driver, driverWait);
		addSongPage = new SinatraAddSongPage(driver, driverWait);
	}

	@After
	public void closePage() {
		driver.quit();
	}
}
