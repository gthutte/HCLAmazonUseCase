package amezon.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager 
{
    public static ExtentReports extent;

    public static ExtentReports getReport()
    {
        if(extent == null)
        {
        	ExtentSparkReporter reporter =
        		    new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/ExtentReport.html");
        	
            reporter.config().setReportName("Amazon Automation Report");
            reporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Tester", "Sayali");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }	

}
