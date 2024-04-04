package lms.stepDefinitions;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.actions.UPRBActions;
import lms.actions.UserPutPrgmBatchStatusActions;
import lms.actions.UsersMapRoleDeleteUserIdActions;
import lms.actions.UsersMapRoleGetAllActions;
import lms.actions.UsersMapRoleGetUserIdActions;
import lms.endpoints.Routes;
import lms.tests.UPRBTests;
import lms.tests.usersMapRoleGetAllTests;
import lms.tests.usersMapRoleGetUserIdTests;
import lms.tests.usersPutPrgmBatchStatusTests;
import lms.tests.usersRolePrgmBatchMapDeleteTests;
import lms.utilities.LoggerLoad;

public class UPRB_SD {
	
	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;

	 //Delete by User id
	 @Given("Admin creates Delete Request to delete user assigned to programs\\/batches for a user {string}")
	 public void admin_creates_delete_request_to_delete_user_assigned_to_programs_batches_for_a_user(String string) throws JsonProcessingException {
		 LoggerLoad.info("Execution of Valid Delete for PrgmBatchStatus Scenarios started");
		this.request = UPRBActions.deleteRPBMUserIdRequest( string);
	}

	 @When("Admin sends HTTPS Request for DeleteUsersPrgmBatch for a user {string}")
	 public void admin_sends_https_request_for_delete_users_prgm_batch_for_a_user(String string) {
		this.response = UPRBActions.deleteUserRoleMapUserIdResponse(request, string);
	}

	 @Then("User should be able to get {int} in the response for DeleteUsersPrgmBatch")
	 public void user_should_be_able_to_get_in_the_response_for_delete_users_prgm_batch(Integer int1) {
		 UPRBTests.GetUserMapRole200ValidationDelete(response);
	}
	
	//RoleGetALL
	 @Given("Admin creates GET Request to retrieve all users assigned to programs\\/batches")
	 public void admin_creates_get_request_to_retrieve_all_users_assigned_to_programs_batches() throws JsonProcessingException {
		 LoggerLoad.info("Execution of Valid GetALL for PrgmBatchStatus Scenarios started");
		System.out.println("Value of token before get all " + token);
		this.request = UPRBActions.getRPBMRequest();
	}

	 @When("Admin sends HTTPS Request for GetAllUsersPrgmBatch")
	 public void admin_sends_https_request_for_get_all_users_prgm_batch() {
		this.response = UPRBActions.getUserRoleMapAllResponse(request);
	}

	 @Then("User should be able to get {int} in the response for GetAllUsersPrgmBatch")
	 public void user_should_be_able_to_get_in_the_response_for_get_all_users_prgm_batch(Integer int1) {
		 UPRBTests.GetUserMapRole200ValidationGetAll(response);
	}
	 
	 
	//Get by User id
	 
	 @Given("Admin creates GET Request to retrieve assigned to programs\\/batches for a user {string}")
	 public void admin_creates_get_request_to_retrieve_assigned_to_programs_batches_for_a_user(String string) throws JsonProcessingException {
		 LoggerLoad.info("Execution of Valid Get by UserID for PrgmBatchStatus Scenarios started");
		this.request = UPRBActions.getRPBMUserIdRequest( string);
	}

	 @When("Admin sends HTTPS Request for GetUsersPrgmBatchUserId for a user {string}")
	 public void admin_sends_https_request_for_get_users_prgm_batch_user_id_for_a_user(String string) {
		this.response = UPRBActions.getUserRoleMapUserIdResponse(request, string);
	}

	 @Then("User should be able to get {int} in the response for GetUsersPrgmBatchUserId for a user")
	 public void user_should_be_able_to_get_in_the_response_for_get_users_prgm_batch_user_id_for_a_user(Integer int1) {
		 UPRBTests.GetUserMapRole200ValidationUserID(response);
		 
	}
	 
	 
	 //Put program batch status
	 @Given("Admin creates PUT Request to assign program\\/batch for a user from excelsheet")
	 public void admin_creates_put_request_to_assign_program_batch_for_a_user_from_excelsheet() throws IOException {
		 LoggerLoad.info("Execution of Valid PUT for PrgmBatchStatus Scenarios started");
	 		this.requests = UPRBActions.putRPBMUserIdRequestDD(Routes.putUserRoleMap_Url, token, "put");
		}
	
		 @When("Admin sends HTTPS Request for PutUserProgramBatchStatusUserId for a user {string}")
		 public void admin_sends_https_request_for_put_user_program_batch_status_user_id_for_a_user(String string) {
			this.responses = UPRBActions.putProgramBatchStatusResponsesDD(requests, string);
		}
	
		 @Then("User should be able to get {int} in the response for PutUserProgramBatchStatusUserId")
		 public void user_should_be_able_to_get_in_the_response_for_put_user_program_batch_status_user_id(Integer int1) {
			 UPRBTests.PutUserMapRole200ValidationDD(responses, "put");

	 
	}
}


