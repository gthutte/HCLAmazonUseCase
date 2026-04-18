package amezon.base;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager 
{
	private DriverManager()
	{
	}
static ThreadLocal <RemoteWebDriver> thread = new ThreadLocal<RemoteWebDriver>();
public static RemoteWebDriver getDriver()
{
	return thread.get();
}
public static void setDriver(RemoteWebDriver driver)
{
	thread.set(driver);	
}
public static void unload()
{
	thread.remove();
}
}
