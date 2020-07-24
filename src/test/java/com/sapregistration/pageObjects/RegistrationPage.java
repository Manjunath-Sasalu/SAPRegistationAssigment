package com.sapregistration.pageObjects;


//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sapregistration.utilities.Utilities;

//import com.sap.testBase.BaseClass;

public class RegistrationPage{
	
	public WebDriver ldriver;

	public RegistrationPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Registration WebElements
	
	@FindBy(xpath = "//div[contains(text(),'Sign up')]")
	@CacheLookup
	WebElement btnSignUp;
	
	@FindBy(xpath = "//h1[contains(@id,'ids-heading-1')]")
	@CacheLookup
	WebElement lblRegistration;
	
	@FindBy(xpath = "//input[contains(@id,'firstName')]")
	@CacheLookup
	WebElement txtFirstName;
		
	@FindBy(xpath = "//input[contains(@id,'lastName')]")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(xpath = "(//input[contains(@name,'mail')])[2]")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[contains(@id,'newPasswordInput')]")
	@CacheLookup
	WebElement txtNewPassword;
	
	@FindBy(xpath = "//input[contains(@id,'retypeNewPasswordInput')]")
	@CacheLookup
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//input[contains(@id,'pdAccept')]")
	@CacheLookup
	WebElement chkPalicyAgree;
	
	@FindBy(xpath = "//input[contains(@id,'touAccept')]")
	@CacheLookup
	WebElement chkTerms;
	
	@FindBy(xpath = "//button[contains(text(),'Register')]")
	@CacheLookup
	WebElement btnRegister;
	
	
	@FindBy(xpath = "/html/body/main/div/div/div[2]")
	@CacheLookup
	WebElement confirmRigister;
	//Action Methods
	//driver.
	

	public void clickOnSignUp() {
		
		Utilities.webDriverExplicitWait(ldriver, btnSignUp, "clickable", 30);
		btnSignUp.click();
		
		ldriver.switchTo().frame("IDS_UI_Window");
	}
	
	public void verifyRegistrationPage()  {
		Utilities.webDriverExplicitWait(ldriver, lblRegistration, "visibility", 10);
		Assert.assertEquals("Registration",lblRegistration.getText());
	}
	
	public void setFirstName(String fName) {
		txtFirstName.clear();
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		txtLastName.clear();
		txtLastName.sendKeys(lName);
	}
	
	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String newPassword) {
		txtNewPassword.clear();
		txtNewPassword.sendKeys(newPassword);
		txtConfirmPassword.clear();
		txtConfirmPassword.sendKeys(newPassword);
	}
	
	public void selectTermsAndPolicyCheckBox(WebDriver ldriver) {
		
		Utilities.scrollToTillWebElement(ldriver, chkPalicyAgree);
		Utilities.webDriverExplicitWait(ldriver, chkPalicyAgree, "visibility", 10);
		chkPalicyAgree.click();
		chkTerms.click();
		
	}
	
	public void clickOnRisterButton()
	{
		btnRegister.click();
	}
	
	public void verifyConfirmationMessage(String confirmMessage) {
		Utilities.webDriverExplicitWait(ldriver, confirmRigister, "visibility", 10);
		String actulConfirm = confirmRigister.getText().trim();
        System.out.println("confMessage :  " + actulConfirm);
        Assert.assertEquals(actulConfirm.contains(confirmMessage),true);
        ldriver.switchTo().defaultContent();
	}
	
}
