package com.magento.qa.pages;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.magento.qa.base.TestBase;

public class MobilePage extends TestBase{
	
	@FindBy(xpath="//a[text()='Mobile']")
	WebElement mobileMenu;
	
	
	
	String sonypath = ".product-image[title='Xperia'] + div";
	//@FindBy(css=".category-products > .toolbar > .sorter > .sort-by > a")			//.sort-by > select")  span[class='price']
	Select sortby;
	
	@FindBy(css=".product-image[title='Xperia'] + div")    //.product-name > a[title='Sony Xperia']")
	WebElement sonyexperia;
	
	
	public MobilePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateMobilePage()
	{
		return driver.findElement(By.cssSelector(".page-title > h1:nth-child(1)")).getText();
	}
	
	
	public MobileDetailPage goToMobileDetailSonyXperiaPage()
	{
		System.out.println(sonypath+ "  joined is  "+""+sonypath+" > .product-name a" );
		System.out.println("Inside get item price  "+driver.findElement(By.cssSelector(sonypath+" span[class='price']")).getText());
		driver.findElement(By.cssSelector(sonypath+" > .product-name a")).click();
		return new MobileDetailPage();
	}
	
	
	public String getItemPrice()
	{
		//System.out.println("Inside get item price"+driver.findElement(By.cssSelector(sonypath+" span[class='price']")).getText());
		return driver.findElement(By.cssSelector(sonypath+" span[class='price']")).getText();
	}
	
	public ShoppingCartPage clickAddToCart()
	{
		driver.findElement(By.cssSelector(sonypath+"[class='product-info'] > div[class='actions'] > button")).click();
		return new ShoppingCartPage();
	}
	
	
	public ArrayList<String> validateSortByName()
	{
		System.out.println("Inside validateSortByName");
		sortby=new Select(driver.findElement(By.cssSelector(".sort-by > select")));
		System.out.println("Selected ");
		sortby.selectByIndex(1);
		
		/**
		WebDriverWait wait = new WebDriverWait(driver,TestUtil.IMPLICIT_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sort-by > select")));
		System.out.println("Selected "+sortby.getAllSelectedOptions().toString());
		**/
		ArrayList<String> list;
		java.util.List<WebElement> names = driver.findElements(By.cssSelector(".product-name > a"));
		//Iterator<WebElement> i=names.iterator();
		list = new ArrayList<String>();							
		
		int	p = 0;					
		//extract the link texts of each link element		
		for (WebElement e : names) 
		{
			System.out.println("Inside loop"+e.getText());
			list.add(e.getText());							
			p++;			
		}		
		System.out.println(list.toString());
		return list;
	}
		
}
