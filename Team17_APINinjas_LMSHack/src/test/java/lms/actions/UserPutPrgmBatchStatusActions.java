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
import lms.GlobalVariables.Env_Var;
import lms.endpoints.Routes;
import lms.payload.usersMapRoleGetAllPojo;
import lms.payload.usersMapRoleGetUserIdPojo;
import lms.payload.usersPutPrgmBatchStatusPojo;
import lms.payload.userLoginPojo;
import lms.utilities.ExcelReader;
import lms.utilities.FileNameConstants;
import lms.utilities.PropertiesFile;


public class UserPutPrgmBatchStatusActions {

//		static RequestSpecification request;
//		static Response response;
//		static ArrayList<String> statusList = new ArrayList<>();
//		
//		public static ArrayList<String> PoststatusList = new ArrayList<>();
//		public static ArrayList<String> PutstatusList = new ArrayList<>();
//		public static ArrayList<String> batchIDstatusList = new ArrayList<>();
//		public static ArrayList<String>  batchNamestatusList = new ArrayList<>();
//		public static ArrayList<String>  programIDstatusList = new ArrayList<>();
//
//		
//		
//	public static RequestSpecification putRPBMUserIdRequest(Integer programid, Integer batchid, String roleid, String status) throws JsonProcessingException {
//		
//		usersPutPrgmBatchStatusPojo uLP = new usersPutPrgmBatchStatusPojo(programid, batchid, roleid, status);
//			ObjectMapper objectMapper = new ObjectMapper(); 
//			String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uLP);		
//			
//		request = RestAssured
//				.given()
//					.headers("Authorization", Env_Var.token)
//					.contentType(ContentType.JSON)
//					.body(requestBody)
//					.baseUri(Routes.putUserRoleMap_Url);
//		
//			System.out.println("*********Request from putRPBMUserIdRequest***********");
//			System.out.println("Request " + request.log().body());
//			
//			return request;
//		}
//		
//		public static Response putUserRoleMapUserIdResponse(RequestSpecification request, String userid){
//			response = 
//				request
//					.when()
//						.put("/{userid}",Env_Var.userID);
//				
//			
//			System.out.println("*********Response from putUserRoleMapUserIdResponse***********");
//			System.out.println(response.print());
//			
//			return response;
//		}
//
//
//
//
//public static List<RequestSpecification> putRPBMUserIdRequestDD(String url, String token, String type) throws IOException {
//	 int prgmid = 0;
//	 int batchid = 0;
//	 String status = null;
//	 String roleid = null;
//	 String s;
//	 
//	 ExcelReader excelReader = new ExcelReader();
//	 List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.PutPrgmBatchStatusEXCEL_TEST_DATA, "PositiveTestDataPrgmBatchStatus");
//      List<RequestSpecification> requestSpecifications = new ArrayList<>();
//      for (Map<String, String> row : testData) {
//   	   
//   	   if(type.toLowerCase()=="put") {
//   		String pidStr = row.get("ProgramID"); 
//
//        if (pidStr != null && !pidStr.isEmpty()) {
//            try {
//            	prgmid = Integer.parseInt(pidStr.split("\\.")[0]);
//            } catch (NumberFormatException e) {
//                
//                System.err.println("Error converting ProgramId to int: " + e.getMessage());
//            }
//        }
//
//        String batchidStr = row.get("BatchID");
//          
//
//          if (batchidStr != null && !batchidStr.isEmpty()) {
//              try {
//                  batchid = Integer.parseInt(batchidStr.split("\\.")[0]);
//              } catch (NumberFormatException e) {
//                  
//                  System.err.println("Error converting BatchId to int: " + e.getMessage());
//              }
//          }
//
//          
//   		System.out.println("batch id " + batchid );
//          status = row.get("Status");
//          roleid = row.get("RoleID");
//          /////////////////////////////////////
//          ///////////////////////////////////////
//          ///////////////////////////////////////
//          
//      	Env_Var.userID = "U404";
//      	Env_Var.batchID = "8608";
//		Env_Var.programID = "16652";
//
//          ////////////////////////////////////////
//          /////////////////////////////////////////
//    		status = "Active";
//    		prgmid = Integer.parseInt(Env_Var.programID);
//    		batchid = Integer.parseInt(Env_Var.batchID);
//    		roleid = "R02";
//
//          PutstatusList.add(row.get("ExpectedStatusCodePost"));
//   	   }
//   	   
//   	   else {
//   		   System.out.println("It is not a put request");
//   	   }    	   
//          // Prepare request body
//          String requestBody = prepareRequestBody(prgmid, batchid, roleid, status);
//          request =  
//  				RestAssured
//  					.given()
//  						.headers("Authorization", Env_Var.token)
//  						.contentType(ContentType.JSON)
//  						.body(requestBody)
//  						.baseUri(url);	
//          requestSpecifications.add(request);		    		
//          
//          System.out.println("***********************************");
//          System.out.println("Request " + request.log().body());
//          
//      }
//      
//      
//      return requestSpecifications;
//}
//
//
//private static String prepareRequestBody(Integer prgmid, Integer batchid, String roleid, String status) throws JsonProcessingException {
//	
//	usersPutPrgmBatchStatusPojo uLP = new usersPutPrgmBatchStatusPojo(prgmid, batchid, roleid, status);
//	ObjectMapper objectMapper = new ObjectMapper(); 
//	String requestBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uLP);
//	
//	System.out.println("***********************************");
//	System.out.println(requestBody.toString());
//	
//   return requestBody;
//}
//
//
//public static List<Response> putProgramBatchStatusResponsesDD(List<RequestSpecification> requests, String userid) {
//	
//	List<Response> responses = new ArrayList<>();
//	
//	for (RequestSpecification request : requests) {
//		////////////////////
//		///////////////////////
//		//response = request.when().put("/{userid}",userid);
//		response = request.when().put("/{userid}",Env_Var.userID);
//		
//		System.out.println("Response is " + response.print());
//		responses.add(response);
//	}
//	
//	return responses;
//}
//
//
//public static List<RequestSpecification> putRPBMUserIdRequestDD_Neg(String url, String token) throws IOException {
//	int prgmid = 0;
//	int batchid = 0;
//	String status = null;
//	String roleid = null;
//	String s;
//
//	ExcelReader excelReader = new ExcelReader();
//
//	List<Map<String, String>> testData = excelReader.readTestDataFromExcel(FileNameConstants.PutPrgmBatchStatusEXCEL_TEST_DATA, "NegativeTestDataPrgmBatchStatus");
//
//	List<RequestSpecification> requestSpecifications = new ArrayList<>();
//
//	for (Map<String, String> row : testData) {
//		System.out.println("Inside For " + row.toString());
//
//		String pidStr = row.get("ProgramID"); 
//		System.out.println("pidStr " + pidStr);
//
//		if (pidStr != null && !pidStr.isEmpty()) {
//			try {
//				System.out.println("Inside Program id statement");
//
//				prgmid = Integer.parseInt(pidStr.split("\\.")[0]);
//			} catch (NumberFormatException e) {
//
//				System.err.println("Error converting ProgramId to int: " + e.getMessage());
//			}
//		}
//
//		String batchidStr = row.get("BatchID");
//		System.out.println("batchidStr " + batchidStr);  
//
//		if (batchidStr != null && !batchidStr.isEmpty()) {
//			try {
//				System.out.println("Inside Batch id statement");
//				batchid = Integer.parseInt(batchidStr.split("\\.")[0]);
//			} catch (NumberFormatException e) {
//
//				System.err.println("Error converting BatchId to int: " + e.getMessage());
//			}
//		}
//
//
//		System.out.println("batch id " + batchid );
//		status = row.get("Status");
//		roleid = row.get("RoleID");
//		
//		 /////////////////////////////////////
//        ///////////////////////////////////////
//        ///////////////////////////////////////
//        
//    	Env_Var.userID = "U404";
//    	Env_Var.batchID = "8608";
//		Env_Var.programID = "16652";
//
//        ////////////////////////////////////////
//        /////////////////////////////////////////
//  		status = "Active";
//  		prgmid = Integer.parseInt(Env_Var.programID);
//  		batchid = Integer.parseInt(Env_Var.batchID);
//  		roleid = "R02";
//
//		
//		
//		PutstatusList.add(row.get("ExpectedStatusCodePut"));
//	}
//
//
//	// Prepare request body
//	String requestBody = prepareRequestBody(prgmid, batchid, roleid, status);
//	
//	request =  
//			RestAssured
//			.given()
//			.headers("Authorization", Env_Var.token)
//			.contentType(ContentType.JSON)
//			.body(requestBody)
//			.baseUri(url);	
//	requestSpecifications.add(request);		    		
//
//	System.out.println("***********************************");
//	System.out.println("Request " + request.toString());
//	System.out.println("Request " + request.log().body());
//
//
//
//
//     return requestSpecifications;
//}
//
////No Auth Code for negative tests
//public static RequestSpecification PutPrgmBatchStatusRequestNoAuth(String url) throws JsonProcessingException{
//	
//	request =  
//		RestAssured
//			.given()					
//				.contentType(ContentType.JSON)					
//				.baseUri(url);	
//
//return request;
//}


}
