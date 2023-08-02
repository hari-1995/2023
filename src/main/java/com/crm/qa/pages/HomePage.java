package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//span[text()='Home']")
	WebElement homeink;
	
	@FindBy(xpath = "//span[text()='Sai Designee']")
	WebElement usernamelabel;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath = "//span[text()='Deals']")
	WebElement dealslink;
	
	@FindBy(xpath = "//span[text()='Tasks']")
	WebElement taskslink;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String verifyhomepagetitle()
	{
		return driver.getTitle();
	}
	
	public Boolean verifycontactusername()
	{
		return usernamelabel.isDisplayed();
	}
	
	public void movehome()
	{
		Actions act = new Actions(driver);
		act.moveToElement(contactslink).build().perform();
	}
	
	
	
	public ContactPage clickcontactslink()
	{
		contactslink.click();
		return new ContactPage();
	}
	
	public DealsPage clickdealslink()
	{
		dealslink.click();
		return new DealsPage(); 
	}
	
	public TasksPage clicktaskslink()
	{
		taskslink.click();
		return new TasksPage();
	}
	
}

