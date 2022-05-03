package stepDefinations;


import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefination {

    @Given("^User is on a login page$")
    public void user_is_on_a_login_page() throws Throwable {
        System.out.println("User is at login page");
    }

    @When("User input login {string} and password {string}")
    public void user_input_login_and_password(String string, String string2) {
           	System.out.println("Input User name: " + string);
           	System.out.println("Input Password: " + string2);
    }

    @Then("^Home page prepopulated \"([^\"]*)\"$")
    public void home_page_prepopulated_something(String strArg1) throws Throwable {
    	System.out.println("Home page prepopulated: " + strArg1);
    }

//    @Then("Home page prepopulated {string}")
//    public void home_page_prepopulated(String string) {
//    	System.out.println("Home page prepopulated: " + string);
//    }

    @And("^click on the loggin button$")
    public void click_on_the_loggin_button() throws Throwable {
    	System.out.println("Click on the login button");
    }

    @And("^user name is displayed$")
    public void user_name_is_displayed() throws Throwable {
    	System.out.println("Check that user name is displayed");
    }

}
