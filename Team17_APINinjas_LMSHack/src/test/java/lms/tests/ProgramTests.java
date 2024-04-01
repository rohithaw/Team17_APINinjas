package lms.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.testng.Assert;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lms.actions.ProgramActions;
import lms.GlobalVariables.Env_Var;
import lms.utilities.FileNameConstants;
import lms.utilities.LoggerLoad;

public class ProgramTests {
	
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
	Env_Var.token=AuthToken;
	LoggerLoad.info("***************** Admin has logged in Successfully*");
	System.out.println("Succesful User login with token: "+Env_Var.token);
	return AuthToken;
	
}
	
	
public static void PostProgram201Validation(Response response) {
		
		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.Prog_JSON_SCHEMA), "UTF-8");		
		
			response
				.then()
				.assertThat()
				.statusCode(201)
				.statusLine("HTTP/1.1 201 ")
				.header("Content-Type", "application/json")
				.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema))
				.time(Matchers.lessThan(4000L));
			// Validate that the response contains a specific field
	        String responseBody = response.getBody().asString();
	        Assert.assertTrue(responseBody.contains("programName"), "March24-ApINinjas");
				
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}


public static void postPutProgramValidationsDD(List<Response> responses, String type) {
    if(type.toLowerCase()=="post") {
    	expectedStatusList = ProgramActions.PoststatusList;
    } else {
    	expectedStatusList = ProgramActions.PutstatusList;
    }
    // Iterate over both response list and expected status list simultaneously
    for (int i = 0; i < responses.size() && i < expectedStatusList.size(); i++) {
        Response response = responses.get(i);
        String expectedStatus = expectedStatusList.get(i);
      if(expectedStatus=="201") {
        
        try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.Prog_JSON_SCHEMA), "UTF-8");		
            // Validate response against expected status code
            response
            	.then()
            	.assertThat()
            	.statusCode(Integer.parseInt(expectedStatus.split("\\.")[0]))
            	.header("Content-Type", "application/json")
				.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema))
				.time(Matchers.lessThan(4000L));
         // Validate that the response contains a specific field
	        String responseBody = response.getBody().asString();
	        Assert.assertTrue(responseBody.contains("programName"), "March24-ApINinjas");
        
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
	            LoggerLoad.error(e.getMessage());
	        }
      }
   }
}

public static void getDeleteProgramValidationsDD(List<Response> responses, String by) {
    if(by.toLowerCase()=="id") {
    	expectedStatusList = ProgramActions.getDeleteIDstatusList;
    } else {
    	expectedStatusList = ProgramActions.getProgNamestatusList;
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
	            LoggerLoad.error(e.getMessage());
         }	      
      }
}

public static void GetDeleteProgram200Validation(Response response) {
	 try {
		response
			.then()
				.assertThat()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 ");
//				.header("Content-Type", "text/plain;charset=UTF-8");
	 	} catch (AssertionError e) {
           System.err.println("Assertion failed " + e.getMessage());
           LoggerLoad.error(e.getMessage());
       }			
}

public static void Put200Validation(Response response) {
	
	try {
		String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.Prog_JSON_SCHEMA), "UTF-8");				
		
		response
			.then()
			.assertThat()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 ")
			.header("Content-Type", "application/json")
			.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema))
			.time(Matchers.lessThan(4000L));
		// Validate that the response contains a specific field
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("programName"), "March24-ApINinjas");
		
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
