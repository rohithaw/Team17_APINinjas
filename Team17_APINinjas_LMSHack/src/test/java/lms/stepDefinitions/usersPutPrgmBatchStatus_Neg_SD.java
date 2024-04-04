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
import lms.actions.UPRBActions;
import lms.actions.UserLoginActions;
import lms.actions.UserPutPrgmBatchStatusActions;
import lms.endpoints.Routes;
import lms.tests.UPRBTests;
import lms.tests.UserLoginTests;
import lms.tests.usersMapRoleGetUserIdTests;
import lms.tests.usersPutPrgmBatchStatusTests;
import lms.utilities.LoggerLoad;


public class usersPutPrgmBatchStatus_Neg_SD {

	
	 RequestSpecification request;
	 List<RequestSpecification> requestList;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responseList;
	 String token;

	 
//Invalid Values
	 //*************************************
	 @Given("Admin creates PUT Request to assign program\\/batch for a user from excelsheet with invalid values")
	 public void admin_creates_put_request_to_assign_program_batch_for_a_user_from_excelsheet_with_invalid_values() throws IOException {
 		this.requestList = UPRBActions.putRPBMUserIdRequestDD_Neg(Routes.putUserRoleMap_Url, token );
	}

	 @When("Admin sends HTTPS Request for PutUserProgramBatchStatusUserId_Neg for a user {string}")
	 public void admin_sends_https_request_for_put_user_program_batch_status_user_id_neg_for_a_user(String string) {
		this.responseList = UPRBActions.putProgramBatchStatusResponsesDD(requestList, string);
	}

	 @Then("User should be able to get {int} in the response for PutUserProgramBatchStatusUserId_Neg")
	 public void user_should_be_able_to_get_in_the_response_for_put_user_program_batch_status_user_id_neg(Integer int1) {
		 UPRBTests.PutUserMapRole200ValidationDD(responseList, "put");
	 }

//Invalid Url PUT PrgmBatchStatus Module
	 //*************************************
		 @Given("User sets {string} with invalid Url, valid endpoint and valid request body PrgmBatchStatus")
		 public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body_prgm_batch_status(String string) throws IOException {
			 LoggerLoad.info("Execution of Invalid Url PrgmBatchStatus Scenarios started");
				if ("Update".equals(string)) {
					this.requestList = UPRBActions.putRPBMUserIdRequestDD_Neg(Routes.PutUserRoleMap_InvalidUrl, token);
				}
				else {
					System.out.println("Request not allowed");
				}
		 }

		 	@When("User sends {string} Status to PrgmBatchStatus")
		 	public void user_sends_status_to_prgm_batch_status(String string) {
				if ("PUT".equals(string)) {
					System.out.println("Inside Update of When");
					this.responseList = UPRBActions.putProgramBatchStatusResponsesDD(requestList, "PUT");
				}else {
					System.out.println("Else of PUT " + string);
					System.out.println("Request not allowed");
				}
		 }

		 @Then("User receives {int} Not found status in PrgmBatchStatus response")
		 public void user_receives_not_found_status_in_prgm_batch_status_response(Integer int1) {
			 System.out.println("Inside Then");
			 UPRBTests.PutUserMapRole200ValidationDD(responseList, "put");
		 }
	
//Invalid End Point PUT PrgmBatchStatus Module
		 //***********************************
		 @Given("User sets {string} with valid Url, invalid endpoint and valid request body PrgmBatchStatus")
		 public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body_prgm_batch_status(String string) throws IOException {
			 	LoggerLoad.info("Execution of Invalid endpoint PrgmBatchStatus Scenarios started");
				if ("Update".equals(string)) {
					this.requestList = UPRBActions.putRPBMUserIdRequestDD_Neg(Routes.PutUserRoleMap_InvalidEP, token);
				}
				else {
					System.out.println("Request not allowed");
				}
		 }

		 @When("User sends {string} Status to PrgmBatchStatus for InvalidEP")
		 public void user_sends_status_to_prgm_batch_status_for_invalid_ep(String string) {
			 if ("PUT".equals(string)) {
					System.out.println("Inside Update of When");
					this.responseList = UPRBActions.putProgramBatchStatusResponsesDD(requestList, "PUT");
				}else {
					System.out.println("Else of PUT " + string);
					System.out.println("Request not allowed");
				}
		 }

		 @Then("User receives {int} Not found status in PrgmBatchStatus response for InvalidEP")
		 public void user_receives_not_found_status_in_prgm_batch_status_response_for_invalid_ep(Integer int1) {
			 System.out.println("Inside Then");
			 UPRBTests.PutUserMapRole200ValidationDD(responseList, "put");
		 }
		 
		 
		 
//No_Auth_Prgm Batch Status
		 //*****************
		 @Given("Unauthorized User sets {string} with valid baseUrl,valid endpoint for PrgmBatchStatus")
		 public void unauthorized_user_sets_with_valid_base_url_valid_endpoint_for_prgm_batch_status(String string) throws JsonProcessingException {
			 	LoggerLoad.info("Execution of No_Auth endpoint PrgmBatchStatus Scenarios started");
				if ("Update".equals(string)) {
					this.request = UPRBActions.PutPrgmBatchStatusRequestNoAuth(Routes.putUserRoleMap_Url);
				}
				else {
					System.out.println("Request not allowed");
				}
		 }

		 @When("User sends {string} status for PrgmBatchStatus")
		 public void user_sends_status_for_prgm_batch_status(String string) {
			 if ("PUT".equals(string)) {
					System.out.println("Inside Update of When");
					this.response = UPRBActions.putUserRoleMapUserIdResponse(request, "PUT");
				}else {
					System.out.println("Else of PUT " + string);
					System.out.println("Request not allowed");
				}

		 }

		 @Then("User receives {int} Unauthorized Status in PrgmBatchStatus response")
		 public void user_receives_unauthorized_status_in_prgm_batch_status_response(Integer int1) {
			 System.out.println("Inside Then");
			 UPRBTests.GetUnauthorizedValidation(response);
		 }
}