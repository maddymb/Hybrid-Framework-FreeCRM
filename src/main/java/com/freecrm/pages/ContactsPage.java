package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement lblContacts;
	
	@FindBy(name="title")
	WebElement Title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean verifyContactsLabel() {
		return lblContacts.isDisplayed();
	}
	
	public void createNewContact(String Title_Value, String name,String surname,String cmpny) {
		Select title=new Select(Title);
		title.selectByVisibleText(Title_Value);
		firstName.sendKeys(name);
		lastName.sendKeys(surname);
		company.sendKeys(cmpny);
		saveBtn.click();
		
	}
	
	
}
