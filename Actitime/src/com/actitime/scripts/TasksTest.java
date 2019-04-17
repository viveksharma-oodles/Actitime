package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.Excelutilities;
import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTasksPage;

public class TasksTest extends BaseLib {

	@Test
	public void createCustomer()
	{
		 String username=Excelutilities.readData("Sheet1",3,1);
		 String password=Excelutilities.readData("Sheet1", 3,2);
		 LoginPage lp=new LoginPage(driver);
		 lp.login(username, password);
		 
		 EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		 ettp.clickOnTasks();
		 
		 OpenTasksPage otp=new OpenTasksPage(driver);
		 otp.clickOnProjAndCustLink();
		 
		 ActiveProjAndCustPage apacp=new ActiveProjAndCustPage(driver);
		 apacp.clickOnCreateNewCustBtn();
		 
		 String customerName=Excelutilities.readData("Sheet1",3,3);
		 CreateNewCustPage cncp=new CreateNewCustPage(driver);
		 cncp.createCustomer(customerName);
		 apacp.verifyCreateCustomer(customerName);
		 apacp.clickOnLogout();
	}
	@Test(dependsOnMethods= {"createCustomer"})
	public void deleteCustomer()
	{
		String username=Excelutilities.readData("Sheet1",4,1);
		   String password=Excelutilities.readData("Sheet1", 4,2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		OpenTasksPage otp=new OpenTasksPage(driver);
		otp.clickOnProjAndCustLink();
		String customerName=Excelutilities.readData("Sheet1",4,3);
		ActiveProjAndCustPage apacp=new ActiveProjAndCustPage(driver);
		apacp.selectCustomer(customerName);
		EditCustInfoPage ecip=new EditCustInfoPage(driver);
		ecip.deleteCustomer();
		apacp.verifyDeleteCustomer();
		apacp.clickOnLogout();
	}
}