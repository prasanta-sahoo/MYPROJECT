package com.project.TestBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.project.Constants.Constants;

public class Baseclass {
/* 
 * This is base class method - setup method will set url and maxsimize browser
 * tier up method will close the current browser
 *  
 */
	 WebDriver driver; 
	 
	 
	public WebDriver setup(){
		
		
		driver = new FirefoxDriver();
		driver.get(Constants.URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}
	
	public void tearup(){
		
		driver.close();
	}
	
}
