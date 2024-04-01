package lms.actions;
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
		
}
