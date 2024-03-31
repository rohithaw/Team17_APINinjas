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
import lms.utilities.LoggerLoad;


public class BatchDDNegModule_SD {
	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;
//	 String token = Env_Var.token;
	 
//background steps
	 @Given("Admin logs in with valid Username and password for Batch Module Negative")
	 public void admin_logs_in_with_valid_username_and_password_for_batch_module_negative() throws JsonProcessingException {
		 this.request = BatchActions.getLoginRequest();
	 }

	 @When("Admin send Post Login request for Batch Module Negative")
	 public void admin_send_post_login_request_for_batch_module_negative() {
		 this.response = BatchActions.getLoginResponse(request);
	 }

	 @Then("Admin should be able to get {int} in the response and generate Token for Batch Module Negative")
	 public void admin_should_be_able_to_get_in_the_response_and_generate_token_for_batch_module_negative(Integer int1) {
		 this.token = BatchTests.getToken(response);
	 }
	 
//Post Batch Negative Steps: 
	 
	 @Given("Authorized Admin sets Post Batch request with valid Url,valid endpoint, invalid request body")
	 public void authorized_admin_sets_post_batch_request_with_valid_url_valid_endpoint_invalid_request_body() throws IOException {
		 LoggerLoad.info("Execution of Post Batch Scenarios started");
		 this.requests = BatchActions.getPostBatchRequestsDDNegative(Routes.CreateBatch_Url, token);
	 }

	 @When("Admin sends POST Batch request for Negative scenarios")
	 public void admin_sends_post_batch_request_for_negative_scenarios() {
		 this.responses = BatchActions.getPostBatchResponsesDD(requests);
	 }

	 @Then("Admin receives expected status in Post batch Negative response")
	 public void admin_receives_expected_status_in_post_batch_negative_response() {
		 BatchTests.postPutBatchValidationsDD(responses, "post");
	 }
	
//Get by BatchID Negative steps:

	@When("Admin sends GET by BatchID request for Negative scenarios")
	public void admin_sends_get_by_batch_id_request_for_negative_scenarios() throws IOException {
		LoggerLoad.info("Execution of Get by BatchID Scenarios started"); 
		this.responses = BatchActions.getGetBatchResponsesDD( "batchid", token, Routes.GetBatchID_ID );
	}
	
//Get by program ID Negative steps:
	
	@When("Admin sends GET by programID request for Negative scenarios")
	public void admin_sends_get_by_program_id_request_for_negative_scenarios() throws IOException {
		LoggerLoad.info("Execution of Get by programID Scenarios started");
		this.responses = BatchActions.getGetBatchResponsesDD("programid", token, Routes.GetProgramID_ID );
	}
	
	@Then("Admin receives expected Status in get programID response")
	 public void admin_receives_expected_status_in_get_programID_response() {
		 BatchTests.getDeleteBatchValidationsDD(responses, "programid");
	 }		 
		
//Get by Batch Name Negative steps:	
	
	 @When("Admin sends GET by BatchName request for Negative scenarios")
	 public void admin_sends_get_by_batch_name_request_for_negative_scenarios() throws IOException {
		 LoggerLoad.info("Execution of Get by Batch Name Scenarios started");
		 this.responses = BatchActions.getGetBatchResponsesDD("batchname", token, Routes.GetBatchName_BatchName );
	 }

	 @Then("Admin receives expected Status in get BatchName response")
	 public void admin_receives_expected_status_in_get_batch_name_response() {
		 BatchTests.getDeleteBatchValidationsDD(responses, "batchname");
	 }
	 
//Put Batch Negative Steps: 
	 
	 @Given("Admin sets Put Batch request with valid Url, invalid endpoint and invalid request body")
	 public void admin_sets_put_batch_request_with_valid_url_invalid_endpoint_and_invalid_request_body() throws IOException {
		 LoggerLoad.info("Execution of Update Batch Scenarios started");
		 this.requests = BatchActions.getPutBatchRequestsDDNegative(Routes.UpdateBatch_ID, token);
	 }

	 @When("Admin sends PUT Batch request for Negative scenarios")
	 public void admin_sends_put_batch_request_for_negative_scenarios() {
		 System.out.println("Batch ID that is being Updated is: "+ Env_Var.batchID);
		 this.responses = BatchActions.getPutBatchResponsesNegativeDD(requests, Env_Var.batchID);
	 }

	 @Then("Admin receives expected status in Put batch Negative response")
	 public void admin_receives_expected_status_in_put_batch_negative_response() {
		 BatchTests.postPutBatchValidationsDD(responses, "put");
	 }
	 
//Delete Batch Negative Steps:
	 @When("Admin sends Delete Batch request for Negative scenarios")
	 public void admin_sends_delete_batch_request_for_negative_scenarios() throws IOException {
		 LoggerLoad.info("Execution of Delete Batch Scenarios started");
		 this.responses = BatchActions.getDeleteBatchResponsesDD(token, Routes.DeleteBatch_ID);
	 }

	 @Then("Admin receives expected Status in BatchID response")
	 public void admin_receives_expected_status_in_batch_ID_response() {
		 BatchTests.getDeleteBatchValidationsDD(responses, "batchid");
	 }
	 
//Invalid Url All Batch Module:
	 @Given("User sets {string} with invalid Url, valid endpoint and valid request body")
	 public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body(String string) throws JsonProcessingException {
		 LoggerLoad.info("Execution of Invalid Url Batch Scenarios started");
		 if("Create".equals(string)) {
			 this.request = BatchActions.getPostBatchRequest(Routes.CreateBatch_InvalidUrl, token);
			}else if ("Get_All".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatches_InvalidUrl, true, token);
			}else if ("Get_By_BatchId".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchID_InvalidUrl, true, token);
			}else if ("Get_By_ProgramId".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetProgramID_InvalidUrl, true, token);
			}else if ("Get_By_BatchName".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchName_InvalidUrl, true, token);
			}else if ("Update".equals(string)) {
				this.request = BatchActions.getPutBatchRequest(Routes.UpdateBatch_InvalidUrl, token);
			}else {
				this.request = BatchActions.getGetDeleteBatchRequest(Routes.DeleteBatch_InvalidUrl, true, token);
			}
	 }

	 @When("User sends {string} Batch")
	 public void user_sends_batch(String string) {
		 if("POST".equals(string)) {
			 this.response = BatchActions.BatchResponseInvalidUrl(request, "post");
			}else if ("GET".equals(string)) {
				this.response = BatchActions.BatchResponseInvalidUrl(request, "get");
			}else if ("PUT".equals(string)) {
				this.response = BatchActions.BatchResponseInvalidUrl(request, "put");
			}else {
				this.response = BatchActions.BatchResponseInvalidUrl(request, "delete");
			}
	 }

	 @Then("User receives {int} Not found status in Batch response")
	 public void user_receives_not_found_status_in_batch_response(Integer int1) {
		 BatchTests.GetNegative404Validation(response);
	 }

//Invalid End Point All Batch Module:
	 @Given("User sets {string} with valid Url, invalid endpoint and valid request body.")
	 public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body(String string) throws JsonProcessingException {
		 LoggerLoad.info("Execution of Invalid Endpoint Batch Scenarios started");
		 if("Create".equals(string)) {
			 this.request = BatchActions.getPostBatchRequest(Routes.CreateBatch_InvalidEP, token);
			}else if ("Get_All".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatches_InvalidEP, true, token);
			}else if ("Get_By_BatchId".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchID_InvalidEP, true, token);
			}else if ("Get_By_ProgramId".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetProgramID_InvalidEP, true, token);
			}else if ("Get_By_BatchName".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequest(Routes.GetBatchName_InvalidEP, true, token);
			}else if ("Update".equals(string)) {
				this.request = BatchActions.getPutBatchRequest(Routes.UpdateBatch_InvalidEP, token);
			}else {
				this.request = BatchActions.getGetDeleteBatchRequest(Routes.DeleteBatch_InvalidEP, true, token);
			}
	 }

//No Auth All Batch Module:
	 @Given("Unauthorized User sets {string} with valid baseUrl,valid endpoint")
	 public void unauthorized_user_sets_with_valid_base_url_valid_endpoint(String string) throws JsonProcessingException {
		 LoggerLoad.info("Execution of No Auth Batch Scenarios started");
		 if("Create".equals(string)) {
			 this.request = BatchActions.getPostPutBatchRequestNoAuth(Routes.CreateBatch_Url);
			}else if ("Get_All".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequestNoAuth(Routes.GetBatches_Url);
			}else if ("Get_By_BatchId".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequestNoAuth(Routes.GetBatchID_ID);
			}else if ("Get_By_ProgramId".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequestNoAuth(Routes.GetProgramID_ID);
			}else if ("Get_By_BatchName".equals(string)) {
				this.request = BatchActions.getGetDeleteBatchRequestNoAuth(Routes.GetBatchName_BatchName);
			}else if ("Update".equals(string)) {
				this.request = BatchActions.getPostPutBatchRequestNoAuth(Routes.UpdateBatch_ID);
			}else {
				this.request = BatchActions.getGetDeleteBatchRequestNoAuth(Routes.DeleteBatch_ID);
			}
	 }

	 @Then("User receives {int} Unauthorized Status in Batch response")
	 public void user_receives_unauthorized_status_in_batch_response(Integer int1) {
		 BatchTests.GetUnauthorizedValidation(response);
	 }
	
}
