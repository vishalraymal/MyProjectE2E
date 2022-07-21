package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OderPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@Parameters({"browser","url"})  
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser, String url)
	{
		launchApp(browser, url);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(groups="Regression")
	public void verifyTotalPrice()
	{
		indexPage =new IndexPage();
		searchResultPage= indexPage.searchProduct("t-shirt");
		addToCartPage= searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage= addToCartPage.clickOnProceedCheckout();
		System.out.println("vishal Raymal");
		double unitPrice = orderPage.getUnitPrice();
		double totalPrice= orderPage.getTotalPrice();
		double totalResultPrice = (unitPrice*2)+2;
		Assert.assertEquals(totalResultPrice,totalPrice);
	}	
	
}
