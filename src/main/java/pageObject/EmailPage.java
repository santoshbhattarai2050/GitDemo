package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPage {
	
	public WebDriver driver;
	
	public EmailPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By email = By.cssSelector("input[id='user_email']");
	By password = By.cssSelector("input[id='user_password']");
	By login = By.cssSelector("[value='Log In']");
	By robot = By.cssSelector("div[id='checkbox']");
	By submit = By.cssSelector("input[id='hcaptcha_submit']");
	
	
	public WebElement fieldEmail() {
		return driver.findElement(email);
	}
	
	public WebElement fieldPassword() {
		return driver.findElement(password);
	}
	
	public WebElement clickLogin() {
		return driver.findElement(login);
	}
	public WebElement clickOncheckbox() {
		return driver.findElement(robot);
	}
	
	public WebElement clickOnSubmit() {
		return driver.findElement(submit);
	}



}
