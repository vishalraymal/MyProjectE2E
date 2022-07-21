package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(xpath="//td[@id='total_price_container']/span")
	WebElement totalPrice;
	
	@FindBy(xpath="//a[@title='Proceed to checkout' and contains(@class,'standard-checkout')]/span")
	WebElement 	proceedToCheckout;
	
	public OrderPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice()
	{
		String unitPrice1=  unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		Double finalUnitPrice= Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice()
	{
		String totalPrice1=  totalPrice.getText();
		String total = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		Double finalTotalPrice= Double.parseDouble(total);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckout()
	{
		Action.click(getDriver(), proceedToCheckout);
		return new LoginPage();
		
		
	}

}
