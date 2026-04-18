package amezon.pages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import amezon.base.Keyword;

public class TestBase extends Keyword
{
	@BeforeMethod(alwaysRun=true)
	public void openBrowser(@Optional("Chrome") String browser) 
	{
	launchBrowser(browser);
	windowMaximize();
	getURL("https://www.amazon.in/");
}
}
