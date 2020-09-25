package com.crm.pageobjects;

import org.openqa.selenium.By;

import com.crm.constants.Constants;
import com.crm.utils.PropertyUtils;

public class CRMLoginPage {

	public static String baseProjectPath = System.getProperty(Constants.USER_DIR); //c://users.//srujan/workspace//AutomatonTesting
	public static PropertyUtils repository = new PropertyUtils(
			baseProjectPath.concat(Constants.CRM_LOGIN_PAGE_OBJECTREPOSITORY_PROPERTY));
	
	public static By uname=By.name(repository.getProperty("CRM_USERNAME_Text_Field"));
	public static By pswd=By.name(repository.getProperty("CRM_PASSWORD_Text_Field"));
	public static By login=By.xpath(repository.getProperty("CRM_LOGIN_BUTTON_Xpath"));
	public static By homepage=By.xpath(repository.getProperty("CRM_Homepage_Xpath"));			
	
}
