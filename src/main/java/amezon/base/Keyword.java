package amezon.base;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
	
	public void mouseHover(WebElement element)
	{
	Actions act = new Actions(DriverManager.getDriver());
    act.moveToElement(element).perform();
	}
	
	public static void captureScreenshot(String fileName) throws IOException 
	{
	    File src = ((TakesScreenshot)DriverManager.getDriver())
	            .getScreenshotAs(OutputType.FILE);

	    File folder = new File("./src/screenshots");
	    folder.mkdirs();

	    File dest = new File(folder, fileName + ".png");
	    FileUtils.copyFile(src, dest);
	}
	public static boolean compareImages(String path1, String path2) throws Exception
	{

	    File file1 = new File(path1);
	    File file2 = new File(path2);

	    System.out.println("Actual File Exists = " + file1.exists());
	    System.out.println("Expected File Exists = " + file2.exists());

	    System.out.println("Actual Path = " + file1.getAbsolutePath());
	    System.out.println("Expected Path = " + file2.getAbsolutePath());

	    if(!file1.exists() || !file2.exists())
	    {
	        System.out.println("One or both files are missing.");
	        return false;
	    }

	    BufferedImage img1 = ImageIO.read(file1);
	    BufferedImage img2 = ImageIO.read(file2);

	    if(img1 == null || img2 == null)
	    {
	        System.out.println("Image format not supported.");
	        return false;
	    }

	    if(img1.getWidth() != img2.getWidth() ||
	       img1.getHeight() != img2.getHeight())
	    {
	        return false;
	    }

	    for(int x=0; x<img1.getWidth(); x++)
	    {
	        for(int y=0; y<img1.getHeight(); y++)
	        {
	            if(img1.getRGB(x,y) != img2.getRGB(x,y))
	            {
	                return false;
	            }
	        }
	    }
	    return true;
	}
}