package amezon.utility;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait
{
	WebDriverWait wait;
	public static void visiblityOfElement(WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(amezon.base.DriverManager.getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	public static void elementToBeClickable(WebElement element)
	{	
		WebDriverWait wait = new WebDriverWait(amezon.base.DriverManager.getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void visiblityofURL(String message)
	{
		WebDriverWait wait = new WebDriverWait(amezon.base.DriverManager.getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.urlContains(message));
	}


}
