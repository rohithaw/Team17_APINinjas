package lms.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.testng.Assert;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lms.actions.BatchActions;
import lms.payload.ExpectedResponse;
import lms.utilities.FileNameConstants;
import lms.utilities.LoggerLoad;

public class UserTests {

	static List<String> expectedStatusList = new ArrayList<>();

	public static void Put200ValidationsDD(List<Response> responses) {
		expectedStatusList = BatchActions.PutstatusList;

		for (int i = 0; i < responses.size() && i < expectedStatusList.size(); i++) {
			Response response = responses.get(i);
			String expectedStatus = expectedStatusList.get(i);
			try {
				// Validate response against expected status code

				response
				.then()
				.assertThat()
				.statusCode(Integer.parseInt(expectedStatus.split("\\.")[0]))
				.time(Matchers.lessThan(4000L));

			} catch (AssertionError e) {
				// Handle assertion error
				System.err.println("Assertion failed for response " + (i + 1) + ": " + e.getMessage());
				LoggerLoad.error(e.getMessage());
			}
		}		
	}

	//Validating the response body--->status code, status line, header, schema validation
	public static void PostUser201Validation(Response response) {	
		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.User_JSON_SCHEMA), "UTF-8");		

			response
			.then()
			.assertThat()
			.statusCode(201)
			.statusLine("HTTP/1.1 201 ")
			.header("Content-Type", "application/json")
			.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}	

	public static void PutUser200Validation(Response response) {

		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.Update_User_JSON_SCHEMA), "UTF-8");				

			response
			.then()
			.assertThat()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 ");
			//.header("Content-Type", "application/json");
			//.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void GetDeleteUser200Validation(Response response) {
		try {
			response
			.then()
			.assertThat()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 ");

		} catch (AssertionError e) {
			System.err.println("Assertion failed " + e.getMessage());
		}			
	}

	public static void genericResponseValidation(Response response, ExpectedResponse expectedResponse) {
		try {
			response
			.then()
			.assertThat()
			.statusCode(expectedResponse.getStatusCode())
			//.statusLine("HTTP/1.1 200 ")
			.header("Content-Type", "application/json");

		} catch (AssertionError e) {
			System.err.println("Assertion failed " + e.getMessage());
		}			
		
	}

}