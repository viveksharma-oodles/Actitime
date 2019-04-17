package com.actitime.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class ActiveProjAndCustPage extends Basepage {

	@FindBy(css="input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	@FindBy(className="successmsg")
	private WebElement successMsg;
	@FindBy(name="selectedCustomer")
	private WebElement customerDrpDwn;
	@FindBy(css="input[Value*='Show']")
	private WebElement showBtn;
	@FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private List<WebElement> custNameLink; 
	
	public ActiveProjAndCustPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCreateNewCustBtn()
	{
		createNewCustBtn.click();
	}
	
	public void verifyCreateCustomer(String customerName)
	{
		Assert.assertTrue(successMsg.isDisplayed());
		Reporter.log("create customer msg is displayed",true);
		Assert.assertTrue(successMsg.getText().contains(customerName));
		Reporter.log(successMsg.getText(),true);
	    	
	}
	public void selectCustomer(String customerName)
	{
		Select sel=new Select(customerDrpDwn);
		sel.selectByVisibleText(customerName);
		showBtn.click();
		if(custNameLink.get(0).getText().equals(customerName))
		{
			custNameLink.get(0).click();
		}
		else {
			System.out.println(customerName+" customer doesnot exist");
		}	
	}
	
	public void verifyDeleteCustomer()
	{
		String expMsg="Customer has been successfully deleted.";
		String actMsg= successMsg.getText();
		Assert.assertEquals(actMsg, expMsg);
		Reporter.log(expMsg,true);
	}
}