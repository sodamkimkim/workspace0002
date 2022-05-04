package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBClient {
	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private static final String DB_DATABASE_NAME = "shopdb";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "asd123";

	private Connection conn;

	// 싱글톤 처리
	private static DBClient dbClient;

	private DBClient() { // 생성자 private으로 선언

	}

	// static은 메인 뜨기전에 생성
	// 이거는 프로그램이 시작될 때부터 생성
	public static DBClient getInstance() {
		// 반환타입 DBClient
		if (dbClient == null) {
			dbClient = new DBClient();
		} // 객체 담는 변수가 null일때만 객체 생성해서 변수에 넣어줌
		return dbClient; // 그리고 그거 반환. 만약 이전에 존재하던 객체가 있으면 그걸 반환하겠지..
	}

	public Connection getConnection() { // 커넥션 리턴해줌 => 리턴타입 Connection
		if (conn == null) {
			// "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8"

			// ip, port, database수정 가능하니까 포맷처리해줄거임
			// UTF-8부분도
			String urlFormat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CHARSET); // 문자열 포맷팅 해서 url에
																									// 담아줌

			// Mysql JDBC Driver 클래스 로딩해서, DriverManager 클래스에 등록한다.
			try {
				
//				리플렉션(Reflection)
//
//				컴파일 시간(Compile Time)이 아닌 실행 시간(Run Time)에 동적으로 
//
//				특정 클래스의 정보를 추출해낼 수 있는 프로그래밍 기법
				Class.forName("com.mysql.cj.jdbc.Driver");
				// DriverManager 객체를 사용하여 DB서버에 접근
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">>> Connection Success <<<");
			} catch (Exception e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		return conn;

	}

	public void connectionClose() {
		if (conn != null) { // 방어적 코드 작성
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			conn = null;
		}
	}
}
