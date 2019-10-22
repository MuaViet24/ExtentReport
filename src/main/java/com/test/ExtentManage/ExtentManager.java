package com.test.ExtentManage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlExtent;
	public static ExtentTest test;
	
	@BeforeTest
	public void setup(){
		htmlExtent= new ExtentHtmlReporter("./Report/extent.html");
		htmlExtent.config().setEncoding("UFT-8");
		htmlExtent.config().setReportName("Extent Report Demo");
		htmlExtent.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(htmlExtent);
		report.setSystemInfo("Tester", "Mua");
		
		
		
	}
	
	@AfterTest
	public void tearDown(){
		report.flush();
	}

}
