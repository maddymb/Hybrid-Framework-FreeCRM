package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement logoText;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement lblContacts;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement lblNewContacts;
	
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
	
	public void clickOnNewContact() {
		Actions as=new Actions(driver);
		as.moveToElement(lblContacts).build().perform();
		lblNewContacts.click();
	}
	
	
	
}
