package com.testCases;
import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import amezon.base.DriverManager;
import amezon.pages.*;

@Test
public class TestCasesAmezon extends TestBase
{

    Electronics el;

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method) {

        test = extent.createTest(method.getName());

        el = PageFactory.initElements(
                DriverManager.getDriver(),
                Electronics.class
        );
    }

    @Test
    public void launchTest() {

        System.out.println("Test started");

        test.pass("Launch test executed successfully");
    }

    @Test
    public void clickOnMobileMenu() {

        el.clickOn();

        test.pass("Clicked on mobile menu successfully");
    }

    @Test
    public void printMenuItems() throws Exception {

        el.clickOn();
        el.printMenuItems();

        captureScreenshot("actualMenu");
        captureScreenshot("expectedMenu");

        boolean result = compareImages(
                "./src/screenshots/actualMenu.png",
                "./src/screenshots/expectedMenu.png"
        );
        Assert.assertTrue(result);

        test.pass("Menu items matched successfully");
    }


}
	