package com.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freecrm.util.TestUtil;
import com.freecrm.util.WebEventListener;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//Constructor of the class for loading the properties file
	public TestBase() {	
		prop= new Properties();
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/freecrm/config/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//This Method is used for defining the browser and other properties
	public static void initialization () {
		String BrowserName=prop.getProperty("browser");
		
		if(BrowserName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "/Users/maddy/Downloads/chromedriver");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/com/freecrm/drivers/chromedriver");
			driver=new ChromeDriver();	
		}
		
		else if(BrowserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/maddy/Downloads/geckodriver");
			//System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+ "/src/main/java/com/freecrm/drivers/gekodriver");
			driver=new FirefoxDriver();	
		}	
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMLPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
}
