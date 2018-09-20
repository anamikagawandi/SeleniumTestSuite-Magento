package com.magento.qa.util;

import org.openqa.selenium.WebDriver;

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

        for (String handle1 : driver.getWindowHandles()) {

               System.out.println(handle1);

               driver.switchTo().window(handle1);

        }

	}
	
}
