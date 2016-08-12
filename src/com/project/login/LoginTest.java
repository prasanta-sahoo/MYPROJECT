package com.project.login;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.project.Constants.Constants;
import com.project.PageObjects.LoginPageObject;
import com.project.TestBase.Baseclass;
import com.project.util.Readxsl;

public class LoginTest {

	private WebDriver driver;
	private Baseclass b = new Baseclass();
	private LoginPageObject ln = new LoginPageObject(driver);
	private Readxsl rd = new Readxsl();
	public static Logger add_log = null;
	
	@BeforeMethod
	public void Setup(){
		
		driver = b.setup();
		add_log = Logger.getLogger("rootlogger");
		
	}
	
	@AfterMethod
	
	public void Teardown(){
		
		b.tearup();
	}
	
	//Login with valid details
	
	@Test
	public void validlogin() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		
		ln =PageFactory.initElements(driver, LoginPageObject.class);
		int AssertFailedCount=0;
		
		System.out.println("Verify valid login details");
		
		System.out.println("Step 1 : Navigate to Login page");
		System.out.println("Step 2 : Enetr username");
		
	
		ln.setusername(Readxsl.getCellvalue(Constants.path, Constants.SheetName,1,0));
		
		System.out.println("Click on Next");
		ln.next();
		Thread.sleep(20);
		
		System.out.println("Enter Password");
		ln.setpassword(Readxsl.getCellvalue(Constants.path, Constants.SheetName,1,1));
		
		System.out.println("Click Submit");
		ln.clicksubmitbtn();
		Thread.sleep(20);
		
		String Title = "Clarion Technologies Pvt Ltd Mail";
		String ActualTitile = ((WebDriver) driver).getTitle();
		System.out.println("Titile is : " +ActualTitile);
		
		if(ActualTitile.equals(Title)){
		
			System.out.println("Login Successfully");
			add_log.info("Successful login");
		}
		
		else{
			
			System.out.println("TestCase Fail");
			add_log.info("TestCase Fail");
			AssertFailedCount++;
		}
			
		 if(AssertFailedCount>0){
			 
			 System.out.println("---- Test Failed. Please check the console for details");
			 add_log.info("---- Test Failed. Please check the console for details");
			 Assert.fail();
		 }
		
	}	
	
	/*login with invalid credential and check inline message
	 * 
	 */
	@Test(enabled=false)
	public void invalidlogindetails() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		
		 ln = PageFactory.initElements(driver,LoginPageObject.class);
		 int  AssertFailedcount=0;
		 System.out.println("Go to login page");
		 System.out.println("Enter username");
		 ln.setusername(rd.getCellvalue(Constants.path, Constants.SheetName, 2, 0));
		 System.out.println("Click on Next");
		 ln.next();
		 Thread.sleep(20);
		 System.out.println("Enter Password");
		 ln.setpassword(rd.getCellvalue(Constants.path,Constants.SheetName, 2, 1));
		 System.out.println("Click on Submit button");
		 ln.clicksubmitbtn();
		 System.out.println("Check inline validation message");
		 String validationmessage = ln.invalidpsederrmsg.getText();
		 if(validationmessage.contains("The email and password you entered don't match")){
			 
			 System.out.println("Validation works -testcasepass");
		 }
		 else
		 {
			 System.out.println("Validation not works -testcaseFail");
			 AssertFailedcount++;
		 }
		 
		 if(AssertFailedcount>0){
			 
			 Assert.fail();
		 }
		
	}

}
