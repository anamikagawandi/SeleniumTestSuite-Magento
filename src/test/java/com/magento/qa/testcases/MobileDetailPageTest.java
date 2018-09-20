package com.magento.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.MobileDetailPage;
import com.magento.qa.pages.MobilePage;

public class MobileDetailPageTest extends TestBase{
	
	HomePage homePage;
	MobilePage mobilePage;
	MobileDetailPage mobileDetailPage;
	String itemprice;
	public MobileDetailPageTest()
	{
		super();
	}
	

	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage =new HomePage();
		mobilePage=homePage.goToMobilePage();
		itemprice=mobilePage.getItemPrice();
		mobileDetailPage=mobilePage.goToMobileDetailSonyXperiaPage();
	}

	@Test(priority=1)
	public void validateMobileDetailTest()
	{
		Assert.assertEquals(mobileDetailPage.validateMobileDetailPage(),"SONY XPERIA");
	}
	
	
	@Test(priority=2)
	public void validateItemPriceTest()
	{
		Assert.assertTrue(itemprice.equals(mobileDetailPage.verifyItemPrice()));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}
	
	
}
