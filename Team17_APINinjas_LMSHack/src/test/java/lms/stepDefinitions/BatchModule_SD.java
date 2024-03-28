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
import lms.endpoints.Routes;
import lms.tests.BatchTests;


public class BatchModule_SD {
	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;
//	 String batchID;
	 String programID;
	 String batchName;
	 
	 @Given("User logs in with valid Username and password for Batch Module")
	 public void user_logs_in_with_valid_username_and_password_for_batch_module() throws JsonProcessingException {
		 this.request = BatchActions.getLoginRequest();
	 }

	 @When("User send Post Login request for Batch Module")
	 public void user_send_post_login_request_for_batch_module() {
		 this.response = BatchActions.getLoginResponse(request);
	 }

	 @Then("User should be able to get {int} in the response and generate Token for Batch Module")
	 public void user_should_be_able_to_get_in_the_response_and_generate_token_for_batch_module(Integer int1) {
		 this.token = BatchTests.getToken(response);
	 }
	 
	@Given("Authorized User sets Post Batch request with valid Url,valid endpoint, request body from excel")
	public void authorized_user_sets_post_batch_request_with_valid_url_valid_endpoint_request_body_from_excel() throws IOException {	
		this.request = BatchActions.getPostBatchRequest(Routes.CreateBatch_Url, token);
	}
	
	@When("User sends POST Batch request.")
	public void user_sends_Post_batch_request() {
		this.response = BatchActions.getPostBatchResponse(request);
		BatchActions.setBatchDetails(response);
		BatchActions.setBatchDetails(response);
		BatchActions.setBatchDetails(response);
	}

	@Then("User receives expected status in Post Batch response")
	public void user_receives_expected_status_in_post_batch_response() {
		 BatchTests.PostBatch201Validation(response);
	}
	
	@Given("Authorized User sets the GET Batches request with valid baseUrl,valid endpoint")
	public void authorized_user_sets_the_get_batches_request_with_valid_base_url_valid_endpoint() throws JsonProcessingException {
	    this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatches_Url, true, token);
	}

	@When("User sends GET Batches request")
	public void user_sends_get_batches_request() {
	    this.response = BatchActions.getAllBatchResponse(request);
	}

	@Then("User receives {int} OK Status and valid response in GET all Batches response body")
	public void user_receives_ok_status_and_valid_response_in_get_all_batches_response_body(Integer int1) {
		BatchTests.GetBatch200Validation(response);
	}
	
	@Given("Authorized User sets the GET by batchID request with valid baseUrl,valid endpoint ,valid id")
	public void authorized_user_sets_the_get_by_batch_id_request_with_valid_base_url_valid_endpoint_valid_id() throws JsonProcessingException {
		this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchID_ID, true, token);
	}

	@When("User sends GET by BatchID request")
	public void user_sends_get_by_batch_id_request() {
		String batchID = Env_Var.batchID;
		System.out.println("Batvch ID from env.variable is: "+ batchID);
		this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "get", batchID);
	}

	@Then("User receives {int} OK Status and valid response in GET by batchID response body")
	public void user_receives_ok_status_and_valid_response_in_get_by_batch_id_response_body(Integer int1) {
		BatchTests.GetBatch200Validation(response);
	}
//
//	@Given("Authorized User sets the GET by programID request with valid baseUrl,valid endpoint ,valid id")
//	public void authorized_user_sets_the_get_by_program_id_request_with_valid_base_url_valid_endpoint_valid_id() throws JsonProcessingException {
//		this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetProgramID_ID, true, token);
//	}
//
//	@When("User sends GET by programID request")
//	public void user_sends_get_by_program_id_request() {
//		System.out.println("Program ID in When stepdef is: "+ programID);
//		this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "get", programID);
//	}
//
//	@Then("User receives {int} OK Status and valid response in GET by programID response body")
//	public void user_receives_ok_status_and_valid_response_in_get_by_program_id_response_body(Integer int1) {
//		BatchTests.GetBatch200Validation(response);
//	}
//	
//	@Given("Authorized User sets the GET by batchName request with valid baseUrl,valid endpoint ,valid batchName")
//	 public void authorized_user_sets_the_get_by_batch_name_request_with_valid_base_url_valid_endpoint_valid_batch_name() throws JsonProcessingException {
//		this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchName_BatchName, true, token);
//	 }
//
//	 @When("User sends GET by BatchName request")
//	 public void user_sends_get_by_batch_name_request() {
//		 System.out.println("Batch Name in When stepdef is: "+ batchName);
//		 this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "get", batchName);
//	 }
//
//	 @Then("User receives {int} OK Status and valid response in GET by batchName response body")
//	 public void user_receives_ok_status_and_valid_response_in_get_by_batch_name_response_body(Integer int1) {
//		 BatchTests.GetBatch200Validation(response);
//	 }
	
}
