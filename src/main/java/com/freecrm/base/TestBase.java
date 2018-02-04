package com.freecrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.freecrm.util.TestUtil;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
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
		//madhur
		
	}
	
	//This Method is used for defining the browser and other properties
	public static void initialization () {
		String BrowserName=prop.getProperty("browser");
		if(BrowserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/maddy/Downloads/chromedriver");
			//System.setProperty(prop.getProperty("ChromePathKey") ,prop.getProperty("ChromePathValue"));
			driver=new ChromeDriver();	
		}
		
		else if(BrowserName.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/main/java/com/freecrm/drivers/gekodriver");
			driver=new FirefoxDriver();	
		}	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMLPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
}
