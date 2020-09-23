package Santosh;

//import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import pageObject.EmailPage;
import pageObject.LoginPage;
import resources.Base;


// created home page test and extended from Base page
public class validateNavigationBar extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
		//driver.manage().window().maximize();
		// Now invoke the browser
		driver.get("https://rahulshettyacademy.com/#/index");
		
	}
	
	@Test
	public void baseNavigation() throws IOException, Throwable {
		
		
		
		//There is Two way to access the class from another page
		//One is inheritance 
		//Another is creating object to that class and invoke methods of it
		LoginPage l = new LoginPage(driver);
		
		// Using assertion to find out if it is displayed on page or not
		Assert.assertTrue(l.getNavigatetoBar().isDisplayed());
		log.info("Navigate bar is displayed");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
