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
	import lms.utilities.FileNameConstants;

	public class UserLogoutTests {
		
		
		public static void GetLogout200Validation(Response response) {
			
				response
					.then()
					.assertThat()
					.statusCode(200)
					.statusLine("HTTP/1.1 201 ");
				
		}
		
	
		
		public static void Put200Validation(Response response) {
			
				response
					.then()
					.assertThat()
					.statusCode(200)
					.statusLine("HTTP/1.1 200 ");
				
		
		}
		
		public static void GetUnauthorizedValidation(Response response) {
			response
				.then()
					.assertThat()
					.statusCode(401)
					.statusLine("HTTP/1.1 401 ");
		}
		
		public static void GetNegative404Validation(Response response) {
			response
				.then()
					.assertThat()
					.statusCode(404)
					.statusLine("HTTP/1.1 404 ");
		}
		
		public static void GetNegative400Validation(Response response) {
			response
				.then()
					.assertThat()
					.statusCode(400);
		}
		
		public static void GetNegative409Validation(Response response) {
			response
				.then()
					.assertThat()
					.statusCode(409);
		}
		
		public static void GetNegative500Validation(Response response) {
			response
				.then()
					.assertThat()
					.statusCode(500);
		}

		

	}
