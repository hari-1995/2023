package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new LoginPage();	
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

	@Test(priority = 1)
	public void loginpagetitletest()
	{
		String Title = loginpage.loginpagetitle();
		Assert.assertEquals(Title, "Cogmento CRM");
	}
	
	@Test(priority = 2)
	public void logintest()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
}
