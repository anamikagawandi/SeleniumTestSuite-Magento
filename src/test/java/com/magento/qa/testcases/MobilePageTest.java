package com.magento.qa.testcases;

import java.util.ArrayList;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.MobileDetailPage;
import com.magento.qa.pages.MobilePage;

public class MobilePageTest  extends TestBase{
	HomePage homepage;
	MobilePage mobilePage;
	MobileDetailPage mobileDetailPage;
	
	public MobilePageTest()
	{
		super();
	}
	
		
	@BeforeMethod
	public void setup()
	{
		initialization();
		homepage =new HomePage();
		mobilePage=homepage.goToMobilePage();
	}

	@Test(priority=1)
	public void MobilePageTitleTest()
	{
		Assert.assertEquals(mobilePage.validateMobilePage(),"MOBILE");
	}
	
	
	@Test(priority=2)
	public void validateSortByNameTest()
	{
		ArrayList<String> list=mobilePage.validateSortByName();
		ArrayList<String> listtemp=new ArrayList<String>(list);	
		Collections.sort(listtemp);
		Assert.assertTrue(listtemp.equals(list));
	}
	
	
	@Test(priority=3)
	public void goToMobileDetailSonyXperiaTest()
	{
		mobileDetailPage=mobilePage.goToMobileDetailSonyXperiaPage();
		//System.out.println(homepage.goToMobilePage());
		Assert.assertEquals(mobileDetailPage.validateMobileDetailPage(),"SONY XPERIA");
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}
	

}
