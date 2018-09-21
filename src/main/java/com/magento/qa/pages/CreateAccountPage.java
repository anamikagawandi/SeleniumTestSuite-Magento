package com.magento.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magento.qa.base.TestBase;

public class CreateAccountPage extends TestBase{

	@FindBy(css=".page-title h1")
	WebElement login_title;
	
	
	@FindBy(css=".button[title='Register']")
	WebElement register_btn;
	
	public CreateAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateCreateAccountPage()
	{
		return login_title.getText();
	}

	
	public DashboardPage verifyCreateAccount(String fname,String mname,String lname,String email,String password)
	{
		driver.findElement(By.cssSelector("#firstname")).sendKeys(fname);
		driver.findElement(By.cssSelector("#middlename")).sendKeys(mname);
		driver.findElement(By.cssSelector("#lastname")).sendKeys(lname);
		driver.findElement(By.cssSelector("#email_address")).sendKeys(email);
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		driver.findElement(By.cssSelector("#confirmation")).sendKeys(password);
		register_btn.click();
		return new DashboardPage();
	}
}
