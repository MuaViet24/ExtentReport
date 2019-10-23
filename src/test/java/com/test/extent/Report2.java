package com.test.extent;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Report2 {
	
	@Test
	public void onPass(){
		Assert.assertTrue(true);
	}
	
	@Test
	public void onFail(){
		Assert.fail();
	}
	
	@Test
	public void onSkip(){
		throw new SkipException("Skip");
	}

}
