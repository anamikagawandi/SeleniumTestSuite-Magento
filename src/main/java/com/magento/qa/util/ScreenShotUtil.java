package com.magento.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.collections4.FactoryUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.magento.qa.base.TestBase;

public class ScreenShotUtil extends TestBase {
	
	public synchronized static void captureScreenShot(WebDriver driver,String name)
	{
		//Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(prop.getProperty("screenshotDir")+name+".png");

                //Copy file at destination

                try {
					FileHandler.copy(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
