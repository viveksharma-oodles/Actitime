package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage extends Basepage 
{
    WebDriver driver;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public void verifyTitle()
	{
		String expTitle="actiTIME - Enter Time-Track";
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, expTitle);
		Reporter.log("Home page title is verified",true);
		}
}