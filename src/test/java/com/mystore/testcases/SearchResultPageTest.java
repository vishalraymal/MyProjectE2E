package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
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

	@Test(groups="Smoke")
	public void productAvailablityTest()
	{
		indexPage= new IndexPage();
		searchResultPage= indexPage.searchProduct("t-shirt");
		boolean status= searchResultPage.productAvailable();
		Assert.assertTrue(status);
		
	}

}
