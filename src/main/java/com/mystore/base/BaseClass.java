package com.mystore.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.w3c.dom.DOMConfiguration;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declare ThreadLocal driver
	public static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<>();
	
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression","Test" })
	public void loadConfig()
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try 
		{
			prop = new Properties();
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
			prop.load(ip);
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}
			
	}
	
	public static WebDriver getDriver()
	{
		// Get driver from threadLocalMap
		return driver.get();
	}
	
	


	//public static void launchApp() 
	public static void launchApp(String browserName, String url)  // 2. need to pass browser parameter value into this using beforeMethod
	{
		//String browserName = prop.getProperty("browser"); // 1. passed browser name through config properties file
		if(browserName.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		else if(browserName.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver= new FirefoxDriver();
			driver.set(new FirefoxDriver());

		}
		else if(browserName.contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			//driver= new EdgeDriver();
			driver.set(new EdgeDriver());

		}
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 30);
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		//getDriver().get(prop.getProperty("url"));
		getDriver().get(url);

	}

	@AfterSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void afterSuite()
	{
		ExtentManager.endReport();
	}
	
	
	
	
	
	
	
	

}
