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
import lms.endpoints.Routes;
import lms.tests.UserLoginTests;


public class userModuleLogin_SD {

	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;

	@Given("User logs in with valid Username and password for Login Module")
	public void user_logs_in_with_valid_username_and_password_for_login_module() throws JsonProcessingException{
		this.request = UserLoginActions.getLoginRequest();
	}

	@When("User send Post Login request for Login Module")
	public void user_send_post_login_request_for_login_module() {
		this.response = UserLoginActions.getLoginResponse(request);
	}

	@Then("User should be able to get {int} in the response and generate Token for Login Module")
	public void user_should_be_able_to_get_in_the_response_and_generate_token_for_login_module(Integer int1) {
		this.token = UserLoginTests.getToken(response);
	}

}

