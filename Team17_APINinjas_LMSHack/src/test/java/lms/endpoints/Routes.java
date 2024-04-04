package lms.endpoints;

import lms.utilities.PropertiesFile;

public class Routes {
			public static String base_url = PropertiesFile.readPropertiesFile("base_url");
			public static String Invalid_base_url = PropertiesFile.readPropertiesFile("Invalid_base_url");
			
			//User Login Module:
			//POST Login
			public static String Login_Url = base_url+"/login";	
			public static String Login_InvalidUrl = Invalid_base_url+"/login";
			public static String Login_InvalidEP = base_url+"/Login";
			public static String Logout_Url = base_url+"/logoutlms";
			
			
			
			//Program Batch Status Role Map GET ALL
			//*****************************
			//Get All
			public static String adminGetAllRoleMap_Url = base_url+"/userRoleProgramBatchMap";
			//Invalid URL
			public static String adminGetAllRoleMap_InvalidUrl = Invalid_base_url+"/userRoleProgramBatchMap";
			//Invalid EP 
			public static String adminGetAllRoleMap_InvalidEP = base_url+"/userRoleProgramBatchMaps";
			
			
			
			//Program Batch Status Role Map GET USERID
			public static String userGetRoleMap_Url = base_url+"/userRoleProgramBatchMap";
			//Invalid URL
			public static String userGetRoleMap_InvalidUrl = Invalid_base_url+"/userRoleProgramBatchMap";
			//Invalid EP 
			public static String userGetRoleMap_InvalidEP = base_url+"/userRoleProgramBatchMaps";
			
			
			//Program Batch Status Role Map DELETE
			public static String deleteUserRoleMap_Url = base_url+"/userRoleProgramBatchMap/deleteAll";
			//Invalid URL
			public static String deleteUserRoleMap_InvalidUrl = Invalid_base_url+"/userRoleProgramBatchMap/deleteAll";
			//Invalid EP 
			public static String deleteUserRoleMap_InvalidEP = base_url+"/userRoleProgramBatchMap/deleteAlls";
			
			
			//Program Batch Status Role Map PUT
			public static String putUserRoleMap_Url = base_url + "/users/roleProgramBatchStatus";
			//Invalid URL
			public static String PutUserRoleMap_InvalidUrl = Invalid_base_url+"/StatusRoleMap";
			//Invalid EP 
			public static String PutUserRoleMap_InvalidEP = base_url+"/batch/";
			
			//Logout GET
			//Invalid URL
			public static String GetLogout_InvalidUrl = Invalid_base_url+"/logoutlms";
			//Invalid EP 
			public static String GetLogout_InvalidEP = base_url+"/logoutlms//";
			
			
			//Login POST
			//Invalid URL
			public static String GetLogin_InvalidUrl = Invalid_base_url+"/logoutlms";
			//Invalid EP 
			public static String GetLogin_InvalidEP = base_url+"/logoutlms//";
			
	}
	
