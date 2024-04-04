package lms.payload;

public class usersMapRoleGetUserIdPojo {

	String userId;
	
		
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public usersMapRoleGetUserIdPojo() {
		
	}
	
	public usersMapRoleGetUserIdPojo( String userid) {
		
		setUserId(userid);
	}
}