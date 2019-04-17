package com.actitime.scripts;


import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.Excelutilities;
import com.actitime.generic.WaitStattementLib;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;

public class LoginTest extends BaseLib
{
   @Test(priority=1)
   public void validLogin()
   {
	 
	   String username=Excelutilities.readData("Sheet1",1,1);
	   String password=Excelutilities.readData("Sheet1", 1,2);
	   LoginPage lp=new LoginPage(driver);
	   lp.login(username, password);
	   
	   EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
	   ettp.verifyLogo();
	   ettp.verifyTitle();
	   
  }
   @Test(priority=2)
   public void invalidLogin()
   {
	   String username=Excelutilities.readData("Sheet1",2,1);
	   String password=Excelutilities.readData("Sheet1", 2,2);
	   LoginPage lp=new LoginPage(driver);
	   lp.login(username, password);
	   WaitStattementLib.eWaitForVsibility(driver, 10,lp.getInvalidLoginMsg());
	   lp.verifyInvalidLogin();
  }
}