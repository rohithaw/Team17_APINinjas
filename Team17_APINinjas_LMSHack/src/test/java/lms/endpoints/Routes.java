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
		
		//User Module:

}
