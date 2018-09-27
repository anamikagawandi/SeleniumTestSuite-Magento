package com.magento.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;

public class DashboardPage extends TestBase {
	
	@FindBy(css=".page-title h1")
	WebElement dashboard_title;
	
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateDashboardPage()
	{
		return dashboard_title.getText();
	}

}
