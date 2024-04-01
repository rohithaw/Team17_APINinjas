package lms.payload;

import java.util.List;

public class UserLoginPojo {
	
	private String loginStatus;
    private String password;
    private List<String> roleIds;
    private String status;
    private String userLoginEmail;
    
   /* public UserLoginPojo(String lstatus, String pwd, List<String> rIds, String status, String email) {
    	setLoginStatus(lstatus);
    	setPassword(pwd);
    	setRoleIds(rIds);
    	setStatus(status);
    	setUserLoginEmail(email);
    }*/
	public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserLoginEmail() {
		return userLoginEmail;
	}
	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}
}
