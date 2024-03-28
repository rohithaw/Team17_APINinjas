package lms.actions;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.payload.LoginPojo;
import lms.utilities.ExcelReader;
import lms.utilities.PropertiesFile;

public class UserActions extends ExcelReader {
	
	static RequestSpecification request;
	static Response response;
	static String batchID;
	static String programID;
	static String batchName;
	static ArrayList<String> statusList = new ArrayList<>();

	static String userLoginEmailId = PropertiesFile.readPropertiesFile("userLoginEmailId");
	static String password = PropertiesFile.readPropertiesFile("password");

	public static RequestSpecification getLoginRequest() throws JsonProcessingException {
		//RestAssured.basePath = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	LoginPojo uLP = new LoginPojo(userLoginEmailId,password);
	ObjectMapper objectMapper = new ObjectMapper();
	String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uLP);
System.out.println("Request body "+requestBody);
	request = RestAssured
	.given()
	.contentType(ContentType.JSON)
	.body(requestBody);
//	.basePath("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms")
//	.baseUri("/login");
	return request;
	}

	public static Response getLoginResponse(RequestSpecification request) throws URISyntaxException{
	response =
	request
	.post(new URI("https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/login"));

	return response;
	}

	/*public static RequestSpecification getPostBatchRequest(String url, String token) throws JsonProcessingException{

	// dynamicGenerator.resetCounter();
	// String batchName = dynamicGenerator.generateBatchName();
	// String batchName = "";
	// System.out.println(batchName);

	try {
	BatchPojo bP = new BatchPojo("Full Stack Tester","March24-ApINinjas-QA-QA01-001",10,"Active",16228);
	ObjectMapper objectMapper = new ObjectMapper();
	String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bP);
	System.out.println(requestBody);
	request = 
	RestAssured
	.given()
	.headers("Authorization", token)
	.contentType(ContentType.JSON)
	.body(requestBody)
	.baseUri(url);

	} catch (JsonProcessingException e) {
	e.printStackTrace();
	}

	return request;
	}

	public static Response getPostBatchResponse(RequestSpecification request) {
	response = request.when().post();

	if(response.path("batchId")!= null) {
	batchID  = response.path("batchId").toString();
	System.out.println("Batch is succesfully created with batchID: "+ batchID);
	}

	return response;
	}*/


}
