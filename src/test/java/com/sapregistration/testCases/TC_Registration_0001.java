package com.sapregistration.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.sapregistration.pageObjects.RegistrationPage;
import com.sapregistration.testBase.BaseClass;

public class TC_Registration_0001 extends BaseClass{ 
	
	@Test
	
	public void verifyRegistration() throws InterruptedException {
			
		logger.info("********* TC_Registration_0001 *************");
		RegistrationPage rp=new RegistrationPage(driver);
		
		String fname = configPropObj.getProperty("fName");
		String lname = configPropObj.getProperty("lName")+randomestring();
		String email = fname+"."+lname+"@yopmail.com";
		driver.get(configPropObj.getProperty("baseURL"));
		
		logger.info(" Navigate to URL: "+configPropObj.getProperty("baseURL"));
		Assert.assertEquals(driver.getTitle(), configPropObj.getProperty("pageTitle"));
		logger.info("Title of the Page: "+driver.getTitle());
		
		rp.clickOnSignUp(); // Click on sign up
		logger.info("Clicked Sign in Button");
		rp.verifyRegistrationPage();
		
		rp.setFirstName(fname);
		logger.info("Entered First Name: "+fname);
		
	    rp.setLastName(lname);
	    logger.info("Entered Last Name: "+lname);
	    
	    rp.setEmail(email);
	    logger.info("Entered Email: "+email);
	    
	    rp.setPassword(configPropObj.getProperty("password"));
	    logger.info("Entered Set Password and Confirm Password: "+configPropObj.getProperty("password"));
	    rp.selectTermsAndPolicyCheckBox(driver);
	    
		rp.clickOnRisterButton();
		logger.info("Click on Rister Button");
		rp.verifyConfirmationMessage(configPropObj.getProperty("confirMessage"));
		logger.info("confirm Registration: "+configPropObj.getProperty("confirMessage")+" "+email);
	}

}
