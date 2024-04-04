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
import lms.actions.UPRBActions;
import lms.actions.UserLoginActions;
import lms.endpoints.Routes;
import lms.tests.UPRBTests;
import lms.tests.UserLoginTests;
import lms.tests.usersMapRoleGetAllTests;
import lms.tests.usersMapRoleGetUserIdTests;
import lms.utilities.LoggerLoad;


public class usersMapRoleGetUserId_Neg_SD {

	
	 RequestSpecification request;
	 Response response;
	 List<RequestSpecification> requests;
	 List<Response> responses;
	 String token;
	 
	 
		//Invalid Url GET UserID PrgmBatchStatus Module
		//*************************************  
	 @Given("User sets {string} with invalid Url, valid endpoint and valid request body GET UserID")
	 public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body_get_user_id(String string) throws IOException {
		 LoggerLoad.info("Execution of Invalid Url GET UserID PrgmBatchStatus Scenarios started");
			if ("Get_UserId".equals(string)) {
				System.out.println("Inside Given");
				this.request = UPRBActions.getRPBMUserIdRequestDD_Neg(Routes.userGetRoleMap_InvalidUrl, token);
				System.out.println("Routes points " + Routes.userGetRoleMap_InvalidUrl);

			}
			else {
				System.out.println("Request not allowed");
			}

	}

	 @When("User sends {string} for PrgmBatchStatus GET UserID invalid Url")
	 public void user_sends_for_prgm_batch_status_get_user_id_invalid_url(String string) {
			if ("GET".equals(string)) {
				System.out.println("Inside Update of When");
				this.response = UPRBActions.getUserRoleMapUserIdResponse_Neg(request, "GET");
			}else {
				System.out.println("Else of GetAll " + string);
				System.out.println("Request not allowed");
			}
		 
	}

	 @Then("User receives {int} Not found status in PrgmBatchStatus response GET UserID invalid Url")
	 public void user_receives_not_found_status_in_prgm_batch_status_response_get_user_id_invalid_url(Integer int1) {
		 System.out.println("Inside Then");
		 UPRBTests.GetNegative404Validation(response);
		 
		 
	}
	 
	 
	//Invalid endpoint GET UserID PrgmBatchStatus Module
	//*************************************
	 
	 @Given("User sets {string} with valid Url, invalid endpoint and valid request body GET UserID InvalidEP")
	 public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body_get_user_id_invalid_ep(String string) throws IOException {
		 LoggerLoad.info("Execution of Invalid Endpoint GET UserID PrgmBatchStatus Scenarios started");
			if ("Get_UserId".equals(string)) {
				System.out.println("Inside Given");
				this.request = UPRBActions.getRPBMUserIdRequestDD_Neg(Routes.userGetRoleMap_InvalidEP, token);
				System.out.println("Routes points " + Routes.userGetRoleMap_InvalidEP);

			}
			else {
				System.out.println("Request not allowed");
			}
		 
	 }

	 @When("User sends {string} for PrgmBatchStatus GET UserID InvalidEP")
	 public void user_sends_for_prgm_batch_status_get_user_id_invalid_ep(String string) {
			if ("GET".equals(string)) {
				System.out.println("Inside Update of When");
				this.response = UPRBActions.getUserRoleMapUserIdResponse_Neg(request, "GET");
			}else {
				System.out.println("Else of GetAll " + string);
				System.out.println("Request not allowed");
			}

	 }

	 @Then("User receives {int} Not found status in PrgmBatchStatus response GET UserID InvalidEP")
	 public void user_receives_not_found_status_in_prgm_batch_status_response_get_user_id_invalid_ep(Integer int1) {
		 System.out.println("Inside Then");
		 UPRBTests.GetNegative404Validation(response);

	 }


		//No Auth GET UserID PrgmBatchStatus Module
		//*************************************

	 
	 
	 @Given("Unauthorized User sets {string} with valid baseUrl,valid endpoint GET UserID NoAuth")
	 public void unauthorized_user_sets_with_valid_base_url_valid_endpoint_get_user_id_no_auth(String string) throws JsonProcessingException {
		 
			LoggerLoad.info("Execution of No_Auth GET UserId PrgmBatchStatus Scenarios started");
			if ("Get_UserId".equals(string)) {
				this.request = UPRBActions.GetPrgmBatchStatusRequestNoAuth(Routes.adminGetAllRoleMap_Url);
			}
			else {
				System.out.println("Request not allowed");
			}
	 }

	 @When("User sends {string} for PrgmBatchStatus GET UserID NoAuth")
	 public void user_sends_for_prgm_batch_status_get_user_id_no_auth(String string) {
			if ("GET".equals(string)) {
				System.out.println("Inside Update of When");
				this.response = UPRBActions.getUserRoleMapUserIdResponse_Neg(request, "GET");
			}else {
				System.out.println("Else of GET " + string);
				System.out.println("Request not allowed");
			}
	 }

	 @Then("User receives {int} Unauthorized Status in PrgmBatchStatus response GET UserID NoAuth")
	 public void user_receives_unauthorized_status_in_prgm_batch_status_response_get_user_id_no_auth(Integer int1) {
			System.out.println("Inside Then");
			UPRBTests.GetUnauthorizedValidation(response);
		 
	 }


	 
	 
	 

}


