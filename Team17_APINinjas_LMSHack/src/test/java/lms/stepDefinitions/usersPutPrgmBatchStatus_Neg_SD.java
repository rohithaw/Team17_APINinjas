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
import lms.endpoints.Routes;
import lms.tests.UPRBTests;
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

	//GetUser id
	//Invalid Url GET UserID PrgmBatchStatus Module
	//*************************************
	@Given("User sets {string} with invalid Url, valid endpoint and valid request body GET UserID")
	public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body_get_user_id(String string) throws IOException {
		LoggerLoad.info("Execution of Invalid Url GET UserID PrgmBatchStatus Scenarios started");
		if ("Get_UserId".equals(string)) {
			System.out.println("Inside Given");
			this.request = UPRBActions.getRPBMUserIdRequestDD_Neg(Routes.userGetRoleMap_InvalidUrl, token);
			System.out.println("Routes points " + Routes.userGetRoleMap_InvalidUrl);
		}
		else {
			System.out.println("Request not allowed");
		}
	}
	@When("User sends {string} for PrgmBatchStatus GET UserID invalid Url")
	public void user_sends_for_prgm_batch_status_get_user_id_invalid_url(String string) {
		if ("GET".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UPRBActions.getUserRoleMapUserIdResponse_Neg(request, "GET");
		}else {
			System.out.println("Else of GetAll " + string);
			System.out.println("Request not allowed");
		}

	}
	@Then("User receives {int} Not found status in PrgmBatchStatus response GET UserID invalid Url")
	public void user_receives_not_found_status_in_prgm_batch_status_response_get_user_id_invalid_url(Integer int1) {
		System.out.println("Inside Then");
		UPRBTests.GetNegative404Validation(response);


	}


	//Invalid endpoint GET UserID PrgmBatchStatus Module
	//*************************************

	@Given("User sets {string} with valid Url, invalid endpoint and valid request body GET UserID InvalidEP")
	public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body_get_user_id_invalid_ep(String string) throws IOException {
		LoggerLoad.info("Execution of Invalid Endpoint GET UserID PrgmBatchStatus Scenarios started");
		if ("Get_UserId".equals(string)) {
			System.out.println("Inside Given");
			this.request = UPRBActions.getRPBMUserIdRequestDD_Neg(Routes.userGetRoleMap_InvalidEP, token);
			System.out.println("Routes points " + Routes.userGetRoleMap_InvalidEP);
		}
		else {
			System.out.println("Request not allowed");
		}

	}
	@When("User sends {string} for PrgmBatchStatus GET UserID InvalidEP")
	public void user_sends_for_prgm_batch_status_get_user_id_invalid_ep(String string) {
		if ("GET".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UPRBActions.getUserRoleMapUserIdResponse_Neg(request, "GET");
		}else {
			System.out.println("Else of GetAll " + string);
			System.out.println("Request not allowed");
		}
	}
	@Then("User receives {int} Not found status in PrgmBatchStatus response GET UserID InvalidEP")
	public void user_receives_not_found_status_in_prgm_batch_status_response_get_user_id_invalid_ep(Integer int1) {
		System.out.println("Inside Then");
		UPRBTests.GetNegative404Validation(response);
	}
	//No Auth GET UserID PrgmBatchStatus Module
	//*************************************


	@Given("Unauthorized User sets {string} with valid baseUrl,valid endpoint GET UserID NoAuth")
	public void unauthorized_user_sets_with_valid_base_url_valid_endpoint_get_user_id_no_auth(String string) throws JsonProcessingException {

		LoggerLoad.info("Execution of No_Auth GET UserId PrgmBatchStatus Scenarios started");
		if ("Get_UserId".equals(string)) {
			this.request = UPRBActions.GetPrgmBatchStatusRequestNoAuth(Routes.adminGetAllRoleMap_Url);
		}
		else {
			System.out.println("Request not allowed");
		}
	}
	@When("User sends {string} for PrgmBatchStatus GET UserID NoAuth")
	public void user_sends_for_prgm_batch_status_get_user_id_no_auth(String string) {
		if ("GET".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UPRBActions.getUserRoleMapUserIdResponse_Neg(request, "GET");
		}else {
			System.out.println("Else of GET " + string);
			System.out.println("Request not allowed");
		}
	}
	@Then("User receives {int} Unauthorized Status in PrgmBatchStatus response GET UserID NoAuth")
	public void user_receives_unauthorized_status_in_prgm_batch_status_response_get_user_id_no_auth(Integer int1) {
		System.out.println("Inside Then");
		UPRBTests.GetUnauthorizedValidation(response);

	}

	//GETALL
	//Invalid Url GET ALL PrgmBatchStatus Module
	//*************************************
	@Given("User sets {string} with invalid Url, valid endpoint and valid request body GetAll")
	public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body_get_all(String string) throws IOException {
		LoggerLoad.info("Execution of Invalid Url GET ALL PrgmBatchStatus Scenarios started");
		if ("Get_All".equals(string)) {
			System.out.println("Inside Given");
			this.request = UPRBActions.getRPBMUserAllRequestDD_Neg(Routes.adminGetAllRoleMap_InvalidUrl, token);
			System.out.println("Routes points " + Routes.adminGetAllRoleMap_InvalidUrl);
		}
		else {
			System.out.println("Request not allowed");
		}
	}
	@When("User sends {string} for PrgmBatchStatus GetAll invalid Url")
	public void user_sends_for_prgm_batch_status_get_all_invalid_url(String string) {
		if ("GET".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UPRBActions.getUserRoleMapAllResponse_Neg(request, "GET");
		}else {
			System.out.println("Else of GetAll " + string);
			System.out.println("Request not allowed");
		}
	}
	@Then("User receives {int} Not found status in PrgmBatchStatus response GetAll invalid Url")
	public void user_receives_not_found_status_in_prgm_batch_status_response_get_all_invalid_url(Integer int1) {
		System.out.println("Inside Then");
		UPRBTests.GetNegative404Validation(response);
	}
	//Invalid End Point GET ALL PrgmBatchStatus Module
	//***********************************
	@Given("User sets {string} with valid Url, invalid endpoint and valid request body GetAll InvalidEP")
	public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body_get_all_invalid_ep(String string) throws IOException {
		LoggerLoad.info("Execution of Invalid endpoint GET ALL PrgmBatchStatus Scenarios started");
		if ("Get_All".equals(string)) {
			this.request = UPRBActions.getRPBMUserAllRequestDD_Neg(Routes.adminGetAllRoleMap_InvalidEP, token);
		}
		else {
			System.out.println("Request not allowed");
		}
	}
	@When("User sends {string} for PrgmBatchStatus GetAll InvalidEP")
	public void user_sends_for_prgm_batch_status_get_all_invalid_ep(String string) {
		if ("GET".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UPRBActions.getUserRoleMapAllResponse_Neg(request, "GET");
		}else {
			System.out.println("Else of GET " + string);
			System.out.println("Request not allowed");
		}
	}
	@Then("User receives {int} Not found status in PrgmBatchStatus response GetAll InvalidEP")
	public void user_receives_not_found_status_in_prgm_batch_status_response_get_all_invalid_ep(Integer int1) {
		System.out.println("Inside Then");
		UPRBTests.GetNegative404Validation(response);
	}
	//No_Auth_ GET ALL Prgm Batch Status
	//*****************
	@Given("Unauthorized User sets {string} with valid baseUrl,valid endpoint GetAll NoAuth")
	public void unauthorized_user_sets_with_valid_base_url_valid_endpoint_get_all_no_auth(String string) throws JsonProcessingException {
		LoggerLoad.info("Execution of No_Auth endpoint GET ALL PrgmBatchStatus Scenarios started");
		if ("Get_All".equals(string)) {
			this.request = UPRBActions.GetPrgmBatchStatusRequestNoAuth(Routes.adminGetAllRoleMap_Url);
		}
		else {
			System.out.println("Request not allowed");
		}
	}
	@When("User sends {string} for PrgmBatchStatus GetAll NoAuth")
	public void user_sends_for_prgm_batch_status_get_all_no_auth(String string) {
		if ("GET".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UPRBActions.getUserRoleMapAllResponse_Neg(request, "GET");
		}else {
			System.out.println("Else of GET " + string);
			System.out.println("Request not allowed");
		}
	}
	@Then("User receives {int} Unauthorized Status in PrgmBatchStatus response GetAll NoAuth")
	public void user_receives_unauthorized_status_in_prgm_batch_status_response_get_all_no_auth(Integer int1) {
		System.out.println("Inside Then");
		UPRBTests.GetUnauthorizedValidation(response);
	}
	//Delete
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





	////			 @Given("Admin creates Delete Request to delete user assigned to programs\\/batches for a user {string}")
	////			 public void admin_creates_delete_request_to_delete_user_assigned_to_programs_batches_for_a_user(String string) throws JsonProcessingException {
	////				this.request = UsersMapRoleDeleteUserIdActions.deleteRPBMUserIdRequest( string);
	////			}
	////
	////			 @When("Admin sends HTTPS Request for DeleteUsersPrgmBatch for a user {string}")
	////			 public void admin_sends_https_request_for_delete_users_prgm_batch_for_a_user(String string) {
	////				this.response = UsersMapRoleDeleteUserIdActions.deleteUserRoleMapUserIdResponse(request, string);
	////			}
	////
	////			 @Then("User should be able to get {int} in the response for DeleteUsersPrgmBatch")
	////			 public void user_should_be_able_to_get_in_the_response_for_delete_users_prgm_batch(Integer int1) {
	////				 usersRolePrgmBatchMapDeleteTests.GetUserMapRole200Validation(response);
	//			//}
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
