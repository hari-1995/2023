package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class DealsTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	DealsPage dealspage;
	
	public DealsTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealspage = homepage.clickdealslink();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void dealslabetes() throws InterruptedException
	{
		Assert.assertTrue(dealspage.verifydealslabel(), "*******Deals Page is displayed for the user********");
		Thread.sleep(10000);
	}
}
