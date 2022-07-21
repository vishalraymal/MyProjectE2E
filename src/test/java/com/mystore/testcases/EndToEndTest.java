package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderPageConfirmationPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

public class EndToEndTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
	OrderPageConfirmationPage orderPageConfirm;

	@Parameters({"browser","url"})  
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser, String url)
	{
		launchApp(browser, url);
	}

	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Regression")
	public void endToEndTest() {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProceedCheckout();
		loginPage= orderPage.clickOnCheckout();
		addressPage =loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage= addressPage.clickOnCheckout();
		shippingPage.checkTheTerms();
		paymentPage= shippingPage.clickOnProceedToCheckout();
		orderSummary= paymentPage.clickOnPaymentMethod();
		orderPageConfirm= orderSummary.clickOnConfirmOrderBtn();
		String actual_test= orderPageConfirm.validateConfirmMsg();
		String expected_text="Your order on My Store is complete.";
		Assert.assertEquals(actual_test, expected_text);
	}
}