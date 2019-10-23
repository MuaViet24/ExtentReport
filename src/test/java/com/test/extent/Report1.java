package com.test.extent;


import java.util.Arrays;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.test.ExtentManage.ExtentManager;

public class Report1 extends ExtentManager{
	
	@Test
	public void onPass(){
		Assert.assertTrue(true);
	}
	
	@Test
	public void onSkip(){
		throw new SkipException("Test skip");
		
	}
	
	@Test
	public void onFail(){
		Assert.fail();
	}
	
	@AfterMethod
	public void captureResult(ITestResult result){
		
		if(result.getStatus() == ITestResult.SUCCESS){
			String log = "<b> Test case passed </b>";
			test = report.createTest("On Pass");
			Markup m = MarkupHelper.createLabel(log, ExtentColor.GREEN);
			test.pass(m);
			
		}else if(result.getStatus() == ITestResult.FAILURE){
			
			String log = "<details><summary><font color=red><b>Click me</b></font></summary><p>"+Arrays.toString(result.getThrowable().getStackTrace()).replaceAll(",", "<br>")+"</p></details>";
			test = report.createTest("On Fail");
			Markup m = MarkupHelper.createLabel(log, ExtentColor.RED);
			test.fail(m);
			
		}else if(result.getStatus() == ITestResult.SKIP){
		
			String log = "<b> Test skipped </b>";
			test = report.createTest("On Skip");
			Markup m = MarkupHelper.createLabel(log, ExtentColor.AMBER);
			test.skip(m);
		}
	}
	
	

}
