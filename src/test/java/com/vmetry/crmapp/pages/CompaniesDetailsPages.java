package com.vmetry.crmapp.pages;

import org.openqa.selenium.WebElement;

import com.vmetry.crmapp.initializer.DriverFunctions;
import com.vmetry.crmapp.initializer.Initializer;

public class CompaniesDetailsPages extends Initializer{
	
	
	public static void enterUserName(String UserName)
	{
		getElement("USERNAME_XPATH").clear();
		getElement("USERNAME_XPATH").sendKeys(UserName);
	}
	
	public static void enterPassword(String Password)
	{
		getElement("PASSWROD_XPATH").clear();
		getElement("PASSWROD_XPATH").sendKeys(Password);
	}
	
	public static void clickLoginButton()
	{
		getElement("LOGIN_BUTTON_XPATH").click();
	}

	public static void clickCompanyButton()
	{
		WebElement target=getElement("COMPANIES_BUTTON_XAPTH");
		WebElement Dest=getElement("NEWCOMPANIES_BUTTON_XAPTH");
		
		DriverFunctions.acctionClassFunction(target, Dest);
	}
	
	public static void enterCompanyName(String CompanyName)
	{
		getElement("COMPANIES_NAME_XPATH").sendKeys(CompanyName);
	}
	
	public static void selectStatusValue(String Value)
	{
		WebElement status=getElement("STATUS_SELECTBUTTON_XPATH");
		
		DriverFunctions.selectClassFunction(status, Value);
		
		
		
	}
	
	public static void category(String Value)
	{
		WebElement category=getElement("CATEGORY_SELECTBUTTON_XPATH");
		
		DriverFunctions.selectClassFunction(category, Value);
	}
	
	public static void enterPhoneNumber(String PhoneNo)
	{
		getElement("PHONENO_XPATH").sendKeys(PhoneNo);
	}
	
	public static void clickSaveButton()
	{
		getElement("SAVE_BUTTON_XPATH").click();
	}
}
