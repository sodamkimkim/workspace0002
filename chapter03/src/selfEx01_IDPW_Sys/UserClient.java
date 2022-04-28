package selfEx01_IDPW_Sys;

public class UserClient {

	private static int userSerialNum = 0;

	public User createUserInfo(String userId, String userPassword, String name, String phoneNum) {
		userSerialNum++;
		return new User(userSerialNum, userId, userPassword, name, phoneNum);
	}
	

}
