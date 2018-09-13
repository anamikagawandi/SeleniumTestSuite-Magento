package com.magento.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//a[text()='Mobile']")
	WebElement mobileMenu;

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public MobilePage goToMobilePage()
	{
		mobileMenu.click();
		return new MobilePage();//driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)")).getText();
	}
		
}
