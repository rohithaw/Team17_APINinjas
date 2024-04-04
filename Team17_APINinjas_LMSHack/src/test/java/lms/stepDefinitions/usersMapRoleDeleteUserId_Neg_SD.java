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
import lms.actions.UsersMapRoleDeleteUserIdActions;
import lms.endpoints.Routes;
import lms.tests.UPRBTests;
import lms.tests.UserLoginTests;
import lms.tests.usersMapRoleGetAllTests;
import lms.tests.usersRolePrgmBatchMapDeleteTests;
import lms.utilities.LoggerLoad;


public class usersMapRoleDeleteUserId_Neg_SD {

	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;

	//Invalid Values Delete PrgmBatchStatus Module
	//*************************************
 

	 @Given("Admin creates GET Request program\\/batch for a user from an excelsheet with invalid values for user id")
	 public void admin_creates_get_request_program_batch_for_a_user_from_an_excelsheet_with_invalid_values_for_user_id() {
	 }

	 @When("Admin sends HTTPS Request for usersMapRoleGetUserId_Neg_SD for a user id {string}")
	 public void admin_sends_https_request_for_users_map_role_get_user_id_neg_sd_for_a_user_id(String string) {
	 }

	 @Then("User should be able to get {int} in the response for usersMapRoleGetUserId_Neg_SD for an invalid user id")
	 public void user_should_be_able_to_get_in_the_response_for_users_map_role_get_user_id_neg_sd_for_an_invalid_user_id(Integer int1) {
	 }

	 
	 
	 
	 
	 
////	 @Given("Admin creates Delete Request to delete user assigned to programs\\/batches for a user {string}")
////	 public void admin_creates_delete_request_to_delete_user_assigned_to_programs_batches_for_a_user(String string) throws JsonProcessingException {
////		this.request = UsersMapRoleDeleteUserIdActions.deleteRPBMUserIdRequest( string);
////	}
////
////	 @When("Admin sends HTTPS Request for DeleteUsersPrgmBatch for a user {string}")
////	 public void admin_sends_https_request_for_delete_users_prgm_batch_for_a_user(String string) {
////		this.response = UsersMapRoleDeleteUserIdActions.deleteUserRoleMapUserIdResponse(request, string);
////	}
////
////	 @Then("User should be able to get {int} in the response for DeleteUsersPrgmBatch")
////	 public void user_should_be_able_to_get_in_the_response_for_delete_users_prgm_batch(Integer int1) {
////		 usersRolePrgmBatchMapDeleteTests.GetUserMapRole200Validation(response);
//	//}
//	 
	//Invalid Url Delete PrgmBatchStatus Module
	//*************************************

	 @Given("User sets {string} with invalid Url, valid endpoint and valid request body Delete")
	 public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body_delete(String string) throws IOException {
			LoggerLoad.info("Execution of Invalid Url Delete PrgmBatchStatus Scenarios started");
			if ("Delete".equals(string)) {
				System.out.println("Inside Given");
				this.request = UPRBActions.deleteRPBMUserIdRequest_Neg(Routes.deleteUserRoleMap_InvalidUrl, token);
				System.out.println("Routes points " + Routes.deleteUserRoleMap_InvalidUrl);

			}
			else {
				System.out.println("Request not allowed");
			}
		 
	 }

	 @When("User sends {string} for PrgmBatchStatus Delete invalid Url")
	 public void user_sends_for_prgm_batch_status_delete_invalid_url(String string) {
				if ("DELETE".equals(string)) {
					System.out.println("Inside Update of When");
					this.response = UPRBActions.deleteUserRoleMapUserIdResponse_Neg(request, "DELETE");
				}else {
					System.out.println("Else of GetAll " + string);
					System.out.println("Request not allowed");
				}

	 }

	 @Then("User receives {int} Not found status in PrgmBatchStatus response Delete invalid Url")
	 public void user_receives_not_found_status_in_prgm_batch_status_response_delete_invalid_url(Integer int1) {
			System.out.println("Inside Then");
			UPRBTests.GetNegative404Validation(response);
		 
	 }

	 
	 
	//Invalid End Point Delete PrgmBatchStatus Module
	//***********************************
	 @Given("User sets {string} with valid Url, invalid endpoint and valid request body Delete InvalidEP")
	 public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body_delete_invalid_ep(String string) throws IOException {
			LoggerLoad.info("Execution of Invalid Endpoing Delete PrgmBatchStatus Scenarios started");
			if ("Delete".equals(string)) {
				System.out.println("Inside Given");
				this.request = UPRBActions.deleteRPBMUserIdRequest_Neg(Routes.deleteUserRoleMap_InvalidEP, token);
				System.out.println("Routes points " + Routes.deleteUserRoleMap_InvalidEP);

			}
			else {
				System.out.println("Request not allowed");
			}
	 }

	 @When("User sends {string} for PrgmBatchStatus Delete InvalidEP")
	 public void user_sends_for_prgm_batch_status_delete_invalid_ep(String string) {
			if ("DELETE".equals(string)) {
				System.out.println("Inside Update of When");
				this.response = UPRBActions.deleteUserRoleMapUserIdResponse_Neg(request, "DELETE");
			}else {
				System.out.println("Else of GetAll " + string);
				System.out.println("Request not allowed");
			}
	 }

	 @Then("User receives {int} Not found status in PrgmBatchStatus response Delete InvalidEP")
	 public void user_receives_not_found_status_in_prgm_batch_status_response_delete_invalid_ep(Integer int1) {
			System.out.println("Inside Then");
			UPRBTests.GetNegative404Validation(response);

	 }

	 
	 
	 
	//No_Auth_ Delete Prgm Batch Status
	//*****************
	 
	 @Given("Unauthorized User sets {string} with valid baseUrl,valid endpoint Delete NoAuth")
	 public void unauthorized_user_sets_with_valid_base_url_valid_endpoint_delete_no_auth(String string) throws IOException {
			LoggerLoad.info("Execution of Invalid Endpoing Delete PrgmBatchStatus Scenarios started");
			if ("Delete".equals(string)) {
				System.out.println("Inside Given");
				this.request = UPRBActions.GetPrgmBatchStatusRequestNoAuth(Routes.deleteUserRoleMap_Url);
				System.out.println("Routes points " + Routes.deleteUserRoleMap_Url);

			}
			else {
				System.out.println("Request not allowed");
			}
		 
		 
	 }

	 @When("User sends {string} for PrgmBatchStatus Delete NoAuth")
	 public void user_sends_for_prgm_batch_status_delete_no_auth(String string) {
			if ("DELETE".equals(string)) {
				System.out.println("Inside Update of When");
				this.response = UPRBActions.deleteUserRoleMapUserIdResponse_Neg(request, "DELETE");
			}else {
				System.out.println("Else of GetAll " + string);
				System.out.println("Request not allowed");
			}

	 
	 }

	 @Then("User receives {int} Unauthorized Status in PrgmBatchStatus response Delete NoAuth")
	 public void user_receives_unauthorized_status_in_prgm_batch_status_response_delete_no_auth(Integer int1) {
			System.out.println("Inside Then");
			UPRBTests.GetUnauthorizedValidation(response);

	 }

}
