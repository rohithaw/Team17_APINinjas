package lms.payload;

public class UserRoleMapPojo {
	
    private String roleId;
    private String userRoleStatus;
    public UserRoleMapPojo() {
    	
    }
    public UserRoleMapPojo(String rId, String userRstatus) {
    	setRoleId(rId);
    	setUserRoleStatus(userRstatus);   	
    }
    public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserRoleStatus() {
		return userRoleStatus;
	}
	public void setUserRoleStatus(String userRoleStatus) {
		this.userRoleStatus = userRoleStatus;
	}
	  
}
