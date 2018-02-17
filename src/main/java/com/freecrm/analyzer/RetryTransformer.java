package com.freecrm.analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

//For Run Time

public class RetryTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotaions, Class testClass, Constructor testConstructor, Method testMethod) {
		
		annotaions.setRetryAnalyzer(RetryAnalyzer.class);
		
	}

}
