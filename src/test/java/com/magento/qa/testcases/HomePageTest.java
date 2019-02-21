package com.magento.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.magento.qa.base.TestBase;
import com.magento.qa.pages.*;
import com.magento.qa.util.ReportUtil;
import com.magento.qa.util.ScreenShotUtil;



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
		t=extent.createTest(this.getClass().getName());
	}

	@Test(priority=1)
	public void homePageTitleTest() throws IOException
	{
		test=t.createNode("Test : homePageTitleTest");//this.getClass().getEnclosingMethod().getName());
		String title=homepage.validateHomePageTitle();
		System.out.println(title);
		try {
			Assert.assertEquals(title,"123Home page");
			test.log(Status.PASS, "Home Page title validated");
			test.pass("Home Page title validated");
		}
		catch(AssertionError e)
		{
			test.log(Status.FAIL, "Home Page title not validated"+"\n"+e.getMessage());
			test.fail("Fail");
			ScreenShotUtil.captureScreenShot(this.driver,"homePageTitleTest");
			//ReportUtil.captureScreenShot("homePageTitleTest", "Home Page title not validated"+"\n"+e.getMessage() );
		}
	}
	
	
	@Test(priority=2)
	public void goToMobilePageTest() throws IOException
	{
		test2=t.createNode("goToMobilePageTest");
		test2.log(Status.INFO,"Navigating from Home Page to Mobile Page");
		mobilePage=homepage.goToMobilePage();
		try {
		//System.out.println(homepage.goToMobilePage());
		Assert.assertEquals(mobilePage.validateMobilePage(),"MOBILE");
		test2.log(Status.INFO, "Successfully navigated to Mobile Page");
		test2.log(Status.PASS, "Mobile Page title validated");

		}
		catch(AssertionError e)
		{
			test2.log(Status.FAIL, "Mobile Page title not validated"+"\n"+e.getMessage());
			test2.fail("Mobile Page title not validated").addScreenCaptureFromPath("C:\\Users\\User.QASPL-32\\git\\MagentoRepo\\test-output\\Reports\\ss1.png");
			ReportUtil.captureScreenShot("goToMobilePageTest", "Mobile Page title not validated"+"\n"+e.getMessage() );
		}
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}
	
}
