package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		String browserName=GenericLib.getValue("browser");
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/home/vivek/Documents/driver/geckodriver");
			driver=new FirefoxDriver();
			Reporter.log("Firefox launched",true);
			
		}else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/home/vivek/Documents/driver/chromedriver");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Reporter.log("chrome launched",true);
			
		}else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver","./exefiles/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			Reporter.log("IE launched",true);		
		}
		WaitStattementLib.iWaitForSecs(driver, 20);
		String url=GenericLib.getValue("testurl");
		driver.get(url);
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		String scriptName =result.getMethod().getMethodName();
		if(result.isSuccess())     //true
		{
			System.out.println(scriptName+" script pass");
		}
		else {
			
			System.out.println(scriptName+" script failed");
			ScreenshotLib slib=new ScreenshotLib();
			slib.takeScreenshot(driver, scriptName);
			Reporter.log("Screenshot has been taken",true);
		}
		driver.close();
		Reporter.log("Browser closed",true);
		
	}
}