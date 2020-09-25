package com.crm.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crm.config.LocalDriverManager;
import com.crm.config.SeleniumNGSuite;
import com.crm.exception.AutomationException;
import com.crm.pageobjects.LoginPage;
import com.crm.utils.DriverUtilsImpl;
//import com.automation.utils.DriverUtilsImpl;
import com.crm.utils.TestDataUtils;
import com.crm.utils.TestResultsUtils;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginPageStepDefinition extends TestDataUtils{


	/** The usablemethods. */
	DriverUtilsImpl usablemethods = new DriverUtilsImpl();
	/** The logger. */
	private static final Logger LOG = LoggerFactory.getLogger(LoginPageStepDefinition.class);

	TestResultsUtils testResultUtils = new TestResultsUtils();

	@Given("^user is on the sfapplication login page$")
    public void user_is_on_the_sfapplication_login_page() throws Throwable {
		 try{
			 /** code which will throw erros will be placed in try blick setup method which is acepting url , browsername***/
				SeleniumNGSuite seleniumObj = new SeleniumNGSuite();
				seleniumObj.setUpSuite();
				LOG.info("Access the Salesforce URL::PASS");
				testResultUtils.logger.log(LogStatus.PASS, "Successfully opened the application");
					 
			 
		 }
		 catch(Throwable e){
			 /** cpde which needs to execute aftererror wull be placed in the catch block **/

			 e.printStackTrace(); //which will print error message to the consolde
			 String homescreenshot = usablemethods.capturescreenshot("home page");
			testResultUtils.logger.log(LogStatus.FAIL, "Application launch failed" + testResultUtils.logger.addBase64ScreenShot(homescreenshot)); 
		//above line will fail in the repot along with it wil show a screenshot of the failre too	 
			 
		 }
		 
	    } 
    

    @When("^user enters username and password$")
    public void user_enters_username_and_password() throws Throwable {
    	try{
        	/** as per earlier step it already launched a browser, open the app, now we need to enter username n pswd 
        	 * for which we need to caprre the proerpties for those 1st and place them in the properties file 
        	 * after that we need to keep the reference of those .proeprty file in the Pages classrs which we can sue it here
        	 * 
        	 * npw we need to understand various methods we have to perform ths operation n call those methods here
        	 * if we remember al the webdriver commands as a methof we have in driverItlsImplclass under util package
        	 */
        	
        	usablemethods.sendText(LoginPage.uname, "vodnalas@techsolutions.com");
        	usablemethods.sendText(LoginPage.pswd, "Krishna@2020");
        	
        	testResultUtils.logger.log(LogStatus.PASS, "Successfully entered  credentails to the app");
        	
        }catch(Throwable e){
        	
        	e.printStackTrace(); //which will print error message to the consolde
			 String loginPage = usablemethods.capturescreenshot("home page");
			testResultUtils.logger.log(LogStatus.FAIL, "Application login failed" + testResultUtils.logger.addBase64ScreenShot(loginPage)); 
		//above line will fail in the repot along with it wil show a screenshot of the failre too
        	
        }
    }

   /* @Then("^user click on the login button$")
    public void user_click_on_the_login_button() throws Throwable {
    	try {
        	usablemethods.gClick(LoginPage.login);
        	Thread.sleep(8500);
        }
         catch(Throwable e){
        	
        	e.printStackTrace(); //which will print error message to the consolde
			 String loginPage = usablemethods.capturescreenshot("home page");
			testResultUtils.logger.log(LogStatus.FAIL, "Application login failed" + testResultUtils.logger.addBase64ScreenShot(loginPage)); 
		//above line will fail in the repot along with it wil show a screenshot of the failre too
        	
        }*/
    

	
	  
}
	  
	  

	
	
	
	


