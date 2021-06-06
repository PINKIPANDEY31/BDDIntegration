package com.web.automation.useractivity;

import java.io.File;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class CaptureScreenshot {
	    
	
	public static void captureScreenMethod(WebDriver driver) throws Exception{
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotFile, new File(".\\screenshots\\fullimage.png"));
		
}
}
