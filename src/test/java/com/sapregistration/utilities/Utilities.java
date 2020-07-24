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
		  System.out.println("***************** scrollToElement *****************");         
//	    		WebElement weElement = null;         
//	    		try {             
//	    			weElement = driver.findElement(By.id(weElement));         
//	    			} catch (Exception e) {             
//	    				weElement = driver.findElement(By.id(weElement));         
//	    			}         
	    		JavascriptExecutor js = (JavascriptExecutor) driver;         
	    		js.executeScript("window.scrollBy(4000,0)", weElement);        
	    		js.executeScript("window.scrollBy(4000,0)", weElement);         
	    		js.executeScript("arguments[0].scrollIntoView(true);", weElement);    
	    }
	  
	  public static void switchToFrame(WebDriver driver, String frameName) {
		  driver.switchTo().frame(frameName);
	  }
	  
	  
	  public static void webDriverImplicitWait(WebDriver driver, WebElement weElement, String action, int timeInSeconds) {
		  
		
		  WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
		  if(action.equals("clickable")) {
			  
		  }else if(action.equals("visibility")) {
			  
			  wait.until(ExpectedConditions.visibilityOf(weElement));
		  }     
		  
	  }

}
