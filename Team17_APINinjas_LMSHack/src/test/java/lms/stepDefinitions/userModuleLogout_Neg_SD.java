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
import lms.actions.UPRBActions;
import lms.actions.UserLoginActions;
import lms.actions.UserLogoutActions;
import lms.endpoints.Routes;
import lms.tests.UPRBTests;
import lms.tests.UserLoginTests;
import lms.tests.UserLogoutTests;
import lms.utilities.LoggerLoad;


public class userModuleLogout_Neg_SD {

	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;
	 
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
