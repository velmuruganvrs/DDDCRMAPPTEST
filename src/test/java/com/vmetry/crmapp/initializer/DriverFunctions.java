package com.vmetry.crmapp.initializer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DriverFunctions extends Initializer{
	
	public static void loadURL(String URL)
	{
	
		driver.get(envProp.getProperty(URL));
	}

	
	public static void acctionClassFunction(WebElement target,WebElement Dest)
	{
		Actions bulider = new Actions(driver);
		
		bulider.moveToElement(target).moveToElement(Dest).click().build().perform();
	}
	
	public static void  selectClassFunction(WebElement element,String Value)
	{
		Select s = new Select(element);
		
		s.selectByVisibleText(Value);
	}
}
