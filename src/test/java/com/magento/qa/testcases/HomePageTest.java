package com.magento.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.*;



public class HomePageTest extends TestBase {

	HomePage homepage;
	MobilePage mobilePage;
	
	public HomePageTest()
	{
		super();
	}
	
		
	@BeforeMethod
	public void setup()
	{
		initialization();
		homepage = new HomePage();
	}

	@Test(priority=1)
	public void homePageTitleTest()
	{
		String title=homepage.validateHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Home page");
	}
	
	
	@Test(priority=2)
	public void goToMobilePageTest()
	{
		mobilePage=homepage.goToMobilePage();
		//System.out.println(homepage.goToMobilePage());
		Assert.assertEquals(mobilePage.validateMobilePage(),"MOBILE");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}
	
}
