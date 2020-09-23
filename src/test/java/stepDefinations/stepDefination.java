package stepDefinations;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.EmailPage;
import pageObject.LoginPage;
import resources.Base;

public class stepDefination extends Base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.get(arg1);
	}

	@Given("^Click on login page in home page$")
	public void click_on_login_page_in_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		LoginPage l = new LoginPage(driver);
		l.getLogin().click();
		
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		EmailPage ep = new EmailPage(driver);
		ep.fieldEmail().sendKeys(arg1);
		ep.fieldPassword().sendKeys(arg2);
		ep.clickLogin().click();
	    
	}
	


}