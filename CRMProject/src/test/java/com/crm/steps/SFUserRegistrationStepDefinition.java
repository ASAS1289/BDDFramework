package com.crm.steps;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.config.SeleniumNGSuite;
import com.crm.pageobjects.LoginPage;
import com.crm.pageobjects.SFUserRegistration;
import com.crm.utils.DriverUtilsImpl;
import com.crm.exception.AutomationException;
import com.crm.utils.TestDataUtils;
import com.crm.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SFUserRegistrationStepDefinition extends TestDataUtils{

	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	private static final Logger LOG = LoggerFactory.getLogger(SFUserRegistrationStepDefinition.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();
	
	 @Given("^user is on signup page$")
	    public void user_is_on_signup_page() throws Throwable {
		 try{
			 /** code which will throw erros will be placed in try blick setup method which is acepting url , browsername***/
				SeleniumNGSuite seleniumObj = new SeleniumNGSuite();
				seleniumObj.setUpSuite();
				LOG.info("Access the Salesforce URL::PASS");
				testResultUtils.logger.log(LogStatus.PASS, "Successfully opened the application");
				
				
				/*
				 * abpve method is taking inputs from config file and it is trying to alunch the chrome browser n in which it will open the applications
				 */
		 }
			 
		 catch(Throwable e){
			 /** cpde which needs to execute aftererror wull be placed in the catch block **/

			 e.printStackTrace(); //which will print error message to the consolde
			 String homescreenshot = usablemethods.capturescreenshot("home page");
			testResultUtils.logger.log(LogStatus.FAIL, "Application launch failed" + testResultUtils.logger.addBase64ScreenShot(homescreenshot)); 
		//above line will fail in the repot along with it wil show a screenshot of the failre too	 
			 
		 }
	    }

	    @When("^user enters firstname last name email role comapny country postalcode and username$")
	    public void user_enters_firstname_last_name_email_role_comapny_country_postalcode_and_username() throws Throwable {
	    	 try{
	    	usablemethods.sendText(SFUserRegistration.firstname, "Ram");
	    	usablemethods.sendText(SFUserRegistration.lastname, "goli");
	    	usablemethods.sendText(SFUserRegistration.email, "ram.goli@gmail,com");
	    	List<WebElement> ddoptions=usablemethods.gGetAllOptions(SFUserRegistration.role);
	    	ddoptions.get(1).click();
	    	usablemethods.sendText(SFUserRegistration.company, "golitech");
	    	usablemethods.sendText(SFUserRegistration.country, "US");
	    	usablemethods.sendText(SFUserRegistration.postalcode, "20152");
	    	usablemethods.sendText(SFUserRegistration.username, "Ram@golitech.com");
	    	
	    	
	    	testResultUtils.logger.log(LogStatus.PASS, "Successfully entered  credentails to the app");
	    	 }
	    	 catch(Throwable e){
		        	
		        	e.printStackTrace(); //which will print error message to the consolde
					 String loginPage = usablemethods.capturescreenshot("home page");
					testResultUtils.logger.log(LogStatus.FAIL, "Application login failed" + testResultUtils.logger.addBase64ScreenShot(loginPage)); 
				//above line will fail in the repot along with it wil show a screenshot of the failre too
		        	
		        }
	    }

	    @When("^user click on checkbox$")
	    public void user_click_on_checkbox() throws Throwable {
	    	try {
	    	usablemethods.gClick(SFUserRegistration.checkbox);
	    	testResultUtils.logger.log(LogStatus.FAIL, "successfully Logged into the application");
	    	}
catch(Throwable e){
	        	
	        	e.printStackTrace(); //which will print error message to the consolde
				 String loginPage = usablemethods.capturescreenshot("home page");
				testResultUtils.logger.log(LogStatus.FAIL, "Application login failed" + testResultUtils.logger.addBase64ScreenShot(loginPage)); 
			//above line will fail in the repot along with it wil show a screenshot of the failre too
	        	
	        }
	    }

	    @Then("^user click on signupsubmit$")
	    public void user_click_on_signupsubmit() throws Throwable {
	    	try {
		    	usablemethods.gClick(SFUserRegistration.signupsubmit);
		    	testResultUtils.logger.log(LogStatus.FAIL, "successfully Logged into the application");
		    	} 
catch(Throwable e){
	        	
	        	e.printStackTrace(); //which will print error message to the consolde
				 String loginPage = usablemethods.capturescreenshot("home page");
				testResultUtils.logger.log(LogStatus.FAIL, "Application login failed" + testResultUtils.logger.addBase64ScreenShot(loginPage)); 
			//above line will fail in the repot along with it wil show a screenshot of the failre too
	        	
	        }
	    }


}
