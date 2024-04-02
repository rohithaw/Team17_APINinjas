package lms.endpoints;

import lms.utilities.PropertiesFile;

public class Routes {
	
	public static String base_url  = PropertiesFile.readPropertiesFile("base_url");
	public static String Invalid_base_url = PropertiesFile.readPropertiesFile("Invalid_base_url");
	
	//USER LOGIN MODULE
	//POST LOGIN
	
	public static String Login_Url=base_url+"/login";
	public static String Login_InvalidUrl= Invalid_base_url+"/login";
	public static String Login_InvalidERP = base_url+"/Login";
	
	//PROGRAM MODULE
	//POST PROGRAM
	public static String CreateProgram_Url = base_url+"/saveprogram";
	public static String CreateProgram_InvalidUrl= Invalid_base_url;
	public static String CreateProgram_InvalidERP = base_url+"/SaveProgram";
	
	
    //GET ALL PROGRAM
	public static String GetProgram_Url = base_url+"/allPrograms";
	public static String GetProgram_InvalidUrl = Invalid_base_url+"/allPrograms";
	public static String GetProgram_InvalidEP = base_url+"/AllProgramss";

	//GET Program BY PROGRAMID
	public static String GetProgramByProgramID_Url = base_url+"/programs";
	public static String GetProgramByProgramID_InvalidUrl = Invalid_base_url+"/programs";
	public static String GetProgramByProgramID_InvalidEP = base_url+"/Program";
	
	
	//GET PRogram By PROGRAM WITH USERS
	public static String GetProgramwithUsers_Url = base_url+"/allProgramsWithUsers";
	public static String GetProgramwithUsers_InvalidUrl = Invalid_base_url+"/allProgramsWithUsers";
	public static String GetProgramwithUsers_InvalidEP = base_url+"/AllProgramss";
	
	//PUT program By PROGRAMNAME
	public static String PutProgramByProgName_Url = base_url+"/program";
	public static String PutProgramByProgName_InvalidUrl = Invalid_base_url+"/program";
	public static String PutProgramByProgName_InvalidEP = base_url+"/pPrograms";
	
	//PUT program By PROGRAMID
	public static String PutProgramByProgID_Url = base_url+"/putprogram";
	public static String PutNegProgramByProgID_Url = base_url+"/putprogram";
	public static String PutProgramByProgID_InvalidUrl = Invalid_base_url+"/putprogram";
	public static String PutProgramByProgID_InvalidEP = base_url+"/Putprograms";
	
	//DELETE Program By ProgramID
	public static String DeleteProgramByProgID_Url = base_url+"/deletebyprogid";
	public static String DeleteProgramByProgID_InvalidUrl = Invalid_base_url+"/deletebyprogid";		
	public static String DeleteProgramByProgID_InvalidEP = base_url+"/DeletebyprogiD";	
	
	//DELETE Program By ProgramName
	public static String DeleteProgramByProgName_Url = base_url+"/deletebyprogname";
	public static String DeleteProgramByProgName_InvalidUrl = Invalid_base_url+"/deletebyprogname";		
	public static String DeleteProgramByProgName_InvalidEP = base_url+"/DeletebyProgname";	
		
	//User
	public static String GetUserRoles_Url = base_url+"/roles";
	public static String GetUserRoles_InvalidEP = base_url+"/Roles";
	public static String GetUserRoles_InvalidUrl =Invalid_base_url+"/roles";
	
	public static String GetAllUsers_Url = base_url+"/users";
	public static String GetAllUsers_InvalidEP = base_url+"/Users";
	public static String GetAllUsers_InvalidUrl = Invalid_base_url+"/users";
	
	
	public static String GetUserbyID_Url = base_url+"/users";
	public static String GetUserbyID_InvalidEP = base_url+"/Users";
	public static String GetUserbyID_InvalidUrl = Invalid_base_url+"/users";
	
	
	
	public static String GetUserbyActiveUser_Url = base_url+"/users/activeUsers";
	public static String GetUserbyActiveUse_InvalidEP = base_url+"/users/ActiveUsers";
	public static String GetUserbyActiveUse_InvalidUrl = Invalid_base_url+"/users/activeUsers";
	
	
	//public static String GetUserbyStatus_Url = base_url+"/users/byStatus?id=all";
	public static String GetUserbyStatus_Url = base_url+"/users/byStatus?id";
	public static String GetUserbyStatus_InvalidEP = base_url+"/users/ByStatus?id";
	public static String GetUserbyStatus_InvalidUrl = Invalid_base_url+"/users/byStatus?id";
	
	public static String GetUserbyBatchID_Url = base_url+"/users/programBatch";
	public static String GetUserbyBatchID_InvalidEP = base_url+"/users/ProgramBatch";
	public static String GetUserbyBatchID_InvalidUrl = Invalid_base_url+"/users/programBatch";
	
	
	public static String GetUserbyProgID_Url = base_url+"/users/programs";
	public static String GetUserbyProgID_InvalidEP = base_url+"/users/Programs";
	public static String GetUserbyProgID_InvalidUrl = Invalid_base_url+"/users/programs";
	
	
	public static String GetUserwithRoles_Url = base_url+"/users/roles";
	public static String GetUserwithRoles_InvalidEP = base_url+"/users/Roles";
	public static String GetUserwithRoles_InvalidUrl = Invalid_base_url+"/users/roles";
	
	
	public static String GetUserbyRoleID_Url = base_url+"/users/roles";
	public static String GetUserbyRoleID_InvalidEP = base_url+"/users/Roles";
	public static String GetUserbyRoleID_InvalidUrl  = Invalid_base_url+"/users/roles";
	
	
	
	public static String GetUserbyFilterUser_Url = base_url+"/v2/users";
	public static String GetUserbyFilterUser_InvalidEP = base_url+"/v2/Users";
	public static String GetUserbyFilterUser_InvalidUrl = Invalid_base_url+"/v2/users";
	
	
	
	
	//Delete User
	public static String DeleteUserbyUserID_Url = base_url+"/users";
	public static String DeleteUserbyUserID_InvalidEP = base_url+"/Users";
	public static String DeleteUserbyUserID_InvalidUrl = Invalid_base_url+"/users";
	
	
	//UserBatchProgram Module
	public static String PutUserProgBatch_Url=base_url+"/users/roleProgramBatchStatus";
	
	
	
}
