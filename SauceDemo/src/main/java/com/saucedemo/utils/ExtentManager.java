package com.saucedemo.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager 
{
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getExtentReports() 
    {
        if (extent == null) 
        {
            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public static void createTest(String testName)
    {
        test = getExtentReports().createTest(testName);
    }

    public static ExtentTest getTest() {
        
        return test;
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
