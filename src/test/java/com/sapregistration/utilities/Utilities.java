package com.sapregistration.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities {
	
	
	  public static void scrollToElement(WebDriver driver, WebElement weElement) 
	    {         
		 
	    		JavascriptExecutor js = (JavascriptExecutor) driver;         
	    		js.executeScript("window.scrollBy(4000,0)", weElement);        
	    		js.executeScript("window.scrollBy(4000,0)", weElement);         
	    		js.executeScript("arguments[0].scrollIntoView(true);", weElement);    
	    }
	  
	  public static void switchToFrame(WebDriver driver, String frameName) {
		  driver.switchTo().frame(frameName);
	  }
	  
	  
	  public static void webDriverExplicitWait(WebDriver driver, WebElement weElement, String action, int timeInSeconds) {
		  
		
		  WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
		  if(action.equals("clickable")) {
			  wait.until(ExpectedConditions.elementToBeClickable(weElement));
		  }else if(action.equals("visibility")) {
			  
			  wait.until(ExpectedConditions.visibilityOf(weElement));
		  }     
		  
	  }
	  
	  public static void scrollToTillWebElement(WebDriver driver, WebElement weElement) {
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", weElement);
	  }

}
