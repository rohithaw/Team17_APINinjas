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
	
	//Logout Get request
	public static String Logout_Url = base_url+"/logoutlms";	

	//Batch Module:
	//POST Create Batch
	public static String CreateBatch_Url = base_url+"/batches";	
	public static String CreateBatch_InvalidUrl = Invalid_base_url+"/batches";
	public static String CreateBatch_InvalidEP = base_url+"/Batch";

	//GET All Batches
	public static String GetBatches_Url = base_url+"/batches";
	public static String GetBatchesSearch_Url = base_url+"/batches?batch";
	public static String GetBatches_InvalidUrl = Invalid_base_url+"/batches";
	public static String GetBatches_InvalidEP = base_url+"/Batch";

	//GET Batch by BatchID
	public static String GetBatchID_InvalidUrl = Invalid_base_url+"/batches/batchId/8636";
	public static String GetBatchID_InvalidEP = base_url+"/batchId/";
	public static String GetBatchID_ID = base_url+"/batches/batchId";

	//GET Batch by ProgramID
	public static String GetProgramID_InvalidUrl = Invalid_base_url+"/batches/program/16766";
	public static String GetProgramID_InvalidEP = base_url+"/program/";
	public static String GetProgramID_ID = base_url+"/batches/program";

	//GET Batch by BatchName
	public static String GetBatchName_InvalidUrl = Invalid_base_url+"/batches/batchName/March24-ApINinjas-NinjaTesters-QA01-001";
	public static String GetBatchName_InvalidEP = base_url+"/batchName/";
	public static String GetBatchName_BatchName = base_url+"/batches/batchName";

	//PUT Update Batch
	public static String UpdateBatch_InvalidUrl = Invalid_base_url+"/batches/8636";
	public static String UpdateBatch_InvalidEP = base_url+"/batch/";
	public static String UpdateBatch_ID = base_url+"/batches";

	//DELETE Batch 
	public static String DeleteBatch_InvalidUrl = Invalid_base_url+"/batches/8508";
	public static String DeleteBatch_InvalidEP = base_url+"/batch/";
	public static String DeleteBatch_ID = base_url+"/batches";

	// Program Module:
	//POST PROGRAM
	public static String CreateProgram_Url = base_url+"/saveprogram";
	public static String CreateProgram_InvalidUrl= Invalid_base_url+"/saveprogram";
	public static String CreateProgram_InvalidERP = base_url+"/SaveProgram";


	//GET ALL PROGRAM
	public static String GetProgram_Url = base_url+"/allPrograms";
	public static String GetProgram_InvalidUrl = Invalid_base_url+"/allPrograms";
	public static String GetProgram_InvalidEP = base_url+"/AllProgramss";

	//GET Program BY PROGRAMID
	public static String GetProgramByProgramID_Url = base_url+"/programs";
	public static String GetProgramByProgramID_InvalidUrl = Invalid_base_url+"/programs/{{programId}}";
	public static String GetProgramByProgramID_InvalidEP = base_url+"/Program/{programId}";


	//GET PRogram By PROGRAM WITH USERS
	public static String GetProgramwithUsers_Url = base_url+"/allProgramsWithUsers";
	public static String GetProgramwithUsers_InvalidUrl = Invalid_base_url+"/allProgramsWithUsers";
	public static String GetProgramwithUsers_InvalidEP = base_url+"/AllProgramss";

	//PUT program By PROGRAMNAME
	public static String PutProgramByProgName_Url = base_url+"/program";
	public static String PutProgramByProgName_InvalidUrl = Invalid_base_url+"/program/{programName}";
	public static String PutProgramByProgName_InvalidEP = base_url+"/pPrograms/{programName}";

	//PUT program By PROGRAMID
	public static String PutProgramByProgID_Url = base_url+"/putprogram";
	public static String PutProgramByProgID_InvalidUrl = Invalid_base_url+"/putprogram/{programId}";
	public static String PutProgramByProgID_InvalidEP = base_url+"/Putprograms/{programId}";

	//DELETE Program By ProgramID
	public static String DeleteProgramByProgID_Url = base_url+"/deletebyprogid";
	public static String DeleteProgramByProgID_InvalidUrl = base_url+"/deletebyprogid/{programId}";		
	public static String DeleteProgramByProgID_InvalidEP = base_url+"/DeletebyprogiD/{programId}";	

	//DELETE Program By ProgramName
	public static String DeleteProgramByProgName_Url = base_url+"/deletebyprogname";
	public static String DeleteProgramByProgName_InvalidUrl = base_url+"/deletebyprogname/{programName}";		
	public static String DeleteProgramByProgName_InvalidEP = base_url+"/DeletebyProgname/{programName}";

	//User Module:
	//POST Create User
	public static String CreateUser_Url = base_url+"/users/roleStatus";

	//PUT Update User
	public static String UpdateUser_Url = base_url+"/users/{userId}";
	public static String UpdateLoginStatus_Url = base_url+"/users/userLogin/{userId}";
	public static String UpdateRoleProgramBatchStatus_Url = base_url+"/users/roleProgramBatchStatus/{userId}";

	//PUT User RoleID
	public static String PutUserRID_Url = base_url+"/users/roleId";
	public static String PutUserRID_InvalidUrl = Invalid_base_url+"/users/roleId";
	public static String PutUserRID__InvalidEP = base_url+"/uroleID";

	//PUT User Role Status
	public static String PutUserRStatus_Url = base_url+"/users/roleStatus";
	public static String PutUserRStatus_InvalidUrl = Invalid_base_url+"/users/roleStatus";
	public static String PutUserRStatus__InvalidEP = base_url+"/roleuse";

	//Get User
	public static String GetUserRoles_Url = base_url+"/roles";
	public static String GetAllUsers_Url = base_url+"/users";
	public static String GetUserbyID_Url = base_url+"/users";
	public static String GetUserbyActiveUser_Url = base_url+"/users/activeUsers";
	public static String GetUserbyStatus_Url = base_url+"/users/byStatus?id";
	public static String GetUserbyBatchID_Url = base_url+"/users/programBatch";
	public static String GetUserbyProgID_Url = base_url+"/users/programs";
	public static String GetUserwithRoles_Url = base_url+"/users/roles";
	public static String GetUserbyRoleID_Url = base_url+"/users/roles";
	public static String GetUserbyFilterUser_Url = base_url+"/v2/users";
	
	//Delete User
	public static String DeleteUserbyUserID_Url = base_url+"/users";

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

}
