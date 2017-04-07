package com.ibm.autotest.mockappication;

import java.util.logging.Logger;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.ibm.autotest.mockapplication.NavigatorFactory;

/**
 * Created by wu on 4/1/2017.
 */
public class LoginSteps {
    private static final Logger LOGGER = Logger.getLogger(LoginSteps.class.getName());

    @Given("^I navigate to the mock application$")
    public void given_I_navigate_to_the_mock_application(){
        LOGGER.info("Entering: I navigate to the mock application");
        NavigatorFactory.getNavigator().given_I_navigate_to_the_mock_application();

    }

    @When("^I try to login with '(.+)' credentials$")
    public void when_I_try_to_login(String credentialsType){
        LOGGER.info("Enter: I try to login with " +
            credentialsType + " credentials");
        NavigatorFactory.getNavigator().when_I_try_to_login(credentialsType);
    }

    @Then("^I should see that I logged in '(.+)'$")
    public void then_I_login(String outcome){
        LOGGER.info("Entering: I should see that I logged in " +
        outcome);
        NavigatorFactory.getNavigator().then_I_login(outcome);
    }

}
