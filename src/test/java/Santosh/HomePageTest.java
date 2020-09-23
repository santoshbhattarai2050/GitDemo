package Santosh;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.EmailPage;
import pageObject.LoginPage;
import resources.Base;


// created home page test and extended from Base page
public class HomePageTest extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		
		//driver.manage().window().maximize();
		// Now invoke the browser
		
	}
	
	@Test(dataProvider="getData")
	public void baseNavigation(String Username, String Password, String text) throws IOException, Throwable {
		
		driver.get("https://rahulshettyacademy.com/#/index");
		Thread.sleep(4000);
		
		//There is Two way to access the class from another page
		//One is inheritance 
		//Another is creating object to that class and invoke methods of it
		LoginPage l = new LoginPage(driver);
		l.getLogin().click();
		
		//Getting object form EmailPage
		EmailPage ep = new EmailPage(driver);
		ep.fieldEmail().sendKeys(Username);
		ep.fieldPassword().sendKeys(Password);
		//System.out.println(text);
		log.info(text);
		ep.clickLogin().click();
		//ep.clickOncheckbox().click();
		//ep.clickOnSubmit().click();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		// Row stand for how many difference data types should run
		// Coloumns stand for how many values per each test
		Object[][] data = new Object[2][3];
		
		//0 row
		data[0][0]="nonresticuser@gmai.com";
		data[0][1]="1234";
		data[0][2]="restricteduser";
		
		//1 row
		data[1][0]="restricteduser@gmail.com";
		data[1][1]="4567";
		data[1][2]="nonrestricteduser";
		
		return data;
		
	}

}
