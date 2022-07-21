package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@Parameters({ "browser", "url" })
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser, String url) {
		launchApp(browser, url);
	}

/*	@Parameters({"browser"}) 
    @BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp()

	{
		launchApp();
	}  */

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = "Smoke")
	public void verifyWishList() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnsingIn();
		loginPage = indexPage.clickOnsingIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean wish_status = homePage.validateMyWishList();
		Assert.assertTrue(wish_status);

	}

	@Test(groups = "Smoke")
	public void verifyOrderHistoryAndDetailsTest() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnsingIn();
		loginPage = indexPage.clickOnsingIn();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean order_hist_status = homePage.validateOrderHistory();
		Assert.assertTrue(order_hist_status);
	}

}
