package com.freecrm.tests;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.LoginPage;



public class LoginPageTest extends TestBase {

	LoginPage objLoginpage;
	
	//Constructor of the class calling the super constructor (TestBase class constructor)
	public LoginPageTest(){
		super();
	}
	
	Logger log=Logger.getLogger(LoginPageTest.class);
	//before method for initialization and creating object of LoginPage
	@BeforeMethod
	public void setUp() {
		log.info("initialoization");
		initialization();
		objLoginpage= new LoginPage();
		log.warn("warning");
		log.fatal("fatal");
		
	}
	
	//Test case validating Title of Web Page
	//	@Test(priority=1,retryAnalyzer=com.freecrm.analyzer.RetryAnalyzer.class) Retry Analyzer At Test Level
	
	@Test(priority=1)
	public void titleTest() {
		String ActualTitle=objLoginpage.validateTitle();
		String ExpectedTitle=prop.getProperty("Title");
		Assert.assertEquals(ActualTitle,ExpectedTitle,"Web Page Title Not Mached");
		
	}
	
	//Test Case for Validating Logo
	@Test(priority=2)
	public void logoTest() {
		boolean Value=objLoginpage.validateLogo();
		Assert.assertTrue(Value,"Logo Displayed");
		
	}
	
	//Test Case for Validating Login Functionality 
	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		//System.err.println("driver"+driver);
		objLoginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		String title=driver.getTitle();
		Assert.assertEquals(title, "CRMPRO");
		
	}
	
	
	
	// For closing and Quitting the Browser
	@AfterMethod
	public void tearDown() {
		driver.close();
		//driver.quit();	
	}
	
	
}
