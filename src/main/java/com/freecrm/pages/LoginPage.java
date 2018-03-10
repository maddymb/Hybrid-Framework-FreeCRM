package com.freecrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;
import com.freecrm.util.JavaScriptExecutorUtility;

public class LoginPage extends TestBase {

	//Page Factory Method : Object Repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//img[@src='https://d19rqa8v8yb76c.cloudfront.net/img/freecrm.jpg']")
	WebElement freecrmLogo;
	
	
	
	//Constructor of the Class
	public LoginPage() {	
		PageFactory.initElements(driver, this); // or we can write PageFactory.initElements(driver, LoginPage.class);
	}
	
	//This Method will Return the Title of Web Page
	public String validateTitle() {
		return driver.getTitle();	
	}
	
	// This Method will return the Boolean Value for the Logo
	public boolean validateLogo() {	
		JavaScriptExecutorUtility.flash(freecrmLogo, driver);
		return freecrmLogo.isDisplayed();
	}
	
	
	//This Method will perform the Login Action
	public HomePage login(String uname,String pass) {
		System.err.println(driver);
		JavaScriptExecutorUtility.flash(username, driver);		
		username.clear();
		username.sendKeys(uname);
		JavaScriptExecutorUtility.drawBorder(username, driver);
		
		JavaScriptExecutorUtility.flash(password, driver);
		password.clear();
		password.sendKeys(pass);	
		
		//loginButton.click();
		JavaScriptExecutorUtility.flash(loginButton, driver);
		JavaScriptExecutorUtility.clickElement(loginButton, driver);
		return new HomePage();
	}
	
	
	
	
}
