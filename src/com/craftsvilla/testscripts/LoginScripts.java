package com.craftsvilla.testscripts;

import org.testng.annotations.Test;

import com.craftsvilla.generic.BaseTest;
import com.craftsvilla.generic.ReadExcel;
import com.craftsvilla.pompages.HomePage;

public class LoginScripts extends BaseTest{

	HomePage homepage = null;
	//SignInPage signinpage = null;
	
	@Test
	public void TC_01_Login() {
		
		try {
			//Read in the excel file.  FILE_PATH is from AutoConst file.
			String[][] credentials = ReadExcel.getData(FILE_PATH,"Main");
			
			//You set i = 1 to skip the header line
			for(int i = 1; i < credentials.length; i++) {

					String email = credentials[i][0];
					String password = credentials[i][1];
					
					System.out.println(email + " - " + password);
					
					/*
					 homepage.clickOnSignInLink();
					 singinpage.setEmail(email);
					 signinpage.clickOnContinue();
					 signinpage.enterPassword(password);
					 signinpage.clickOnLoginButtion();
					 */

			}
			
			
			
		}catch(Exception e) {
			
		}
		
		
		
	}
	
	
}
