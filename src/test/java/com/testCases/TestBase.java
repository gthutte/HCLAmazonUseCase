package com.testCases;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.*;

import amezon.base.Keyword;
import amezon.utility.ExtentManager;

public class TestBase extends Keyword
{
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setupReport()
	{
	    extent = ExtentManager.getReport();
}

		
	@BeforeMethod(alwaysRun=true)
	public void openBrowser(@Optional("Chrome") String browser) 
	{
	launchBrowser(browser);
	windowMaximize();
	getURL("https://www.amazon.in/");
	
	}
	
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        extent.flush();   
        driverClose();
    }
    @AfterSuite
    public void flushReport() {
        extent.flush();
    }


	
}
