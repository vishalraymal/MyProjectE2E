package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	
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
	
	@Test(groups="Smoke")
	public void verifyMyStoreLogoTest()
	{
		indexPage = new IndexPage();
		boolean result= indexPage.validateLogo();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups="Smoke")
	public void verifyMyTitle()
	{
		String actTitle= indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
		
	}

}
