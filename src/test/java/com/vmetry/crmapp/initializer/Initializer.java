package com.vmetry.crmapp.initializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Initializer {
	/*
	 * Initializer WebDriver
	 */
	public static WebDriver driver;
	
	/*
	 * Initializer config Properties File
	 */
	public static FileInputStream envsrc;
	
	public static Properties envProp;
	
	/*
	 * Initializer locator Properties File
	 */
	public static FileInputStream locafigsrc;
	
	public static Properties locaProp;
	
	
	/*
	 * Initializer ExtentReports 
	 */
	public static ExtentHtmlReporter HtmlPath;
	
	public static ExtentReports Reports;
	
	public static ExtentTest Logs;
	
	public static void openBrowser(String BrowserName) throws Exception
	{
		
		
		HtmlPath = new ExtentHtmlReporter("D:\\WrokOutSelenium Wrokphase\\DDDCRMAPPTest\\Extent_Reports\\ExtentsReports.html");
		
		Reports = new ExtentReports();
		
		Reports.attachReporter(HtmlPath);
		
		envsrc = new FileInputStream(new File("D:\\WrokOutSelenium Wrokphase\\DDDCRMAPPTest\\src\\test\\resources\\com\\vmetry\\crmapp\\config\\env.properties"));
		
		
		envProp = new Properties();
		
		envProp.load(envsrc);
		
		locafigsrc = new FileInputStream(new File("D:\\WrokOutSelenium Wrokphase\\DDDCRMAPPTest\\src\\test\\resources\\com\\vmetry\\crmapp\\config\\locator.properties"));
		
		
		locaProp = new Properties();
		
		locaProp.load(locafigsrc);
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\rivers\\chromedriver.exe");
			
			driver= new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\rivers\\IEDriverServer.exe");
			
			driver= new InternetExplorerDriver();
		}else if(BrowserName.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\rivers\\geckodriver.exe");
			
			driver= new  FirefoxDriver();
		}
		  
		
		driver.manage().window().maximize();
		
		//driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	public static WebElement getElement(String XpathName)
	{
		
		return driver.findElement(By.xpath(locaProp.getProperty(XpathName)));
	}

}
