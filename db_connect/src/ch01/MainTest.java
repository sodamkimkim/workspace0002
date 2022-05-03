package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest {
	// DB서버와 연결하기 위한 준비물
	private Connection conn; // DB 커넥션 연결 객체
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";

	private Statement stmt; // String을 mysql이 인식할 수 있는 쿼리구문으로 변경해 줌
	private ResultSet rs; // 결과값 받아줌.

	// 생성자 !!
	public MainTest() {
		try {
			// reflect 기법 : 컴파일 시점 문자열 --> 런타임 시점에 실제 클래스가 존재하는지 확인
			// 있다면,, 메모리(heap) 영역에 올라간다.
			Class.forName("com.mysql.cj.jdbc.Driver"); // 우리가 땡겨온 mysql connector.jar에 정의되어있는 클래스임
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement();
			String sql1 = "select * from memberTbl";
			rs = stmt.executeQuery(sql1);

					
			/**
			 * 메모리에 드라이버 메니저를 올림 <br>
			 * 내 계정과 패스워드를 디비서버에 연결<br>
			 * 컨낵션이라는 녀석은 연결되어있는 객체임<br>
			 * 객체안의 기능인 createStatement호출해서 객체 받아옴<br>
			 * 쿼리문 던져서<br>
			 * 쿼리 구문이 실행되면,, 결과는 rs 에 저장<br>
			 * 결과는 mysql에서 쿼리문 날렸을 때 나오는 테이블 모양임.<br>
			 * 그 모양 고대로 result set에 담긴다.<br>
			 * 
			 */

			/* <서버 클라이언트 개념은 절대적이지 않고 상황에 따라 변화한다.>
			 * 소셜로그인..
			 * 개인정보들,, 회원가입율 떨어지니까
			 * 데이터들이 집중되어있는 공룡기업들,, 카카오, 네이버 등에 요청해서
			 * 데이터를 가지고온다.
			 * 
			 * 웹서버를 개발했지만,, 그때는 
			 * 우리 웹서버는 클라이언트 개념이 되고 카카오 이런곳이 서버 개념이 되는 거임
			 * 
			 * 결론 ) 서버 클라이언트 개념은 절대적이지 않고 상황에 따라 변화한다.
			 * */
			
			while (rs.next()) {
				String memberId = rs.getString("memberId");
				String memberName = rs.getString("memberName");
				System.out.println("id: " + memberId + " , " + "name : " + memberName);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MainTest();
	} // end of main
} // end of class
