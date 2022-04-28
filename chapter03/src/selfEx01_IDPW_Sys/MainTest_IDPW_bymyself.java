package selfEx01_IDPW_Sys;

import java.util.ArrayList;
import java.util.Scanner;

import ch11.Book;

public class MainTest_IDPW_bymyself {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		UserDao userArrayList = new UserArrayList();
		UserClient userClient = new UserClient();

		// 1. 변수 초기화, 2. 반복문, 3. 후처리
		String selectedMenu = "";
		do {
			System.out.println("테스트 관리자정보: 아이디 - theka265  비번: 12341234");
			System.out.println("테스트 user정보: 아이디 - theka1  비번: 12341111");
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			System.out.println("1.User정보생성 2. User정보조회 3. AllUser정보조회 4. User정보수정 5. User정보삭제  0. 프로그램 종료");
			System.out.println(
					"---------------------------------------------------------------------------------------------------");

			selectedMenu = removeBlankString(scanner.nextLine());
			boolean pwdFlag = true;

			String tempPwd1 = null;
			String tempPwd2 = null;

			// 0. 프로그램 종료
			if (selectedMenu.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				scanner.close();

				// 1.User정보생성
			} else if (selectedMenu.equals("1")) {
				System.out.println("새로운 아이디입력: ");

				
				
				
				
				/**
				 * comment.. - 일단 필수적인 것만 만들어 놓고, 제출하고 - 나중에 ID & PW 조건 만들자. - 예를들어 not null &
				 * 8자 이상 not null 중복x
				 */
				String tempID = removeBlankString(scanner.nextLine());

				// 비번확인 반복문
				while (pwdFlag) {
					System.out.println("패스워드 입력: ");
					tempPwd1 = removeBlankString(scanner.nextLine());

					System.out.println("패스워드 확인: ");
					tempPwd2 = removeBlankString(scanner.nextLine());

					if (tempPwd1.equals(tempPwd2)) { // 패스워드 1,2 같으면
						System.out.println("user 이름 입력: ");
						String tempName = removeBlankString(scanner.nextLine());
						System.out.println("전화번호 입력: ");
						String tempPhone = removeBlankString(scanner.nextLine());
						User user = userClient.createUserInfo(tempID, tempPwd2, tempName, tempPhone);
						userArrayList.addUser(user);

						pwdFlag = false;
					} else {
						continue;

					}
				}

				// 비번 불일치

				// 2. User정보조회
			} else if (selectedMenu.equals("2")) {

				// id랑 비번 입력하면 해당 정보 다 보여줌
				System.out.println("user 아이디 입력: ");
				String tempID = removeBlankString(scanner.nextLine());
				System.out.println("user 비번 입력: ");
				String tempPwd = removeBlankString(scanner.nextLine());
				// 입력 id의 인덱스를 찾아서.
				// 그 해당 인덱스의 pwd랑 맞으면 정보 보여준다.

				userArrayList.readSelectedUserInfo(tempID, tempPwd);

				// 3. AllUser정보조회
			} else if (selectedMenu.equals("3")) {
				// 관리자만 조회할 수 있음

				System.out.println("관리자 아이디 입력 : ");
				String adId = removeBlankString(scanner.nextLine());

				System.out.println("관리자 비번 입력 : ");
				String adPw = removeBlankString(scanner.nextLine());

				userArrayList.readAllUserInfo(adId, adPw);

				// 4. User정보수정
			} else if (selectedMenu.equals("4")) {
				// 아이디입력, 패스워드 입력 맞으면 수정가능

				System.out.println("user 아이디 입력: ");
				String tempID = removeBlankString(scanner.nextLine());
				System.out.println("user 비번 입력: ");
				String tempPwd = removeBlankString(scanner.nextLine());
				// 입력 id의 인덱스를 찾아서.
				// 그 해당 인덱스의 pwd랑 맞으면 정보 보여준다.

				int index = userArrayList.getindexById(tempID);

				if (index != -1) { // 아이디 정보가 존재하면

					// 1. 해당 인덱스의 아이디 = 비번 일치여부에 따라
					// 2. selected - userInfo 보여주고
					userArrayList.readSelectedUserInfo(tempID, tempPwd);

					// 3. 새로운 정보를 입력받아서
					// 4. arraylist.update에 유저 id와 user를 던져준다.
					System.out.println("새로운 패스워드 : ");
					String newPwd = removeBlankString(scanner.nextLine());
					System.out.println("새로운 이름 : ");
					String newName = removeBlankString(scanner.nextLine());
					System.out.println("새로운 연락처 : ");
					String newPhone = removeBlankString(scanner.nextLine());

					// 5. User 객체를 새로 생성 후
					// 6. arraylist.update에 던져준다.
					User user = userClient.createUserInfo(tempID, newPwd, newName, newPhone);
					userArrayList.updateUserInfo(tempID, user);

					// 7. arraylist.update에서는 .set(index, user)로 정보를 변경해 준다.
				} else {
					System.out.println("index가 -1임. 일치하는 id가 없음");
				}

				// 5. User정보삭제
			} else if (selectedMenu.equals("5")) {
				System.out.println("삭제 하려는 user 아이디 입력: ");
				String tempID = removeBlankString(scanner.nextLine());
				System.out.println("비번 입력해야 삭제가능: ");
				String tempPwd = removeBlankString(scanner.nextLine());

				userArrayList.readSelectedUserInfo(tempID, tempPwd);
				userArrayList.deleteUserInfo(tempID, tempPwd);

				// 메뉴 - 잘못된 입력
			} else {
				System.out.println("잘못된 입력입니다.");
			}

		} while (!selectedMenu.equals("0"));

	} // end of main

	public static String removeBlankString(String str) {
		String result1 = str.trim();
		String result2 = result1.replace(" ", "");
		return result2;
	}

} // end of class
