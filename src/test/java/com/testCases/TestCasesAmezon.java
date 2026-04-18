package com.testCases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import amezon.pages.TestBase;
import amezon.pages.Electronics;

import amezon.base.DriverManager;
import amezon.pages.*;

@Test
public class TestCasesAmezon extends TestBase
{
	Electronics el;
	
    @Test
    public void launchTest()
    {
        System.out.println("Test started");
    }
    
    @BeforeMethod(alwaysRun=true)
	public void SetUpPage()
	{
    	
	el=	PageFactory.initElements(DriverManager.getDriver(), Electronics.class);
	}
    @Test
    public void clickOnMobileMenu()
    {
    	el.clickOn();
    }
    @Test
    public void printMenuItems()
    {
    	el.clickOn();
    	el.printMenuItems();
    }
}
	