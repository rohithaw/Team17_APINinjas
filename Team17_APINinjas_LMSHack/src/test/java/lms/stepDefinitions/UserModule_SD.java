package lms.stepDefinitions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.actions.UserActions;
import lms.endpoints.Routes;
import lms.tests.UserTests;

public class UserModule_SD {
	
	
	RequestSpecification request;
	Response response;
	List<RequestSpecification> requests;
	List<Response> responses;
	String token;
	
	//Background steps
	@Given("User logs in with valid Username and password for User Module")
	public void user_logs_in_with_valid_username_and_password_for_user_module() throws JsonProcessingException {
	   this.request = UserActions.getLoginRequest();
	}

	@When("User send Post Login request for User Module")
	public void user_send_post_login_request_for_user_module() {
		 this.response = UserActions.getLoginResponse(request);
	}

	@Then("User should be able to get {int} in the response and generate Token for User Module")
	public void user_should_be_able_to_get_in_the_response_and_generate_token_for_user_module(Integer int1) {
		this.token = UserTests.getToken(response);
	}

	//Create user steps
	@Given("Authorized User sets Post User request with valid Url,valid endpoint, request body from excel")
	public void authorized_user_sets_post_user_request_with_valid_url_valid_endpoint_request_body_from_excel() throws IOException {
		this.request = UserActions.getPostCreateUserRequest(Routes.CreateUser_Url, token);
	}

	@When("User sends POST User request.")
	public void user_sends_post_user_request() {
		this.response = UserActions.getPostCreateUserResponse(request);
		UserActions.setUserDetails(response);
	}

	@Then("User receives expected status in Post User response")
	public void user_receives_expected_status_in_post_user_response() {
		 UserTests.PostUser201Validation(response);
	}
	
	

}
