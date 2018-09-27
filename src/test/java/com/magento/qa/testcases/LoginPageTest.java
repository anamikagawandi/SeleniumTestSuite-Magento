package com.magento.qa.testcases;

import java.io.File;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.magento.qa.base.TestBase;
import com.magento.qa.pages.DashboardPage;
import com.magento.qa.pages.HomePage;
import com.magento.qa.pages.LoginPage;
import com.magento.qa.util.DataProviderUtil;

public class LoginPageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	File file;
	
	public LoginPageTest()
	{
		super();
		file = new File("D:\\SeleniumWorkspace\\MagentoCRM\\src\\main\\java\\com\\magento\\qa\\testdata\\LoginData.xlsx");
	}
	
	
	@DataProvider(name="readLoginCreds")
	public Object[][] readLoginCreds() throws Exception
	{
		return DataProviderUtil.readLoginCreds(file);	
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
	
	
	@Test(dataProvider="readLoginCreds" , priority=2)
	public void validateLogin(String user,String password,boolean flag)
	{
		System.out.println(user+"       "+ password);
		if(flag)
		{
			dashboardPage=loginPage.validateLogin(user,	password);
			Assert.assertEquals(dashboardPage.validateDashboardPage(),"MY DASHBOARD","Login Failed");
		}
		else
		{
			loginPage.enterCreds(user,	password);
			Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid login or password."));
		}
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
		driver.quit();
	}

}
