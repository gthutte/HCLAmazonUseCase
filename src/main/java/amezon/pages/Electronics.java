package amezon.pages;

import amezon.base.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import amezon.utility.Wait;

public class Electronics
{
	public static final Logger log = LogManager.getLogger(Electronics.class);

	@FindBy(xpath="//a[text()='Mobiles']")
	WebElement MobileMenu;
	
	public void clickOn()
	{
		Wait.elementToBeClickable(MobileMenu);
		this.MobileMenu.click();
		
        Actions act = new Actions(DriverManager.getDriver());
        act.moveToElement(MobileMenu).perform();

	}




}
