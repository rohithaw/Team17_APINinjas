package lms.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.actions.UserLoginActions;
import lms.actions.UserLogoutActions;
import lms.endpoints.Routes;
import lms.tests.UserLoginTests;


public class userModuleLogout_SD {

	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;

	 @Given("User logs out using Logout Module")
	 public void user_logs_out_using_logout_module() throws JsonProcessingException {
		this.request = UserLogoutActions.getLogoutRequest();
	}

	 @When("Admin calls Get Https method with valid endpoint")
	 public void admin_calls_get_https_method_with_valid_endpoint() {
	this.response = UserLogoutActions.getLogoutResponse(request);
	}

	 @Then("Admin should be able to get {int} in the response for Logout Module")
	 public void admin_should_be_able_to_get_in_the_response_for_logout_module(Integer int1) {
	}

}
