package lms.actions;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.GlobalVariables.Env_Var;
import lms.endpoints.Routes;
import lms.payload.BatchPojo;
import lms.payload.LoginPojo;
import lms.utilities.ExcelReader;
import lms.utilities.PropertiesFile;

public class BatchActions extends ExcelReader {
	
	static RequestSpecification request;
	static Response response;
	static String batchID;
	static String programID;
	static String batchName;
	static ArrayList<String> statusList = new ArrayList<>();

	static String userLoginEmailId = PropertiesFile.readPropertiesFile("userLoginEmailId");
	static String password = PropertiesFile.readPropertiesFile("password");
	
public static RequestSpecification getLoginRequest() throws JsonProcessingException {
		
		LoginPojo uLP = new LoginPojo(userLoginEmailId,password);
		ObjectMapper objectMapper = new ObjectMapper(); 
		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uLP);		
		
		request = RestAssured
			.given()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.baseUri(Routes.Login_Url);
	
		return request;
	}
	
	public static Response getLoginResponse(RequestSpecification request){
		response = 
			request
				.when()
					.post();
			
		return response;
	}
	
public static RequestSpecification getPostBatchRequest(String url, String token) throws JsonProcessingException{
		
//		dynamicGenerator.resetCounter();
		String baseBatchName = "March24-ApINinjas-QA-QA1-";
		String batchName = dynamicGenerator.generateBatchName(baseBatchName);
		System.out.println("Generated batch name is"+ batchName);

		try {
			BatchPojo bP = new BatchPojo("Full Stack Tester",batchName,10,"Active",16228);
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

public static Response getPostBatchResponse(RequestSpecification request) {
	response = request.when().post();	
	return response;
}

public static void setBatchDetails(Response response) {
   
            if (response.path("batchId") != null) {
                batchID = response.path("batchId").toString();
                batchName = response.path("batchName").toString();
                programID = response.path("programId").toString();
                
                Env_Var.batchID = batchID;
                Env_Var.batchName = batchName;
                Env_Var.programID = programID;
                
                System.out.println("Created Batch Id is: "+ batchID );
                System.out.println("Created Batch Name is: "+ batchName );
                System.out.println("This Batch is created under the Program ID: "+ programID );
            }  
}

public static RequestSpecification getGetDeleteBatchRequest(String url, boolean Auth, String token) throws JsonProcessingException {
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
}

}
