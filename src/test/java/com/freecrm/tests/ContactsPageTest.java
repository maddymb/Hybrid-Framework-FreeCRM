package com.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.base.TestBase;
import com.freecrm.pages.ContactsPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage objLoginPage;
	HomePage objHomePage;
	ContactsPage objContactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		objLoginPage=new LoginPage();
		objHomePage=objLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame("mainpanel");
		objContactsPage=objHomePage.clickOnContacts();
	}
	
	@Test
	public void verifyContactsLabel() {
		boolean flag=objContactsPage.verifyContactsLabel();
		Assert.assertTrue(flag);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
