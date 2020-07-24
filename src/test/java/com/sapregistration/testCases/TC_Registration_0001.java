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
			
		RegistrationPage rp=new RegistrationPage(driver);
		
		String fname = firstName;
		String lname = lastName+randomestring();
		String email = fname+"."+lname+"@yopmail.com";
		
		driver.get(configPropObj.getProperty("baseURL"));
		Assert.assertEquals(driver.getTitle(), configPropObj.getProperty("pageTitle")); //Verify title of the page	
		rp.clickOnSignUp(); // Click on sign up
		
		rp.verifyRegistrationPage();
		rp.setFirstName(fname);
	    rp.setLastName(lname);    
	    rp.setEmail(email);
	    
	    rp.setPassword(password);
	    rp.selectTermsAndPolicyCheckBox(driver);
	    
		rp.clickOnRisterButton();
		rp.verifyConfirmationMessage(configPropObj.getProperty("confirMessage"));
		
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
