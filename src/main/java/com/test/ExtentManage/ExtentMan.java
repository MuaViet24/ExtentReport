package com.test.ExtentManage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentMan {
	
	public static ExtentReports extent;
	public static String filename = "extent_"+System.currentTimeMillis()+".html";
	public static ExtentReports extentConfig(String fileName){
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Report/"+fileName);
		htmlReporter.config().setEncoding("UFT-8");
		htmlReporter.config().setReportName("MyReports");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

}
