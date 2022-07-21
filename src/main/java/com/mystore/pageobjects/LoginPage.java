package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath="//input[@id='email']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement signInBtn;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement emailForNewAcct;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement createNewAcctBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public HomePage login(String uname, String pword)
	{
		Action.type(userName, uname);
		Action.type(password, pword);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
		
	}
	
	public AddressPage login1(String uname, String pword)
	{
		Action.type(userName, uname);
		Action.type(password, pword);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();
		
	}
	
	public AccountCreationPage createNewAcct(String emailId)
	{
		Action.type(emailForNewAcct, emailId);
		Action.click(getDriver(), createNewAcctBtn);
		return new AccountCreationPage();
	}
	
	
	
	
	
	
	
	
	
}
