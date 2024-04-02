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
import lms.utilities.ExcelReader;
import lms.utilities.PropertiesFile;
public class UserLogoutActions {
		static RequestSpecification request;
		static Response response;
		static ArrayList<String> statusList = new ArrayList<>();
		
	public static RequestSpecification getLogoutRequest() throws JsonProcessingException {
			
//		userLogoutPojo uLP = new userLogoutPojo();
//		ObjectMapper objectMapper = new ObjectMapper();
//		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uLP);		
//	
			request = RestAssured
				.given()
					.headers("Authorization", Env_Var.token)
					.contentType(ContentType.JSON)
//					.body(requestBody)
					.baseUri(Routes.Logout_Url);
		
			System.out.println("*********Request from getLogoutRequest***********");
			System.out.println(request);
			
			return request;
		}
		
		public static Response getLogoutResponse(RequestSpecification request){
			response =
				request
					.when()
						.get();
				
			System.out.println("*********Response from getLogoutResponse***********");
			System.out.println(response.print() );
			
			return response;
		}
		
		public static RequestSpecification getLogoutRequest_Neg(String url, String token) throws IOException {
			RequestSpecification request;
			// Prepare request body
			request =
					RestAssured
					.given()
					.headers("Authorization", Env_Var.token)
					.contentType(ContentType.JSON)
					.baseUri(url);	
			System.out.println("***********************************");
			System.out.println("Request to string " + request.toString());
		     return request;
		}
		public static Response getLogoutResponse_Neg(RequestSpecification request, String type){
			System.out.println("Type "+ type);
			response =
				request
					.when()
						.get();
				
			System.out.println("*********Response from getLogoutResponse_Neg***********");
			System.out.println(response.print());
			
			return response;
		}
		//No Auth Code for negative tests
		public static RequestSpecification GetLogoutNoAuth(String url) throws JsonProcessingException{
			
			request =
				RestAssured
					.given()					
						.contentType(ContentType.JSON)					
						.baseUri(url);	
			System.out.println("Request " + request.log().body());
		return request;
		}
		
}
