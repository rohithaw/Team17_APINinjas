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
import lms.actions.UsersMapRoleDeleteUserIdActions;
import lms.endpoints.Routes;
import lms.tests.UserLoginTests;
import lms.tests.usersRolePrgmBatchMapDeleteTests;
import lms.utilities.LoggerLoad;


public class usersMapRoleDeleteUserId_SD {

	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;

//	 @Given("Admin creates Delete Request to delete user assigned to programs\\/batches for a user {string}")
//	 public void admin_creates_delete_request_to_delete_user_assigned_to_programs_batches_for_a_user(String string) throws JsonProcessingException {
//		 LoggerLoad.info("Execution of Valid Delete for PrgmBatchStatus Scenarios started");
//		this.request = UsersMapRoleDeleteUserIdActions.deleteRPBMUserIdRequest( string);
//	}
//
//	 @When("Admin sends HTTPS Request for DeleteUsersPrgmBatch for a user {string}")
//	 public void admin_sends_https_request_for_delete_users_prgm_batch_for_a_user(String string) {
//		this.response = UsersMapRoleDeleteUserIdActions.deleteUserRoleMapUserIdResponse(request, string);
//	}
//
//	 @Then("User should be able to get {int} in the response for DeleteUsersPrgmBatch")
//	 public void user_should_be_able_to_get_in_the_response_for_delete_users_prgm_batch(Integer int1) {
//		 usersRolePrgmBatchMapDeleteTests.GetUserMapRole200Validation(response);
//	}
}
