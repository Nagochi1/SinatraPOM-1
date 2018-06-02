package com.herokuapp.sinatra.utils;

import org.openqa.selenium.WebElement;

public class PageElementsValidation {

	public boolean elementsValidation(WebElement[] containerList) {

		boolean flag = false;
		
		try {
			
			for (WebElement webElement : containerList) {
				flag = elementValidation(webElement);
				if(!flag)
					return false;
			}
			
			
		} catch (Exception e) {
			System.out.println("Element not found");
			return false;
		}
		
		
		return true;
	}

	public boolean elementValidation(WebElement webElement) {
		
		return webElement.isDisplayed() && webElement.isEnabled();

	}
}
