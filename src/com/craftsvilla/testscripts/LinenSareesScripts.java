package com.craftsvilla.testscripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.craftsvilla.generic.BaseTest;
import com.craftsvilla.pompages.HomePage;

public class LinenSareesScripts extends BaseTest{
	
	HomePage homePage = null;
	//SareesPage sareesPage = null;
	//LinenSareesPage linensarees = null;
	//ProductDescriptionPage prodescpage = null;
	//CartPage cartpage = null;
	
	@Test
	public void tc_o1_buyLinenSaree() {
		
		homePage = new HomePage(driver);
		//SareesPage = new SareesPage(driver);
		//LinenSareesPage = new LinenSareesPage(driver);
		//ProductDescriptionPage = new ProductionDescriptionPage(driver);
		//CartPage = new CartPage(driver);
	
		
		try {
			homePage.goToSareesLink();
			//sareesPage.clickOnLinenSarees();
			//linen
			
			Reporter.log("tc_o1_buyLinenSaree - test case executed successfully.", true);
			
		}
		catch(Exception e)
		{
			Reporter.log("tc_o1_buyLinenSaree - test case failed " + e, true);
		}
		
	}

}
