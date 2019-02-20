package com.magento.qa.util;

import java.io.IOException;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.*;

import com.magento.qa.base.TestBase;

public class ReportUtil extends TestBase {
	
	public static void setReporter()
	{
		reporter = new ExtentLoggerReporter(prop.getProperty("reportPath"));
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setAnalysisStrategy(AnalysisStrategy.TEST);
		reporter.loadXMLConfig(prop.getProperty("extentReportConfig"));
		//reporter.config().setAutoCreateRelativePathMedia(true);
	}
	
	
	public static void flushReport()
	{
		extent.flush();
	}

	
	  public static void captureScreenShot(String screenshotname,String description) 
	  {
		  try { 
			  MediaEntityModelProvider mediaModel = 
						MediaEntityBuilder.createScreenCaptureFromPath(screenshotname+".png").build();
					test.fail(description, mediaModel);
		  }
		  catch(IOException e)
		  {
			  
		  }
	  }
	  
	 
}
