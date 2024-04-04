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
import lms.actions.UsersMapRoleGetAllActions;
import lms.actions.UsersMapRoleGetUserIdActions;
import lms.actions.UserLoginActions;
import lms.endpoints.Routes;
import lms.tests.UserLoginTests;
import lms.tests.usersMapRoleGetUserIdTests;
import lms.utilities.LoggerLoad;


public class usersMapRoleGetUserId_SD {

	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;

//	 @Given("Admin creates GET Request to retrieve assigned to programs\\/batches for a user {string}")
//	 public void admin_creates_get_request_to_retrieve_assigned_to_programs_batches_for_a_user(String string) throws JsonProcessingException {
//		 LoggerLoad.info("Execution of Valid Get by UserID for PrgmBatchStatus Scenarios started");
//		this.request = UsersMapRoleGetUserIdActions.getRPBMUserIdRequest( string);
//	}
//
//	 @When("Admin sends HTTPS Request for GetUsersPrgmBatchUserId for a user {string}")
//	 public void admin_sends_https_request_for_get_users_prgm_batch_user_id_for_a_user(String string) {
//		this.response = UsersMapRoleGetUserIdActions.getUserRoleMapUserIdResponse(request, string);
//	}
//
//	 @Then("User should be able to get {int} in the response for GetUsersPrgmBatchUserId for a user")
//	 public void user_should_be_able_to_get_in_the_response_for_get_users_prgm_batch_user_id_for_a_user(Integer int1) {
//		 usersMapRoleGetUserIdTests.GetUserMapRole200Validation(response);
//		 
//	}
}


