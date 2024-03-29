package lms.actions;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.GlobalVariables.Env_Var;
import lms.endpoints.Routes;
import lms.payload.UserPojo;
import lms.payload.UserRoleMapPojo;
import lms.payload.LoginPojo;
import lms.payload.UserLoginPojo;
import lms.utilities.ExcelReader;
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

	public static RequestSpecification getPostCreateUserRequest(String url, String token)
			throws JsonProcessingException {

//		dynamicGenerator.resetCounter();
		// String baseBatchName = "March24-ApINinjas-QA-QA1-";
		// String batchName = dynamicGenerator.generateBatchName(baseBatchName);
		// System.out.println("Generated batch name is"+ batchName);

		// Creating a UserLoginPojo object
		UserLoginPojo userLoginpj = new UserLoginPojo();
		userLoginpj.setLoginStatus("Active");
		userLoginpj.setPassword("hack0234");
		userLoginpj.setRoleIds(List.of("string"));
		userLoginpj.setStatus("Active");
		userLoginpj.setUserLoginEmail("saxi09@gmail.com");

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
			userpj.setUserLinkedinUrl("https://www.linkedin.com/in/saxi/");
			userpj.setUserLocation("Seattle");
			userpj.setUserLogin(userLoginpj);
			userpj.setUserMiddleName("pp");
			userpj.setUserPhoneNumber(4259995457L);
			userpj.setUserRoleMaps(userRoleMaps);
			userpj.setUserTimeZone("EST");
			userpj.setUserVisaStatus("H1B");

			ObjectMapper objectMapper = new ObjectMapper();
			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userpj);
			
			System.out.println("POST User request body is : "+requestBody);
			request = RestAssured.given().headers("Authorization", token).contentType(ContentType.JSON)
					.body(requestBody).baseUri(url);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return request;
	}

public static Response getPostCreateUserResponse(RequestSpecification request) {
	response = request.when().post();	
	//System.out.println("Create user response body is : "+response.prettyPrint()+"\n");
	return response;
}

public static void setUserDetails(Response response) {
   
            if (response.path("userId") != null) {
                userID = response.path("userId").toString();
                //batchName = response.path("batchName").toString();
               // programID = response.path("programId").toString();
                
                Env_Var.userID = userID;
                //Env_Var.batchName = batchName;
                //Env_Var.programID = programID;
                
                System.out.println("Created User Id is: "+ userID );
              
            }  
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

public static Response getBatchResponse(RequestSpecification request) {
	response = request.when().get();
	return response;
}

public static RequestSpecification getPutBatchRequest(String url, String token) throws JsonProcessingException{
	
	String batchName = Env_Var.batchName;

	try {
		BatchPojo bP = new BatchPojo("SDET",batchName,15,"Active",16228);
		ObjectMapper objectMapper = new ObjectMapper(); 
		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bP);		
		System.out.println(requestBody);
		request =  
			RestAssured
				.given()
					.headers("Authorization", token)
					.contentType(ContentType.JSON)
					.body(requestBody)
					.baseUri(url);	
		
	} catch (JsonProcessingException e) {
		e.printStackTrace();
	}
	
	return request;
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