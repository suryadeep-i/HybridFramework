package stepdefenitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	String title;
	
	@Given("user is in login page")
	public void user_is_in_login_page() {
	    DriverFactory.getDriver().get("https://magento.softwaretestingboard.com/customer/account/login/");	    
	}

	@When("user gets the title of page")
	public void user_gets_the_title_of_page() {
		title = loginpage.getLoginPageTitle();
	}

	@Then("title should be {string}")
	public void title_should_be(String expectedTitle) {
	    Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("user click on forgot password")
	public void user_click_on_forgot_password() {
	    Assert.assertTrue(loginpage.forgotPasswordLink());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	    loginpage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	    loginpage.enterPassword(password);
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
	    loginpage.clickOnLogin();
	}


}
