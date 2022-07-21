package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass {

	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters({"browser","url"})  
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser, String url)
	{
		launchApp(browser,url);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	
	@Test(groups= {"Smoke","Sanity"},dataProvider="Credentials", dataProviderClass= DataProviders.class )
	public void verifyLoginTest(String uname, String pword) throws InterruptedException
	{
	Log.startTestCase("login page test");
	indexPage= new IndexPage();	
	loginPage= indexPage.clickOnsingIn();
	Log.info("user clicked on signed in...");
	Log.info("Enter username and password..");
//	homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	homePage= loginPage.login(uname	, pword);
	String actualURL= homePage.getCurrentURL();
	String expectedURL ="http://automationpractice.com/index.php?controller=my-account";
	Log.info("Verifying if user able to login or not");
	Assert.assertEquals(actualURL, expectedURL);
	
	}
	
}
