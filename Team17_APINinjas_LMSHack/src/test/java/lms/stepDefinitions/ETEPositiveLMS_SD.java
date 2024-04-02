package lms.stepDefinitions;

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
import lms.GlobalVariables.Env_Var;
import lms.actions.BatchActions;
import lms.actions.ProgramActions;
import lms.actions.UPRBActions;
import lms.actions.UserActions;
import lms.actions.UserLogoutActions;
import lms.endpoints.Routes;
import lms.tests.BatchTests;
import lms.tests.ProgramTests;
import lms.tests.UPRBTests;
import lms.tests.UserTests;
import lms.utilities.LoggerLoad;


public class ETEPositiveLMS_SD {

	RequestSpecification request;
	Response response;
	List<RequestSpecification> requests;
	List<Response> responses;
	String token;

	//background steps
	@Given("Admin logs in with valid Username and password")
	public void admin_logs_in_with_valid_username_and_password() throws JsonProcessingException {
		LoggerLoad.info("********Admin Enters valid Username and Passowrd for Authentication*");
		this.request = BatchActions.getLoginRequest();
	}

	@When("Admin send Post Login request")
	public void admin_send_post_login_request() {
		this.response = BatchActions.getLoginResponse(request);
	}

	@Then("Admin should be able to get {int} in the response and generate Token")
	public void admin_should_be_able_to_get_in_the_response_and_generate_token(Integer int1) {
		this.token = BatchTests.getToken(response);
	}

	//Program Module:
	//POST Program DD:
	@Given("Authorized Admin sets Post Program request with valid Url,valid endpoint, request body from excel")
	public void authorized_admin_sets_post_program_request_with_valid_url_valid_endpoint_request_body_from_excel() throws IOException {
		LoggerLoad.info("******************Execution of Post Program Scenarios started");
		this.requests = ProgramActions.getPostPutProgramRequestsDD(Routes.CreateProgram_Url, token, "post");
	}

	@When("Admin sends POST Program request.")
	public void admin_sends_post_program_request() {
		this.responses = ProgramActions.getPostProgramResponsesDD(requests);
	}

	@Then("Admin receives expected status in Post Program response")
	public void admin_receives_expected_status_in_post_program_response() {
		ProgramTests.postPutProgramValidationsDD(responses, "post");
	}

	//GET Program DD:

	@Given("Admin creates GET Request for the program API endpoint to retrieve all program details")
	public void admin_creates_get_request_for_the_program_api_endpoint_to_retrieve_all_program_details() throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Get all Programs Scenarios started");
		this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgram_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all program details")
	public void admin_sends_https_request_to_retrieve_all_program_details() {

		this.response = ProgramActions.getProgramResponse(request);

	}

	//Get Program by ProgramID:

	@Given("Admin creates GET Request for the program API endpoint to retrieve program by programID")
	public void admin_creates_get_request_for_the_program_api_endpoint_to_retrieve_program_by_program_id() throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Get by ProgramID Scenarios started");
		this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgramByProgramID_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve program with programID")
	public void admin_sends_https_request_to_retrieve_program_with_program_id() {

		this.response = ProgramActions.getGetPutDeleteProgramResponsePositive(request, "get", Env_Var.programID);

	}

	//Get Program with User Details


	@Given("Admin creates GET Request for the program API endpoint to retrieve program with User details")
	public void admin_creates_get_request_for_the_program_api_endpoint_to_retrieve_program_with_user_details() throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Get Program with User Scenarios started");
		this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgramwithUsers_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve program with Users details")
	public void admin_sends_https_request_to_retrieve_program_with_users_details() {

		this.response = ProgramActions.getProgramResponse(request);

	}

	@Then("Admin recieves {int} OK and valid response for program")
	public void admin_recieves_ok_and_valid_response_for_program(Integer int1) {

		ProgramTests.GetDeleteProgram200Validation(response);

	}

	//PUT Program by program ID DD

	@Given("Authorized admin sets Put Program request with valid Url,valid endpoint with program id, request body from excel")
	public void authorized_admin_sets_put_program_request_with_valid_url_valid_endpoint_with_program_id_request_body_from_excel() throws IOException {
		LoggerLoad.info("******************Execution of Update by Program ID Scenarios started");
		this.requests = ProgramActions.getPostPutProgramRequestsDD(Routes.PutProgramByProgID_Url, token, "put");
	}

	@When("Admin sends Put Program request with programID")
	public void admin_sends_put_program_request_with_program_id() {

		LoggerLoad.info("Program ID that is being Updated is: "+ Env_Var.programID);
		this.responses = ProgramActions.getPutIDProgramResponsesDD(requests, Env_Var.programID);

	}

	@Then("Admin receives expected status in Put Program response of particular program ID")
	public void admin_receives_expected_status_in_put_program_response_of_particular_program_id() {

		ProgramTests.postPutProgramValidationsDD(responses, "put");

	}	

	//PUT by Program Name DD

	@Given("Authorized admin sets Put Program request with valid Url,valid endpoint with program name, request body from excel")
	public void authorized_admin_sets_put_program_request_with_valid_url_valid_endpoint_with_program_name_request_body_from_excel() throws IOException {
		LoggerLoad.info("******************Execution of Update by Program Name Scenarios started");
		this.requests = ProgramActions.getPostPutProgramRequestsDD(Routes.PutProgramByProgName_Url, token, "put");
	}

	@When("Admin sends Put Program request with programName")
	public void admin_sends_put_program_request_with_program_name() {

		LoggerLoad.info("Program Name that is being Updated is: "+ Env_Var.programName);
		this.responses = ProgramActions.getPutNameProgramResponsesDD(requests, Env_Var.programName);

	}

	@Then("Admin receives expected status in Put Program response  of particular program name")
	public void admin_receives_expected_status_in_put_program_response_of_particular_program_name() {

		ProgramTests.postPutProgramValidationsDD(responses, "put");
	}

	//Delete Program by ProgramID

	@Given("Authorized admin sets Delete Program by ProgramID request with valid endpoint")
	public void authorized_admin_sets_delete_program_by_program_id_request_with_valid_endpoint() throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Delete Program by ID Scenarios started");
		this.request = ProgramActions.getGetDeleteProgramRequest(Routes.DeleteProgramByProgID_Url, true, Env_Var.token);
	}

	@When("Admin sends Delete Program request with programID")
	public void admin_sends_delete_program_request_with_program_id() {

		System.out.println("Program ID that is being deleted is: "+ Env_Var.programID);
		this.response = ProgramActions.getGetPutDeleteProgramResponsePositive(request, "delete", Env_Var.programID);
	}

	//Delete Program by ProgramName

	@Given("Authorized admin sets Delete Program by programName request with valid endpoint")
	public void authorized_admin_sets_delete_program_by_program_name_request_with_valid_endpoint() throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Delete Program by Name Scenarios started");
		this.request = ProgramActions.getGetDeleteProgramRequest(Routes.DeleteProgramByProgName_Url, true, Env_Var.token);

	}

	@When("Admin sends Delete Program request with programName")
	public void admin_sends_delete_program_request_with_program_name() {

		System.out.println("Program Name that is being Deleted is: "+ Env_Var.programName);
		this.response = ProgramActions.getGetPutDeleteProgramResponsePositive(request, "delete", Env_Var.programName);				
	}

	@Then("Admin receives expected status in Delete Program response")
	public void admin_receives_expected_status_in_delete_program_response_for_that_particular_program_name() {

		ProgramTests.GetDeleteProgram200Validation(response);

	}

	//Batch Module: 
	//Post Batch Steps	 
	@Given("Authorized Admin sets Post Batch request with valid Url,valid endpoint, request body")
	public void authorized_admin_sets_post_batch_request_with_valid_url_valid_endpoint_request_body_from_excel() throws IOException {	
		LoggerLoad.info("******************Execution of Post Batch Scenarios started");
		this.requests = BatchActions.getPostPutBatchRequestsDD(Routes.CreateBatch_Url, token, "post");
	}

	@When("Admin sends POST Batch request.")
	public void admin_sends_Post_batch_request() {
		this.responses = BatchActions.getPostBatchResponsesDD(requests);
	}

	@Then("Admin receives expected status in Post Batch response")
	public void admin_receives_expected_status_in_post_batch_response() {
		BatchTests.postPutBatchValidationsDD(responses, "post");
	}

	//Get All Batches steps	

	@Given("Authorized Admin sets the GET Batches request with or without search {string}")
	public void authorized_admin_sets_the_get_batches_request_with_or_without(String string) throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Get Batches Scenarios started");
		if("Yes".equals(string)) {
			this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchesSearch_Url, true, token);
		}else if ("No".equals(string)) {
			this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatches_Url, true, token);
		}
	}

	@When("Admin sends GET Batches request")
	public void admin_sends_get_batches_request() {
		this.response = BatchActions.getBatchResponse(request);
	}

	//Get by BatchID Positive steps:	
	@Given("Authorized Admin sets the GET by batchID request with valid baseUrl,valid endpoint ,id")
	public void authorized_admin_sets_the_get_by_batch_id_request_with_valid_base_url_valid_endpoint_id() throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Get by BatchID Scenario started");
		this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchID_ID, true, token);
	}

	@When("Admin sends GET by BatchID request")
	public void admin_sends_get_by_batch_id_request() {
		this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "get", Env_Var.batchID);
	}

	//Get by program ID positive steps:
	@Given("Authorized Admin sets the GET by programID request with valid baseUrl,valid endpoint ,id")
	public void authorized_admin_sets_the_get_by_program_id_request_with_valid_base_url_valid_endpoint_id() throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Get by ProgramID Scenario started");
		this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetProgramID_ID, true, token);
	}

	@When("Admin sends GET by programID request")
	public void admin_sends_get_by_program_id_request() {
		this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "get", Env_Var.programID);
	}

	//Get by Batch Name positive steps:	
	@Given("Authorized Admin sets the GET by batchName request with valid baseUrl,valid endpoint ,batchName")
	public void authorized_admin_sets_the_get_by_batch_name_request_with_valid_base_url_valid_endpoint_batch_name() throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Get by Batch Name Scenario started");
		this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchName_BatchName, true, token);
	}

	@When("Admin sends GET by BatchName request")
	public void admin_sends_get_by_batch_name_request() {
		this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "get", Env_Var.batchName);
	}	 

	//Put Batch Steps:	 
	@Given("Admin sets Put Batch request with valid Url, invalid endpoint and valid request body")
	public void admin_sets_put_batch_request_with_valid_url_invalid_endpoint_and_valid_request_body() throws IOException {
		LoggerLoad.info("******************Execution of Update Batch Scenario started");
		this.requests = BatchActions.getPostPutBatchRequestsDD(Routes.UpdateBatch_ID, token, "put");
	}

	@When("Admin sends PUT Batch request")
	public void admin_sends_put_batch_request() {
		LoggerLoad.info("Batch ID that is being Updated is: "+ Env_Var.batchID);
		this.responses = BatchActions.getPutBatchResponsesDD(requests, Env_Var.batchID);
	}

	@Then("Admin receives expected status in Put Batch response")
	public void admin_receives_expected_status_in_put_batch_response() {
		BatchTests.postPutBatchValidationsDD(responses, "put");
	}

	//Delete Batch Positive Steps:	 
	@Given("Authorized Admin sets Delete Batch request with valid Url,valid endpoint, batch ID")
	public void authorized_admin_sets_delete_batch_request_with_valid_url_valid_endpoint_batch_id() throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Delete Batch Scenario started");
		this.request = BatchActions.getGetDeleteBatchRequest(Routes.DeleteBatch_ID, true, token);
	}

	@When("Admin sends Delete Batch request")
	public void admin_sends_delete_batch_request() {
		LoggerLoad.info("Batch ID that is being deleted is: "+ Env_Var.batchID);
		this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "delete", Env_Var.batchID);	     
	}

	@Then("Admin receives {int} OK Status in Batch response")
	public void admin_receives_ok_status_in_delete_batch_response(Integer int1) {
		BatchTests.GetDeleteBatch200Validation(response);
	}

	//User Module:
	//Create user steps:

	@Given("Authorized User sets Post User request with valid Url,valid endpoint, request body from excel")
	public void authorized_user_sets_post_user_request_with_valid_url_valid_endpoint_request_body_from_excel() throws IOException {
		this.requests = UserActions.getPostCreateUserRequestDD(token);
	}
	@When("User sends POST User request.")
	public void user_sends_post_user_request() {
		this.responses = UserActions.getPostUserResponsesDD(requests);
		UserActions.setUserDetails(responses.get(0));
	}
	@Then("User receives expected status in Post User response")
	public void user_receives_expected_status_in_post_user_response() {
		for(Response resp:responses) {
			UserTests.PostUser201Validation(resp);
		}

	}

	//Put- update User details-UserId(Fields we are changing in request body should change in the given user id fields as well)
	@Given("Admin creates PUT Request with valid data in request body with values only in mandatory fields")
	public void admin_creates_put_request_with_valid_data_in_request_body_with_values_only_in_mandatory_fields() throws IOException {
		this.requests = UserActions.getPutUpdateUserRequestDD( token);
	}
	@When("Admin sends PUT User request")
	public void admin_sends_put_user_request() {
		this.responses = UserActions.getPutUpdateUserResponsesDD(requests);

	}
	@Then("Admin receives expected status in Put User response")
	public void admin_receives_ok_status_in_put_user_response() {
		for(Response resp:responses) {
			UserTests.PutUser200Validation(resp);
		}
	}

	//Update User login Status:
	@Given("Admin creates PUT Request with valid data in request body for LoginStatus")
	public void admin_creates_put_request_with_valid_data_in_request_body_for_login_status() throws IOException {
		this.requests = UserActions.getPutUpdateUserLoginStatusRequestDD( token);
	}
	@When("Admin sends PUT User request LoginStatus")
	public void admin_sends_put_user_request_login_status() {
		this.responses = UserActions.getPutUpdateUserLoginStatusResponsesDD(requests);
	}

	//update User RoleID steps:
	@Given("Admin sets Put User RoleID request with valid Url, invalid endpoint and valid request body")
	public void admin_sets_put_user_role_id_request_with_valid_url_invalid_endpoint_and_valid_request_body() throws IOException {
		LoggerLoad.info("******************Execution of Update User Role ID Scenario started");
		this.requests = UserActions.putUserRoleIDRequestsDD(Routes.PutUserRID_Url, token);
	}

	@When("Admin sends Put User RoleID request")
	public void admin_sends_put_user_role_id_request() {
		LoggerLoad.info("Updating role status of User with role ID: "+ Env_Var.userID);
		this.responses = UserActions.getPutUserRoleIDStatusResponse(requests, Env_Var.userID);
	}

	@Then("Admin receives {int} status in Put User RoleID response")
	public void admin_receives_status_in_put_user_role_id_response(Integer int1) {
		UserTests.Put200ValidationsDD(responses);
	}

	//update User Role status steps:
	@Given("Admin sets Put User Role status request with valid Url, invalid endpoint and valid request body")
	public void admin_sets_put_user_role_status_request_with_valid_url_invalid_endpoint_and_valid_request_body() throws IOException {
		LoggerLoad.info("******************Execution of Update User Role Status Scenario started");
		this.requests = UserActions.putUserRoleStatusRequestsDD(Routes.PutUserRStatus_Url, token);
	}

	@When("Admin sends Put User Role status request")
	public void admin_sends_put_user_role_status_request() {
		LoggerLoad.info("Updating role status of User with role ID: "+ Env_Var.userID);
		this.responses = UserActions.getPutUserRoleIDStatusResponse(requests, Env_Var.userID);
	}

	@Then("Admin receives {int} status in Put User Role status response")
	public void admin_receives_status_in_put_user_role_status_response(Integer int1) {
		UserTests.Put200ValidationsDD(responses);
	}

	//GET ROLES

	@Given("Admin creates GET Request for the UserRoles API endpoint to retrieve all UserRoles details")
	public void admin_creates_get_request_for_the_UserRoles_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {

		this.request = UserActions.getGetUserRequest(Routes.GetUserRoles_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all UserRoles details")
	public void admin_sends_https_request_to_retrieve_all_UserRoles_details() {

		this.response = UserActions.getUserResponse(request);

	}

	//GET USERS

	@Given("Admin creates GET Request for the User API endpoint to retrieve all User details")
	public void admin_creates_get_request_for_the_program_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {

		this.request = UserActions.getGetUserRequest(Routes.GetAllUsers_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all User details")
	public void admin_sends_https_request_to_retrieve_all_User_details() {

		this.response = UserActions.getUserResponse(request);

	}

	//GET Userinfo by ID

	@Given("Admin creates GET Request for the Userinfo by ID API endpoint to retrieve all User details")
	public void admin_creates_get_request_for_the_Userinfo_by_ID_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {

		this.request = UserActions.getGetUserRequest(Routes.GetUserbyID_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all Userinfo by ID details")
	public void admin_sends_https_request_to_retrieve_all_Userinfo_by_ID_details() {

		this.response = UserActions.getGetPutDeleteUserResponsePositive(request, "get", Env_Var.userID);;

	}
	//		Get Active Users	
	@Given("Admin creates GET Request for the ActiveUsers endpoint to retrieve all User details")
	public void admin_creates_get_request_for_the_ActiveUsers_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {

		this.request = UserActions.getGetUserRequest(Routes.GetUserbyActiveUser_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all ActiveUsers details")
	public void admin_sends_https_request_to_retrieve_all_ActiveUsers_details() {

		this.response = UserActions.getUserResponse(request);

	}
	//		Get count of User Status	
	@Given("Admin creates GET Request for the count users endpoint to retrieve all User details")
	public void admin_creates_get_request_for_the_count_users_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {

		this.request = UserActions.getGetUserRequest(Routes.GetUserbyStatus_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all count users details")
	public void admin_sends_https_request_to_retrieve_all_count_users_details() {

		this.response = UserActions.getUserResponse(request);

	}

	//		Get User By BatchID	
	@Given("Admin creates GET Request for the user by progbatch endpoint to retrieve all User details")
	public void admin_creates_get_request_for_the_user_by_progbatch_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {

		this.request = UserActions.getGetUserRequest(Routes.GetUserbyBatchID_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all user by progbatch details")
	public void admin_sends_https_request_to_retrieve_all_user_by_progbatch_details() {

		this.response = UserActions.getGetPutDeleteUserResponsePositive(request, "get", Env_Var.batchID);

	}
	//			
	//Get User by ProgID
	@Given("Admin creates GET Request for the userbyprog endpoint to retrieve all User details")
	public void admin_creates_get_request_for_the_userbyprog_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {

		this.request = UserActions.getGetUserRequest(Routes.GetUserbyProgID_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all userbyprog details")
	public void admin_sends_https_request_to_retrieve_all_userbyprog_details() {

		this.response = UserActions.getGetPutDeleteUserResponsePositive(request, "get", Env_Var.programID);

	}

	//Get User with role	
	@Given("Admin creates GET Request for the UserswithRole endpoint to retrieve all User details")
	public void admin_creates_get_request_for_the_UserswithRole_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {

		this.request = UserActions.getGetUserRequest(Routes.GetUserwithRoles_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all UserswithRole details")
	public void admin_sends_https_request_to_retrieve_all_UserswithRole_details() {

		this.response = UserActions.getUserResponse(request);

	}
	//Get User with Roleid	
	@Given("Admin creates GET Request for the UserswithRoleID endpoint to retrieve all User details")
	public void admin_creates_get_request_for_the_UserswithRoleID_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {

		this.request = UserActions.getGetUserRequest(Routes.GetUserbyRoleID_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all UserswithRoleID details")
	public void admin_sends_https_request_to_retrieve_all_UserswithRoleID_details() {


		this.response = UserActions.getGetPutDeleteUserResponsePositive(request, "get", "R02");

	}
	//Get User Filter/Facet
	@Given("Admin creates GET Request for the UserswithFilters endpoint to retrieve all User details")
	public void admin_creates_get_request_for_the_UserswithFilters_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {

		this.request = UserActions.getGetUserRequest(Routes.GetUserbyFilterUser_Url, true, Env_Var.token);

	}

	@When("Admin sends HTTPS Request to retrieve all UserswithFilters details")
	public void admin_sends_https_request_to_retrieve_all_UserswithFilters_details() {

		this.response = UserActions.getUserResponse(request);

	}

	@Then("Admin recieves {int} OK and valid response for User")
	public void admin_recieves_ok_and_valid_response_for_User(Integer int1) {

		UserTests.GetDeleteUser200Validation(response);

	}

	//	Get count of User Status	

	@Given("Admin sets the GET Userrequest with UserID {string}")
	public void authorized_admin_sets_the_get_user_request_with_or_without(String string) throws JsonProcessingException {
		LoggerLoad.info("******************Execution of Get User Scenarios started");
		if("all".equals(string)) {
			this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyStatus_Url, true, token);
		}else if ("R01".equals(string)) {
			this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyStatus_Url, true, token);
		}
		else if ("R02".equals(string)) {
			this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyStatus_Url, true, token);
		}
		else if ("R03".equals(string)) {
			this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyStatus_Url, true, token);
		}
	}

	//User Role Program Batch Status Module:

	//Delete User
	@Given("Authorized admin sets Delete User by UserID request with valid endpoint")
	public void authorized_admin_sets_delete_user_by_userID_request_with_valid_endpoint() throws JsonProcessingException {
		this.request = UserActions.getGetDeleteUserRequest(Routes.DeleteUserbyUserID_Url, true, token);
	}

	@When("Admin sends Delete User request with UserID")
	public void admin_sends_delete_user_request() {
		System.out.println("User ID that is being deleted is: "+ "U284");
		this.response = UserActions.getGetPutDeleteUserResponsePositive(request, "delete", "U284");	  
	}

	@Then("Admin receives {int} OK Status in delete User response")
	public void admin_receives_ok_status_in_delete_user_response(Integer int1) {
		UserTests.GetDeleteUser200Validation(response);
	}

	//Delete by User id
	@Given("Admin creates Delete Request to delete user assigned to programs\\/batches for a user")
	public void admin_creates_delete_request_to_delete_user_assigned_to_programs_batches_for_a_user() throws JsonProcessingException {
		LoggerLoad.info("Execution of Valid Delete for PrgmBatchStatus Scenarios started");
		this.request = UPRBActions.deleteRPBMUserIdRequest( );
	}
	@When("Admin sends HTTPS Request for DeleteUsersPrgmBatch for a user")
	public void admin_sends_https_request_for_delete_users_prgm_batch_for_a_user() {
		this.response = UPRBActions.deleteUserRoleMapUserIdResponse(request);
	}
	@Then("User should be able to get {int} in the response for DeleteUsersPrgmBatch")
	public void user_should_be_able_to_get_in_the_response_for_delete_users_prgm_batch(Integer int1) {
		UPRBTests.GetUserMapRole200Validation(response);
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
		UPRBTests.GetUserMapRole200Validation(response);
	}


	//Get by User id

	@Given("Admin creates GET Request to retrieve assigned to programs\\/batches for a user")
	public void admin_creates_get_request_to_retrieve_assigned_to_programs_batches_for_a_user() throws JsonProcessingException {
		LoggerLoad.info("Execution of Valid Get by UserID for PrgmBatchStatus Scenarios started");
		this.request = UPRBActions.getRPBMUserIdRequest( );
	}
	@When("Admin sends HTTPS Request for GetUsersPrgmBatchUserId for a user")
	public void admin_sends_https_request_for_get_users_prgm_batch_user_id_for_a_user() {
		this.response = UPRBActions.getUserRoleMapUserIdResponse(request);
	}
	@Then("User should be able to get {int} in the response for GetUsersPrgmBatchUserId for a user")
	public void user_should_be_able_to_get_in_the_response_for_get_users_prgm_batch_user_id_for_a_user(Integer int1) {
		UPRBTests.GetUserMapRole200Validation(response);

	}


	//Put program batch status
	@Given("Admin creates PUT Request to assign program\\/batch for a user from excelsheet")
	public void admin_creates_put_request_to_assign_program_batch_for_a_user_from_excelsheet() throws IOException {
		LoggerLoad.info("Execution of Valid PUT for PrgmBatchStatus Scenarios started");
		this.requests = UPRBActions.putRPBMUserIdRequestDD(Routes.putUserRoleMap_Url, token, "put");
	}

	@When("Admin sends HTTPS Request for PutUserProgramBatchStatusUserId for a user {string}")
	public void admin_sends_https_request_for_put_user_program_batch_status_user_id_for_a_user(String string) {
		this.responses = UPRBActions.putProgramBatchStatusResponsesDD(requests, Env_Var.userID);
	}

	@Then("User should be able to get {int} in the response for PutUserProgramBatchStatusUserId")
	public void user_should_be_able_to_get_in_the_response_for_put_user_program_batch_status_user_id(Integer int1) {
		UPRBTests.PutUserMapRole200ValidationDD(responses, "put");

	}

	//Logout
	@Given("User logs out using Logout Module")
	public void user_logs_out_using_logout_module() throws JsonProcessingException {
		this.request = UserLogoutActions.getLogoutRequest();
	}
	@When("Admin calls Get Https method with valid endpoint")
	public void admin_calls_get_https_method_with_valid_endpoint() {
		this.response = UserLogoutActions.getLogoutResponse(request);
	}
	@Then("Admin should be able to get {int} in the response for Logout Module")
	public void admin_should_be_able_to_get_in_the_response_for_logout_module(Integer int1) {
	}

	//User put program batch status
	@Given("Admin creates PUT Request with valid data in request body for RoleProgramBatchStatus")
	public void admin_creates_put_request_with_valid_data_in_request_body_for_role_program_batch_status() throws IOException {
		this.requests = UserActions.getPutUpdateUserProgramBatchStatusRequestDD( token);
	}
	@When("Admin sends PUT User request for RoleProgramBatchStatus")
	public void admin_sends_put_user_request_for_role_program_batch_status() {
		this.responses = UserActions.getPutUpdateUserProgramBatchStatusResponsesDD(requests);
	}
	
	@Given("Admin creates GET Request to retrieve assigned to programs\\/batches for a user {string}")
	public void admin_creates_get_request_to_retrieve_assigned_to_programs_batches_for_a_user(String string) throws JsonProcessingException {
		LoggerLoad.info("Execution of Valid Get by UserID for PrgmBatchStatus Scenarios started");
		this.request = UPRBActions.getRPBMUserIdRequest( );
	}

	@When("Admin sends HTTPS Request for GetUsersPrgmBatchUserId for a user {string}")
	public void admin_sends_https_request_for_get_users_prgm_batch_user_id_for_a_user(String string) {
		this.response = UPRBActions.getUserRoleMapUserIdResponse(request);
	}

	@Given("Admin creates Delete Request to delete user assigned to programs\\/batches for a user {string}")
	public void admin_creates_delete_request_to_delete_user_assigned_to_programs_batches_for_a_user(String string) throws JsonProcessingException {
		LoggerLoad.info("Execution of Valid Delete for PrgmBatchStatus Scenarios started");
		this.request = UPRBActions.deleteRPBMUserIdRequest( );
	}

	@When("Admin sends HTTPS Request for DeleteUsersPrgmBatch for a user {string}")
	public void admin_sends_https_request_for_delete_users_prgm_batch_for_a_user(String string) {
		this.response = UPRBActions.deleteUserRoleMapUserIdResponse(request);
	}
}



