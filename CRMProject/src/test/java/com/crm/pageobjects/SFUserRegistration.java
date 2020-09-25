package com.crm.pageobjects;

import org.openqa.selenium.By;

import com.crm.constants.Constants;
import com.crm.utils.PropertyUtils;

public class SFUserRegistration {

	
		// TODO Auto-generated method stub
		public static String baseProjectPath = System.getProperty(Constants.USER_DIR); //c://users.//srujan/workspace//AutomatonTesting
		public static PropertyUtils repository = new PropertyUtils(
				baseProjectPath.concat(Constants.SF_SINGUP_PAGE_OBJECTREPOSITORY_PROPERTY));
		
		public static By firstname=By.id(repository.getProperty("SIGNUP_FIRSTNAME"));
		public static By lastname=By.id(repository.getProperty("SIGNUP_LASTNAME"));
		public static By email=By.id(repository.getProperty("SIGNUP_EMAIL"));
		public static By role=By.id(repository.getProperty("SIGNUP_ROLE"));
		public static By company=By.id(repository.getProperty("SIGNUP_COMPANY"));
		public static By country=By.id(repository.getProperty("SIGNUP_COUNTRY"));
		public static By postalcode=By.id(repository.getProperty("SIGNUP_POSTALCODE"));
		public static By username=By.id(repository.getProperty("SIGNUP_USERNAME"));
		public static By checkbox=By.id(repository.getProperty("SIGNUP_CHECKBOX"));
		public static By signupsubmit=By.id(repository.getProperty("SIGNUP_SINGMEUP"));
		
	}


