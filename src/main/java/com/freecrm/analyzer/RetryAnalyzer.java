package com.freecrm.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyzer implements IRetryAnalyzer{

	int counter=0;
	int retryLimit=3;
	
	
	public boolean retry(ITestResult result) {
		
		if(counter<retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}

/*
 * How to execute failed test cases in Selenium WebDriver using IRetryAnalyzer in TestNG.

I'm sure, you are facing random failure during an automated test run. These failures might not necessarily be because of product bugs. 

These failure can be because of following reasons:

+Random browser issues 
+Browser becoming unresponsive
+Random machine issues
+Server issues like unexpected delay in the response from server
+Application not responding properly
+Application is very slow
+Network is very slow, hence app is very slow
+Ajax Component could not be loaded properly
+HTML DOM is slow


There are two ways to implement retry logic using TestNG Listener:
1. By specifying retryAnalyzer value in the @Test annotation
2. By adding Retry analyser during run time by implementing IAnnotationTransformer interfacesI
*/
