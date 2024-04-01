package lms.tests;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lms.actions.UPRBActions;
import lms.utilities.FileNameConstants;
import lms.utilities.LoggerLoad;
public class UPRBTests {
	static List<String> expectedStatusList = new ArrayList<>();
	
	//Get ALL
	
	public static void GetUserMapRole200Validation(Response response) {
		
		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.UsersMapRoleGetAll_JSON_SCHEMA), "UTF-8");		
		
			response
				.then()
				.assertThat()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 ")
				.header("Content-Type", "application/json");
				//.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
				
		} catch (IOException e) {
			e.printStackTrace();
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
				.statusLine("HTTP/1.1 404 ");
				//.header("Content-Type", "application/json");
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
	
	//Put
	
	public static void PutUserMapRole200Validation(Response response) {
		
		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.UsersMapRolePutUserId_JSON_SCHEMA), "UTF-8");		
		
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
	
	
	public static void PutUserMapRole200ValidationDD(List<Response> responses, String type) {
	    if(type.toLowerCase()=="put") {
	    	expectedStatusList = UPRBActions.PutstatusList;
	    } else {
	    	System.out.println("Not a put request");
	    }
	    // Iterate over both response list and expected status list simultaneously
	    for (int i = 0; i < responses.size() && i < expectedStatusList.size(); i++) {
	        Response response = responses.get(i);
	        String expectedStatus = expectedStatusList.get(i);
	      if(expectedStatus=="200") {
	       
	        try {
				String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.UsersMapRolePutUserId_JSON_SCHEMA), "UTF-8");		
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
		            LoggerLoad.error(e.getMessage());
		        }
	      }
	   }
	}
	
	
	
	public static void PutNegative400Validation(Response response) {
		response
			.then()
				.assertThat()
				.statusCode(400)
				.header("Content-Type", "application/json");
	}
	
	
			
}
