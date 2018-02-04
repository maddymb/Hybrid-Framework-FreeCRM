package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement lblContacts;
	

	public ContactsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean verifyContactsLabel() {
		return lblContacts.isDisplayed();
	}
	
	
	
	
}
