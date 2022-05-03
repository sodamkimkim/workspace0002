package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

//mysql에서 buytbl 긁어오기
public class MainTest2 {
	private Connection conn;
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";

	private Statement stmt;
	private ResultSet rs;

	public MainTest2() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement();
			String sql1 = "select * from buytbl";
			rs = stmt.executeQuery(sql1);

			while (rs.next()) {
				String userName = rs.getString("userName");
//			System.out.println(userName);
				String prodName = rs.getString("prodName");
//			System.out.println(prodName);
				String price = rs.getString("price");
				String amount = rs.getString("amount");
				System.out.println("userName : " + userName + " prodName : " + prodName + " price : " + price
						+ " amount : " + amount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// mysql에서 buytbl 긁어오기
	public static void main(String[] args) {
		new MainTest2();
	}

}
