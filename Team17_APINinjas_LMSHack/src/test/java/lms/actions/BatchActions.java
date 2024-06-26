package lms.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sun.tools.javac.code.Type;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.GlobalVariables.Env_Var;
import lms.endpoints.Routes;
import lms.payload.BatchPojo;
import lms.payload.LoginPojo;
import lms.utilities.ExcelReader;
import lms.utilities.FileNameConstants;
import lms.utilities.LoggerLoad;
import lms.utilities.PropertiesFile;

public class BatchActions extends ExcelReader {
	
	static RequestSpecification request;
	static Response response;
	static String batchID;
	static String programID;
	static String batchName;
	public static ArrayList<String> PoststatusList = new ArrayList<>();
	public static ArrayList<String> PutstatusList = new ArrayList<>();
	public static ArrayList<String> batchIDstatusList = new ArrayList<>();
	public static ArrayList<String>  batchNamestatusList = new ArrayList<>();
	public static ArrayList<String>  programIDstatusList = new ArrayList<>();
		
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
	
		return request;
	}
	
	public static Response getLoginResponse(RequestSpecification request){
		response = 
			request
				.when()
					.post();
			
		return response;
	}
	
public static RequestSpecification getPostBatchRequest(String url, String token) throws JsonProcessingException{
		
		String batchName = dynamicGenerator.generateBatchName();
		System.out.println("Generated batch name is"+ batchName);

		try {
			BatchPojo bP = new BatchPojo("Full Stack Tester",batchName,10,"Active",16766);
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

public static RequestSpecification getPostPutBatchRequestNoAuth(String url) throws JsonProcessingException{
	
		request =  
			RestAssured
				.given()					
					.contentType(ContentType.JSON)					
					.baseUri(url);	

	return request;
}

public static List<RequestSpecification> getPostPutBatchRequestsDD(String url, String token, String type) throws IOException {
	 String bDes;
	 int classes;
	 String bName;
	 int pId;
	 String bStatus;
	 
	 ExcelReader excelReader = new ExcelReader();
	 List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "ETEPositiveTestData");
       List<RequestSpecification> requestSpecifications = new ArrayList<>();
       for (Map<String, String> row : testData) {
    	   
    	   if(type.toLowerCase()=="post") {
           bDes = row.get("batchDescription"); // Extract fields from each row
           String classesStr = row.get("NoOfClasses");
           classes = 0; // Default value in case of null or conversion failure
           if (classesStr != null && !classesStr.isEmpty()) {
               try {
                   classes = Integer.parseInt(classesStr.split("\\.")[0]);
               } catch (NumberFormatException e) {
                   System.err.println("Error converting NoOfClasses to int: " + e.getMessage());
               }
           }
           bName = dynamicGenerator.generateBatchName();
           pId = Integer.parseInt(Env_Var.programID); 
           bStatus = row.get("batchStatus");
           PoststatusList.add(row.get("ExpectedStatusCodePost"));
    	   }
    	   
    	   else {bDes = row.get("updateBatchDescription"); // Extract fields from each row
    	         String classesStr = row.get("updateNoOfClasses");
    	         classes = 0; // Default value in case of null or conversion failure
    	         if (classesStr != null && !classesStr.isEmpty()) {
    	             try{
    	                   classes = Integer.parseInt(classesStr.split("\\.")[0]);
    	               } catch (NumberFormatException e) {
    	                   System.err.println("Error converting NoOfClasses to int: " + e.getMessage());
    	               }
    	           }
    	         bName = dynamicGenerator.generateBatchName();
    	         pId = Integer.parseInt(Env_Var.programID);
    	         bStatus = row.get("updateBatchStatus");
    	         PutstatusList.add(row.get("ExpectedStatusCodePut"));
    	   }    	   
           // Prepare request body
           String requestBody = prepareRequestBody(bDes, bName, classes, bStatus, pId);
           request =  
   				RestAssured
   					.given()
   						.headers("Authorization", token)
   						.contentType(ContentType.JSON)
   						.body(requestBody)
   						.baseUri(url);	
           requestSpecifications.add(request);		    		
   		
       }
       return requestSpecifications;
}

public static List<RequestSpecification> getPostBatchRequestsDDNegative(String url, String token) throws IOException {
	 
	ExcelReader excelReader = new ExcelReader();
	 List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "PostPutTestData-BatchJyo");
       List<RequestSpecification> requestSpecifications = new ArrayList<>();
       int columnCount = 0;
       // Iterate over each row of test data
       System.out.println("Number of rows in the Post Test Data are: "+ testData.size());
       for (Map<String, String> row : testData) {
           String bDes = row.get("batchDescription"); // Extract fields from each row
           String bName = row.get("batchName");
           if (columnCount < 3) {
           	bName = dynamicGenerator.generateBatchName(bName);    
           }
           columnCount++;
           
           String classesStr = row.get("NoOfClasses");
           int classes = 0; // Default value in case of null or conversion failure
           if (classesStr != null && !classesStr.isEmpty()) {
               try {
                   classes = Integer.parseInt(classesStr.split("\\.")[0]);
               } catch (NumberFormatException e) {
                   // Handle conversion failure
                   System.err.println("Error converting NoOfClasses to int: " + e.getMessage());
               }
           }
           String bStatus = row.get("batchStatus");
           String pIdStr = row.get("programId");
           int pId = 0; // Default value in case of null or conversion failure

           if (pIdStr != null && !pIdStr.isEmpty()) {
               try {
                   pId = Integer.parseInt(pIdStr.split("\\.")[0]);
               } catch (NumberFormatException e) {
                   
                   System.err.println("Error converting ProgramId to int: " + e.getMessage());
               }
           }
           PoststatusList.add(row.get("ExpectedStatusCodePost"));
    	   
           // Prepare request body
           String requestBody = prepareRequestBody(bDes, bName, classes, bStatus, pId);
           request =  
   				RestAssured
   					.given()
   						.headers("Authorization", token)
   						.contentType(ContentType.JSON)
   						.body(requestBody)
   						.baseUri(url);	
           requestSpecifications.add(request);		    		
   		
       }
       return requestSpecifications;
}

public static List<RequestSpecification> getPutBatchRequestsDDNegative(String url, String token) throws IOException {
	 
	ExcelReader excelReader = new ExcelReader();
	 List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "PostPutTestData-BatchJyo");
       List<RequestSpecification> requestSpecifications = new ArrayList<>();
//       int columnCount = 0;       // Iterate over each row of test data
       System.out.println("Number of rows in the Put Test Data are: "+ testData.size());
       for (Map<String, String> row : testData) {
           String bDes = row.get("updateBatchDescription"); // Extract fields from each row
           String bName = row.get("updateBatchName");
           
           String classesStr = row.get("updateNoOfClasses");
           int classes = 0; // Default value in case of null or conversion failure
           if (classesStr != null && !classesStr.isEmpty()) {
               try {
                   classes = Integer.parseInt(classesStr.split("\\.")[0]);
               } catch (NumberFormatException e) {
                   // Handle conversion failure
                   System.err.println("Error converting NoOfClasses to int: " + e.getMessage());
               }
           }
           String bStatus = row.get("updateBatchStatus");
           String pIdStr = row.get("updateProgramId");
           int pId = 0; // Default value in case of null or conversion failure

           if (pIdStr != null && !pIdStr.isEmpty()) {
               try {
                   pId = Integer.parseInt(pIdStr.split("\\.")[0]);
               } catch (NumberFormatException e) {
                   
                   System.err.println("Error converting ProgramId to int: " + e.getMessage());
               }
           }
           PutstatusList.add(row.get("ExpectedStatusCodePut"));
    	   
           // Prepare request body
           String requestBody = prepareRequestBody(bDes, bName, classes, bStatus, pId);
           request =  
   				RestAssured
   					.given()
   						.headers("Authorization", token)
   						.contentType(ContentType.JSON)
   						.body(requestBody)
   						.baseUri(url);	
           requestSpecifications.add(request);		    		
   		
       }
       return requestSpecifications;
}

private static String prepareRequestBody(String batchDesc, String bName, int classes, String bStatus, int pId) throws JsonProcessingException {
	
	BatchPojo bP = new BatchPojo(batchDesc,bName,classes,bStatus,pId);
	ObjectMapper objectMapper = new ObjectMapper(); 
	String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bP);
	System.out.println(requestBody);
   return requestBody;
}

public static List<Response> getPostBatchResponsesDD(List<RequestSpecification> requests) {
	
	List<Response> responses = new ArrayList<>();
	
	for (RequestSpecification request : requests) {
		response = request.when().post();
		responses.add(response);
		
		 if (response.path("batchId") != null) {
             batchID = response.path("batchId").toString();
             batchName = response.path("batchName").toString();
             programID = response.path("programId").toString();
             
             Env_Var.batchID = batchID;
             Env_Var.batchName = batchName;
             Env_Var.programID = programID;
             
             LoggerLoad.info("Created Batch Id is: "+ batchID );
             LoggerLoad.info("Created Batch Name is: "+ batchName );
             LoggerLoad.info("This Batch is created under the Program ID: "+ programID );
         }
	}
	return responses;
}

public static List<Response> getPutBatchResponsesDD(List<RequestSpecification> requests, String batchId) {
	
	List<Response> responses = new ArrayList<>();
	
	for (RequestSpecification request : requests) {
		response = request.when().put("/{batchId}",batchId);
		responses.add(response);
	}
	return responses;
}

public static List<Response> getPutBatchResponsesNegativeDD(List<RequestSpecification> requests, String batchId) {
	
	List<Response> responses = new ArrayList<>();
	
	for (RequestSpecification request : requests) {
		if(batchId != null) {
			response = request.when().put("/{batchId}",batchId);
			responses.add(response);
		}else {
			batchId = "9036";
			response = request.when().put("/{batchId}",batchId);
			responses.add(response);
		}
	}
	return responses;
}

public static Response getPostBatchResponse(RequestSpecification request) {
	response = request.when().post();	
	return response;
}

public static Response BatchResponseInvalidUrl(RequestSpecification request, String type) {
	
	switch (type.toLowerCase()) {
	case "post":
		response = request.when().post();
		break;
	case "put":
		response = request.when().put();
		break;
	case "get":
		response = request.when().get();
		break;
	case "delete":
		response = request.when().delete();
		break;
	default:
		System.out.println("Invalid request type");
		break;
	}
	return response;
}

public static void setBatchDetails(Response response) {
   
            if (response.path("batchId") != null) {
                batchID = response.path("batchId").toString();
                batchName = response.path("batchName").toString();
                programID = response.path("programId").toString();
                
                Env_Var.batchID = batchID;
                Env_Var.batchName = batchName;
                Env_Var.programID = programID;
                
                LoggerLoad.info("Created Batch Id is: "+ batchID );
                LoggerLoad.info("Created Batch Name is: "+ batchName );
                LoggerLoad.info("This Batch is created under the Program ID: "+ programID );
            }  
}

public static RequestSpecification getGetDeleteBatchRequest(String url, boolean Auth, String token) throws JsonProcessingException {
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

public static RequestSpecification getGetDeleteBatchRequestNoAuth(String url) throws JsonProcessingException {
		request =  
				RestAssured
					.given()
						.contentType(ContentType.JSON)						
						.baseUri(url);
	
	return request;
}

public static Response getGetPutDeleteBatchResponsePositive(RequestSpecification request, String type, String IdorName ) {
	
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

public static List<Response> getGetBatchResponsesDD(String by, String token, String url ) throws IOException {
	String bID = null;
	String pID = null;
	String bName = null;
	
	List<Response> responses = new ArrayList<>();
	ExcelReader excelReader = new ExcelReader();
	List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "GetDeleteTestData-BatchJyo");
	System.out.println("Number of rows in the Test Data are: "+ testData.size());
	for (Map<String, String> row : testData) {
    	
    	request =  
    			RestAssured
    				.given()
    					.headers("Authorization", token)
    					.contentType(ContentType.JSON)						
    					.baseUri(url);
    	
   		   if( by.toLowerCase()=="batchid") {
   			   
   			   bID = row.get("BatchID"); // Extract fields from each row  
   			   if (!bID.contains(".")) {
   				   System.out.println("String Batch Id from excel is: "+ bID);
   				   response = request.when().get("/{bID}", bID);                  
   			   } else {
   				   int batchid = Integer.parseInt(bID.split("\\.")[0]);
   				   bID = Integer.toString(batchid); 
   				   System.out.println("String Batch Id from excel is: "+ bID);
   				   response = request.when().get("/{bID}", bID);            	
   			   	}           
   		   }
   		   else if( by.toLowerCase()=="programid") {
   			pID = row.get("ProgramID"); 
   			if (!pID.contains(".")) {
   				System.out.println("String Program Id from excel is: "+ pID);
   				response = request.when().get("/{pID}",pID);
            } else {
            	int programid = Integer.parseInt(pID.split("\\.")[0]);
   	            pID = Integer.toString(programid); 
   	            System.out.println("String Program Id from excel is: "+ pID);
   	            response = request.when().get("/{pID}",pID);          	
            }
       	   }
   			
   		   else if( by.toLowerCase()=="batchname") {
   			bName = row.get("BatchName");  
   			if (!bName.contains(".")) {
   				System.out.println("String Batch Name from excel is: "+ bName);
   				response = request.when().get("/{bName}",bName);
            } else {
            	int batchName = Integer.parseInt(bName.split("\\.")[0]);
            	bName = Integer.toString(batchName); 
            	System.out.println("String Batch Name from excel is: "+ bName);
   	            response = request.when().get("/{bName}",bName);            	
            }
           
       	}
   	   batchIDstatusList.add(row.get("ExpectedStatusbatchID"));
   	   batchNamestatusList.add(row.get("StatusGetBName"));
   	   programIDstatusList.add(row.get("ExpectedStatusProgramID"));   	
   	   
   	   responses.add(response);
    }
	return responses;
}

public static List<Response> getDeleteBatchResponsesDD(String token, String url ) throws IOException {
	String bID = null;
	
	List<Response> responses = new ArrayList<>();
	ExcelReader excelReader = new ExcelReader();
	List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "GetDeleteTestData-BatchJyo");
	System.out.println(testData.size());
	for (Map<String, String> row : testData) {    	
    	request =  
    			RestAssured
    				.given()
    					.headers("Authorization", token)
    					.contentType(ContentType.JSON)						
    					.baseUri(url);
   			   
   			   bID = row.get("BatchID"); // Extract fields from each row  
   			   if (!bID.contains(".")) {
   				   System.out.println("String Batch Id from excel is: "+ bID);
   				   response = request.when().delete("/{bID}", bID);                  
   			   } else {
   				   int batchid = Integer.parseInt(bID.split("\\.")[0]);
   				   bID = Integer.toString(batchid); 
   				   System.out.println("String Batch Id from excel is: "+ bID);
   				   response = request.when().delete("/{bID}", bID);            	
   			   	}           
   		   
   	   batchIDstatusList.add(row.get("ExpectedStatusbatchID"));
   	   responses.add(response);
    }
	return responses;
}

public static Response getBatchResponse(RequestSpecification request) {
	response = request.when().get();
	return response;
}

public static RequestSpecification getPutBatchRequest(String url, String token) throws JsonProcessingException{
	
	String batchName = Env_Var.batchName;

	try {
		BatchPojo bP = new BatchPojo("SDET",batchName,15,"Active",16228);
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

public static Response getGetDeleteBatchResponseNegative(RequestSpecification request, String UserIdorName, String type ) {
	switch (type.toLowerCase()) {
	case "put":
		response = request.when().put("/{UserIdorName}",UserIdorName);
		break;
	case "get":
		response = request.when().get("/{UserIdorName}",UserIdorName);
		break;
	case "delete":
		response = request.when().delete("/{UserIdorName}",UserIdorName);
		break;
	default:
		System.out.println("Invalid request type");
		break;
	}				
	return response;
}

}
