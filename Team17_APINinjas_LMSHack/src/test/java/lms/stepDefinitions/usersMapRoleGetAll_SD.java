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
import lms.actions.UserLoginActions;
import lms.endpoints.Routes;
import lms.tests.UserLoginTests;
import lms.tests.usersMapRoleGetAllTests;
import lms.utilities.LoggerLoad;


public class usersMapRoleGetAll_SD {

	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;

//	 @Given("Admin creates GET Request to retrieve all users assigned to programs\\/batches")
//	 public void admin_creates_get_request_to_retrieve_all_users_assigned_to_programs_batches() throws JsonProcessingException {
//		 LoggerLoad.info("Execution of Valid GetALL for PrgmBatchStatus Scenarios started");
//		System.out.println("Value of token before get all " + token);
//		this.request = UsersMapRoleGetAllActions.getRPBMRequest();
//	}
//
//	 @When("Admin sends HTTPS Request for GetAllUsersPrgmBatch")
//	 public void admin_sends_https_request_for_get_all_users_prgm_batch() {
//		this.response = UsersMapRoleGetAllActions.getUserRoleMapAllResponse(request);
//	}
//
//	 @Then("User should be able to get {int} in the response for GetAllUsersPrgmBatch")
//	 public void user_should_be_able_to_get_in_the_response_for_get_all_users_prgm_batch(Integer int1) {
//		 usersMapRoleGetAllTests.GetUserMapRole200Validation(response);
//	}
}

	