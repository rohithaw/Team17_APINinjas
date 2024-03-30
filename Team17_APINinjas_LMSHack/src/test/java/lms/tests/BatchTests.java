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
import lms.actions.BatchActions;
import lms.utilities.FileNameConstants;

public class BatchTests {
	
	static List<String> expectedStatusList = new ArrayList<>();
	
	public static String getToken(Response response){
			response
				.then()
					.assertThat()
					.statusCode(200)
				.extract()
					.response();
		
		String token = response.path("token");
		String AuthToken = "Bearer "+token;
		System.out.println("Succesful User login with token: "+AuthToken);
		return AuthToken;
	}
	
	public static void PostBatch201Validation(Response response) {
		
		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.Batch_JSON_SCHEMA), "UTF-8");		
		
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
	
	public static void postPutBatchValidationsDD(List<Response> responses, String type) {
	    if(type.toLowerCase()=="post") {
	    	expectedStatusList = BatchActions.PoststatusList;
	    } else {
	    	expectedStatusList = BatchActions.PutstatusList;
	    }
	    // Iterate over both response list and expected status list simultaneously
	    for (int i = 0; i < responses.size() && i < expectedStatusList.size(); i++) {
	        Response response = responses.get(i);
	        String expectedStatus = expectedStatusList.get(i);
	      if(expectedStatus=="201") {
	        
	        try {
				String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.Batch_JSON_SCHEMA), "UTF-8");		
	            // Validate response against expected status code
	            response
	            	.then()
	            	.assertThat()
	            	.statusCode(Integer.parseInt(expectedStatus.split("\\.")[0]))
	            	.header("Content-Type", "application/json")
					.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
	        
	         } catch (IOException e) {
				e.printStackTrace();
	         }
	      }else {
	    	  try {
		            // Validate response against expected status code
		            response
		            	.then()
		            	.assertThat()
		            	.statusCode(Integer.parseInt(expectedStatus.split("\\.")[0]));
		        
				} catch (AssertionError e) {
		            // Handle assertion error
		            System.err.println("Assertion failed for response " + (i + 1) + ": " + e.getMessage());
		        }
	      }
	   }
	}
	
	public static void getDeleteBatchValidationsDD(List<Response> responses, String by) {
	    if(by.toLowerCase()=="id") {
	    	expectedStatusList = BatchActions.getDeleteIDstatusList;
	    } else {
	    	expectedStatusList = BatchActions.getBNamestatusList;
	    }
	    // Iterate over both response list and expected status list simultaneously
	    for (int i = 0; i < responses.size() && i < expectedStatusList.size(); i++) {
	        Response response = responses.get(i);
	        String expectedStatus = expectedStatusList.get(i);
	        System.out.println(expectedStatus);
	        try {
	            response
	            	.then()
	            	.assertThat()
	            	.statusCode(Integer.parseInt(expectedStatus.split("\\.")[0]));
	            		        
	         } catch (AssertionError e) {
		            System.err.println("Assertion failed for response " + (i + 1) + ": " + e.getMessage());
	         }	      
	      }
	}
	
	public static void GetDeleteBatch200Validation(Response response) {
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
	
	public static void Put200Validation(Response response) {
		
		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.Batch_JSON_SCHEMA), "UTF-8");				
			
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
	}

}
