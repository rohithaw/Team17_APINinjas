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
import lms.actions.UserPutPrgmBatchStatusActions;
import lms.endpoints.Routes;
import lms.tests.UPRBTests;
import lms.tests.UserLoginTests;
import lms.tests.usersMapRoleGetAllTests;
import lms.tests.usersMapRoleGetUserIdTests;
import lms.tests.usersPutPrgmBatchStatusTests;
import lms.utilities.LoggerLoad;

public class usersMapRoleGetAll_Neg_SD {
	RequestSpecification request;
	List<RequestSpecification> requestList;
	Response response;
	List<RequestSpecification> requests;
	List<Response> responseList;
	String token;



	//Invalid Url GET ALL PrgmBatchStatus Module
	//*************************************

	@Given("User sets {string} with invalid Url, valid endpoint and valid request body GetAll")
	public void user_sets_with_invalid_url_valid_endpoint_and_valid_request_body_get_all(String string) throws IOException {
		LoggerLoad.info("Execution of Invalid Url GET ALL PrgmBatchStatus Scenarios started");
		if ("Get_All".equals(string)) {
			System.out.println("Inside Given");
			this.request = UPRBActions.getRPBMUserAllRequestDD_Neg(Routes.adminGetAllRoleMap_InvalidUrl, token);
			System.out.println("Routes points " + Routes.adminGetAllRoleMap_InvalidUrl);

		}
		else {
			System.out.println("Request not allowed");
		}
	}

	@When("User sends {string} for PrgmBatchStatus GetAll invalid Url")
	public void user_sends_for_prgm_batch_status_get_all_invalid_url(String string) {
		if ("GET".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UPRBActions.getUserRoleMapAllResponse_Neg(request, "GET");
		}else {
			System.out.println("Else of GetAll " + string);
			System.out.println("Request not allowed");
		}
	}

	@Then("User receives {int} Not found status in PrgmBatchStatus response GetAll invalid Url")
	public void user_receives_not_found_status_in_prgm_batch_status_response_get_all_invalid_url(Integer int1) {
		System.out.println("Inside Then");
		UPRBTests.GetNegative404Validation(response);

	}

	//Invalid End Point GET ALL PrgmBatchStatus Module
	//***********************************
	@Given("User sets {string} with valid Url, invalid endpoint and valid request body GetAll InvalidEP")
	public void user_sets_with_valid_url_invalid_endpoint_and_valid_request_body_get_all_invalid_ep(String string) throws IOException {
		LoggerLoad.info("Execution of Invalid endpoint GET ALL PrgmBatchStatus Scenarios started");
		if ("Get_All".equals(string)) {
			this.request = UPRBActions.getRPBMUserAllRequestDD_Neg(Routes.adminGetAllRoleMap_InvalidEP, token);
		}
		else {
			System.out.println("Request not allowed");
		}
	}

	@When("User sends {string} for PrgmBatchStatus GetAll InvalidEP")
	public void user_sends_for_prgm_batch_status_get_all_invalid_ep(String string) {
		if ("GET".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UPRBActions.getUserRoleMapAllResponse_Neg(request, "GET");
		}else {
			System.out.println("Else of GET " + string);
			System.out.println("Request not allowed");
		}
	}

	@Then("User receives {int} Not found status in PrgmBatchStatus response GetAll InvalidEP")
	public void user_receives_not_found_status_in_prgm_batch_status_response_get_all_invalid_ep(Integer int1) {
		System.out.println("Inside Then");
		UPRBTests.GetNegative404Validation(response);
	}



	//No_Auth_ GET ALL Prgm Batch Status
	//*****************
	@Given("Unauthorized User sets {string} with valid baseUrl,valid endpoint GetAll NoAuth")
	public void unauthorized_user_sets_with_valid_base_url_valid_endpoint_get_all_no_auth(String string) throws JsonProcessingException {
		LoggerLoad.info("Execution of No_Auth endpoint GET ALL PrgmBatchStatus Scenarios started");
		if ("Get_All".equals(string)) {
			this.request = UPRBActions.GetPrgmBatchStatusRequestNoAuth(Routes.adminGetAllRoleMap_Url);
		}
		else {
			System.out.println("Request not allowed");
		}
	}

	@When("User sends {string} for PrgmBatchStatus GetAll NoAuth")
	public void user_sends_for_prgm_batch_status_get_all_no_auth(String string) {
		if ("GET".equals(string)) {
			System.out.println("Inside Update of When");
			this.response = UPRBActions.getUserRoleMapAllResponse_Neg(request, "GET");
		}else {
			System.out.println("Else of GET " + string);
			System.out.println("Request not allowed");
		}

	}

	@Then("User receives {int} Unauthorized Status in PrgmBatchStatus response GetAll NoAuth")
	public void user_receives_unauthorized_status_in_prgm_batch_status_response_get_all_no_auth(Integer int1) {
		System.out.println("Inside Then");
		UPRBTests.GetUnauthorizedValidation(response);
	}
}