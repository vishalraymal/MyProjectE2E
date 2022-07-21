package com.mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement quantity;

	@FindBy(name = "group_1")
	WebElement size;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn;

	@FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String qnty) {
		Action.type(quantity, qnty);

	}
	
	public void selectSize(String size1)
	{
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart()
	{
		Action.click(getDriver(), addToCartBtn);
	}
	
	
	public String validateAddToCart()
	{
		Action.explicitWait(getDriver(), addToCartMessage, 10);
		//return Action.isDisplayed(driver, addToCartMessage);
		return addToCartMessage.getText();
	}
	
	public OrderPage clickOnProceedCheckout()
	{
		Action.explicitWait(getDriver(), proceedToCheckOutBtn, 15);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		//Action.click(driver, proceedToCheckOutBtn);
		return new OrderPage();
		
	}
	

}
