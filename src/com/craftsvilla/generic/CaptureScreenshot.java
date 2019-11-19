package com.craftsvilla.generic;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class CaptureScreenshot implements ITestListener {
	
	public static String myTimeString = null;
	
	public static void myTime() {
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now(); 
		   
		   String myTime = dtf.format(now);
		   System.out.println(myTime);
		   
		   String myYear = myTime.split("/")[0];
		   String myMonth = myTime.split("/")[1];
		   String myDay = (myTime.split("/")[2]).split(" ")[0];
		   System.out.println(myMonth + myDay + myYear);
		   
		   String myHr = (myTime.split(" ")[1]).split(":")[0];
		   String myMin = (myTime.split(" ")[1]).split(":")[1];
		   String mySec = (myTime.split(" ")[1]).split(":")[2];
		   myTimeString = myHr+myMin+mySec;   
		   //System.out.println(myTimeString);
	}
	

	public void onTestStart(ITestResult result) {
		
		EventFiringWebDriver event = new EventFiringWebDriver(BaseTest.driver);
		String methodName=result.getMethod().getMethodName();  //returns the name of the method that failed.
		myTime();
		
		try {
			//screenshot is created in a png file
			File src = event.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\SeleniumTraining\\OutputFiles\\onTestStart-" + methodName + "-"+myTimeString+".png"));
					
		}
		catch(Exception e) {
			
		}
	}

	public void onTestFinish(ITestContext context) {

	}
	

	
	public void onTestSuccess(ITestResult result) {
		EventFiringWebDriver event = new EventFiringWebDriver(BaseTest.driver);
		String methodName=result.getMethod().getMethodName();  //returns the name of the method that failed.
		myTime();
		
		try {
			//screenshot is created in a png file
			File src = event.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\SeleniumTraining\\OutputFiles\\onTestSuccess-" + methodName + "-"+myTimeString+".png"));
		}
		catch(Exception e) {
			
		}
	}


	//get screenshot of failure
	public void onTestFailure(ITestResult result) {
		EventFiringWebDriver event = new EventFiringWebDriver(BaseTest.driver);
		String methodName=result.getMethod().getMethodName();  //returns the name of the method that failed.
		myTime();
		
		try {
			//screenshot is created in a png file
			File src = event.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\SeleniumTraining\\OutputFiles\\onTestFailure-" + methodName + "-"+myTimeString+".png"));
		}
		catch(Exception e) {
			
		}
	}


	public void onTestSkipped(ITestResult result) {
		EventFiringWebDriver event = new EventFiringWebDriver(BaseTest.driver);
		String methodName=result.getMethod().getMethodName();  //returns the name of the method that failed.
		myTime();
		
		try {
			//screenshot is created in a png file
			File src = event.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\SeleniumTraining\\OutputFiles\\onTestSkipped-" + methodName + "-"+myTimeString+".png"));
		}
		catch(Exception e) {
			
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}


	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}

 

