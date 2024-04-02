package lms.stepDefinitions;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.actions.BatchActions;
import lms.actions.UserActions;
import lms.payload.ExpectedResponse;
import lms.tests.BatchTests;
import lms.tests.UserTests;

public class UserModule_SD {
RequestSpecification request;
	Response response;
	List<RequestSpecification> requests;
	List<Response> responses;
	List<ExpectedResponse>expectedResponses;
	String token;
	
	@Given("Admin logs in with valid Username and password for User Module")
	public void admin_logs_in_with_valid_username_and_password_for_user_module() throws JsonProcessingException {
		 this.request = BatchActions.getLoginRequest();
	}
	
	@When("Admin send Post Login request for User Module")
	public void admin_send_post_login_request_for_user_module() {
		this.response = BatchActions.getLoginResponse(request);
	}
	
	@Then("Admin should be able to login and generate token for User Module")
	public void admin_should_be_able_to_login_and_generate_token_for_user_module() {
		this.token = BatchTests.getToken(response);
	}
	
	@Given("Authorized User sets Post User request with valid Url,valid endpoint, request body from excel from {string}")
	public void authorized_user_sets_post_user_request_with_valid_url_valid_endpoint_request_body_from_excel_from(String sheetName) throws IOException {
		System.out.println("Sheet Name "+sheetName);
		System.out.println("Token "+token);
		this.requests = UserActions.getPostCreateUserRequestDD(token, sheetName);//slight new
		this.expectedResponses = UserActions.getExpectedResponsesDD(sheetName); //From excel sheet--new
	}
	@When("User sends POST User request NN")
	public void user_sends_post_user_request_NN() {
		this.responses = UserActions.getPostUserResponsesDD(requests); //Actual--old
	}
	@Then("User receives expected responses")
	public void user_receives_expected_responses() {
		for(int i=0; i< responses.size();i++) {
			UserTests.genericResponseValidation(responses.get(i), expectedResponses.get(i));//new
		}
	}
	
	@Given("Admin creates PUT Request with valid data in request body for LoginStatus from {string}")
	public void admin_creates_put_request_with_valid_data_in_request_body_for_login_status_from(String sheetName) throws IOException {
		this.requests = UserActions.getPutUpdateUserLoginStatusRequestDD( token, sheetName);
		this.expectedResponses = UserActions.getExpectedResponsesDD(sheetName); //From excel sheet--new
	}

	@Given("Admin creates PUT Request with valid data in request body for RoleProgramBatchStatus from {string}")
	public void admin_creates_put_request_with_valid_data_in_request_body_for_role_program_batch_status_from(String sheetName) throws IOException {
		this.requests = UserActions.getPutUpdateUserProgramBatchStatusRequestDD( token, sheetName);
		this.expectedResponses = UserActions.getExpectedResponsesDD(sheetName); //From excel sheet--new
	}
	
	@When("Admin sends PUT User request LoginStatus for User Module")
	public void admin_sends_put_user_request_login_status_for_user_module() {
		this.responses = UserActions.getPutUpdateUserLoginStatusResponsesDD(requests);
	}

	@When("Admin sends PUT User request for RoleProgramBatchStatus for User Module")
	public void admin_sends_put_user_request_for_role_program_batch_status_for_user_module() {
		this.responses = UserActions.getPutUpdateUserProgramBatchStatusResponsesDD(requests);
	}

}
	
	