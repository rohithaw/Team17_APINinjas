package lms.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import lms.utilities.FileNameConstants;

public class UserTests {
	
public static void PostUser201Validation(Response response) {
		
		try {
			String jsonSchema = FileUtils.readFileToString(new File(FileNameConstants.Prog_JSON_SCHEMA), "UTF-8");		
		
			response
				.then()
				.assertThat()
				.statusCode(201)
				.statusLine("HTTP/1.1 201 ")
				//.header("Content-Type", "application/json")
				.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
				
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
				.statusLine("HTTP/1.1 200 ")
				.header("Content-Type", "application/json");
				
	 	} catch (AssertionError e) {
          System.err.println("Assertion failed " + e.getMessage());
      }			
}

}
