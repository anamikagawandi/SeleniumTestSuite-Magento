package com.magento.qa.testcases;


import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.MobileDetailPage;
import com.magento.qa.pages.MobilePage;
import com.magento.qa.pages.ProductComparePage;


public class ProductComparePageTest extends TestBase{
	
	HomePage homepage;
	MobilePage mobilePage;
	MobileDetailPage mobileDetailPage;
	ProductComparePage productComparePage;
	
	
	public ProductComparePageTest()
	{
		super();
	}
	
		
	@BeforeMethod
	public void setup()
	{
		initialization();
		homepage =new HomePage();
		mobilePage=homepage.goToMobilePage();
		productComparePage=mobilePage.goToCompareProduct();///////
	}

	
	@Test
	public void verifyCompareProductsTest()
	{
		ArrayList<String> listvalues= new ArrayList<String>();
		listvalues.add("SONY XPERIA");
		listvalues.add("IPHONE");
		ArrayList<String> list=productComparePage.verifyCompareProductNames();
		Assert.assertTrue(list.equals(listvalues));
	}
	
	@Test
	public void verifyCloseBtnTest()
	{
		mobilePage=productComparePage.verifyCloseBtnTest();
		Assert.assertEquals(mobilePage.validateMobilePage(),"MOBILE");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}

}
