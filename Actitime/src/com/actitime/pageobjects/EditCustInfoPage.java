package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustInfoPage {

	@FindBy(css="input[Value='Delete This Customer']")
	private WebElement deleteThisCustBtn;
	@FindBy(id="deleteButton")
	private WebElement deleteBtn;
	
	public EditCustInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void deleteCustomer()
	{
		deleteThisCustBtn.click();
		deleteBtn.click();
	}
}