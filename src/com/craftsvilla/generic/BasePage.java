package com.craftsvilla.generic;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

public class BasePage {
	//This will help us to identify elements are present or not or validating titles, handle alerts, mouse overs, etc.
	
	public WebDriver driver = null;
	
	//logs all the information related to the web elements here
	public Logger log = Logger.getLogger(BasePage.class); 
	
	//Constructor
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	//Now you can create methods
	
	//Check page title
	public void verifyTitle(String exp_title) {
		String act_title = null;
		try {
			WebDriverWait w = new WebDriverWait(driver,10);
			w.until(ExpectedConditions.titleIs(exp_title));
			act_title = driver.getTitle();
			
			//Checks the actual and expected titles.  If not right it will throw exception
			Assert.assertEquals(act_title, exp_title);  
			//5 types of messages to log:  debug, fatal, info, error messages, warning			
			log.info("Validated the "+act_title + " and the " + exp_title + " successfully.");

		}
		catch(Exception e) {
			log.error(act_title + " and the " + exp_title + " does not match. " + e);
		}
	}
	
	//check if webelement exist or not
	public void verifyElementPresent(WebElement ele) {
		
		try {
			WebDriverWait w = new WebDriverWait(driver,10);
			w.until(ExpectedConditions.visibilityOf(ele));
			log.info("WebElement " + ele + " found.");
		}
		catch(Exception e) {
			log.error("WebElement " + ele + " was not found" + e);
		}
	}
	
	public void mouseHover(WebElement ele) {
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			log.info("Mouseover on " + ele);
		}
		catch(Exception e){
			log.error("Unable to mouse hover on " + ele);
		}
	}
	
	
	public void handleDropdown(WebElement ele) {
		try
		{
			Select ddEle = new Select(ele);
			log.info("Select dropdown " + ele);
		}
		catch(Exception e){
			log.error("Unable to select from dropdown " + ele);
		}	
	}
	

}
