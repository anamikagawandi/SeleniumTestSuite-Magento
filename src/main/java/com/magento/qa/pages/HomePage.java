package com.magento.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;
import com.magento.qa.util.TestUtil;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//a[text()='Mobile']")
	WebElement mobileMenu;

	@FindBy(xpath="//span[@class='label'][text()='Account']")////span[@class='icon']/following-sibling::span[@class='label'][contains(text(),'Account')]
	WebElement accountmenu;
	
	@FindBy(xpath="//div[@class='block-title']/following-sibling::ul//a[@title='My Account']")
	WebElement myaccountlink;
	
	@FindBy(xpath="//div[@class='block-title']/following-sibling::ul//a[@title='My Account']")
	WebElement welcomemessage;
	
	@FindBy(xpath="//a[@title='Log Out']")
	WebElement logout_btn;
	
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
		
	public LoginPage goToLoginPage()
	{
		myaccountlink.click();
		return new LoginPage();			
	}
	
}
