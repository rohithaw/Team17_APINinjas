package lms.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.utilities.FileNameConstants;

public class UserTests {
	
	public static String getToken(Response response){
			response
				.then()
					.assertThat()
					.statusCode(200)
				.extract()
					.response();
		
		String token = response.path("token");
		String AuthToken = "Bearer "+token;
		System.out.println("Succesful User login with token value : "+AuthToken+"\n");
		return AuthToken;
	}
	
	//Validating the response body--->status code, status line, header, schema validation
	public static void PostUser201Validation(Response response) {	
		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.User_JSON_SCHEMA), "UTF-8");		
		
			response
				.then()
				.assertThat()
				.statusCode(201)
				.statusLine("HTTP/1.1 201 ")
				.header("Content-Type", "application/json")
				.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
				
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
public static void PutUser200Validation(Response response) {
		
	try {
		String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.Update_User_JSON_SCHEMA), "UTF-8");				
		
		response
			.then()
			.assertThat()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 ")
			.header("Content-Type", "application/json")
			.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
		
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	
	/*public static void GetDeleteBatch200Validation(Response response) {
		 try {
			response
				.then()
					.assertThat()
					.statusCode(200)
					.statusLine("HTTP/1.1 200 ")
					.header("Content-Type", "application/json");
		 	} catch (AssertionError e) {
	            System.err.println("Assertion failed " + e.getMessage());
	        }			
	}
	
//	public static void postBatchValidationsDD(List<Response> responses) {
//	    List<String> expectedStatusList = BatchAssignEndPoints.statusList;
//
	    // Iterate over both response list and expected status list simultaneously
//	    for (int i = 0; i < responses.size() && i < expectedStatusList.size(); i++) {
//	        Response response = responses.get(i);
//	        String expectedStatus = expectedStatusList.get(i);
//
//	        try {
//	            // Validate response against expected status code
//	            response
//	            	.then()
//	            	.assertThat()
//	            	.statusCode(Integer.parseInt(expectedStatus.split("\\.")[0]));
//	        
//	        } catch (AssertionError e) {
//	            // Handle assertion error
//	            System.err.println("Assertion failed for response " + (i + 1) + ": " + e.getMessage());
//	        }
//	        
//	    }
//	}
	
	
	
	public static void GetUnauthorizedValidation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(401)
				.statusLine("HTTP/1.1 401 ")
				.header("Content-Type", "application/json");
	}
	
	public static void GetNegative404Validation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(404)
				.statusLine("HTTP/1.1 404 ")
				.header("Content-Type", "application/json");
	}
	
	public static void GetNegative400Validation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(400)
				.header("Content-Type", "application/json");
	}
	
	public static void GetNegative409Validation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(409)
				.header("Content-Type", "application/json");
	}
	
	public static void GetNegative500Validation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(500)
				.header("Content-Type", "application/json");
	}*/

}
