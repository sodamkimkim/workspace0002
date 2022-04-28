package selfEx01_IDPW_Sys;

import java.util.ArrayList;

public interface UserDao {

	// 메뉴 -> 1. 유저정보 등록 | 2. 유저정보 조회(selected user) | 3. 유저 전부 조회 | 4. 유저정보 수정 | 5. 유저 정보 삭제 | 0. 프로그램 종료

	// 유저정보 등록
	void addUser(User user);
	
	// selectedUser 조회
	void readSelectedUserInfo(String userId, String userPassword);
	
	// All정보 조회
	void readAllUserInfo(String ADMINISTRATOR_ID, String ADMINISTRATOR_PWD);
	
	// 유저정보 수정
	void updateUserInfo(String userId, User user);
	
	// selecteduser 정보 삭제
	void deleteUserInfo(String userId, String userPassword);
	
	int getindexById(String userId);
	int getindexByPw(String userPassword);
	
	ArrayList<User> getArrayList();
	
}
