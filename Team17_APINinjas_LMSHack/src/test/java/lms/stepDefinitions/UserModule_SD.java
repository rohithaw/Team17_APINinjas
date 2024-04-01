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
import lms.globalVariables.Env_Var;
import lms.tests.ProgramTests;
import lms.tests.UserTests;
import lms.utilities.LoggerLoad;

public class UserModule_SD {
	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;
	String UserID="U284";
	String batchID="8636";
	String programID="16448";
	String RoleID="R02";
	
	
	 //LoginDD
	 @Given("Admin logs in with valid Username and password for User")
		public void admin_logs_in_with_valid_username_and_password_for_User() throws JsonProcessingException {
		 
		 this.request = ProgramActions.getLoginRequest();
	 }
	 
	 @When("Admin send Post Login request for User")
		public void admin_send_post_login_request_for_User() {
		
			this.response = ProgramActions.getLoginResponse(request);
		   
		}
	
		@Then("Admin should be able to get {int} in the response and generate Token for User")
		public void admin_should_be_able_to_get_in_the_response_and_generate_token_for_User(Integer int1) {
		 
			this.token = ProgramTests.getToken(response);
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
			
			 this.response = UserActions.getGetPutDeleteUserResponsePositive(request, "get", UserID);;
		   
		}
//	Get Active Users	
		@Given("Admin creates GET Request for the ActiveUsers endpoint to retrieve all User details")
		public void admin_creates_get_request_for_the_ActiveUsers_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {
			
			this.request = UserActions.getGetUserRequest(Routes.GetUserbyActiveUser_Url, true, Env_Var.token);
		   
		}
	
		@When("Admin sends HTTPS Request to retrieve all ActiveUsers details")
		public void admin_sends_https_request_to_retrieve_all_ActiveUsers_details() {
			
			 this.response = UserActions.getUserResponse(request);
		   
		}
//	Get count of User Status	
	
		@Given("Admin sets the GET Userrequest with UserID {string}")
		public void authorized_admin_sets_the_get_batches_request_with_or_without(String string) throws JsonProcessingException {
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

		@When("Admin sends HTTPS Request to retrieve all count users details")
		public void admin_sends_https_request_to_retrieve_all_count_users_details() {
			this.response = UserActions.getUserResponse(request);
		}

		
//	Get User By BatchID	
		@Given("Admin creates GET Request for the user by progbatch endpoint to retrieve all User details")
		public void admin_creates_get_request_for_the_user_by_progbatch_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {
			
			this.request = UserActions.getGetUserRequest(Routes.GetUserbyBatchID_Url, true, Env_Var.token);
		   
		}
	
		@When("Admin sends HTTPS Request to retrieve all user by progbatch details")
		public void admin_sends_https_request_to_retrieve_all_user_by_progbatch_details() {
			
			 this.response = UserActions.getGetPutDeleteUserResponsePositive(request, "get", batchID);
		   
		}
//		
//Get User by ProgID
		@Given("Admin creates GET Request for the userbyprog endpoint to retrieve all User details")
		public void admin_creates_get_request_for_the_userbyprog_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {
			
			this.request = UserActions.getGetUserRequest(Routes.GetUserbyProgID_Url, true, Env_Var.token);
		   
		}
	
		@When("Admin sends HTTPS Request to retrieve all userbyprog details")
		public void admin_sends_https_request_to_retrieve_all_userbyprog_details() {
			
			 this.response = UserActions.getGetPutDeleteUserResponsePositive(request, "get", programID);
		   
		}
		
//	Get User with role	
		@Given("Admin creates GET Request for the UserswithRole endpoint to retrieve all User details")
		public void admin_creates_get_request_for_the_UserswithRole_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {
			
			this.request = UserActions.getGetUserRequest(Routes.GetUserwithRoles_Url, true, Env_Var.token);
		   
		}
	
		@When("Admin sends HTTPS Request to retrieve all UserswithRole details")
		public void admin_sends_https_request_to_retrieve_all_UserswithRole_details() {
			
			 this.response = UserActions.getUserResponse(request);
		   
		}
//	Get User with Roleid	
		@Given("Admin creates GET Request for the UserswithRoleID endpoint to retrieve all User details")
		public void admin_creates_get_request_for_the_UserswithRoleID_api_endpoint_to_retrieve_all_User_details() throws JsonProcessingException {
			
			this.request = UserActions.getGetUserRequest(Routes.GetUserbyRoleID_Url, true, Env_Var.token);
		   
		}
	
		@When("Admin sends HTTPS Request to retrieve all UserswithRoleID details")
		public void admin_sends_https_request_to_retrieve_all_UserswithRoleID_details() {
			
			
			this.response = UserActions.getGetPutDeleteUserResponsePositive(request, "get", RoleID);
		   
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
//	Delete User
		 @Given("Authorized admin sets Delete User by UserID request with valid endpoint")
		 public void authorized_admin_sets_delete_user_by_userID_request_with_valid_endpoint() throws JsonProcessingException {
			 this.request = UserActions.getGetDeleteUserRequest(Routes.DeleteUserbyUserID_Url, true, token);
		 }
	
		 @When("Admin sends Delete User request with UserID")
		 public void admin_sends_delete_batch_request() {
			 System.out.println("User ID that is being deleted is: "+ "U284");
			 this.response = UserActions.getGetPutDeleteUserResponsePositive(request, "delete", "U284");	     
		 }
	
		 @Then("Admin receives {int} OK Status in delete User response")
		 public void admin_receives_ok_status_in_delete_batch_response(Integer int1) {
			 UserTests.GetDeleteUser200Validation(response);
		 }
	
}
