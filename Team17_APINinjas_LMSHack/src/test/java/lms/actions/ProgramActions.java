package lms.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lms.endpoints.Routes;
import lms.GlobalVariables.Env_Var;
import lms.payload.LoginPojo;
import lms.payload.ProgramPojo;
import lms.utilities.ExcelReader;
import lms.utilities.FileNameConstants;
import lms.utilities.LoggerLoad;
import lms.utilities.PropertiesFile;

public class ProgramActions extends ExcelReader {
	
	static RequestSpecification request;
	static Response response;
	static String programID;
	static String programName;
	static String UpdateprogramName;
	static ArrayList<String> statusList = new ArrayList<>();
	public static ArrayList<String> PoststatusList = new ArrayList<>();
	public static ArrayList<String> PutstatusList = new ArrayList<>();
	public static ArrayList<String> getDeleteIDstatusList = new ArrayList<>();
	public static ArrayList<String> getProgNamestatusList = new ArrayList<>();

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


public static RequestSpecification getPostProgramRequest(String url, String token) throws JsonProcessingException{
	
//	dynamicGenerator.resetCounter();
	//String baseBatchName = "March24-ApINinjas-QA-QA1-";
	String programName = dynamicGenerator.generateProgramName();
	System.out.println("Generated program name is"+ programName);

	try {
		ProgramPojo bP = new ProgramPojo("Prog for Team17",programName,"Active");
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

public static List<RequestSpecification> getPostPutProgramRequestsDD(String url, String token, String type) throws IOException {
	 String progDes;
	 String progName;
	 String progStatus;
	 
	 ExcelReader excelReader = new ExcelReader();
	 List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "ETEPositiveTestData");
      List<RequestSpecification> requestSpecifications = new ArrayList<>();
      System.out.println(testData.size());
      for (Map<String, String> row : testData) {
   	   
   	   if(type.toLowerCase()=="post") {
   		progDes = row.get("programDescription"); // Extract fields from each row

   		progName = dynamicGenerator.generateProgramName();
//        int pId = Integer.parseInt(Env_Var.programID);
   		progStatus = row.get("programStatus");
          PoststatusList.add(row.get("ExpectedStatusCodePost"));
   	   }
   	   
   	   else {progDes = row.get("UpdateprogramDescription"); // Extract fields from each row
   	         
   	progName = dynamicGenerator.generateProgramName();
   	       
   	progStatus = row.get("UpdateprogramStatus");
   	         PutstatusList.add(row.get("ExpectedStatusCodePut"));
   	   }    	   
          // Prepare request body
          String requestBody = prepareRequestBody(progDes, progName, progStatus);
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

public static List<RequestSpecification> getPostProgramRequestsDDNegative(String url, String token) throws IOException {
	 
	ExcelReader excelReader = new ExcelReader();
	 List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "PostPutTestData-Program");
       List<RequestSpecification> requestSpecifications = new ArrayList<>();
       //int columnCount = 0;
       // Iterate over each row of test data
       System.out.println("Number of rows in the Post Test Data are: "+ testData.size());
       for (Map<String, String> row : testData) {
           String progDes = row.get("programDescription"); // Extract fields from each row
           String progName = row.get("programName");
//           if (columnCount < 3) {
//        	   progName = DynamicGenerator.generateProgramName(progName);    
//           }
//           columnCount++;
           
          // }
           String progStatus = row.get("programStatus");      
           PoststatusList.add(row.get("ExpectedStatusCodePost"));
    	   
           // Prepare request body
           String requestBody = prepareRequestBody(progDes, progName, progStatus);
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

public static List<RequestSpecification> getPutProgramRequestsDDNegative(String url, String token) throws IOException {
	 
	ExcelReader excelReader = new ExcelReader();
	 List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "PostPutTestData-Program");
       List<RequestSpecification> requestSpecifications = new ArrayList<>();
//       int columnCount = 0;
       // Iterate over each row of test data
       System.out.println("Number of rows in the Put Test Data are: "+ testData.size());
       for (Map<String, String> row : testData) {
           String progDes = row.get("updateProgramDescription"); // Extract fields from each row
           String  progStatus = row.get("updateProgramStatus");
//           if (columnCount < 3) {
//           	bName = dynamicGenerator.generateBatchName(bName);    
//           }
//           columnCount++;
           
     
           String progName = row.get("updateprogramName");
          
           PutstatusList.add(row.get("ExpectedStatusCodePut"));
    	   
           // Prepare request body
           String requestBody = prepareRequestBody(progDes, progName, progStatus);
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


private static String prepareRequestBody(String programDesc, String programName, String progamStatus) throws JsonProcessingException {
	
	ProgramPojo progP = new ProgramPojo(programDesc,programName,progamStatus);
	ObjectMapper objectMapper = new ObjectMapper(); 
	String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(progP);
	System.out.println(requestBody);
  return requestBody;
}

public static List<Response> getPostProgramResponsesDD(List<RequestSpecification> requests) {
	
	List<Response> responses = new ArrayList<>();
	
	for (RequestSpecification request : requests) {
		response = request.when().post();
		responses.add(response);
		
		 if (response.path("programId") != null) {
			 programID = response.path("programId").toString();
		     programName = response.path("programName").toString();
		        
		        
		        Env_Var.programName = programName;
		        Env_Var.programID = programID;
            
		    LoggerLoad.info("Created Program Id is: "+  Env_Var.programID );
		    LoggerLoad.info("Created Program Name is: "+ Env_Var.programName );
           
        }
	}
	return responses;
}

public static List<Response> getPutIDProgramResponsesDD(List<RequestSpecification> requests, String progId) {
	
	List<Response> responses = new ArrayList<>();
	
	for (RequestSpecification request : requests) {
		response = request.when().put("/{programId}",programID);
		responses.add(response);
		
		 if (response.path("programId") != null) {
			 programID = response.path("programId").toString();
		     programName = response.path("programName").toString();
		        
		        
		        Env_Var.programName = programName;
		        Env_Var.programID = programID;
            
		        LoggerLoad.info("Created Program Id is: "+  Env_Var.programID );
		        LoggerLoad.info("Created Program Name is: "+ Env_Var.programName );
		 }

	}
	return responses;
}


public static List<Response> getPutNameProgramResponsesDD(List<RequestSpecification> requests, String progName) {
	
	List<Response> responses = new ArrayList<>();
	
	for (RequestSpecification request : requests) {
		response = request.when().put("/{programName}",programName);
		responses.add(response);
		
		 if (response.path("programId") != null) {
			 programID = response.path("programId").toString();
		     programName = response.path("programName").toString();
		        
		        
		        Env_Var.programName = programName;
		        Env_Var.programID = programID;
            
		        LoggerLoad.info("Created Program Id is: "+  Env_Var.programID );
		        LoggerLoad.info("Created Program Name is: "+ Env_Var.programName );
		 }

	}
	return responses;
}


public static Response getPostProgramResponse(RequestSpecification request) {
response = request.when().post();	
return response;
}

public static void setProgramDetails(Response response) {
	   
    if (response.path("programId") != null) {
        programID = response.path("programId").toString();
        programName = response.path("programName").toString();
        
        
        Env_Var.programName = programName;
        Env_Var.programID = programID;
        
        LoggerLoad.info("Created Program Id is: "+ programID );
        LoggerLoad.info("Created Program Name is: "+ programName );
        LoggerLoad.info("Created Envi Program Id is: "+  Env_Var.programID );
    }  
}

public static RequestSpecification getGetDeleteProgramRequest(String url, boolean Auth, String token) throws JsonProcessingException {
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

public static Response getGetPutDeleteProgramResponsePositive(RequestSpecification request, String type, String IdorName ) {
	
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


public static List<Response> getGetProgramResponsesDD(String by, String token, String url ) throws IOException {
	//String bID = null;
	String progID = null;
	String progName = null;
	
	List<Response> responses = new ArrayList<>();
	ExcelReader excelReader = new ExcelReader();
	List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "GetDeleteTestData-Program");
	System.out.println("Number of rows in the Test Data are: "+ testData.size());
	for (Map<String, String> row : testData) {
    	
    	request =  
    			RestAssured
    				.given()
    					.headers("Authorization", token)
    					.contentType(ContentType.JSON)						
    					.baseUri(url);
    	
   		   if( by.toLowerCase()=="programid") {
   			   
   			progID = row.get("ProgramID"); // Extract fields from each row  
   			   if (!progID.contains(".")) {
   				   System.out.println("String Program Id from excel is: "+ progID);
   				   response = request.when().get("/{bID}", progID);                  
   			   } else {
   				   int batchid = Integer.parseInt(progID.split("\\.")[0]);
   				progID = Integer.toString(batchid); 
   				   System.out.println("String Program Id from excel is: "+ progID);
   				   response = request.when().get("/{progID}", progID);            	
   			   	}           
   		   }
   			
   		   else if( by.toLowerCase()=="programName") {
   			progName = row.get("ProgramName");  
   			if (!progName.contains(".")) {
   				System.out.println("String Program Name from excel is: "+ progName);
   				response = request.when().get("/{progName}",progName);
            } else {
            	int programName = Integer.parseInt(progName.split("\\.")[0]);
            	progName = Integer.toString(programName); 
            	System.out.println("String Program Name from excel is: "+ progName);
   	            response = request.when().get("/{bName}",progName);            	
            }
           
       	}
   	   getDeleteIDstatusList.add(row.get("ExpectedStatusGetDeleteID"));
   	getProgNamestatusList.add(row.get("StatusGetProgName"));
   	   
   	   responses.add(response);
    }
	return responses;
}

public static List<Response> getDeleteProgramResponsesDD(String token, String url ) throws IOException {
	String bID = null;
	
	List<Response> responses = new ArrayList<>();
	ExcelReader excelReader = new ExcelReader();
	List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.EXCEL_TEST_DATA, "GetDeleteTestData-Program");
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
   				   response = request.when().get("/{bID}", bID);                  
   			   } else {
   				   int batchid = Integer.parseInt(bID.split("\\.")[0]);
   				   bID = Integer.toString(batchid); 
   				   System.out.println("String Batch Id from excel is: "+ bID);
   				   response = request.when().get("/{bID}", bID);            	
   			   	}           
   		   
   	   getDeleteIDstatusList.add(row.get("ExpectedStatusGetDeleteID"));  	   
   	   responses.add(response);
    }
	return responses;
}

public static Response getProgramResponse(RequestSpecification request) {
	response = request.when().get();
	return response;
}

public static RequestSpecification getPutProgramRequest(String url, String token) throws JsonProcessingException{
	
	String programName = Env_Var.programName;

	try {
		ProgramPojo progP = new ProgramPojo("Prog for Team17-updated",programName,"Active");
		ObjectMapper objectMapper = new ObjectMapper(); 
		String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(progP);		
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

public static Response getGetDeleteProgramResponseNegative(RequestSpecification request, String UserIdorName, String type ) {
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
