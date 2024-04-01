package lms.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.GlobalVariables.Env_Var;
import lms.endpoints.Routes;
import lms.payload.BatchPojo;
import lms.payload.ExpectedResponse;
import lms.payload.UserLoginPojo;
import lms.payload.UserPojo;
import lms.payload.UserProgramBatchPojo;
import lms.payload.UserPutRoleIDPojo;
import lms.payload.UserRoleMapPojo;
import lms.payload.UserRoleProgramBatchPojo;
import lms.utilities.ExcelReader;
import lms.utilities.FileNameConstants;
import com.fasterxml.jackson.annotation.JsonInclude;

public class UserActions {
	static RequestSpecification request;
	static Response response;
	static String userID;
	public static ArrayList<String> PutstatusList = new ArrayList<>();

	public static List<RequestSpecification> putUserRoleIDRequestsDD(String url, String token) throws IOException {
		String RoleID;

		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "ETEPositiveTestData");
		List<RequestSpecification> requestSpecifications = new ArrayList<>();
		for (Map<String, String> row : testData) {

			RoleID = row.get("updateRoleID"); // Extract fields from each row
			PutstatusList.add(row.get("ExpectedStatusCodePut"));    	   
			// Prepare request body
			String requestBody = preparePutRoleIDRequestBody(List.of(RoleID));
			request =  
					RestAssured
					.given()
					.headers("Authorization", token)
					.contentType(ContentType.JSON)
					.body(requestBody)
					.baseUri(url);	
			requestSpecifications.add(request);		    		     
		}
		return requestSpecifications;
	}

	public static List<RequestSpecification> putUserRoleStatusRequestsDD(String url, String token) throws IOException {
		String RoleID;
		String RoleStatus;

		ExcelReader excelReader = new ExcelReader();
		List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "ETEPositiveTestData");
		List<RequestSpecification> requestSpecifications = new ArrayList<>();
		for (Map<String, String> row : testData) {

			RoleID = row.get("updateRoleID"); // Extract fields from each row
			RoleStatus = row.get("updateRoleStatus");

			PutstatusList.add(row.get("ExpectedStatusCodePut"));    	   
			// Prepare request body
			String requestBody = preparePutRoleStatusRequestBody(RoleID, RoleStatus);
			request =  
					RestAssured
					.given()
					.headers("Authorization", token)
					.contentType(ContentType.JSON)
					.body(requestBody)
					.baseUri(url);	
			requestSpecifications.add(request);		    		     
		}
		return requestSpecifications;
	}

	private static String preparePutRoleIDRequestBody(List<String> RId) throws JsonProcessingException {

		UserPutRoleIDPojo uPRID = new UserPutRoleIDPojo(RId);
		ObjectMapper objectMapper = new ObjectMapper(); 
		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uPRID);		
		System.out.println(requestBody);
		return requestBody;
	}

	private static String preparePutRoleStatusRequestBody(String RoleID, String Rstatus) throws JsonProcessingException {

		UserRoleMapPojo uRM = new UserRoleMapPojo(RoleID, Rstatus);
		ObjectMapper objectMapper = new ObjectMapper(); 
		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uRM);		
		System.out.println(requestBody);
		return requestBody;
	}

	public static List<Response> getPutUserRoleIDStatusResponse(List<RequestSpecification> requests, String userId) {

		List<Response> responses = new ArrayList<>();

		for (RequestSpecification request : requests) {
			response = request.when().put("/{userId}",userId);
			responses.add(response);
		}		
		return responses;
	}

	//DD Create USER request
	public static List<RequestSpecification> getPostCreateUserRequestDD(String token, String sheetName) throws IOException {
		ExcelReader excelReader = new ExcelReader();
		List<RequestSpecification> requests = new ArrayList<RequestSpecification>();
		List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, sheetName);
		for (Map<String, String> row : testData) {
			System.out.println(row);
			UserPojo userpj = mapRowToUserPojo(row);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userpj);
			System.out.println("POST User request body is : " + requestBody);
			RequestSpecification userRequest = RestAssured.given().headers("Authorization", token)
					.contentType(ContentType.JSON).body(requestBody);
			userRequest.log();
			requests.add(userRequest);
		}
		return requests;
	}
	
	public static List<RequestSpecification> getPostCreateUserRequestDD(String token) throws IOException {
		return getPostCreateUserRequestDD(token, "PostUser");
	}

	//DD create USER Response
	public static List<Response> getPostUserResponsesDD(List<RequestSpecification> requests) {
		List<Response> responses = new ArrayList<>();

		for (RequestSpecification request : requests) {
			Response userPostResponse = request.when().post(Routes.CreateUser_Url);
			userPostResponse.prettyPrint();
			responses.add(userPostResponse);
		}
		return responses;
	}

	//DD Update USER request
	public static List<RequestSpecification> getPutUpdateUserRequestDD(String token) throws IOException {
		ExcelReader excelReader = new ExcelReader();
		List<RequestSpecification> requests = new ArrayList<RequestSpecification>();
		List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA,"PutUser");
		for (Map<String, String> row : testData) {
			System.out.println(row);
			UserPojo userpj = mapUpdateRowToUserPojo(row);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userpj);
			System.out.println("PUT User request body is : " + requestBody);
			RequestSpecification userRequest = RestAssured.given().headers("Authorization", token)
					.contentType(ContentType.JSON).body(requestBody).pathParam("userId", userID);
			userRequest.log();
			requests.add(userRequest);
		}
		return requests;
	}

	//DD Update USER Response
	public static List<Response> getPutUpdateUserResponsesDD(List<RequestSpecification> requests) {
		List<Response> responses = new ArrayList<>();

		for (RequestSpecification request : requests) {
			Response userPostResponse = request.when().put(Routes.UpdateUser_Url);
			System.out.println(userPostResponse);
			userPostResponse.prettyPrint();
			responses.add(userPostResponse);
		}
		return responses;
	}


	//DD Update user Login status request
	public static List<RequestSpecification> getPutUpdateUserLoginStatusRequestDD(String token) throws IOException {
		ExcelReader excelReader = new ExcelReader();
		List<RequestSpecification> requests = new ArrayList<RequestSpecification>();
		List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA,"PutLoginStatus");
		for (Map<String, String> row : testData) {
			System.out.println(row);
			UserLoginPojo loginpj = mapUpdateRowToUserLoginPojo(row);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(loginpj);
			System.out.println("PUT User request body is : " + requestBody);
			RequestSpecification userRequest = RestAssured.given().headers("Authorization", token)
					.contentType(ContentType.JSON).body(requestBody).pathParam("userId", userID);
			userRequest.log();
			requests.add(userRequest);
		}
		return requests;
	}

	//DD Update User Login Status Response
	public static List<Response> getPutUpdateUserLoginStatusResponsesDD(List<RequestSpecification> requests) {
		List<Response> responses = new ArrayList<>();

		for (RequestSpecification request : requests) {
			Response userPostResponse = request.when().put(Routes.UpdateLoginStatus_Url);
			System.out.println(userPostResponse);
			userPostResponse.prettyPrint();
			responses.add(userPostResponse);
		}
		return responses;
	}

	//Convert Excel Row to POJO(DataDriven)-->update user by user login status
	private static UserLoginPojo mapUpdateRowToUserLoginPojo(Map<String, String> row) {

		// Creating a UserLoginPojo object
		UserLoginPojo userLoginpj = new UserLoginPojo();
		userLoginpj.setLoginStatus(StringUtils.isEmpty(row.get("userLogin.loginStatus")) ? null : row.get("userLogin.loginStatus"));
		userLoginpj.setPassword(StringUtils.isEmpty(row.get("userLogin.password")) ? null : row.get("userLogin.password"));
		String roleIds = StringUtils.isEmpty(row.get("userLogin.roleIds")) ? null : row.get("userLogin.roleIds");
		userLoginpj.setRoleIds(Arrays.asList(roleIds.split(",")));
		userLoginpj.setStatus(StringUtils.isEmpty(row.get("userLogin.status")) ? null : row.get("userLogin.status"));
		String fullEmail =  row.get("userLogin.userLoginEmail") == null ? null : row.get("userLogin.userLoginEmail");
		if(fullEmail != null && fullEmail.contains("xxx")) {
			fullEmail = dynamicGenerator.generateUserLoginEmail(fullEmail);
		}
		userLoginpj.setUserLoginEmail(fullEmail);
		return userLoginpj;
	}

	//Convert Excel Row to POJO(DataDriven)-->create user
	private static UserPojo mapRowToUserPojo(Map<String, String> row) {
		// Creating a UserLoginPojo object
		UserLoginPojo userLoginpj = new UserLoginPojo();
		userLoginpj.setLoginStatus(StringUtils.isEmpty(row.get("userLogin.loginStatus")) ? null : row.get("userLogin.loginStatus"));
		userLoginpj.setPassword(StringUtils.isEmpty(row.get("userLogin.password")) ? null : row.get("userLogin.password"));
		//userLoginpj.setRoleIds(List.of("string"));
		userLoginpj.setStatus(StringUtils.isEmpty(row.get("userLogin.status")) ? null : row.get("userLogin.status"));
		String fullEmail =  row.get("userLogin.userLoginEmail") == null ? null : row.get("userLogin.userLoginEmail");
		if(fullEmail != null && fullEmail.contains("xxx")) {
			fullEmail = dynamicGenerator.generateUserLoginEmail(fullEmail);
		}
		userLoginpj.setUserLoginEmail(fullEmail);
		// Creating a list of UserRoleMapPojo objects
		List<UserRoleMapPojo> userRoleMaps = new ArrayList<>();
		UserRoleMapPojo userRoleMappj = new UserRoleMapPojo();
		userRoleMappj.setRoleId(row.get("userRoleMaps.roleId"));
		userRoleMappj.setUserRoleStatus(row.get("userRoleMaps.userRoleStatus"));
		userRoleMaps.add(userRoleMappj);
		// Creating the entire UserPojo object
		UserPojo userpj = new UserPojo();
		userpj.setUserUserId(userID);
		userpj.setUserComments(row.get("comments"));
		userpj.setUserEduPg(row.get("eduUg"));
		userpj.setUserEduUg(row.get("eduPg"));
		userpj.setUserFirstName(row.get("firstName"));
		userpj.setUserUserId(StringUtils.isEmpty(row.get("userId")) ? null : row.get("userId"));
		userpj.setUserLastName(row.get("lastName"));
		userpj.setUserLinkedinUrl(row.get("linkedinUrl"));
		userpj.setUserLocation(row.get("location"));
		userpj.setUserLogin(userLoginpj);
		userpj.setUserMiddleName(row.get("middleName"));

		String baseNumber = row.get("phoneNumber") == null ? null : row.get("phoneNumber");
		String fullNumber = baseNumber;
		if(baseNumber != null && baseNumber.endsWith("xxx")) {
			fullNumber = dynamicGenerator.generatePhoneNumber(baseNumber);
		}
		userpj.setUserPhoneNumber(Long.parseLong(fullNumber));
		//userpj.setUserPhoneNumber(row.get("phoneNumber") == null?null :Long.parseLong(row.get("phoneNumber")));
		userpj.setUserRoleMaps(userRoleMaps);
		userpj.setUserTimeZone(row.get("timeZone"));
		userpj.setUserVisaStatus(row.get("visaStatus"));
		return userpj;
	}

	//Convert Excel Row to POJO(DataDriven)-->update user by userId
	private static UserPojo mapUpdateRowToUserPojo(Map<String, String> row) {
		// Creating the entire UserPojo object
		UserPojo userpj = new UserPojo();
		userpj.setUserUserId(userID);
		userpj.setUserComments(row.get("comments"));
		userpj.setUserEduPg(row.get("eduUg"));
		userpj.setUserEduUg(row.get("eduPg"));
		userpj.setUserFirstName(row.get("firstName"));
		userpj.setUserUserId(StringUtils.isEmpty(row.get("userId")) ? null : row.get("userId"));
		userpj.setUserLastName(row.get("lastName"));
		userpj.setUserLinkedinUrl(row.get("linkedinUrl"));
		userpj.setUserLocation(row.get("location"));
		userpj.setUserMiddleName(row.get("middleName"));

		String baseNumber = row.get("phoneNumber") == null ? null : row.get("phoneNumber");
		String fullNumber = baseNumber;
		if(baseNumber != null && baseNumber.endsWith("xxx")) {
			fullNumber = dynamicGenerator.generatePhoneNumber(baseNumber);
		}
		userpj.setUserPhoneNumber(Long.parseLong(fullNumber));
		String fullEmail =  row.get("userLogin.userLoginEmail") == null ? null : row.get("userLogin.userLoginEmail");
		if(fullEmail != null && fullEmail.contains("xxx")) {
			fullEmail = dynamicGenerator.generateUserLoginEmail(fullEmail);
		}
		userpj.setUserLoginEmail(fullEmail);
		//userpj.setUserPhoneNumber(row.get("phoneNumber") == null?null :Long.parseLong(row.get("phoneNumber")));
		userpj.setUserTimeZone(row.get("timeZone"));
		userpj.setUserVisaStatus(row.get("visaStatus"));
		return userpj;
	}

	public static void setUserDetails(Response response) {
		if (response.path("userId") != null) {
			userID = response.path("userId").toString();
			Env_Var.userID = userID;
			System.out.println("Created User Id is: "+ userID );
		}

	}
	
	public static RequestSpecification getGetUserRequest(String url, boolean Auth, String token) throws JsonProcessingException {
		if(Auth) {
		request =
				RestAssured
					.given()
						.headers("Authorization", token)
						.contentType(ContentType.JSON)						
						.baseUri(url);
		} else {
			request =
					RestAssured
						.given()
							.contentType(ContentType.JSON)						
							.baseUri(url);
			
		}
		return request;
	}
	
	public static Response getGetPutDeleteUserResponsePositive(RequestSpecification request, String type, String IdorName ) {
		
		switch (type.toLowerCase()) {
		case "put":
			response = request.when().put("/{IdorName}",IdorName);
			break;
		case "get":
			response = request.when().get("/{IdorName}",IdorName);
			break;
		case "delete":
			response = request.when().delete("/{IdorName}",IdorName);
			break;
		default:
			System.out.println("Invalid request type");
			break;
		}
		return response;
	}
	
//	public static RequestSpecification getUserStatusRequest(String url, boolean Auth, String token,String id) throws JsonProcessingException {
//		if(Auth) {
//		request =
//				RestAssured
//					.given()
//						.headers("Authorization", token)
//						.contentType(ContentType.JSON)						
//						.baseUri(url).pathParam("id", all);
//		}
//	}
//	
	public static Response getUserResponse(RequestSpecification request) {
		response = request.when().get();
		return response;
	}
	
	public static RequestSpecification getGetDeleteUserRequest(String url, boolean Auth, String token) throws JsonProcessingException {
		if(Auth) {
		request =
				RestAssured
					.given()
						.headers("Authorization", token)
						.contentType(ContentType.JSON)						
						.baseUri(url);
		}
		return request;
	}
	
	//DD Update user Program Batch Status request
	public static List<RequestSpecification> getPutUpdateUserProgramBatchStatusRequestDD(String token) throws IOException {
	ExcelReader excelReader = new ExcelReader();
	List<RequestSpecification> requests = new ArrayList<RequestSpecification>();
	List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA,"PutProgramBatchStatus");
	for (Map<String, String> row : testData) {
		System.out.println(row);
		UserRoleProgramBatchPojo pgmbatchpj = mapUpdateRowToUserRoleProgramBatchPojo(row);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pgmbatchpj);
		System.out.println("PUT User request body is : " + requestBody);
		RequestSpecification userRequest = RestAssured.given().headers("Authorization", token)
				.contentType(ContentType.JSON).body(requestBody).pathParam("userId", userID);
		userRequest.log();
		requests.add(userRequest);
	}
	return requests;
}

//DD Update User  Program Batch  Status Response
public static List<Response> getPutUpdateUserProgramBatchStatusResponsesDD(List<RequestSpecification> requests) {
	List<Response> responses = new ArrayList<>();
	
	for (RequestSpecification request : requests) {
		Response userPostResponse = request.when().put(Routes.UpdateRoleProgramBatchStatus_Url);
		System.out.println(userPostResponse);
		userPostResponse.prettyPrint();
		responses.add(userPostResponse);
	}
	return responses;
}

//Convert Excel Row to POJO(DataDriven)-->update user by program batch status
	private static UserRoleProgramBatchPojo mapUpdateRowToUserRoleProgramBatchPojo(Map<String, String> row) {
		
		// Creating a UserLoginPojo object
		UserRoleProgramBatchPojo pgmbatchpj = new UserRoleProgramBatchPojo();
		Integer programId= StringUtils.isEmpty(row.get("programId")) ? null : Integer.parseInt(row.get("programId"));
		//pgmbatchpj.setProgramId(programId);
		
		
		pgmbatchpj.setProgramId(Integer.parseInt(Env_Var.programID));
		
		System.out.println("RoleId from excel "+row.get("roleId"));
		String roleId= StringUtils.isEmpty(row.get("roleId")) ? null : row.get("roleId");
		System.out.println("RoleId from excel final "+roleId);
		pgmbatchpj.setRoleId(roleId);		
		
		
		String userId= StringUtils.isEmpty(row.get("userId")) ? null : row.get("userId");
		pgmbatchpj.setUserId(userId);		
		
		// Creating a list of UserRoleMapPojo objects
		List<UserProgramBatchPojo> userPBList = new ArrayList<>();
		UserProgramBatchPojo userPBpj = new UserProgramBatchPojo();
		Integer batchId= StringUtils.isEmpty(row.get("batchId")) ? null : Integer.parseInt(row.get("batchId"));
		//userPBpj.setBatchId(batchId);
		userPBpj.setBatchId(Integer.parseInt(Env_Var.batchID));
		
		String userRoleProgramBatchStatus= StringUtils.isEmpty(row.get("userRoleProgramBatchStatus")) ? null : row.get("userRoleProgramBatchStatus");
		userPBpj.setUserRoleProgramBatchStatus(userRoleProgramBatchStatus);
		userPBList.add(userPBpj);
		pgmbatchpj.setUserRoleProgramBatches(userPBList);
		return pgmbatchpj;
	}

	public static List<ExpectedResponse> getExpectedResponsesDD(String sheetName) throws IOException {
		ExcelReader excelReader = new ExcelReader();
		List<ExpectedResponse> expResponses = new ArrayList<ExpectedResponse>();
		List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, sheetName);
		for (Map<String, String> row : testData) {
			ExpectedResponse expResp = new ExpectedResponse();
			if(row.containsKey("expectedResponseCode") && StringUtils.isNotEmpty(row.get("expectedResponseCode"))) {
				expResp.setStatusCode(Integer.parseInt(row.get("expectedResponseCode")));
			}
			//Add/set more expected
			expResponses.add(expResp);
		}
		return expResponses;
	}

}	
