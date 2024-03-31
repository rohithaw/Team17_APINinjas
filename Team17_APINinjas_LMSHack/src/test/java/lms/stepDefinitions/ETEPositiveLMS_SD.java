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
import lms.endpoints.Routes;
import lms.tests.BatchTests;
import lms.tests.ProgramTests;
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

}


