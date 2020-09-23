package resources;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	
	//Created Globle Variable driver
	public WebDriver driver;
	public Properties prop;

	// Creating Method
	public WebDriver initializeDriver ()throws IOException {

		// Invoke the browser
		// IF it is chrome invoke in chrome browser.
		// If it is firefox invoke in firefox browser

		// created data properties file
		Properties prop = new Properties();

		// Give file path
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Sami\\eclipse-workspace\\E2Eproject\\src\\main\\java\\\\resources\\data.properties");//In real work you have to make it dynamite.
		//to make dynamite replace this part "C:\\Users\\Sami\\eclipse-workspace\\E2Eproject" with System.getProperty("user.dir")+rest in ""
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			
			// execute in chrome browser
			System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
			//ChromeOptions option = new ChromeOptions();
			//if(browserName.contains("headless")) {
				
				//option.addArguments("headless");
			//}
			// If you want to run in headless
			/*ChromeOptions option = new ChromeOptions();
			option.addArguments("headless");
			driver = new ChromeDriver(option);*/
			
			driver = new ChromeDriver();
			
		} else if (browserName.equals("firefox")) {
			// execute in firefox browser
		} else if (browserName.equals("IE")) {
			// execute in IE browser
		}
		
		//Give wait time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshot(String testcaseName,WebDriver driver) throws IOException {
		
			TakesScreenshot ts =(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
			FileUtils.copyFile(src,new File(destinationFile));
			return destinationFile;
	}

}
