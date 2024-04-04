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
import lms.actions.UserPutPrgmBatchStatusActions;
import lms.utilities.FileNameConstants;
import lms.utilities.LoggerLoad;

	public class usersPutPrgmBatchStatusTests {
//		static List<String> expectedStatusList = new ArrayList<>();
//		public static void PutUserMapRole200Validation(Response response) {
//			
//			try {
//				String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.UsersMapRolePutUserId_JSON_SCHEMA), "UTF-8");		
//			
//				response
//					.then()
//					.assertThat()
//					.statusCode(200)
//					.statusLine("HTTP/1.1 200 ")
//					.header("Content-Type", "application/json")
//					.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
//					
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//				
//		}
//		
//		
//		public static void PutUserMapRole200ValidationDD(List<Response> responses, String type) {
//		    if(type.toLowerCase()=="put") {
//		    	expectedStatusList = UserPutPrgmBatchStatusActions.PutstatusList;
//		    } else {
//		    	System.out.println("Not a put request");
//		    }
//		    // Iterate over both response list and expected status list simultaneously
//		    for (int i = 0; i < responses.size() && i < expectedStatusList.size(); i++) {
//		        Response response = responses.get(i);
//		        String expectedStatus = expectedStatusList.get(i);
//		      if(expectedStatus=="200") {
//		        
//		        try {
//					String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.UsersMapRolePutUserId_JSON_SCHEMA), "UTF-8");		
//		            // Validate response against expected status code
//		            response
//		            	.then()
//		            	.assertThat()
//		            	.statusCode(Integer.parseInt(expectedStatus.split("\\.")[0]))
//		            	.header("Content-Type", "application/json")
//						.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
//		        
//		         } catch (IOException e) {
//					e.printStackTrace();
//		         }
//		      }else {
//		    	  try {
//			            // Validate response against expected status code
//			            response
//			            	.then()
//			            	.assertThat()
//			            	.statusCode(Integer.parseInt(expectedStatus.split("\\.")[0]));
//			        
//					} catch (AssertionError e) {
//			            // Handle assertion error
//			            System.err.println("Assertion failed for response " + (i + 1) + ": " + e.getMessage());
//			            LoggerLoad.error(e.getMessage());
//			        }
//		      }
//		   }
//		}
//		
//		
//		
//		public static void PutNegative400Validation(Response response) {
//			response
//				.then()
//					.assertThat()
//					.statusCode(400)
//					.header("Content-Type", "application/json");
//		}
//		
//		
//		public static void GetUnauthorizedValidation(Response response) {
//			response
//				.then()
//					.assertThat()
//					.statusCode(401)
//					.statusLine("HTTP/1.1 401 ");
//		}
		
		
}