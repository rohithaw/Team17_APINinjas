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
	public static String PutNegProgramByProgID_Url = base_url+"/putprogram/16902";
	public static String PutProgramByProgID_InvalidUrl = Invalid_base_url+"/putprogram";
	public static String PutProgramByProgID_InvalidEP = base_url+"/Putprograms";
	
	//DELETE Program By ProgramID
	public static String DeleteProgramByProgID_Url = base_url+"/deletebyprogid";
	public static String DeleteProgramByProgID_InvalidUrl = base_url+"/deletebyprogid";		
	public static String DeleteProgramByProgID_InvalidEP = base_url+"/DeletebyprogiD";	
	
	//DELETE Program By ProgramName
	public static String DeleteProgramByProgName_Url = base_url+"/deletebyprogname";
	public static String DeleteProgramByProgName_InvalidUrl = base_url+"/deletebyprogname";		
	public static String DeleteProgramByProgName_InvalidEP = base_url+"/DeletebyProgname";	
		
	//User
	public static String GetUserRoles_Url = base_url+"/roles";
	public static String GetAllUsers_Url = base_url+"/users";
	public static String GetUserbyID_Url = base_url+"/users";
	public static String GetUserbyActiveUser_Url = base_url+"/users/activeUsers";
	//public static String GetUserbyStatus_Url = base_url+"/users/byStatus?id=all";
	public static String GetUserbyStatus_Url = base_url+"/users/byStatus?id";
	public static String GetUserbyBatchID_Url = base_url+"/users/programBatch";
	public static String GetUserbyProgID_Url = base_url+"/users/programs";
	public static String GetUserwithRoles_Url = base_url+"/users/roles";
	public static String GetUserbyRoleID_Url = base_url+"/users/roles";
	public static String GetUserbyFilterUser_Url = base_url+"/v2/users";
	
	//Delete User
	public static String DeleteUserbyUserID_Url = base_url+"/users";
	
	
	//UserBatchProgram Module
	public static String PutUserProgBatch_Url=base_url+"/users/roleProgramBatchStatus";
	
	
	
}
