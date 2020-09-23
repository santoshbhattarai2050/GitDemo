package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	By getText = By.cssSelector("div[class='pull-left']");
	By signin =	By.cssSelector("a[href*='sign_in']");
	By NavBar = By.cssSelector("div[class='nav-outer clearfix']");
	
	//To make locater variable Private 
	/*private By getText = By.cssSelector("div[class='pull-left']");
	private By signin =	By.cssSelector("a[href*='sign_in']");
	private By NavBar = By.cssSelector("div[class='nav-outer clearfix']");*/
	
	

	//Creating method for signin
	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(getText);
	}
	
	public WebElement getNavigatetoBar() {
		return driver.findElement(NavBar);
	}



}
