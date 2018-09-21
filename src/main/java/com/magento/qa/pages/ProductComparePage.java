package com.magento.qa.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;
import com.magento.qa.util.TestUtil;

public class ProductComparePage extends TestBase{
	
	public ProductComparePage()
	{
		PageFactory.initElements(driver, this);
	}

	
	public ArrayList<String> verifyCompareProductNames()
	{
		ArrayList<String> list= new ArrayList<String>();
		
		java.util.List<WebElement> names = driver.findElements(By.cssSelector(".product-name > a"));			
		
		for (WebElement e : names) 
		{
			System.out.println("Inside loop"+e.getText());
			list.add(e.getText());									
		}		
		
		return list;
	}
	
	
	public MobilePage verifyCloseBtnTest()
	{
		driver.findElement(By.xpath("//button[@title='Close Window']")).click();
		TestUtil.switchToWindow(driver);
		return new MobilePage();
	}
}
