package ch05;

public interface UserInfoDao {
	
	//CRUD개념탑재

	// 매개변수 여러번 쓰는것을 userinfo타입으로 통으로 받음
	void insertUserInfo(UserInfo info); // public abstract 생략
	void updateUserInfo(UserInfo info);
	void deleteUserInfo(String userId); // Id만 지우면 유저정보 다 삭제
	
} // end of Interface
