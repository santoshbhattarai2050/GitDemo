package Santosh;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObject.EmailPage;
import pageObject.LoginPage;
import resources.Base;


// created home page test and extended from Base page
public class ValidatePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		//driver.manage().window().maximize();
		// Now invoke the browser
		driver.get("https://rahulshettyacademy.com/#/index");
		log.info("Navigated to homepage");
	}
	
	@Test
	public void baseNavigation() throws IOException, Throwable {
		
		
		//Thread.sleep(4000);
		
		//There is Two way to access the class from another page
		//One is inheritance 
		//Another is creating object to that class and invoke methods of it
		LoginPage l = new LoginPage(driver);
		
		// Compare the text from the browser with actual text
		Assert.assertEquals(l.getTitle().getText(), "Featured Courses123");
		log.info("Successfully Validated Text Message");
		
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
