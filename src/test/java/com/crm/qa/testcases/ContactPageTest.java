package com.crm.qa.testcases;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	
	public ContactPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage = homepage.clickcontactslink();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verifycontctlable()
	{
		Assert.assertTrue(contactpage.verifycontactlabel(), "label is present");
	}
	
	@Test(enabled = false)
	public void selectcontact() throws InterruptedException
	{
		contactpage.selectcontact();
		Thread.sleep(10000);
	}
	
	@DataProvider
	public Object[][] getcrmdata()
	{
		Object data[][] =TestUtil.getTestData("DataC");
		return data;
	}
	
	@Test(priority = 3, dataProvider = "getcrmdata")
	public void validatecreatenewcontact(String Firstname, String Lastname) throws InterruptedException
	{
		contactpage.newcontactlink();
		//contactpage.createnewcontact("Tom", "jery");
		contactpage.createnewcontact(Firstname, Lastname);
	}
}
