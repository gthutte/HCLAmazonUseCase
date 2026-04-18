package amezon.pages;

import amezon.base.DriverManager;
import amezon.base.Keyword;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import amezon.utility.Wait;

public class Electronics
{
	public static final Logger log = LogManager.getLogger(Electronics.class);
	Keyword kw = new Keyword();

	@FindBy(xpath="//a[text()='Mobiles']")
	WebElement MobileMenu;
	
	public void clickOn()
	{
	    Wait.elementToBeClickable(MobileMenu);
	    kw.mouseHover(MobileMenu);
	    MobileMenu.click();
	}
	@FindBy(xpath="//div[@id='nav-subnav']//a")
	List<WebElement> menuList;
	
	@FindBy(xpath="//img[@alt=\"Electronics\"]")
	WebElement electronics;
	
public void printMenuItems()
	{

	String electronics = this.electronics.getAttribute("alt");
	System.out.println(electronics);


    for(WebElement ele : menuList)
    {
        String text = ele.getText().trim();

        if(!text.isEmpty())
        {
            System.out.println(text);
        }
    }
    
    System.out.println("Total = " + menuList.size());
	}
}
