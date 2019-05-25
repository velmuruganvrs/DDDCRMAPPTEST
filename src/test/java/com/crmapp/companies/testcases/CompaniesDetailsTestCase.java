package com.crmapp.companies.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vmetry.crmapp.initializer.DriverFunctions;
import com.vmetry.crmapp.initializer.Initializer;
import com.vmetry.crmapp.pages.CompaniesDetailsPages;
import com.vmetry.crmapp.utils.ScreenShoot;

public class CompaniesDetailsTestCase  extends Initializer{
	
	
	@BeforeClass
	
	public void setUp() throws Exception
	{
		
		openBrowser("chrome");
		
		DriverFunctions.loadURL("URL");
		 
		CompaniesDetailsPages.enterUserName("velmurugan");
		
		CompaniesDetailsPages.enterPassword("9789679298");
		CompaniesDetailsPages.clickLoginButton();
		
	}
	
	@Test(dataProvider="companiesPageTestdata")
	
	public void companiesPageTest(String CompnayName,String Status,String Catageory,String MobileNumber) throws Exception
	{
		
		Logs=Reports.createTest("companiesPageTest");
		driver.switchTo().frame("mainpanel");
		
		CompaniesDetailsPages.clickCompanyButton();
		CompaniesDetailsPages.enterCompanyName(CompnayName);
		//CompaniesDetailsPages.enterCompanyName(CompnayName);
		CompaniesDetailsPages.selectStatusValue(Status);
		CompaniesDetailsPages.category(Catageory);
		CompaniesDetailsPages.enterPhoneNumber(MobileNumber);
		CompaniesDetailsPages.clickSaveButton();
		
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		
	}
	
	
	@DataProvider(name="companiesPageTestdata")
	
	public Object[][] companiesDataSet()
	{
		Object[][] data = new Object[2][4];
		
		data[0][0]="TTSL";
		data[0][1]="Hot";
		data[0][2]="Partner";
		data[0][3]="9789679298";
		
		data[1][0]="SQS";
		data[1][1]="Active";
		data[1][2]="Client";
		data[1][3]="9789679299";
		
		return data;
				
	}
	
	@AfterMethod
	
	public void tearDown(ITestResult Result) throws Exception
	{
		
		ScreenShoot.extentReportsGenerator(Result);
		
	}

}

