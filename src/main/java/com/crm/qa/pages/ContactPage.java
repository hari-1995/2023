/**********
Author : Hari Krishna
Date: 02-Aug-2023

************/ 
package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]/span")
	WebElement contactlabel;

	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div/table/tbody/tr/td[2]/a")
	WebElement contactcheckbox;
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
	WebElement newcontactlink;
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement firstname;
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[2]/div/div/input")
	WebElement lastname;
	
	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement savebtn;
	 
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}

	public Boolean verifycontactlabel()
	{
		return contactlabel.isDisplayed();
	}
	
	public void selectcontact()
	{
		Actions act = new Actions(driver);
		act.moveToElement(contactcheckbox).build().perform();
		contactcheckbox.click();
	}
	
	public void newcontactlink()
	{
		newcontactlink.click();
	}

	
	public void createnewcontact(String fn, String ln) throws InterruptedException
	{
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		Thread.sleep(10000);
		savebtn.click();
		Thread.sleep(10000);

	}

} 
