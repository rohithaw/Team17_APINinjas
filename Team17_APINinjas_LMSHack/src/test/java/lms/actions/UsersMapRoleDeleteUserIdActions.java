package lms.actions;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.GlobalVariables.Env_Var;
import lms.endpoints.Routes;
import lms.payload.usersMapRoleGetAllPojo;
import lms.payload.usersMapRoleGetUserIdPojo;
import lms.payload.userLoginPojo;
import lms.payload.usersMapRoleDeleteUserIdPojo;
import lms.utilities.ExcelReader;
import lms.utilities.PropertiesFile;


public class UsersMapRoleDeleteUserIdActions {

//		static RequestSpecification request;
//		static Response response;
//		static ArrayList<String> statusList = new ArrayList<>();
//		
//	public static RequestSpecification deleteRPBMUserIdRequest(String userid) throws JsonProcessingException {
//		//adminRoleMapAllPojo(int batchId,int programId,String roleId,String userId,String userRoleProgramBatchStatus)
//		
//		usersMapRoleDeleteUserIdPojo uLP = new usersMapRoleDeleteUserIdPojo(userid);
//			ObjectMapper objectMapper = new ObjectMapper(); 
//			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uLP);		
//			
//			request = RestAssured
//				.given()
//				.headers("Authorization", Ent_Var.token)
//					.contentType(ContentType.JSON)
//					.body(requestBody)
//					.baseUri(Routes.deleteUserRoleMap_Url);
//		
//			
//			System.out.println("*********Request from deleteRPBMUserIdRequest***********");
//			System.out.println("Request " + request.log().body());
//			return request;
//		}
//		
//		public static Response deleteUserRoleMapUserIdResponse(RequestSpecification request, String userid){
//			response = 
//				request
//					.when()
//						.delete("/{userid}",userid);
//			
//			
//			System.out.println("*********Response from deleteUserRoleMapUserIdResponse***********");
//			System.out.println(response.print());
//			
//			return response;
//		}
//		
//		
//		public static RequestSpecification deleteRPBMUserIdRequest_Neg(String url, String token) throws IOException {
//			RequestSpecification request;
//
//			// Prepare request body
//			request =  
//					RestAssured
//					.given()
//					.headers("Authorization", Ent_Var.token)
//					.contentType(ContentType.JSON)
//					//.body(requestBody)
//					.baseUri(url);	
//
//			System.out.println("***********************************");
//			System.out.println("Request to string " + request.toString());
//		     return request;
//		}
//
//		
//		
//		
//		public static Response deleteUserRoleMapUserIdResponse_Neg(RequestSpecification request, String type){
//			System.out.println("Type "+ type);
//			response = 
//				request
//					.when()
//						.get();
//				
//			System.out.println("*********Response from getUserRoleMapAllResponse***********");
//			System.out.println(response.print());
//			
//			return response;
//		}
//
//		//No Auth Code for negative tests
//		public static RequestSpecification GetPrgmBatchStatusRequestNoAuth(String url) throws JsonProcessingException{
//			
//			request =  
//				RestAssured
//					.given()					
//						.contentType(ContentType.JSON)					
//						.baseUri(url);	
//			System.out.println("Request " + request.log().body());
//		return request;
//		}

}