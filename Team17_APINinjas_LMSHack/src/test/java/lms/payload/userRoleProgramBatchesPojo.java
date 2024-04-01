package lms.payload;

public class userRoleProgramBatchesPojo {
	
    Integer batchId;
    String userRoleProgramBatchStatus;
    
    
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	public String getUserRoleProgramBatchStatus() {
		return userRoleProgramBatchStatus;
	}
	public void setUserRoleProgramBatchStatus(String userRoleProgramBatchStatus) {
		this.userRoleProgramBatchStatus = userRoleProgramBatchStatus;
	}
	
	
	 public userRoleProgramBatchesPojo() {
			
		}
		
		
		public userRoleProgramBatchesPojo(Integer batchId,String userRoleProgramBatchStatus)
		{
			setBatchId(batchId);
			setUserRoleProgramBatchStatus(userRoleProgramBatchStatus);
		}

}
