package lms.payload;

public class usersMapRoleDeleteUserIdPojo {

	String userId;
	
		
	public String getUserId() {
		System.out.println("retuen User id in ROLE MAP delete request " + userId);
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
		System.out.println("User id in ROLE MAP delete request " + userId);
	}


	public usersMapRoleDeleteUserIdPojo() {
		
	}
	
	public usersMapRoleDeleteUserIdPojo(String userid) {
		
		setUserId(userid);
		System.out.println("Setting User id in ROLE MAP delete request " + userid);
	}
}