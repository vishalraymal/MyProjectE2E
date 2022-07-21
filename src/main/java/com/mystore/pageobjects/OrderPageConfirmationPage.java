package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPageConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//strong[text()='Your order on My Store is complete.']")
	WebElement confirmMsg;

	public OrderPageConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmMsg()
	{
		String msg= confirmMsg.getText();
		return msg;
		
		
	}
}
