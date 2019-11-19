package com.craftsvilla.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.generic.BasePage;



public class HomePage extends BasePage
{
	//Identifies the webelement at that point in time(run-time)

	@FindBy(xpath="//a[@href='/']")
	private WebElement lnk_logo;
	
	@FindBy(id="carCount")
	private WebElement lnk_cart;
	
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement lnk_signIn;
	
	@FindBy(name="q")
	private WebElement txt_search;
	
	@FindBy(xpath="//a[@href=\"/womens-clothing/sarees/?MID=megamenu_sarees_seeall\"]")
	private WebElement lnk_sarees;
	
	//Constructor
	public HomePage(WebDriver driver)
	{
		super(driver); //This helps you be able to handle super class members
		PageFactory.initElements(driver, this);
		
		//above is like 
		//PageFactory.initElements(driver, HomePage.class);
	}
	
	
	//now use the methods that were created from BasePage
	public void clickOnLogo() {
		try {
			verifyElementPresent(lnk_logo);
			lnk_logo.click();
			log.info("Clicked Successfully on " + lnk_logo);
		}
		catch(Exception e) {
			log.error("Unable to click on " + lnk_logo + e);
		}
	}
	
	public void clickOnCart() {
		try {
			verifyElementPresent(lnk_cart);
			lnk_cart.click();
			log.info("Clicked successfully on " + lnk_cart);
		}
		catch(Exception e) {
			log.error("Unable to click on " + lnk_cart + e);			
		}
	}
	
	public void goToSareesLink() {
		try {
			verifyElementPresent(lnk_sarees);
			mouseHover(lnk_sarees);
			log.info("Mousehovered successfully on " + lnk_sarees);
		}
		catch(Exception e) {
			log.error("Unable to mouseover " + lnk_sarees + e);			
		}
	}	
	
}
