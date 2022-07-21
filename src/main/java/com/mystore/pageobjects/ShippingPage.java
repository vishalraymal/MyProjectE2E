package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='cgv']")
	WebElement terms;
	
	@FindBy(name="processCarrier")
	WebElement proceedCheckout;
	
	public ShippingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTheTerms()
	{
		Action.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToCheckout()
	{
		Action.click(getDriver(), proceedCheckout);
		return new PaymentPage();
	}

}
