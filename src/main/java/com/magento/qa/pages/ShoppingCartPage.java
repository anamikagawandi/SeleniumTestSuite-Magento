package com.magento.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.magento.qa.base.TestBase;

public class ShoppingCartPage extends TestBase {

	
	//String="";
	
	@FindBy(css="[title='Qty']")
	WebElement qty;
}
