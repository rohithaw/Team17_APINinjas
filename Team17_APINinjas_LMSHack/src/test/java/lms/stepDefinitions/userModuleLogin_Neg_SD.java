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
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.GlobalVariables.Env_Var;
import lms.actions.UPRBActions;
import lms.actions.UserLoginActions;
import lms.actions.UserLogoutActions;
import lms.endpoints.Routes;
import lms.tests.UPRBTests;
import lms.tests.UserLoginTests;
import lms.tests.UserLogoutTests;
import lms.utilities.LoggerLoad;


public class userModuleLogin_Neg_SD {

	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;

	//invalid password Login
	 @Given("User logs in with valid Username and invalid password for Login Module")
	 public void user_logs_in_with_valid_username_and_invalid_password_for_login_module() throws JsonProcessingException {
	 	 LoggerLoad.info("Execution of Invalid Password Login Scenarios started");
	 			this.request = UserLoginActions.getLoginRequest_Neg("numpyninja@gmail.com", "Hackathon@2024");
	 		

	 }

	@When("User send Post Login request with valid Username and invalid password for Login Module")
	public void user_send_post_login_request_with_valid_username_and_invalid_password_for_login_module() {
	 			this.response = UserLoginActions.getLoginResponse_Neg(request);

	 }

	@Then("User should be able to get {int} in the response and unable to generate Token for invalid password")
	public void user_should_be_able_to_get_in_the_response_and_unable_to_generate_token_for_invalid_password(Integer int1) {	
		UserLoginTests.GetNegative401Validation(response);
	 }


	
	//Invalid UserName_Login
	
	@Given("User logs in with invalid username and valid password for Login Module")
	public void user_logs_in_with_invalid_username_and_valid_password_for_login_module() throws JsonProcessingException {
	 	 LoggerLoad.info("Execution of Invalid Password Login Scenarios started");
		this.request = UserLoginActions.getLoginRequest_Neg("ninja@gmail.com", "lmsHackathon@2024");

	}

	@When("User send Post Login request invalid user name and valid password password for Login Module")
	public void user_send_post_login_request_invalid_user_name_and_valid_password_password_for_login_module() {
			this.response = UserLoginActions.getLoginResponse_Neg(request);

	}

	@Then("User should be able to get {int} in the response and unable to generate Token with invalid user")
	public void user_should_be_able_to_get_in_the_response_and_unable_to_generate_token_with_invalid_user(Integer int1) {
		UserLoginTests.GetNegative401Validation(response);

	}


	 

//Invalid Endpoint
@Given("User sets {string} with valid Url, invalid endpoint and valid request body Login")
public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body_login(String string) throws JsonProcessingException {
	 LoggerLoad.info("Execution of Invalid Endpoint Login Scenarios started");
		if ("Login".equals(string)) {
			System.out.println("Inside Given");
			this.request = UserLoginActions.getLoginRequestEP_Neg();

		}
		else {
			System.out.println("Request not allowed");
		}


}

@When("User sends {string} Status to Login for InvalidEP")
public void user_sends_status_to_login_for_invalid_ep(String string) {
	 if ("POST".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UserLoginActions.getLoginResponse_Neg(request);
		}else {
			System.out.println("Else of GetAll " + string);
			System.out.println("Request not allowed");
		}

}

@Then("User receives {int} Not found status in Login response for InvalidEP")
public void user_receives_not_found_status_in_login_response_for_invalid_ep(Integer int1) {
	UserLoginTests.GetNegative400Validation(response);
}


//Invalid URL Login

@Given("User sets {string} with invalid Url, valid endpoint and valid request body Login")
public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body_login(String string) throws IOException {
	 LoggerLoad.info("Execution of Invalid URL Login Scenarios started");
		if ("Login".equals(string)) {
			System.out.println("Inside Given");
			this.request = UserLoginActions.postLoginInvalidURL_Neg(Routes.GetLogin_InvalidUrl);
			System.out.println("Routes " + Routes.GetLogin_InvalidUrl);
		}
		else {
			System.out.println("Request not allowed");
		}
	
}

@When("User sends {string} Status to Login")
public void user_sends_status_to_login(String string) {
	
	 if ("POST".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UserLoginActions.getLoginResponse_Neg(request);
		}else {
			System.out.println("Else of GetAll " + string);
			System.out.println("Request not allowed");
		}
}

@Then("User receives {int} Not found status in Login response")
public void user_receives_not_found_status_in_login_response(Integer int1) {
	UserLoginTests.GetNegative404Validation(response);
}



////////////////////
//Logout

//Invalid URL	 
	 @Given("User sets {string} with invalid Url, valid endpoint and valid request body Logout")
	 public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body_logout(String string) throws IOException {
		 
		 	LoggerLoad.info("Execution of Logout with invalid URL Scenarios started");
			if ("Logout".equals(string)) {
				System.out.println("Inside Given");
				this.request = UserLogoutActions.getLogoutRequest_Neg(Routes.GetLogout_InvalidUrl, token);
				System.out.println("Routes points " + Routes.GetLogout_InvalidUrl);

			}
			else {
				System.out.println("Request not allowed");
			}

		  
	 }

	 @When("User sends {string} Status to Logout")
	 public void user_sends_status_to_logout(String string) {
		 if ("GET".equals(string)) {
				System.out.println("Inside Update of When");
				this.response = UserLogoutActions.getLogoutResponse_Neg(request, "GET");
			}else {
				System.out.println("Else of GetAll " + string);
				System.out.println("Request not allowed");
			}
		 
	 }

	 @Then("User receives {int} Not found status in Logout response")
	 public void user_receives_not_found_status_in_logout_response(Integer int1) {
		 UserLogoutTests.GetNegative404Validation(response);
		 
	 }

	 
	 //Invalid Endpoint
	 @Given("User sets {string} with valid Url, invalid endpoint and valid request body Logout")
	 public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body_logout(String string) throws IOException {
		 LoggerLoad.info("Execution of Invalid Endpoing Logout Scenarios started");
			if ("Logout".equals(string)) {
				System.out.println("Inside Given");
				this.request = UserLogoutActions.getLogoutRequest_Neg(Routes.GetLogout_InvalidEP, token);
				System.out.println("Routes points " + Routes.GetLogout_InvalidEP);

			}
			else {
				System.out.println("Request not allowed");
			}


	 }

	 @When("User sends {string} Status to Logout for InvalidEP")
	 public void user_sends_status_to_logout_for_invalid_ep(String string) {
		 if ("GET".equals(string)) {
				System.out.println("Inside Update of When");
				this.response = UserLogoutActions.getLogoutResponse_Neg(request, "GET");
			}else {
				System.out.println("Else of GetAll " + string);
				System.out.println("Request not allowed");
			}

	 }

	 @Then("User receives {int} Not found status in Logout response for InvalidEP")
	 public void user_receives_not_found_status_in_logout_response_for_invalid_ep(Integer int1) {
		 UserLogoutTests.GetNegative400Validation(response);
	 }

	 
	 //No Auth
	 @Given("Unauthorized User sets {string} with valid baseUrl,valid endpoint for Logout")
	 public void unauthorized_user_sets_with_valid_base_url_valid_endpoint_for_logout(String string) throws JsonProcessingException {
			LoggerLoad.info("Execution of Noauth Logout Scenarios started");
			if ("Logout".equals(string)) {
				System.out.println("Inside Given");
				this.request = UserLogoutActions.GetLogoutNoAuth(Routes.Logout_Url);
				System.out.println("Routes points " + Routes.Logout_Url);

			}
			else {
				System.out.println("Request not allowed");
			}

	 }

	 @When("User sends {string} status for Logout")
	 public void user_sends_status_for_logout(String string) {
			if ("GET".equals(string)) {
				System.out.println("Inside Update of When");
				this.response = UserLogoutActions.getLogoutResponse_Neg(request, "GET");
			}else {
				System.out.println("Else of GetAll " + string);
				System.out.println("Request not allowed");
			}
		 
	 }

	 @Then("User receives {int} Unauthorized Status in Logout response")
	 public void user_receives_unauthorized_status_in_logout_response(Integer int1) {
		 UserLogoutTests.GetUnauthorizedValidation(response);
	 }


}



