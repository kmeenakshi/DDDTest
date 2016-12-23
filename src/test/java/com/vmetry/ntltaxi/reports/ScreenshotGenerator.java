package com.vmetry.ntltaxi.reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.vmetry.ntltaxi.initialiser.Initialiser;

public class ScreenshotGenerator extends Initialiser{
	public static String takeScreenshot(String name) throws IOException{
		   File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		   File dst=new File("C:\\Seleniumworkspace\\DDDTest\\Screenshot\\"+name+".jpg");
		   FileUtils.copyFile(src, dst);
		   return dst.toString();   
		}
	public static void attachscreenshot(ITestResult it) throws IOException
	{
		Object[] data=it.getParameters();
		 if(it.isSuccess())
		    {
		    String path=takeScreenshot(data[0].toString());
		    log.addScreenCapture(path);
		    log.log(LogStatus.PASS, "testcase pass", path);
		    }else
		    {
		        String path=takeScreenshot(data[0].toString());
		        log.addScreenCapture(path);
		        log.log(LogStatus.FAIL, "testcase pass",path );
		     }
		    report.endTest(log);
		    report.flush();
	}
}
