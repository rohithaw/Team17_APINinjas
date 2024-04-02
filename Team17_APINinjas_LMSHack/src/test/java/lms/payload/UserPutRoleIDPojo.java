package lms.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPutRoleIDPojo {
	
	@JsonIgnore
	private String userId;
	
	private List<String> userRoleList;
	
	public UserPutRoleIDPojo() {
		
	}
	
	public UserPutRoleIDPojo(List<String> userRList) {
		setUserRoleList(userRList);
	}

	public List<String> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<String> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	

}
