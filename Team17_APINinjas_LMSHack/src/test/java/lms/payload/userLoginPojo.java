package lms.payload;

public class userLoginPojo {

	String userLoginEmailId;
	String password;

		public userLoginPojo() {

		}

		public userLoginPojo(String email,String pwd) {
			setUserLoginEmailId(email);
			setPassword(pwd);
		}

		public String getUserLoginEmailId() {
			return userLoginEmailId;
		}

		public void setUserLoginEmailId(String userLoginEmailId) {
			this.userLoginEmailId = userLoginEmailId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}
