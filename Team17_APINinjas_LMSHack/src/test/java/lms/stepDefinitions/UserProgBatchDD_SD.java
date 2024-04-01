package lms.stepDefinitions;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.actions.ProgramActions;
import lms.tests.ProgramTests;

public class UserProgBatchDD_SD {
	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;
	 
	 //LoginDD
	 @Given("Admin logs in with valid Username and password for UserProgBatch")
		public void admin_logs_in_with_valid_username_and_password_for_UserProgBatch() throws JsonProcessingException {
		 
		 this.request = ProgramActions.getLoginRequest();
	 }
	 
	 @When("Admin send Post Login request for User for UserProgBatch")
		public void admin_send_post_login_request_for_UserProgBatch() {
		
			this.response = ProgramActions.getLoginResponse(request);
		   
		}
	
		@Then("Admin should be able to get {int} in the response and generate Token for UserProgBatch")
		public void admin_should_be_able_to_get_in_the_response_and_generate_token_for_UserProgBatch(Integer int1) {
		 
			this.token = ProgramTests.getToken(response);
		}
	//PUT
		
		@Given("Admin creates PUT Request to assign programbatch for a user from excelsheet")
		public void admin_creates_put_request_to_assign_programbatch_for_a_user_from_excelsheet() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@When("Admin sends HTTPS Request for PutUserProgramBatchStatusUserId for a user")
		public void admin_sends_https_request_for_put_user_program_batch_status_user_id_for_a_user() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

		@Then("User should be able to get {int} in the response for PutUserProgramBatchStatusUserId")
		public void user_should_be_able_to_get_in_the_response_for_put_user_program_batch_status_user_id(Integer int1) {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}

}
