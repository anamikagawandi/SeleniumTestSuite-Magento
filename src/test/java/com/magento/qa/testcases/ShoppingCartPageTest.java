package com.magento.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.MobileDetailPage;
import com.magento.qa.pages.MobilePage;
import com.magento.qa.pages.ShoppingCartPage;

public class ShoppingCartPageTest extends TestBase{
	
	HomePage homePage;
	MobilePage mobilePage;
	MobileDetailPage mobileDetailPage;
	ShoppingCartPage shoppingCartPage;
	
	
	public ShoppingCartPageTest()
	{
		super();
	}
	

	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage =new HomePage();
		mobilePage=homePage.goToMobilePage();
		shoppingCartPage=mobilePage.clickAddToCart();
	}

	
	@Test(priority=1)
	public void verifyErrorMessage()
	{
		Assert.assertTrue(shoppingCartPage.verifyErrorMessage().contains("* The maximum quantity allowed for purchase is 500."));
	}

	
	
	@Test(priority=2)
	public void verifyEmptyCartBtn()
	{
		Assert.assertEquals(shoppingCartPage.verifyEmptyCartButton(),"SHOPPING CART IS EMPTY");
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}
}
