package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement logoText;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement lblContacts;
	
	public HomePage() {		
		PageFactory.initElements(driver, this);	
	}
	
	public boolean verifyLogo() {
		return logoText.isDisplayed();
	}
	
	public ContactsPage clickOnContacts() {
		lblContacts.click();
		return new ContactsPage();
		
	}
	
	
	
}
