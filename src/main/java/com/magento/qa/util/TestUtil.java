package com.magento.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import com.magento.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 20;
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static void switchToWindow(WebDriver driver)
	{
		java.util.Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);

        for (String handle1 : driver.getWindowHandles()) 
        {
               System.out.println(handle1);
               driver.switchTo().window(handle1);
        }
	}
	
	public static boolean isLoginActive(WebElement element)
	{
		if(element.getText().contains("Default welcome msg!"))
			return false;
		else
			return true;
	}
	
	
}
