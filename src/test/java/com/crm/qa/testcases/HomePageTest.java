package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void homepagetitletest()
	{
		String HomeTitle = homepage.verifyhomepagetitle();
		Assert.assertEquals(HomeTitle, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void verifyusernametest()
	{
		Assert.assertTrue(homepage.verifycontactusername());
	}
	
	@Test(priority = 3)
	public void movehomeicon() throws InterruptedException
	{
		homepage.movehome();
		Thread.sleep(10000);
		contactpage = homepage.clickcontactslink();
	}
	
}



