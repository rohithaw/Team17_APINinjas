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
import lms.payload.LoginPojo;

import lms.utilities.ExcelReader;
import lms.utilities.PropertiesFile;
public class UserLoginActions {
		static RequestSpecification request;
		static Response response;
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
		
			System.out.println("*********Request from getLoginRequest***********");
			System.out.println(request.toString() );
			
			return request;
		}
		
		public static Response getLoginResponse(RequestSpecification request){
			response =
				request
					.when()
						.post();
				
			System.out.println("*********Response from getLoginResponse***********");
			System.out.println(response.print());
			
			return response;
		}
		
		
		
		public static RequestSpecification getLoginRequest_Neg(String userLoginEmailId,String password) throws JsonProcessingException {
			
			LoginPojo uLP = new LoginPojo(userLoginEmailId,password);
				ObjectMapper objectMapper = new ObjectMapper();
				String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uLP);		
				
				request = RestAssured
					.given()
						.contentType(ContentType.JSON)
						.body(requestBody)
						.baseUri(Routes.Login_Url);
			
				System.out.println("*********Request from getLoginRequest***********");
				System.out.println(request.toString() );
				
				return request;
			}
		
		public static RequestSpecification getLoginRequestEP_Neg() throws JsonProcessingException {
			
			LoginPojo uLP = new LoginPojo(userLoginEmailId,password);
				ObjectMapper objectMapper = new ObjectMapper();
				String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uLP);		
				
				request = RestAssured
					.given()
						.contentType(ContentType.JSON)
						.body(requestBody)
						.baseUri(Routes.GetLogin_InvalidEP);
			
				System.out.println("*********Request from getLoginRequest***********");
				System.out.println(request.toString() );
				
				return request;
			}
			
		public static Response getLoginResponse_Neg(RequestSpecification request){
			response =
				request
					.when()
						.post();
				
			System.out.println("*********Response from getLoginResponse***********");
			System.out.println(response.print());
			
			return response;
		}
		
		
		public static RequestSpecification postLoginInvalidURL_Neg(String url) throws IOException {
			LoginPojo uLP = new LoginPojo(userLoginEmailId,password);
			ObjectMapper objectMapper = new ObjectMapper();
			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uLP);		
			
			request = RestAssured
				.given()
					.contentType(ContentType.JSON)
					.body(requestBody)
					.baseUri(url);
		
			System.out.println("*********Request from getLoginRequest***********");
			System.out.println(request.toString() );
			
			return request;
		}
		
}
