package com.magento.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(css=".page-title h1")
	WebElement login_title;
	
	
	@FindBy(css="a[title='Create an Account']")
	WebElement create_acct_btn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPage()
	{
		return login_title.getText();
	}

	
	public CreateAccountPage goToCreateAccountPage()
	{
		create_acct_btn.click();
		return new CreateAccountPage();
	}
}
