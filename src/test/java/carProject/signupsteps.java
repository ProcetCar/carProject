package carProject;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signupsteps {
	public Signup signup=new Signup();
	public static String email;
	public static String password;
	public static String username;
	public static String age;
	public LOGIN lo=new LOGIN();

@Given("I am on the signup page")
public void i_am_on_the_signup_page() {
    Assert.assertTrue(signup.run(1));
}

@When("I enter a valid username as a  {string}")
public void i_enter_a_valid_username_as_a(String string) {
	username=string;
}

@When("I enter a valid password as a {string}")
public void i_enter_a_valid_password_as_a(String string) {
password=string;
}

@When("I enter a valid email as a {string}")
public void i_enter_a_valid_email_as_a(String string) {
email=string;
}

@When("I enter a valid age as a {string}")
public void i_enter_a_valid_age_as_a(String string) {
	age=string;
}

@Then("I should be registered successfully")
public void i_should_be_registered_successfully() {
	
}

@Given("a user is already registered")
public void a_user_is_already_registered() {
}

@When("I enter the same email {string}")
public void i_enter_the_same_email(String string) {
email=string;
}

@When("I click the signup button")
public void i_click_the_signup_button() {
}

@Then("I should see an error message for a user already registered")
public void i_should_see_an_error_message_for_a_user_already_registered() {
	Assert.assertTrue(lo.checkIfRegister(email));
}

@When("I enter a username as a {string}")
public void i_enter_a_username_as_a(String string) {
	username=string;
}

@Then("I should see an error message for a missing username")
public void i_should_see_an_error_message_for_a_missing_username() {
Assert.assertFalse(lo.ifvalid(username));}

@When("I enter a  password as a {string}")
public void i_enter_a_password_as_a(String string) {
password=string;
}

@Then("I should see an error message for a missing password")
public void i_should_see_an_error_message_for_a_missing_password() {
	Assert.assertFalse(lo.ifvalid(password));

}

@Then("I should see an error message for a missing email")
public void i_should_see_an_error_message_for_a_missing_email() {
	Assert.assertFalse(lo.ifvalid(email));

}

@Then("I should see an error message for a missing age")
public void i_should_see_an_error_message_for_a_missing_age() {
	Assert.assertFalse(lo.ifvalid(age));

}
}
