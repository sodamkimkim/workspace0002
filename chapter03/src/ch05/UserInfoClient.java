package ch05;

import java.util.Scanner;

public class UserInfoClient {

	public static final String MYSQL = "mysql";
	public static final String ORACLE = "oracle";

	public static void main(String[] args) {
		
		//UserInfo 스캐너로 받아서 흐름을 만들어 주세요.
		System.out.println("사용할 db를 입력해 주세요");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
	
		// 사용자한테 userInfo 정보를 받는다고 가정
		UserInfo info = new UserInfo();
		System.out.print("id : ");
		info.setUserId(scanner.nextLine());
		System.out.print("비번 : ");
		info.setPassword(scanner.nextLine());
		System.out.print("유저네임 : ");
		info.setUserName(scanner.nextLine());

		// 인터페이스 활용할 수 있다.

		// 1. mysql쓰는 A회사.
//		UserInfoMysqlDao mySqlDao = new UserInfoMysqlDao();
//		mySqlDao.insertUserInfo(info);
//		
//		// 2. Oracle쓰는 B회사
//		UserInfoOracleDao oracleDao = new UserInfoOracleDao();
//		oracleDao.insertUserInfo(info);

//		String str = new String("mysql");
		// 문자열을 비교할 때는 무조건 equals쓴다.
//		if (str == MYSQL) { // 문자열이 다릅니다. 출력 (왜냐면 '주소값'비교)
		// 실제로 값은 같지만
		// 1. equals는 문자열의 값을 비교한다.
		// 2. == 는 객체의 주소값을 비교한다.

//// if("mysql" == MYSQL) // 이거는 '상수풀 주소값'비교하니까 같게 나옴. // 상수풀은 문자열값같으면 같은주소값가진다.
//		if ("mysql".equals(MYSQL)) { // 문자열이 같습니다. 출력 (왜냐면 '문자열값'비교)
//			System.out.println("문자열이 같습니다.");
//		} else {
//			System.out.println("문자열이 다릅니다.");
//		}

//		UserInfoDao userInfoDao1 = new UserInfoMySql();
//		UserInfoDao userInfoDao2 = new UserInfoMySql();
//		
//
//		System.out.println("사용할 Id를 입력해 주세요");
//		if ("mysql".equals(info)) {
//			userinfo1.toString();
//
//		} else {
//			userinfo2.toString();
//		}

		UserInfoDao dao = null; // main은 멤버변수라서 초기화 시켜줘야한다.

		if (MYSQL.equals(str)) {
			dao = new UserInfoMysqlDao();
		} else if (ORACLE.equals(str)) {
			dao = new UserInfoOracleDao();

		} else {
			System.out.println("잘못된 입력입니다.");

		}
		if (dao != null) {
			dao.insertUserInfo(info);

		}

		// # dao : data access object
		// 데이터를 단순히 담기만 하는1 기능, DB로 넘겨줌
		//
	} // end of main

} // end of class
