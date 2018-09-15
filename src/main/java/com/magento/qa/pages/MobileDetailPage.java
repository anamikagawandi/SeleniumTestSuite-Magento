package com.magento.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.magento.qa.base.TestBase;

public class MobileDetailPage extends TestBase{
	
	
	@FindBy(xpath="//a[text()='Mobile']")
	WebElement mobileMenu;
	
	@FindBy(css=".price")
	WebElement price;
	
	
	public MobileDetailPage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateMobileDetailPage()
	{
		System.out.println(driver.findElement(By.cssSelector(".product >strong")).getText());
		return driver.findElement(By.cssSelector(".product >strong")).getText();
	}
	
	public String verifyItemPrice()
	{
		return price.getText();
	}
	
	
	
}
