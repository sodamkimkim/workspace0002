package selfEx01_IDPW_Sys;

import java.util.ArrayList;
import java.util.Scanner;

import ch11.Book;

public class UserArrayList implements UserDao {

	public static final String ADMINISTRATOR_ID = "theka265";
	public static final String ADMINISTRATOR_PWD = "12341234";
	private ArrayList<User> users = new ArrayList<User>();
	Scanner scanner = new Scanner(System.in);

	public UserArrayList() {
		User user1 = new User(1, "theka1", "12341111", "김소담1", "01050270221");
		User user2 = new User(2, "theka2", "12342222", "김소담2", "01050270222");
		User user3 = new User(3, "theka3", "12343333", "김소담3", "01050270223");
		User user4 = new User(4, "theka4", "12344444", "김소담4", "01050270224");
		User user5 = new User(5, "theka5", "12345555", "김소담5", "01050270225");

		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
	}

	// user를 ArrayList에 저장
	@Override
	public void addUser(User user) {
		users.add(user);
		System.out.println("새로운 user정보를 저장하였습니다.");
	}

	// user를 ArrayList에서 조회
	@Override
	public void readSelectedUserInfo(String userId, String userPassword) {

// userID의 인덱스를 받아서, 그 인덱스의 pwd와 비교해서 일치하면 출력해줌
		int index = users.indexOf(userId);
		if (index != -1) {
			System.out.println("index가 -1이 아님. ID와 Pwd일치여부 확인중");
			// 해당 인덱스의 pw와 userPassword값과 비교
			while (users.get(index).getUserPassword().equals(userPassword)) {
				System.out.println("해당 ID와 일치하는 Pwd발견하였음");
				System.out.println(users.get(index));
			}

		} else {
			System.out.println("index가 -1임. 일치하는 id가 없음");
		}

	}

	// user정보 all조회
	@Override
	public void readAllUserInfo(String ADMINISTRATOR_ID, String ADMINISTRATOR_PWD) {

		if (this.ADMINISTRATOR_ID.equals(ADMINISTRATOR_ID) && this.ADMINISTRATOR_PWD.equals(ADMINISTRATOR_PWD)) {
			System.out.println("----현재 저장된 유저정보 확인----");
			for (User user : users) {
				System.out.println(user);
			}
		} else {
			System.out.println("관리자 정보가 잘못되었습니다.");

		}
	}

	// user정보 수정
	@Override
	public void updateUserInfo(String userId, User user) {
		// 7. arraylist.update에서는 .set(index, user)로 정보를 변경해 준다.
		
		//여기서 인덱스는 userId가 가진 인덱스
		int index = users.indexOf(userId);
		users.set(index, user);

	}



	// user정보 삭제
	@Override
	public void deleteUserInfo(String userId, String userPassword) {
		int index = users.indexOf(userId);
		if (index != -1) {
			System.out.println("index가 -1이 아님. ID와 Pwd일치여부 확인중");
			// 해당 인덱스의 pw와 userPassword값과 비교
			while (users.get(index).getUserPassword().equals(userPassword)) {
				users.remove(index);
			}

		} else {
			System.out.println("id와 pwd가 일치하지 않습니다.");
		}
		
		
		
	}

	public int getindexById(String userId) {
		return users.indexOf(userId);
	}

	public int getindexByPw(String userPassword) {
		return users.indexOf(userPassword);
	}

	public ArrayList<User> getArrayList() {
		return users;
	}

} // end of class
