package lms.actions;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserActions {
	
	static RequestSpecification request;
	static Response response;
	
	public static RequestSpecification getGetUserRequest(String url, boolean Auth, String token) throws JsonProcessingException {
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
	
	public static Response getGetPutDeleteUserResponsePositive(RequestSpecification request, String type, String IdorName ) {
		
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
	
	public static RequestSpecification getGetDeleteUserRequest(String url, boolean Auth, String token) throws JsonProcessingException {
		if(Auth) {
		request =  
				RestAssured
					.given()
						.headers("Authorization", token)
						.contentType(ContentType.JSON)						
						.baseUri(url);
		} 
		return request;
	}
	
	
	public static RequestSpecification getGetDeleteUserRequestNoAuth(String url) throws JsonProcessingException {
		request =  
				RestAssured
					.given()
						.contentType(ContentType.JSON)						
						.baseUri(url);

	return request;
	}

//	public static RequestSpecification getUserStatusRequest(String url, boolean Auth, String token,String id) throws JsonProcessingException {
//		if(Auth) {
//		request =  
//				RestAssured
//					.given()
//						.headers("Authorization", token)
//						.contentType(ContentType.JSON)						
//						.baseUri(url).pathParam("id", all);
//		}
//	}
//	
	public static Response getUserResponse(RequestSpecification request) {
		response = request.when().get();
		return response;
	}
	
//	public static RequestSpecification getGetDeleteUserRequest(String url, boolean Auth, String token) throws JsonProcessingException {
//		if(Auth) {
//		request =  
//				RestAssured
//					.given()
//						.headers("Authorization", token)
//						.contentType(ContentType.JSON)						
//						.baseUri(url);
//		} else {
//			request =  
//					RestAssured
//						.given()
//							.contentType(ContentType.JSON)						
//							.baseUri(url);
//			
//		}
//		return request;
//	}


}
