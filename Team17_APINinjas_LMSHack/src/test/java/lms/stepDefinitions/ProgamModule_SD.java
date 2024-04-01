//package lms.stepDefinitions;
//
//import java.util.List;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//
//import io.cucumber.java.en.*;
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.response.ResponseBody;
//import io.restassured.specification.RequestSpecification;
//import lms.actions.ProgramActions;
//import lms.endpoints.Routes;
//import lms.globalVariables.Env_var;
//import lms.tests.ProgramTests;
//
//public class ProgamModule_SD {
//	
//	 RequestSpecification request;
//	 Response response;
//	 List<RequestSpecification> requests;
//	 List<Response> responses;
//	 String token;
//	 String programName;
//	
//	 //User Login
//	
//	@Given("Admin logs in with valid Username and password for Program")
//	public void admin_logs_in_with_valid_username_and_password_for_program() throws JsonProcessingException {
//		
//		this.request = ProgramActions.getLoginRequest();
//		//RestAssured.baseURI="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
//		//RequestSpecification request=RestAssured.given();
//		//request.header("Content-Type","application/json");
//		//Response response=request.body("{\n"
//		//		+ "  \"password\": \"lmsHackathon@2024\",\n"
//		//		+ "  \"userLoginEmailId\": \"numpyninja@gmail.com\"\n"
//			//	+ "}").post("/login");
//		
//		//String jsonString=response.asString();
//		//token=JsonPath.from(jsonString).get("token");
//		//System.out.println(token);
//			   
//	}
//
//	@When("Admin send Post Login request for Program")
//	public void admin_send_post_login_request_for_program() {
//	
//		this.response = ProgramActions.getLoginResponse(request);
//	   
//	}
//
//	@Then("Admin should be able to get {int} in the response and generate Token for Program")
//	public void admin_should_be_able_to_get_in_the_response_and_generate_token_for_program(Integer int1) {
//	 
//		this.token = ProgramTests.getToken(response);
//	}
//	
//	//Post Program
//	
//	@Given("Authorized Admin sets Post Program request with valid Url,valid endpoint, request body from excel")
//	public void authorized_admin_sets_post_program_request_with_valid_url_valid_endpoint_request_body_from_excel() throws JsonProcessingException {
//		
//		this.request = ProgramActions.getPostProgramRequest(Routes.CreateProgram_Url, Env_var.token);
//	  
//	}
//
//	@When("Admin sends POST Program request.")
//	public void admin_sends_post_program_request() {
//		
//		this.response = ProgramActions.getPostProgramResponse(request);
//		ProgramActions.setProgramDetails(response);
//	  
//	}
//
//	@Then("Admin receives expected status in Post Program response")
//	public void admin_receives_expected_status_in_post_program_response() {
//		
//		ProgramTests.PostProgram201Validation(response);
//	   
//	}
//	
//	//Get All Programs
//	
//	@Given("Admin creates GET Request for the program API endpoint to retrieve all program details")
//	public void admin_creates_get_request_for_the_program_api_endpoint_to_retrieve_all_program_details() throws JsonProcessingException {
//		
//		this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgram_Url, true, Env_var.token);
//	   
//	}
//
//	@When("Admin sends HTTPS Request to retrieve all program details")
//	public void admin_sends_https_request_to_retrieve_all_program_details() {
//		
//		 this.response = ProgramActions.getProgramResponse(request);
//	   
//	}
//
//	//Get Program By ID
//	
//	@Given("Admin creates GET Request for the program API endpoint to retrieve program by programID")
//	public void admin_creates_get_request_for_the_program_api_endpoint_to_retrieve_program_by_program_id() throws JsonProcessingException {
//		
//		this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgramByProgramID_Url, true, Env_var.token);
//	    
//	}
//
//	@When("Admin sends HTTPS Request to retrieve program with programID")
//	public void admin_sends_https_request_to_retrieve_program_with_program_id() {
//		
//		this.response = ProgramActions.getGetPutDeleteProgramResponsePositive(request, "get", Env_var.programID);
//	   
//	}
//	
//	//Get Program with User Details
//
//
//	@Given("Admin creates GET Request for the program API endpoint to retrieve program with User details")
//	public void admin_creates_get_request_for_the_program_api_endpoint_to_retrieve_program_with_user_details() throws JsonProcessingException {
//		
//		this.request = ProgramActions.getGetDeleteProgramRequest(Routes.GetProgramwithUsers_Url, true, Env_var.token);
//	    
//	}
//
//	@When("Admin sends HTTPS Request to retrieve program with Users details")
//	public void admin_sends_https_request_to_retrieve_program_with_users_details() {
//		
//		 this.response = ProgramActions.getProgramResponse(request);
//	   
//	}
//
//	@Then("Admin recieves {int} OK and valid response for program")
//	public void admin_recieves_ok_and_valid_response_for_program(Integer int1) {
//		
//		ProgramTests.GetDeleteProgram200Validation(response);
//	   
//	}
//
//	//Update Program by ProgramID
//	
//	@Given("Authorized admin sets Put Program request with valid Url,valid endpoint with program id, request body from excel")
//	public void authorized_admin_sets_put_program_request_with_valid_url_valid_endpoint_with_program_id_request_body_from_excel() throws JsonProcessingException {
//	   
//		 this.request = ProgramActions.getPutProgramRequest(Routes.PutProgramByProgID_Url, Env_var.token);
//	}
//
//	@When("Admin sends Put Program request with programID")
//	public void admin_sends_put_program_request_with_program_id() {
//		
//		System.out.println("Batch ID that is being Updated is: "+ Env_var.programID);
//		 this.response = ProgramActions.getGetPutDeleteProgramResponsePositive(request, "put", Env_var.programID);
//	    
//	}
//
//	@Then("Admin receives expected status in Put Program response of particular program ID")
//	public void admin_receives_expected_status_in_put_program_response_of_particular_program_id() {
//		
//		ProgramTests.Put200Validation(response);
//	    
//	}
//	
//	//Update Program by ProgramName
//
//	@Given("Authorized admin sets Put Program request with valid Url,valid endpoint with program name, request body from excel")
//	public void authorized_admin_sets_put_program_request_with_valid_url_valid_endpoint_with_program_name_request_body_from_excel() throws JsonProcessingException {
//	   
//		 this.request = ProgramActions.getPutProgramRequest(Routes.PutProgramByProgName_Url, Env_var.token);
//	}
//
//	@When("Admin sends Put Program request with programName")
//	public void admin_sends_put_program_request_with_program_name() {
//	   
//		System.out.println("Program Name which need to be updated is: "+ Env_var.programName);
//		 this.response = ProgramActions.getGetPutDeleteProgramResponsePositive(request, "put", Env_var.programName);
//		
//	}
//
//	@Then("Admin receives expected status in Put Program response  of particular program name")
//	public void admin_receives_expected_status_in_put_program_response_of_particular_program_name() {
//		
//		//System.out.println("Program Name which is updated is: "+ Env_var.UpdatedprogramName);
//		ProgramTests.Put200Validation(response);
//	  
//	}
//	
//	//Delete Program by ProgramID
//
//	@Given("Authorized admin sets Delete Program by ProgramID request with valid endpoint")
//	public void authorized_admin_sets_delete_program_by_program_id_request_with_valid_endpoint() throws JsonProcessingException {
//	   
//		 this.request = ProgramActions.getGetDeleteProgramRequest(Routes.DeleteProgramByProgID_Url, true, Env_var.token);
//	}
//
//	@When("Admin sends Delete Program request with programID")
//	public void admin_sends_delete_program_request_with_program_id() {
//	   
//		System.out.println("Program ID that is being deleted is: "+ Env_var.programID);
//		 this.response = ProgramActions.getGetPutDeleteProgramResponsePositive(request, "delete", Env_var.programID);
//	}
//	
//	//Delete Program by ProgramName
//
//	@Given("Authorized admin sets Delete Program by programName request with valid endpoint")
//	public void authorized_admin_sets_delete_program_by_program_name_request_with_valid_endpoint() throws JsonProcessingException {
//		
//		 this.request = ProgramActions.getGetDeleteProgramRequest(Routes.DeleteProgramByProgName_Url, true, Env_var.token);
//	  
//		
//	}
//
//	@When("Admin sends Delete Program request with programName")
//	public void admin_sends_delete_program_request_with_program_name() {
//	    
//		System.out.println("Program Name that is being Deleted is: "+ Env_var.programName);
//		 this.response = ProgramActions.getGetPutDeleteProgramResponsePositive(request, "delete", Env_var.programName);
//		
//	}
//
//	@Then("Admin receives expected status in Delete Program response")
//	public void admin_receives_expected_status_in_delete_program_response_for_that_particular_program_name() {
//	   
//		ProgramTests.GetDeleteProgram200Validation(response);
//		
//
//	}
//}