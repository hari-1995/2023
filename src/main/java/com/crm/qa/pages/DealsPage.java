package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath= "//*[@id=\"dashboard-toolbar\"]/div[1]/span")
	WebElement dealslabel;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifydealslabel()
	{
		return dealslabel.isDisplayed();
	}
	


}
