package com.magento.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.magento.qa.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Selenium\\MagentoRepo\\src\\main\\java\\com\\magento\\qa\\config\\config.properties");//"D:\\SeleniumWorkspace\\MagentoCRM\\src\\main\\java\\com\\magento\\qa\\config\\config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		//System.out.println(browserName);
		//System.out.println(browserName.equals("firefox"));
		if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\MagentoRepo\\geckodriver.exe");//"D:\\Selenium\\MagentoRepo\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}

}
