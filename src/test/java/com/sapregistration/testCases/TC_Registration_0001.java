package com.sapregistration.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.sapregistration.pageObjects.RegistrationPage;
import com.sapregistration.testBase.BaseClass;
import com.sapregistration.utilities.XLUtils;

public class TC_Registration_0001 extends BaseClass{ 
	
	@Test(dataProvider="RegisterData")
	
	public void verifyRegistration(String firstName, String lastName, String emailId, String password) throws InterruptedException {
			
		logger.info("********* TC_Registration_0001 *************");
		RegistrationPage rp=new RegistrationPage(driver);
		
		String fname = firstName;//configPropObj.getProperty("fName");
		String lname = lastName+randomestring();	//configPropObj.getProperty("lName")+randomestring();
		String email = fname+"."+lname+"@yopmail.com";  //Generating unique mail id's
		
		driver.get(configPropObj.getProperty("baseURL"));
		logger.info(" Navigate to URL: "+configPropObj.getProperty("baseURL"));
		Assert.assertEquals(driver.getTitle(), configPropObj.getProperty("pageTitle"));
		logger.info("Title of the Page: "+driver.getTitle());
		
		rp.clickOnSignUp(); // Click on sign up
		logger.info("Clicked Sign in Button");
		rp.verifyRegistrationPage();
		
		rp.setFirstName(fname);
		System.out.println("Entered First Name: "+fname);
		logger.info("Entered First Name: "+fname);
		
	    rp.setLastName(lname);
	    System.out.println("Entered Last Name: "+lname);
	    logger.info("Entered Last Name: "+lname);
	    
	    rp.setEmail(email);
	    System.out.println("Entered Email: "+email);
	    logger.info("Entered Email: "+email);
	    
	    //rp.setPassword(configPropObj.getProperty("password"));
	    rp.setPassword(password);
	    logger.info("Entered Set Password and Confirm Password: "+configPropObj.getProperty("password"));
	    rp.selectTermsAndPolicyCheckBox(driver);
	    
		rp.clickOnRisterButton();
		logger.info("Click on Rister Button");
		rp.verifyConfirmationMessage(configPropObj.getProperty("confirMessage"));
		logger.info("confirm Registration: "+configPropObj.getProperty("confirMessage")+" "+email);
	}
	
	@DataProvider(name="RegisterData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/TestData/Register.xlsx";
		
		int totalrows=XLUtils.getRowCount(path, "Sheet1");	
		int totalcols=XLUtils.getCellCount(path,"Sheet1",1);
				
		String regdata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //5
		{		
			for(int j=0;j<totalcols;j++)
			{
				regdata[i-1][j]= XLUtils.getCellData(path, "Sheet1",i, j);  //1,0
			}
		}
	return regdata;
				
	}

}
