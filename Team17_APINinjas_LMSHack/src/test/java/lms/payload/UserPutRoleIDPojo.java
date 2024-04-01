package lms.payload;

import java.util.List;

public class UserPutRoleIDPojo {
	
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

}
