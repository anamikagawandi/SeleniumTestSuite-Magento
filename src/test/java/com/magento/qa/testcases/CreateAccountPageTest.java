package com.magento.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.CreateAccountPage;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.LoginPage;

public class CreateAccountPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	CreateAccountPage createAccountPage;
	
	public CreateAccountPageTest()
	{
		super();
	}
	

	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage =new HomePage();
		loginPage=homePage.goToLoginPage();
		createAccountPage=loginPage.goToCreateAccountPage();
	}

	/*
	@DataProvider(name="enterCreds")
	public Object [][] getCreds()
	{
		return
	}
	*/
	@Test(priority=1, dataProvider = "enterCreds")
	public void validateCreateAccountTest()
	{
		Assert.assertTrue(loginPage.validateLoginPage().contains("LOGIN OR CREATE AN ACCOUNT"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}


}
