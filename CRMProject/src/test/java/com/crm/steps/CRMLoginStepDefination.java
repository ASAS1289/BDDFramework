package com.crm.steps;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.config.SeleniumNGSuite;
import com.crm.pageobjects.CRMLoginPage;
import com.crm.pageobjects.LoginPage;
import com.crm.utils.DriverUtilsImpl;
import com.crm.utils.TestDataUtils;
import com.crm.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CRMLoginStepDefination extends TestDataUtils{

	
	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	private static final Logger LOG = LoggerFactory.getLogger(LoginPageStepDefinition.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	
	 @Given("^user on the crm login page$")
	    public void user_on_the_crm_login_page() throws Throwable {
		 try {
		 SeleniumNGSuite seleniumObject= new SeleniumNGSuite();
		   seleniumObject.setUpSuite();
		   testResultUtils.logger.log(LogStatus.PASS, "successfully opened the application");
		 }
		 catch(Throwable e) {
			 String screenshot = usablemethods.capturescreenshot("Login Page");
			 testResultUtils.logger.log(LogStatus.FAIL, " Application failed to load" + testResultUtils.logger.addBase64ScreenShot(screenshot)); 
			 e.printStackTrace();
		 }
	    }
	 
	 @When("^user enter login credentails$")
	    public void user_enter_login_credentails(DataTable dt) throws Throwable {
		    try{
	    	List<String> values=dt.asList(String.class);
	    	System.out.println("1st value is " + values.get(0));
	    	System.out.println("2nd value is " + values.get(1));
	    	usablemethods.sendText(CRMLoginPage.uname, values.get(0));
	     	usablemethods.sendText(CRMLoginPage.pswd, values.get(1));
	     	testResultUtils.logger.log(LogStatus.PASS, "Successfully entered  credentails to the app");
		    }
		    catch(Throwable e){
		    	String screenshot = usablemethods.capturescreenshot("Username and Password");
		    	testResultUtils.logger.log(LogStatus.FAIL, "Username and password not entered" + testResultUtils.logger.addBase64ScreenShot(screenshot));
		    	e.printStackTrace();
		    }

	 }

	 @Then("^click on the login button$")
	    public void click_on_the_login_button() throws Throwable {
		 try {
		 usablemethods.gClick(CRMLoginPage.login);
		 testResultUtils.logger.log(LogStatus.PASS, "Login button is working");
	     	Thread.sleep(8500);
		 }
		 catch(Throwable e) {
			 String screenshot = usablemethods.capturescreenshot("Click Login Button");
			 testResultUtils.logger.log(LogStatus.FAIL, "Login button is not clicked" + testResultUtils.logger.addBase64ScreenShot(screenshot));
			 e.printStackTrace();
		 }
		 }
	    
	 
	 @And("^verify user on home page$")
	    public void verify_user_on_home_page() throws Throwable {
		 try {
		 boolean logincheck= usablemethods.isElementPresent(CRMLoginPage.homepage);
	
	      if(logincheck)
	      {
	    	  System.out.println("Login successfull");
	    	  testResultUtils.logger.log(LogStatus.PASS, "successfully Logged into the application");
	    	  
	      }
	      else
	      {
	    	  System.out.println("Login failed");
	    	  testResultUtils.logger.log(LogStatus.FAIL, "Login Failed into the application");
	     
	 }
		}
		catch(Throwable e) {
			String screenshot = usablemethods.capturescreenshot("home page");
			testResultUtils.logger.log(LogStatus.FAIL, "user failed Logged into the application" + testResultUtils.logger.addBase64ScreenShot(screenshot));	
			e.printStackTrace();
		}
		
	}
 }

