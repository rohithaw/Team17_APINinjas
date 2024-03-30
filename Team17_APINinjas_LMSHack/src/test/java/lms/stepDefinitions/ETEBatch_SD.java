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


public class ETEBatch_SD {
	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;
	 
//background steps
	 @Given("Admin logs in with valid Username and password for Batch Module")
	 public void admin_logs_in_with_valid_username_and_password_for_batch_module() throws JsonProcessingException {
		 this.request = BatchActions.getLoginRequest();
	 }

	 @When("Admin send Post Login request for Batch Module")
	 public void admin_send_post_login_request_for_batch_module() {
		 this.response = BatchActions.getLoginResponse(request);
	 }

	 @Then("Admin should be able to get {int} in the response and generate Token for Batch Module")
	 public void admin_should_be_able_to_get_in_the_response_and_generate_token_for_batch_module(Integer int1) {
		 this.token = BatchTests.getToken(response);
	 }
	 
//Post Batch Steps	 
	@Given("Authorized Admin sets Post Batch request with valid Url,valid endpoint, request body")
	public void authorized_admin_sets_post_batch_request_with_valid_url_valid_endpoint_request_body_from_excel() throws IOException {	
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
		this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchID_ID, true, token);
	}

	@When("Admin sends GET by BatchID request")
	public void admin_sends_get_by_batch_id_request() {
		this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "get", Env_Var.batchID);
	}

//Get by program ID positive steps:
	@Given("Authorized Admin sets the GET by programID request with valid baseUrl,valid endpoint ,id")
	public void authorized_admin_sets_the_get_by_program_id_request_with_valid_base_url_valid_endpoint_id() throws JsonProcessingException {
		this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetProgramID_ID, true, token);
	}

	@When("Admin sends GET by programID request")
	public void admin_sends_get_by_program_id_request() {
		this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "get", Env_Var.programID);
	}
		
//Get by Batch Name positive steps:	
	@Given("Authorized Admin sets the GET by batchName request with valid baseUrl,valid endpoint ,batchName")
	 public void authorized_admin_sets_the_get_by_batch_name_request_with_valid_base_url_valid_endpoint_batch_name() throws JsonProcessingException {
		this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchName_BatchName, true, token);
	 }

	 @When("Admin sends GET by BatchName request")
	 public void admin_sends_get_by_batch_name_request() {
		 this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "get", Env_Var.batchName);
	 }	 
		
//Put Batch Steps:	 
	 @Given("Admin sets Put Batch request with valid Url, invalid endpoint and valid request body")
	 public void admin_sets_put_batch_request_with_valid_url_invalid_endpoint_and_valid_request_body() throws IOException {
		 this.requests = BatchActions.getPostPutBatchRequestsDD(Routes.UpdateBatch_ID, token, "put");
	 }

	 @When("Admin sends PUT Batch request")
	 public void admin_sends_put_batch_request() {
		 System.out.println("Batch ID that is being Updated is: "+ Env_Var.batchID);
		 this.responses = BatchActions.getPutBatchResponsesDD(requests, Env_Var.batchID);
	 }

	 @Then("Admin receives expected status in Put Batch response")
	 public void admin_receives_expected_status_in_put_batch_response() {
		 BatchTests.postPutBatchValidationsDD(responses, "put");
	 }
	 
//Delete Batch Positive Steps:	 
	 @Given("Authorized Admin sets Delete Batch request with valid Url,valid endpoint, batch ID")
	 public void authorized_admin_sets_delete_batch_request_with_valid_url_valid_endpoint_batch_id() throws JsonProcessingException {
		 this.request = BatchActions.getGetDeleteBatchRequest(Routes.DeleteBatch_ID, true, token);
	 }

	 @When("Admin sends Delete Batch request")
	 public void admin_sends_delete_batch_request() {
		 System.out.println("Batch ID that is being deleted is: "+ Env_Var.batchID);
		 this.response = BatchActions.getGetPutDeleteBatchResponsePositive(request, "delete", Env_Var.batchID);	     
	 }

	 @Then("Admin receives {int} OK Status in Batch response")
	 public void admin_receives_ok_status_in_delete_batch_response(Integer int1) {
		 BatchTests.GetDeleteBatch200Validation(response);
	 }
	
}


