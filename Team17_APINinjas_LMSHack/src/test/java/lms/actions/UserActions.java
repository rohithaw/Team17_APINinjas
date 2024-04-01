package lms.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.GlobalVariables.Env_Var;
import lms.endpoints.Routes;
import lms.payload.LoginPojo;
import lms.payload.UserLoginPojo;
import lms.payload.UserPojo;
import lms.payload.UserProgramBatchPojo;
import lms.payload.UserRoleMapPojo;
import lms.payload.UserRoleProgramBatchPojo;
import lms.utilities.ExcelReader;
import lms.utilities.FileNameConstants;
import lms.utilities.PropertiesFile;

public class UserActions extends ExcelReader {

	static RequestSpecification request;
	static Response response;
	static String userID;
	static ArrayList<String> statusList = new ArrayList<>();

	static String userLoginEmailId = PropertiesFile.readPropertiesFile("userLoginEmailId");
	static String password = PropertiesFile.readPropertiesFile("password");

	public static RequestSpecification getLoginRequest() throws JsonProcessingException {

		LoginPojo uLP = new LoginPojo(userLoginEmailId, password);
		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uLP);

		request = RestAssured.given().contentType(ContentType.JSON).body(requestBody).baseUri(Routes.Login_Url);

		return request;
	}

	public static Response getLoginResponse(RequestSpecification request) {
		response = request.when().post();

		return response;
	}
	
		//DD Create USER request
		public static List<RequestSpecification> getPostCreateUserRequestDD(String token) throws IOException {
		ExcelReader excelReader = new ExcelReader();
		List<RequestSpecification> requests = new ArrayList<RequestSpecification>();
		List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.BatchEXCEL_TEST_DATA,
				"PostUser");
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
	
	//DD Update USER request- userId
			public static List<RequestSpecification> getPutUpdateUserRequestDD(String token) throws IOException {
			ExcelReader excelReader = new ExcelReader();
			List<RequestSpecification> requests = new ArrayList<RequestSpecification>();
			List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.BatchEXCEL_TEST_DATA,
					"PutUser");
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
		
		//DD Update USER Response-userId
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

		//DD Update user Login status request
		public static List<RequestSpecification> getPutUpdateUserLoginStatusRequestDD(String token) throws IOException {
		ExcelReader excelReader = new ExcelReader();
		List<RequestSpecification> requests = new ArrayList<RequestSpecification>();
		List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.BatchEXCEL_TEST_DATA,
				"PutLoginStatus");
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
		
		
		//DD Update user Program Batch Status request
				public static List<RequestSpecification> getPutUpdateUserProgramBatchStatusRequestDD(String token) throws IOException {
				ExcelReader excelReader = new ExcelReader();
				List<RequestSpecification> requests = new ArrayList<RequestSpecification>();
				List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.BatchEXCEL_TEST_DATA,
						"PutProgramBatchStatus");
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
					pgmbatchpj.setProgramId(Env_Var.programID);
					
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
					userPBpj.setBatchId(Env_Var.batchID);
					
					String userRoleProgramBatchStatus= StringUtils.isEmpty(row.get("userRoleProgramBatchStatus")) ? null : row.get("userRoleProgramBatchStatus");
					userPBpj.setUserRoleProgramBatchStatus(userRoleProgramBatchStatus);
					userPBList.add(userPBpj);
					pgmbatchpj.setUserRoleProgramBatches(userPBList);
					return pgmbatchpj;

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
	
	
//Create User--->Request without DD
	public static RequestSpecification getPostCreateUserRequest(String url, String token) throws JsonProcessingException {

//		dynamicGenerator.resetCounter();
		// String baseBatchName = "March24-ApINinjas-QA-QA1-";
		// String batchName = dynamicGenerator.generateBatchName(baseBatchName);
		// System.out.println("Generated batch name is"+ batchName);

		// Creating a UserLoginPojo object
		UserLoginPojo userLoginpj = new UserLoginPojo();
		userLoginpj.setLoginStatus("Active");
		userLoginpj.setPassword("hack0234");
		//userLoginpj.setRoleIds(List.of("string"));
		userLoginpj.setStatus("Active");
		userLoginpj.setUserLoginEmail("saxi74@gmail.com");

		// Creating a list of UserRoleMapPojo objects
		List<UserRoleMapPojo> userRoleMaps = new ArrayList<>();
		UserRoleMapPojo userRoleMappj = new UserRoleMapPojo();
		userRoleMappj.setRoleId("R03");
		userRoleMappj.setUserRoleStatus("Active");
		userRoleMaps.add(userRoleMappj);

		// Creating the entire UserPojo object
		try {
			UserPojo userpj = new UserPojo();
			userpj.setUserComments("ROLE_STUDENT");
			userpj.setUserEduPg("msc");
			userpj.setUserEduUg("bsc");
			userpj.setUserFirstName("APINinjas");
			userpj.setUserLastName("Student");
			userpj.setUserLinkedinUrl("https://www.linkedin.com/in/sa622/");
			userpj.setUserLocation("Seattle");
			userpj.setUserLogin(userLoginpj);
			userpj.setUserMiddleName("pp");
			userpj.setUserPhoneNumber(4374795557l);
			userpj.setUserRoleMaps(userRoleMaps);
			userpj.setUserTimeZone("EST");
			userpj.setUserVisaStatus("H1B");

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL) ;
			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userpj);
			
			System.out.println("POST User request body is : "+requestBody);
			request = RestAssured.given().headers("Authorization", token).contentType(ContentType.JSON)
					.body(requestBody).baseUri(url);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return request;
	}

	//Create user---> Response without DD
public static Response getPostCreateUserResponse(RequestSpecification request) {
	response = request.when().post();	
	//System.out.println("Create user response body is : "+response.prettyPrint()+"\n");
	return response;
}

public static void setUserDetails(Response response) {
   
            if (response.path("userId") != null) {
                userID = response.path("userId").toString();
               
                Env_Var.userID = userID;
                
                System.out.println("Created User Id is: "+ userID );
              
            }  
}


//Update user details----> Request without DD
public static RequestSpecification getPutUserUpdateRequest(String url, String token) throws IOException{
	
	String userID = Env_Var.userID;

	try {
		UserPojo userpj = new UserPojo();
		UserLoginPojo userLoginpj = new UserLoginPojo();
		userpj.setUserComments(null);
		userpj.setUserEduPg("msc");
		userpj.setUserEduUg("bsc");
		userpj.setUserFirstName("APINinjas1234");
		userpj.setUserUserId(null);
		userpj.setUserLastName("Student1");
		userpj.setUserLinkedinUrl(null);
		userpj.setUserLocation(null);
		userLoginpj.setUserLoginEmail(null);
		userpj.setUserPhoneNumber(4279895457l);
		userpj.setUserTimeZone("EST");
		userpj.setUserVisaStatus("H1B");

		ObjectMapper objectMapper = new ObjectMapper(); 
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL) ;
		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userpj);		
		System.out.println(requestBody);
		request =  
			RestAssured
				.given()
					.headers("Authorization", token)
					.contentType(ContentType.JSON)
					.body(requestBody)
					.pathParam("userId", userID);
					//.baseUri(url);	
		
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
	
	return request;
}



/*private static List<UserPojo> mapRowToUserPojo(List<Map<String, String>> testData) {
	List<UserPojo> userList = new ArrayList<UserPojo>();
	for (Map<String, String> row : testData) {
		// Creating a UserLoginPojo object
		UserLoginPojo userLoginpj = new UserLoginPojo();
		userLoginpj.setLoginStatus("Active");
		userLoginpj.setPassword("hack0234");
		// userLoginpj.setRoleIds(List.of("string"));
		userLoginpj.setStatus("Active");
		userLoginpj.setUserLoginEmail("saxi74@gmail.com");

		// Creating a list of UserRoleMapPojo objects
		List<UserRoleMapPojo> userRoleMaps = new ArrayList<>();
		UserRoleMapPojo userRoleMappj = new UserRoleMapPojo();
		userRoleMappj.setRoleId("R03");
		userRoleMappj.setUserRoleStatus("Active");
		userRoleMaps.add(userRoleMappj);

		// Creating the entire UserPojo object
		UserPojo userpj = new UserPojo();
		userpj.setUserComments("ROLE_STUDENT");
		userpj.setUserEduPg("msc");
		userpj.setUserEduUg("bsc");
		userpj.setUserFirstName("APINinjas");
		userpj.setUserLastName("Student");
		userpj.setUserLinkedinUrl("https://www.linkedin.com/in/sa622/");
		userpj.setUserLocation("Seattle");
		userpj.setUserLogin(userLoginpj);
		userpj.setUserMiddleName("pp");
		userpj.setUserPhoneNumber(4374795557L);
		userpj.setUserRoleMaps(userRoleMaps);
		userpj.setUserTimeZone("EST");
		userpj.setUserVisaStatus("H1B");
		userList.add(userpj);
	}
	return userList;
}*/

//Update user details----> Response
public static Response getUserUpdateResponse(RequestSpecification request) {
	response = request.when().put(Routes.UpdateUser_Url);
	return response;
}
/*public static RequestSpecification getGetDeleteBatchRequest(String url, boolean Auth, String token) throws JsonProcessingException {
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

public static Response getGetPutDeleteBatchResponsePositive(RequestSpecification request, String type, String IdorName ) {
	
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





public static Response getGetDeleteBatchResponseNegative(RequestSpecification request, String UserIdorName, String type ) {
	switch (type.toLowerCase()) {
	case "put":
		response = request.when().put("/{UserIdorName}",UserIdorName);
		break;
	case "get":
		response = request.when().get("/{UserIdorName}",UserIdorName);
		break;
	case "delete":
		response = request.when().delete("/{UserIdorName}",UserIdorName);
		break;
	default:
		System.out.println("Invalid request type");
		break;
	}				
	return response;
}*/

}