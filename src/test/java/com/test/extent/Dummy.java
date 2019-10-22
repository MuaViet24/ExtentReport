package com.test.extent;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.test.ExtentManage.ExtentManager;

public class Dummy extends ExtentManager{
	
	
	@Test
	public void testOnPass(){
		
		test = report.createTest("Test on pass");
		Markup m = MarkupHelper.createLabel("Test case Passed", ExtentColor.GREEN);
		test.pass(m);
	}
	
	@Test
	public void testOnFail(){
		
		test = report.createTest("Test on fail");
		Markup m = MarkupHelper.createLabel("Test case Failed", ExtentColor.RED);
		test.fail(m);
		//Assert.fail();
	}
	
	@Test
	public void testOnSkip(){
		
		
		test = report.createTest("Test on skip");
		Markup m = MarkupHelper.createLabel("Test case skipped", ExtentColor.AMBER);
		test.skip(m);
		//throw new SkipException("Test skipped");
	}

}
