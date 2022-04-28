package ch05_1_h;

public class UserInfo {

	private String userId;
	private String password;
	private String userName;
	
	public UserInfo(String userId, String password, String userName) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", password=" + password + ", userName=" + userName + "]";
	}
}
