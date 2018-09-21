package com.magento.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.LoginPage;
import com.magento.qa.pages.MobileDetailPage;
import com.magento.qa.pages.MobilePage;

public class LoginPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	

	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage =new HomePage();
		loginPage=homePage.goToLoginPage();
	}

	@Test(priority=1)
	public void validateLoginPageTest()
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
