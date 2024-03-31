package lms.tests;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.endpoints.Routes;
import lms.payload.UserPojo;

public class ProgramTests {
	
	@Test
	public void testPathParam() {
		String userID = "U404";

		try {
			UserPojo userpj = new UserPojo();
			userpj.setUserFirstName("APINinjas12345");
			userpj.setUserLastName("Student1");
			userpj.setUserPhoneNumber(4279895457L);
			userpj.setUserTimeZone("EST");
			userpj.setUserVisaStatus("H1B");

			ObjectMapper objectMapper = new ObjectMapper(); 
			objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL) ;
			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userpj);		
			System.out.println(requestBody);
			RequestSpecification request =  
				RestAssured
					.given()
						.headers("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJudW1weW5pbmphQGdtYWlsLmNvbSIsImlhdCI6MTcxMTgxNTU0OCwiZXhwIjoxNzExODQ0MzQ4fQ.XooNna6C_VqvKxiAjdsoEp-Mam6fJn1bD-9v0hQpUoY95LH01H2H71JnHdHZyX7b_x75xkWJqcDxguJdtZHJGw")
						.contentType(ContentType.JSON)
						.body(requestBody)
						.pathParam("userId", userID);
						//.baseUri(Routes.UpdateUser_Url);	
			request.log();
			//Response resp = request.when().put();
			Response resp = request.when().put(Routes.UpdateUser_Url);
			resp.prettyPrint();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

}
