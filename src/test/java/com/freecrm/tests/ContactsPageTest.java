package com.freecrm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	String sheetName = "contacts";
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
	
	@DataProvider(name="TestData")
	public Object[][] getTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(dataProvider="TestData")
	public void createNewContactTest(String Title_Value, String name,String surname,String cmpny) {
		objHomePage.clickOnNewContact();
		//objContactsPage.createNewContact("Mr.", "Maddy", "Bharadwaj", "HCL");
		objContactsPage.createNewContact(Title_Value, name, surname, cmpny);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}
