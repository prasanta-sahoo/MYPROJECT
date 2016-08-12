package com.project.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	WebDriver driver;
	
	@FindBy(how=How.ID, using="Email")
	public static WebElement uname;
	
	@FindBy(how=How.ID,using="next")
	public static WebElement next;
	
	@FindBy(how=How.ID,using="Passwd")
	public static WebElement password;
	
	@FindBy(how=How.ID, using="signIn")
	public static WebElement submitbtn;
	
	@FindBy(how=How.XPATH, using=".//*[@id='errormsg_0_Passwd']")
	public static WebElement invalidpsederrmsg;
	
	
	public void setusername(String usrname){
		uname.sendKeys(usrname);
		
		}
	public void next(){
		
		next.click();
	}
	
	public void setpassword(String paswd){
		
		password.sendKeys(paswd);
	}
	
	public void clicksubmitbtn(){
	 submitbtn.click();
	}
	
	
	
	public LoginPageObject(WebDriver driver){
		 //create a constructor to invoke the page factory to initialize/load all the webelements present in page class 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
