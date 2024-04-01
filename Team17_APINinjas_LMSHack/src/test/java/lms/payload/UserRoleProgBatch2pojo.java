package lms.payload;

import java.util.List;

public class UserRoleProgBatch2pojo {
	
	private Integer programId;
    private String roleId;
    private String userId;
    private List<userRoleProgramBatchesPojo> userRoleProgramBatches;

    
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

	public List<userRoleProgramBatchesPojo> getUserRoleProgramBatches() {
		return userRoleProgramBatches;
	}

	public void setUserRoleProgramBatches(List<userRoleProgramBatchesPojo> userRoleProgramBatches) {
		this.userRoleProgramBatches = userRoleProgramBatches;
	}

	
public UserRoleProgBatch2pojo() {
		
	}
	
	
	public UserRoleProgBatch2pojo(Integer programId,String roleId,String userId,List<userRoleProgramBatchesPojo> userRoleProgramBatches)
	{
		setProgramId(programId);
		setRoleId(roleId);
		setUserId(userId);
		setUserRoleProgramBatches(userRoleProgramBatches);
	}
   
}

