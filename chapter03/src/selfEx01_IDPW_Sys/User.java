package selfEx01_IDPW_Sys;

public class User {

	private int userNum;
	private String userId; // essential
	private String userPassword; // essential
	private String userName; // essential

	private String phoneNum; // optinal

	// 생성자
	public User(int userSerialNum, String userId, String userPassword, String name, String phoneNum) {

		this.userNum = userSerialNum;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = name;
		this.phoneNum = phoneNum;

	}

	public int getUseNum() {
		return userNum;
	}

	public void setUseNum(int useNum) {
		this.userNum = useNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public String toString() {
		return "User [useNum=" + userNum + ", userId=" + userId + ", userPassword=" + userPassword + ", userName="
				+ userName + ", phoneNum=" + phoneNum + "]";
	}

} // end of class
