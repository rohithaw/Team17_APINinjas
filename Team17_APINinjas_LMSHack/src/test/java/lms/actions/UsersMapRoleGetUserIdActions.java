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
import lms.utilities.ExcelReader;
import lms.utilities.PropertiesFile;


public class UsersMapRoleGetUserIdActions {

//		static RequestSpecification request;
//		static Response response;
//		static ArrayList<String> statusList = new ArrayList<>();
//		
//	public static RequestSpecification getRPBMUserIdRequest(String userid) throws JsonProcessingException {
//			request = RestAssured
//				.given()
//					.headers("Authorization", Ent_Var.token)
//					.contentType(ContentType.JSON)
//		//			.body(requestBody)
//					.baseUri(Routes.userGetRoleMap_Url);
//		
//			System.out.println("*********Request from getRPBMUserIdRequest***********");
//			System.out.println("Request " + request.log().body());
//			
//			return request;
//		}
//		
//		public static Response getUserRoleMapUserIdResponse(RequestSpecification request, String userid){
//			response = 
//				request
//					.when()
//						.get("/{userid}",userid);
//				
//			
//			System.out.println("*********Response from getUserRoleMapUserIdResponse***********");
//			System.out.println(response.print());
//			
//			return response;
//		}
//		
//		
//		
//		
//		public static RequestSpecification getRPBMUserIdRequestDD_Neg(String url, String token) throws IOException {
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
//		public static Response getUserRoleMapUserIdResponse_Neg(RequestSpecification request, String type){
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
//
		
}