package lms.stepDefinitions;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.actions.ProgramActions;
import lms.endpoints.Routes;
import lms.globalVariables.Env_Var;
import lms.tests.ProgramTests;
import lms.utilities.LoggerLoad;

public class ProgramNegativeDD_SD {
	
	RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;
	 String programID="16727";
//	 String token = Env_Var.token;
	 
//background steps
	 @Given("Admin logs in with valid Username and password for Program Module Negative")
	 public void admin_logs_in_with_valid_username_and_password_for_batch_module_negative() throws JsonProcessingException {
		 this.request = ProgramActions.getLoginRequest();
	 }

	 @When("Admin send Post Login request for Program Module Negative")
	 public void admin_send_post_login_request_for_batch_module_negative() {
		 this.response = ProgramActions.getLoginResponse(request);
	 }

	 @Then("Admin should be able to get {int} in the response and generate Token for Program Module Negative")
	 public void admin_should_be_able_to_get_in_the_response_and_generate_token_for_batch_module_negative(Integer int1) {
		 this.token = ProgramTests.getToken(response);
	 }
	 
	 
	//Post Batch Negative Steps: 
	 
		 @Given("Authorized Admin sets Post Program request with valid Url,valid endpoint, invalid request body")
		 public void authorized_admin_sets_post_Program_request_with_valid_url_valid_endpoint_invalid_request_body() throws IOException {
			 this.requests = ProgramActions.getPostProgramRequestsDDNegative(Routes.CreateProgram_Url, token);
		 }

		 @When("Admin sends POST Program request for Negative scenarios")
		 public void admin_sends_post_batch_request_for_negative_scenarios() {
			 this.responses = ProgramActions.getPostProgramResponsesDD(requests);
		 }

		 @Then("Admin receives expected status in Post Program Negative response")
		 public void admin_receives_expected_status_in_post_Program_negative_response() {
			 ProgramTests.postPutProgramValidationsDD(responses, "post");
		 }
	 
	 @When("Admin sends GET by ProgramID request for Negative scenarios")
		public void admin_sends_get_by_batch_id_request_for_negative_scenarios() throws IOException {
			 this.responses = ProgramActions.getGetProgramResponsesDD( "programId", token, Routes.GetProgramByProgramID_Url );
		}
	 
	 @Then("Admin receives expected Status in ProgramID response")
	 public void admin_receives_expected_status_in_batch_ID_response() {
		 ProgramTests.getDeleteProgramValidationsDD(responses, "programId");
	 }
	 
		 
		//Put Batch Negative Steps: 
		 
		 @Given("Admin sets Put Program request with valid Url, invalid endpoint and invalid request body")
		 public void admin_sets_put_Program_request_with_valid_url_invalid_endpoint_and_invalid_request_body() throws IOException {
			 LoggerLoad.info("Execution of Update Program Scenarios started");
			 this.requests = ProgramActions.getPutProgramRequestsDDNegative(Routes.PutNegProgramByProgID_Url, token);
		 }

		 @When("Admin sends PUT Program request for Negative scenarios")
		 public void admin_sends_put_Program_request_for_negative_scenarios() {
//			 System.out.println("Program ID that is being Updated is: "+ "programID");
//			 this.responses = ProgramActions.getPutIDProgramResponsesDD(requests,programID);
			 this.responses = ProgramActions.getPostProgramResponsesDD(requests);
		 }

		 @Then("Admin receives expected status in Put Program Negative response")
		 public void admin_receives_expected_status_in_put_batch_negative_response() {
			 ProgramTests.postPutProgramValidationsDD(responses, "put");
		 }
		 
		//Delete Batch Negative Steps:
		 @When("Admin sends Delete Program request for Negative scenarios")
		 public void admin_sends_delete_program_request_for_negative_scenarios() throws IOException {
			 LoggerLoad.info("Execution of Delete Batch Scenarios started");
			 this.responses = ProgramActions.getDeleteProgramResponsesDD(token, Routes.DeleteProgramByProgID_Url);
		 }

		 @Then("Admin receives expected Status in ProgramID delete response")
		 public void admin_receives_expected_status_in_program_ID_delete_response() {
			 ProgramTests.getDeleteProgramValidationsDD(responses, "programid");
		 }
		 
		 
		//Invalid Url All Batch Module:
		 @Given("User sets {string} with invalid Url, valid endpoint and valid request body for Program")
		 public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body(String string) throws JsonProcessingException {
			 LoggerLoad.info("Execution of Invalid Url Program Scenarios started");
			 if("Create".equals(string)) {
				 this.request = ProgramActions.getPostProgramRequest(Routes.CreateProgram_InvalidUrl, token);
				}else if ("Get_All".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgram_InvalidUrl, true, token);
				}else if ("Get_By_ProgramId".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgramByProgramID_InvalidUrl, true, token);
				}else if ("Get_Program_Users ".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgramwithUsers_InvalidUrl, true, token);
				}else if ("Update_By_progID".equals(string)) {
					this.request = ProgramActions.getPutProgramRequest(Routes.PutProgramByProgID_InvalidUrl, token);
				}else if ("Update_By_progName".equals(string)) {
					this.request = ProgramActions.getPutProgramRequest(Routes.PutProgramByProgName_InvalidUrl, token);
				}else if ("Delete_By_ProgID".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequest(Routes.DeleteProgramByProgID_InvalidUrl,true, token);
				}else {
					this.request = ProgramActions.getGetDeleteProgramRequest(Routes.DeleteProgramByProgName_InvalidUrl, true, token);
				}
		 }

		 @When("User sends {string} Program")
		 public void user_sends_Program(String string) {
			 if("POST".equals(string)) {
				 this.response = ProgramActions.ProgramResponseInvalidUrl(request, "post");
				}else if ("GET".equals(string)) {
					this.response = ProgramActions.ProgramResponseInvalidUrl(request, "get");
				}else if ("PUT".equals(string)) {
					this.response = ProgramActions.ProgramResponseInvalidUrl(request, "put");
				}else {
					this.response = ProgramActions.ProgramResponseInvalidUrl(request, "delete");
				}
		 }

		 @Then("User receives {int} Not found status in Program response")
		 public void user_receives_not_found_status_in_batch_response(Integer int1) {
			 ProgramTests.GetNegative404Validation(response);
		 }
		 
		 
		//Invalid End Point All Batch Module:
		 @Given("User sets {string} with valid Url, invalid endpoint and valid request body for Program")
		 public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body_for_program(String string) throws JsonProcessingException {
			 LoggerLoad.info("Execution of Invalid Endpoint Batch Scenarios started");
			 if("Create".equals(string)) {
				 this.request = ProgramActions.getPostProgramRequest(Routes.CreateProgram_InvalidERP, token);
				}else if ("Get_All".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgram_InvalidEP, true, token);
				}else if ("Get_By_ProgramId".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgramByProgramID_InvalidEP, true, token);
				}else if ("Get_Program_Users".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgramwithUsers_InvalidEP, true, token);
				}else if ("Update_By_progID".equals(string)) {
					this.request = ProgramActions.getPutProgramRequest(Routes.PutProgramByProgID_InvalidEP, token);
				}else if ("Update_By_progName".equals(string)) {
					this.request = ProgramActions.getPutProgramRequest(Routes.PutProgramByProgName_InvalidEP, token);
				}else if ("Delete_By_ProgID".equals(string)) {
						this.request = ProgramActions.getGetDeleteProgramRequest(Routes.DeleteProgramByProgID_InvalidEP,true, token);
				}else {
					this.request = ProgramActions.getGetDeleteProgramRequest(Routes.DeleteProgramByProgName_InvalidEP, true, token);
				}
		 }
		 
		//No Auth All Batch Module:
		 @Given("Unauthorized User sets {string} with valid baseUrl,valid endpoint for Program")
		 public void unauthorized_user_sets_with_valid_base_url_valid_endpoint_for_Program(String string) throws JsonProcessingException {
			 LoggerLoad.info("Execution of No Auth Batch Scenarios started");
			 if("Create".equals(string)) {
				 this.request = ProgramActions.getPostPutProgramRequestNoAuth(Routes.CreateProgram_Url);
				}else if ("Get_All".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequestNoAuth(Routes.GetProgram_Url);
				}else if ("Get_By_ProgramId".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequestNoAuth(Routes.GetProgramByProgramID_Url);
				}else if ("Get_Program_Users".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequestNoAuth(Routes.GetProgramwithUsers_Url);
				}else if ("Update_By_progID".equals(string)) {
					this.request = ProgramActions.getPostPutProgramRequestNoAuth(Routes.PutProgramByProgID_Url);
				}else if ("Update_By_progName".equals(string)) {
					this.request = ProgramActions.getPostPutProgramRequestNoAuth(Routes.PutProgramByProgName_Url);
				}else if ("Delete_By_ProgID".equals(string)) {
					this.request = ProgramActions.getGetDeleteProgramRequestNoAuth(Routes.DeleteProgramByProgID_Url);
				}else {
					this.request = ProgramActions.getGetDeleteProgramRequestNoAuth(Routes.DeleteProgramByProgName_Url);
				}
		 }

		 @Then("User receives {int} Unauthorized Status in Program response")
		 public void user_receives_unauthorized_status_in_program_response(Integer int1) {
			 ProgramTests.GetUnauthorizedValidation(response);
		 }
		


}
