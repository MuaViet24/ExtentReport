package com.test.ExtentManage;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListeners implements ITestListener{

	public ExtentTest test;
	public static String fileName ="extent_"+System.currentTimeMillis()+".html";
	public static ExtentReports extent = ExtentMan.extentConfig(fileName);
	public static ThreadLocal<ExtentTest> classThreadLocal = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test = extent.createTest(result.getMethod().getMethodName());
		classThreadLocal.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String log = "<b>Test " +result.getMethod().getMethodName()+" Passed";
		Markup m = MarkupHelper.createLabel(log, ExtentColor.GREEN);
		classThreadLocal.get().pass(m);
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String log = "<details><summary><b> Test "+ result.getMethod().getMethodName()+ " Failed </b></summary><p>"+Arrays.toString(result.getThrowable().getStackTrace())+"</p></details>";
		Markup m = MarkupHelper.createLabel(log, ExtentColor.RED);
		classThreadLocal.get().fail(m);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String log = "<b> Test "+ result.getMethod().getMethodName()+ " Skipped";
		Markup m = MarkupHelper.createLabel(log, ExtentColor.AMBER);
		classThreadLocal.get().skip(m);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		extent.flush();
		
	}

}
