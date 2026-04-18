package amezon.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Keyword
{
	public static final Logger log = LogManager.getLogger(Keyword.class);

	public static void launchBrowser(String browserName)
	{
		RemoteWebDriver driver;
		log.info("Launching browser: " + browserName);
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
			log.info("Chrome broswer launched succcesfully...");
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			driver=new FirefoxDriver();
			log.info("FireFox Browser launched successfully...");
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
			log.info("Edge browser launched succeessfully...");
					
		}else
		{
			log.info("Invalid browser name..");
			throw new InvalidBrowserNameException();
		}
		DriverManager.setDriver(driver);
	}
	public static void getURL(String url) 
	{
	DriverManager.getDriver().get(url);
	}
	
	public static void windowMaximize() 
	{
		DriverManager.getDriver().manage().window().maximize();
	}
	public static void driverClose()
	{
		DriverManager.getDriver().close();
	}
	public static void driverQuit() 
	{
       DriverManager.getDriver().quit();
	}
	public static void deleteAllCookies()
	{
		DriverManager.getDriver().manage().deleteAllCookies();
	}
	
}
