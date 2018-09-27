package com.magento.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(css=".page-title h1")
	WebElement login_title;
	
	@FindBy(css="#email")
	WebElement emailid;
	
	@FindBy(css="#pass")
	WebElement emailpassword;
	
	@FindBy(css="#send2")
	WebElement login_btn;
	
	@FindBy(css="a[title='Create an Account']")
	WebElement create_acct_btn;
	
	@FindBy(css=".messages span")
	WebElement error_message;
	
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
	
	public DashboardPage validateLogin(String user, String password)
	{
		enterCreds(user,password);
		return new DashboardPage();
	}
	
	
	public void  enterCreds(String user,String pass)
	{
		emailid.sendKeys(user);
		emailpassword.sendKeys(pass);
		login_btn.click();
	}
	
	public String getErrorMessage()
	{
		return error_message.getText().toString();
	}
}
