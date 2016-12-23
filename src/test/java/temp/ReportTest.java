package temp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportTest {
	public WebDriver wd;
	public ExtentReports report;
	public ExtentTest log;
	
@Test(priority=1)
public void googletest()
{
	wd=new FirefoxDriver();
	wd.get("https://www.google.co.in/?gfe_rd=cr&ei=1PdZWKyCG8X08wesnJG4DA&gws_rd=ssl");
	report=new ExtentReports("C:\\Seleniumworkspace\\DDDTest\\Reports\\report.html");
	log= report.startTest("googletest");
	
	
	
}
@Test(priority=2)
public void yahootest()
{
	log = report.startTest("yahootest");
	wd.get("https://www.yahoo.com/");
}
@Test(priority=3)
public void maventest()
{
	log = report.startTest("maventest");
	wd.get("https://mvnrepository.com/artifact/com.relevantcodes/extentreports/2.41.2");
}
@AfterMethod
public void teardown(ITestResult it) throws IOException{
    
    if(it.isSuccess())
    {
    String path=takeScreenshot(it.getName());
    log.addScreenCapture(path);
    log.log(LogStatus.PASS, "testcase pass", path);
    }else
    {
        String path=takeScreenshot(it.getName());
        log.addScreenCapture(path);
        log.log(LogStatus.FAIL, "testcase pass",path );
     }
    report.endTest(log);
    report.flush();
}

public String takeScreenshot(String name) throws IOException{
   File src=((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
   File dst=new File("C:\\Seleniumworkspace\\DDDTest\\Screenshot\\"+name+".jpg");
   FileUtils.copyFile(src, dst);
   return dst.toString();   
}

}
