package carProject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Logoutsteps {
	public LOGIN lo=new LOGIN();

	@Given("I want to log out")
	public void i_want_to_log_out() {
	   
	}

	@When("The user presses the log out button")
	public void the_user_presses_the_log_out_button() {
	   
	}

	@Then("the login page will appear")
	public void the_login_page_will_appear() {
	   Assert.assertTrue(lo.run(1));
	}
}
