package com.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage objLoginPage;
	HomePage objHomePage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		objLoginPage=new LoginPage();
		objHomePage=objLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void logoTest() {
		TestUtil.switchToFrame("mainpanel");
		boolean flag=objHomePage.verifyLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void verifyContactLinkTest() {
		TestUtil.switchToFrame("mainpanel");
		objHomePage.clickOnContacts();
	}
	
	
	@AfterMethod
	public void tearDown() {		
		driver.close();
		driver.quit();
	}
	
}
