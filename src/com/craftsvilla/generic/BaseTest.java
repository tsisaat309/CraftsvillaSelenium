//class recording 13 - automation framework setup
package com.craftsvilla.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//after creating autoconst file for variables
//create a class that will help launch browser and set up all preconditions and post conditions

public class BaseTest implements AutoConst {
	
	public static WebDriver driver = null;  //static variables belong to the class
	public WebDriverWait wait = null;       //instance variables belong to the object
	
	//This is for the base state
	@Parameters("browser")
	@BeforeMethod
	public void launchApplication(String browser)
	{
		//System.out.println(browser);
		System.out.println("@BeforeMethod - launchApplication function entered.");
			
		switch(browser)
		{
			case "CHROME":
				System.setProperty(CHROME_KEY, CHROME_VALUE);
					driver = new ChromeDriver();
					wait=new WebDriverWait(driver,10);
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.get(APP_URL);
					break;
			case "FIREFOX":
				System.setProperty(GECKO_KEY, GECKO_VALUE);
				driver = new FirefoxDriver();
				wait=new WebDriverWait(driver,10);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(APP_URL);
				break;	
				
				
			//case "HTMLUnitDriver":
				//driver = new HTMLUnitDriver();  //we don't have this yet we need to download for headless browser
				//wait=new WebDriverWait(driver,10);
				//driver.manage().window().maximize();
				//driver.manage().deleteAllCookies();
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//driver.get(APP_URL);
				//break;					
		
			default:
				Reporter.log("Invalid browser selection", true);
			}
		
	}
	
	
	@AfterMethod
	public void closeApp() {
		driver.quit();  //use .quit() to close ALL browsers instead of .close()
	}
}
