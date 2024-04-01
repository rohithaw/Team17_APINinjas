package lms.payload;

import java.util.List;
public class UserPojo {
	
    private String userComments;
    private String userEduPg;
    private String userEduUg;
    private String userFirstName;
    private String userUserId;
    private String userLastName;
    private String userLinkedinUrl;
    private String userLocation;
    private UserLoginPojo userLogin;
    private String userMiddleName;
    private long userPhoneNumber;
    private List<UserRoleMapPojo> userRoleMaps;
    private String userTimeZone;
    private String userVisaStatus;
    private String userLoginEmail;
    private List<String>userRoleList;
    public UserPojo() {
    	
    }
    public UserPojo(String uComments, String Pg, String Ug, String fName, String uId, String lName,
    		String LinkedinUrl, String uLocation, UserLoginPojo uLogin, String uMidName,
    		long phone,  List<UserRoleMapPojo> uRoleMaps, String uTime, String uVisaStatus ) {
    	
    	setUserComments(uComments);
    	setUserEduPg(Pg);
    	setUserEduUg(Ug);
    	setUserFirstName(fName);
    	setUserUserId(uId);
    	setUserLastName(lName);
    	setUserLinkedinUrl(LinkedinUrl);
    	setUserLocation(uLocation);
    	setUserLogin(uLogin);
    	setUserMiddleName(uMidName);
    	setUserPhoneNumber(phone);
    	setUserRoleMaps(uRoleMaps);
    	setUserTimeZone(uTime);
    	setUserVisaStatus(uVisaStatus);
    	
    }
    public String getUserComments() {
		return userComments;
	}
	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}
	public String getUserEduPg() {
		return userEduPg;
	}
	public void setUserEduPg(String userEduPg) {
		this.userEduPg = userEduPg;
	}
	public String getUserEduUg() {
		return userEduUg;
	}
	public void setUserEduUg(String userEduUg) {
		this.userEduUg = userEduUg;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public String getUserUserId() {
		return userUserId;
	}
	public void setUserUserId(String userUserId) {
		this.userUserId = userUserId;
	}
	
	
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserLinkedinUrl() {
		return userLinkedinUrl;
	}
	public void setUserLinkedinUrl(String userLinkedinUrl) {
		this.userLinkedinUrl = userLinkedinUrl;
	}
	public String getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	public String getUserMiddleName() {
		return userMiddleName;
	}
	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}
	public long getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(long phone) {
		this.userPhoneNumber = phone;
	}
	public String getUserTimeZone() {
		return userTimeZone;
	}
	public void setUserTimeZone(String userTimeZone) {
		this.userTimeZone = userTimeZone;
	}
	public String getUserVisaStatus() {
		return userVisaStatus;
	}
	public void setUserVisaStatus(String userVisaStatus) {
		this.userVisaStatus = userVisaStatus;
	}
	public UserLoginPojo getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLoginPojo userLogin) {
		this.userLogin = userLogin;
	}
	public List<UserRoleMapPojo> getUserRoleMaps() {
		return userRoleMaps;
	}
	public void setUserRoleMaps(List<UserRoleMapPojo> userRoleMaps) {
		this.userRoleMaps = userRoleMaps;
	}
	public String getUserLoginEmail() {
		return userLoginEmail;
	}
	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}
	public List<String> getUserRoleList() {
		return userRoleList;
	}
	public void setUserRoleList(List<String> userRoleList) {
		this.userRoleList = userRoleList;
	}
	
	
}
