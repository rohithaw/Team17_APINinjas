package lms.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.GlobalVariables.Env_Var;
import lms.endpoints.Routes;
import lms.payload.usersMapRoleGetAllPojo;
import lms.tests.UserLoginTests;
import lms.payload.userLoginPojo;
import lms.utilities.ExcelReader;
import lms.utilities.FileNameConstants;
import lms.utilities.PropertiesFile;


public class UsersMapRoleGetAllActions {

//		static RequestSpecification request;
//		static Response response;
//		static ArrayList<String> statusList = new ArrayList<>();
//		
//	public static RequestSpecification getRPBMRequest() throws JsonProcessingException {
//		
//			
//			request = RestAssured
//				.given()
//					.headers("Authorization", Ent_Var.token)
//					.contentType(ContentType.JSON)
////					.body(requestBody)
//					.baseUri(Routes.adminGetAllRoleMap_Url);
//		
//			System.out.println("*********Request from getRPBMRequest***********");
//			System.out.println("Request " + request.log().body());
//			
//			return request;
//		}
//		
//		public static Response getUserRoleMapAllResponse(RequestSpecification request){
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
//		public static Response getUserRoleMapAllResponse_Neg(RequestSpecification request, String type){
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
//		
//		public static RequestSpecification getRPBMUserAllRequestDD_Neg(String url, String token) throws IOException {
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