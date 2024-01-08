package carProject;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {
	
	private static String Email;
	private static String Password;
	private LOGIN lo=new LOGIN();
   private static  List<User> userlist=Mydata.listUser();

	@Given("I choose to exit instead of log in")
	public void i_choose_to_exit_instead_of_log_in() {
	}

	@Then("i will not enter the app")
	public void i_will_not_enter_the_app() {
		Assert.assertFalse(lo.run(2));

	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		Assert.assertTrue(lo.run(1));
	}

	@When("I enter my email as {string}")
	public void i_enter_my_email_as(String string) {
        Email=string;
	}

	@When("I enter my password as {string}")
	public void i_enter_my_password_as(String string) {
		Password=string;
	}

	@Then("A login succeded message should appear")
	public void a_login_succeded_message_should_appear() {
		lo.navigateToLoginPage(Email,Password,userlist);
		System.out.println("login successfully as customer");
		Assert.assertTrue(lo.performLogin(Email, Password,userlist));

	}

	@Then("i will be logged in as a customer")
	public void i_will_be_logged_in_as_a_customer() {
		Assert.assertEquals(lo.getc(), true);
		Assert.assertEquals(lo.getA(), false);
		Assert.assertEquals(lo.geti(), false);

	}

	@Given("I am on the login pagee")
	public void i_am_on_the_login_pagee() {
	}

	@When("I enter my emaill as {string}")
	public void i_enter_my_emaill_as(String string) {
      Email=string;
}

	@When("I enter my passwordd as {string}")
	public void i_enter_my_passwordd_as(String string) {
      Password=string;
	}

	@Then("A login succeded message should appearr")
	public void a_login_succeded_message_should_appearr() {
		System.out.println("login successfully as installer");

		Assert.assertTrue(lo.performLogin(Email, Password,userlist));

	}

	@Then("i will be logged in as a installer")
	public void i_will_be_logged_in_as_a_installer() {
		Assert.assertEquals(lo.geti(), true);
		Assert.assertEquals(lo.getA(), false);
		Assert.assertEquals(lo.getc(), false);	}

	@Given("I am on the login pageee")
	public void i_am_on_the_login_pageee() {
	}

	@When("I enter my emailll as {string}")
	public void i_enter_my_emailll_as(String string) {
    Email=string;
    }

	@When("I enter my passworddd as {string}")
	public void i_enter_my_passworddd_as(String string) {
Password=string;
}

	@Then("A login succeded message should appearrr")
	public void a_login_succeded_message_should_appearrr()
{
		System.out.println("login successfully as admin");

	Assert.assertTrue(lo.performLogin(Email, Password,userlist));

	}

	@Then("i will be logged in as an adminstrator")
	public void i_will_be_logged_in_as_an_adminstrator() {
		Assert.assertEquals(lo.getA(), true);
		Assert.assertEquals(lo.getc(), false);
		Assert.assertEquals(lo.geti(), false);
	}

	@When("I enter my emaillll as {string}")
	public void i_enter_my_emaillll_as(String string) {
 Email=string;
 }

	@When("I enter my passwordddd as {string}")
	public void i_enter_my_passwordddd_as(String string) {

	Password=string;
	}

	@Then("An error message succeded message should appear")
	public void an_error_message_succeded_message_should_appear() {
		System.out.println("you are not login please register before login");
		Assert.assertFalse(lo.performLogin(Email, Password,userlist));

	}
	
}
