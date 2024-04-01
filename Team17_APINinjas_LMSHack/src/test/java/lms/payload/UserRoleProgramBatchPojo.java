package lms.payload;

import java.util.List;

public class UserRoleProgramBatchPojo {
	
	private Integer programId;
    private String roleId;
    private String userId;
    private List<UserProgramBatchPojo> userRoleProgramBatches;

    
   public Integer getProgramId() {
		return programId;
	}

	public void setProgramId(Integer programId) {
		this.programId = programId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<UserProgramBatchPojo> getUserRoleProgramBatches() {
		return userRoleProgramBatches;
	}

	public void setUserRoleProgramBatches(List<UserProgramBatchPojo> userRoleProgramBatches) {
		this.userRoleProgramBatches = userRoleProgramBatches;
	}

   
}
