package com.freecrm.util;

import com.freecrm.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIME=20;
	public static long IMLPLICIT_WAIT=20;
	
	public static void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	
}
