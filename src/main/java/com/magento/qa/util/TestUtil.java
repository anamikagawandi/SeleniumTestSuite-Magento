package com.magento.qa.util;

import com.magento.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 20;
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
}
