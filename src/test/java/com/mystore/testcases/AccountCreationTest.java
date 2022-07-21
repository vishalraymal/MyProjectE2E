package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class AccountCreationTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage actCreatePage;
	
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
	
	
	@Test(groups="Sanity")
	public void verifyCreateAccountPageTest()
	{
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnsingIn();
		actCreatePage= loginPage.createNewAcct("abc@abctest12abc.com");
		boolean status= actCreatePage.validateAcctCreatePage();
		Assert.assertTrue(status);
		
	}
	
	
}
