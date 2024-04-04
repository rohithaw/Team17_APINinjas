package lms.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
import lms.actions.UsersMapRoleGetAllActions;
import lms.actions.UsersMapRoleGetUserIdActions;
import lms.actions.UserLoginActions;
import lms.actions.UserPutPrgmBatchStatusActions;
import lms.endpoints.Routes;
import lms.tests.UserLoginTests;
import lms.tests.usersMapRoleGetUserIdTests;
import lms.tests.usersPutPrgmBatchStatusTests;
import lms.utilities.LoggerLoad;


public class usersPutPrgmBatchStatus_SD {

	
	 //RequestSpecification request;
	 List<RequestSpecification> request;
	 List<Response> response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;

	 //user "U404", program id "16652", batch id "8608", role id "R03", status "Active"
	 
	 
//	@Given("Admin creates PUT Request to assign program\\/batch for a user, program id {int}, batch id {int}, role id {string}, status {string}")
//	public void admin_creates_put_request_to_assign_program_batch_for_a_user_program_id_batch_id_role_id_status(Integer programid, Integer batchid, String roleid, String status) throws JsonProcessingException {
// 		this.request = UserPutPrgmBatchStatusActions.putRPBMUserIdRequest( programid, batchid, roleid, status);
//	}
//
//	 @When("Admin sends HTTPS Request for PutUserProgramBatchStatusUserId for a user {string}")
//	 public void admin_sends_https_request_for_put_user_program_batch_status_user_id_for_a_user(String string) {
//		this.response = UserPutPrgmBatchStatusActions.putUserRoleMapUserIdResponse(request, string);
//	}
//
//	 @Then("User should be able to get {int} in the response for PutUserProgramBatchStatusUserId")
//	 public void user_should_be_able_to_get_in_the_response_for_put_user_program_batch_status_user_id(Integer int1) {
//		 usersPutPrgmBatchStatusTests.PutUserMapRole200Validation(response);

	 //************** DD  *******************
	 
//	 @Given("Admin creates PUT Request to assign program\\/batch for a user from excelsheet")
//	 public void admin_creates_put_request_to_assign_program_batch_for_a_user_from_excelsheet() throws IOException {
//		 LoggerLoad.info("Execution of Valid PUT for PrgmBatchStatus Scenarios started");
//	 		this.request = UserPutPrgmBatchStatusActions.putRPBMUserIdRequestDD(Routes.putUserRoleMap_Url, token, "put");
//		}
//	
//		 @When("Admin sends HTTPS Request for PutUserProgramBatchStatusUserId for a user {string}")
//		 public void admin_sends_https_request_for_put_user_program_batch_status_user_id_for_a_user(String string) {
//			this.response = UserPutPrgmBatchStatusActions.putProgramBatchStatusResponsesDD(request, string);
//		}
//	
//		 @Then("User should be able to get {int} in the response for PutUserProgramBatchStatusUserId")
//		 public void user_should_be_able_to_get_in_the_response_for_put_user_program_batch_status_user_id(Integer int1) {
//			 usersPutPrgmBatchStatusTests.PutUserMapRole200ValidationDD(response, "put");
//
	 
	//}
}



