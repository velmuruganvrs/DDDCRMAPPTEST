package com.vmetry.crmapp.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.vmetry.crmapp.initializer.Initializer;

public class ScreenShoot extends Initializer {
	
	public static void extentReportsGenerator(ITestResult Result) throws Exception
	{
		
		if(Result.isSuccess())
		{
			
			Logs.log(Status.PASS, Result.getName());
			Logs.log(Status.PASS, "This Test Case Is Pass");
			
			String path=getScreeShoot(Result.getName());		
			Logs.addScreenCaptureFromPath(path);
		}else if(Result.getStatus()==ITestResult.FAILURE){
			Logs.log(Status.FAIL, Result.getName());
			Logs.log(Status.FAIL, Result.getThrowable());
			Logs.log(Status.FAIL, "This Test Case Is Fail");
			
			String path=getScreeShoot(Result.getName());		
			Logs.addScreenCaptureFromPath(path);
		}
		
			
	}

	
	
	public static String getScreeShoot(String MethodName) throws Exception
	{
		
		
		File Src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File Dst = new File("D:\\WrokOutSelenium Wrokphase\\DDDCRMAPPTest\\Scren_Shoot_Floder\\"+MethodName+".jpg");
		FileUtils.copyFile(Src, Dst);
		
		return Dst.toString();
		
		
	}
}
