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
import lms.actions.ProgramActions;
import lms.actions.UserActions;
import lms.endpoints.Routes;
import lms.payload.ExpectedResponse;
import lms.tests.BatchTests;
import lms.tests.ProgramTests;
import lms.tests.UserTests;
import lms.utilities.LoggerLoad;

public class UserModuleNegativeDD_SD {
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
	
	@Given("Admin creates PUT Request with valid data in request body from {string}")
	public void admin_creates_put_request_with_valid_data_in_request_body_from(String sheetName) throws IOException {
		this.requests = UserActions.getPutUpdateUserRequestDD( token,sheetName);
		this.expectedResponses = UserActions.getExpectedResponsesDD(sheetName); //From excel sheet--new
	}

	@When("Admin sends PUT User request for Admin details update in User Module")
	public void admin_sends_put_user_request_for_admin_details_update_in_user_module() {
		this.responses = UserActions.getPutUpdateUserResponsesDD(requests);
	}

	//No Auth All User Module:
		 @Given("Unauthorized User sets {string} with valid baseUrl,valid endpoint for User")
		 public void unauthorized_user_sets_with_valid_base_url_valid_endpoint_for_User(String string) throws JsonProcessingException {
			 LoggerLoad.info("Execution of No Auth User Scenarios started");
			 if("Get_All_roles".equals(string)) {
				 this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserRoles_Url);
				}else if ("Get_All_users".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetAllUsers_Url);
				}else if ("Get_Userinfo_By_ID".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyID_Url);
				}else if ("Get_Active_Users".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyActiveUser_Url);
				}else if ("Get_Count_Users".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyStatus_Url);
				}else if ("Get_Users_ProgBatch".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyBatchID_Url);
				}else if ("Get_Users_Prog".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyProgID_Url);
				}else if ("Get_UserswithRole".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserwithRoles_Url);
				}else if ("Get_UserswithRoleID".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyRoleID_Url);
				}else if ("Get_UserswithFilters".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyFilterUser_Url);
				}else {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.DeleteUserbyUserID_Url);
				}
		 }
		
		 @When("User sends {string} User")
		 public void user_sends_user(String string) {
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
		 @Then("User receives {int} Unauthorized Status in User response")
		 public void user_receives_unauthorized_status_in_user_response(Integer int1) {
			 ProgramTests.GetUnauthorizedValidation(response);
		 }
		
		//Invalid End Point All Batch Module:
		 @Given("User sets {string} with valid Url, invalid endpoint and valid request body for User")
		 public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body_for_user(String string) throws JsonProcessingException {
			 LoggerLoad.info("Execution of No Auth User Scenarios started");
			 if("Get_All_roles".equals(string)) {
				 this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserRoles_InvalidEP, true, token);
				}else if ("Get_All_users".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequest(Routes.GetAllUsers_InvalidEP, true, token);
				}else if ("Get_Userinfo_By_ID".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyID_InvalidEP, true, token);
				}else if ("Get_Active_Users".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyActiveUse_InvalidEP, true, token);
				}else if ("Get_Count_Users".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyStatus_InvalidEP, true, token);
				}else if ("Get_Users_ProgBatch".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyProgID_InvalidEP, true, token);
				}else if ("Get_Users_Prog".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyBatchID_InvalidEP, true, token);
				}else if ("Get_UserswithRole".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserwithRoles_InvalidEP, true, token);
				}else if ("Get_UserswithRoleID".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyRoleID_InvalidEP, true, token);
				}else if ("Get_UserswithFilters".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequest(Routes.GetUserbyFilterUser_InvalidEP, true, token);
				}else {
					this.request = UserActions.getGetDeleteUserRequest(Routes.DeleteUserbyUserID_InvalidEP, true, token);
				}
		 }
		
		 @Then("User receives {int} Not found status in User response")
		 public void user_receives_not_found_status_in_user_response(Integer int1) {
			 ProgramTests.GetNegative404Validation(response);
		 }
		
		//Invalid Url All Batch Module:
		 @Given("User sets {string} with invalid Url, valid endpoint and valid request body for User")
		 public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body_for_user(String string) throws JsonProcessingException {
			 LoggerLoad.info("Execution of No Auth User Scenarios started");
			 if("Get_All_roles".equals(string)) {
				 this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserRoles_InvalidUrl);
				}else if ("Get_All_users".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetAllUsers_InvalidUrl);
				}else if ("Get_Userinfo_By_ID".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyID_InvalidUrl);
				}else if ("Get_Active_Users".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyActiveUse_InvalidUrl);
				}else if ("Get_Count_Users".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyStatus_InvalidUrl);
				}else if ("Get_Users_ProgBatch".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyBatchID_InvalidUrl);
				}else if ("Get_Users_Prog".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyProgID_InvalidUrl);
				}else if ("Get_UserswithRole".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserRoles_InvalidUrl);
				}else if ("Get_UserswithRoleID".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyRoleID_InvalidUrl);
				}else if ("Get_UserswithFilters".equals(string)) {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.GetUserbyFilterUser_InvalidUrl);
				}else {
					this.request = UserActions.getGetDeleteUserRequestNoAuth(Routes.DeleteUserbyUserID_InvalidUrl);
				}
		 }
	
}
	
	