package lms.stepDefinitions;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.actions.ProgramActions;
import lms.actions.UserActions;
import lms.endpoints.Routes;
import lms.tests.ProgramTests;
import lms.utilities.LoggerLoad;

public class UserNegativeDD_SD {
	
	
	RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;
	
	
	//background steps
		 @Given("Admin logs in with valid Username and password for User Module Negative")
		 public void admin_logs_in_with_valid_username_and_password_for_User_module_negative() throws JsonProcessingException {
			System.out.println("Admin Logs witn valid username and pasword") ;
			this.request = ProgramActions.getLoginRequest();
		 }

		 @When("Admin send Post Login request for User Module Negative")
		 public void admin_send_post_login_request_for_User_module_negative() {
			 this.response = ProgramActions.getLoginResponse(request);
		 }

		 @Then("Admin should be able to get {int} in the response and generate Token for User Module Negative")
		 public void admin_should_be_able_to_get_in_the_response_and_generate_token_for_User_module_negative(Integer int1) {
			 this.token = ProgramTests.getToken(response);
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
