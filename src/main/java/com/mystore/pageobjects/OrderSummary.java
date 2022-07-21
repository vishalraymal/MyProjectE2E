package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummary extends BaseClass {
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	public OrderSummary()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderPageConfirmationPage clickOnConfirmOrderBtn()
	{
		Action.explicitWait(getDriver(), confirmOrderBtn, 15);
		Action.click(getDriver(), confirmOrderBtn);
		return new OrderPageConfirmationPage();
	}
	

	
}
