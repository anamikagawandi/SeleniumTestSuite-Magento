package com.magento.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import com.magento.qa.util.MailerUtil;
import com.magento.qa.util.ReportUtil;
import com.magento.qa.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent; 
	public static ExtentLoggerReporter reporter;
	public static ExtentTest test,t,test2;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(".\\src\\main\\java\\com\\magento\\qa\\config\\config.properties");
			//FileInputStream ip = new FileInputStream("D:\\Selenium\\MagentoRepo\\src\\main\\java\\com\\magento\\qa\\config\\config.properties");//"D:\\SeleniumWorkspace\\MagentoCRM\\src\\main\\java\\com\\magento\\qa\\config\\config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void beforeSuite()
	{
		ReportUtil.setReporter();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		ReportUtil.flushReport();
		MailerUtil.mailReport();
		
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		//System.out.println(browserName);
		//System.out.println(browserName.equals("firefox"));
		
	
		if(browserName.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			System.setProperty("webdriver.firefox.bin","C:\\Users\\User.QASPL-32\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			//System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\MagentoRepo\\geckodriver.exe");//"D:\\Selenium\\MagentoRepo\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
	}

}
