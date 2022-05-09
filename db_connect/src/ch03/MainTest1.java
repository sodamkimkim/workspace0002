package ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch02.DBClient;

public class MainTest1 {
	public static void main(String[] args) {
		// DBClient는 싱글톤으로 설계됨.
		// @ object는 main-method에서 new하기 때문에
		// 언제 태어나서 언제 죽을 수 있는 것들을 말함

		// @ static으로 만들어진 녀석들은
		// life-cycle이 프로그램 시작-끝으로만 처리 된다.
		DBClient client = DBClient.getInstance();
		Connection connection = client.getConnection();
		ResultSet resultSet = null;

		// 데이터 한건 조회
//		Statement stmt = connection.createStatement()

		// preparedStatement사용
		try {
			String selectQuery1 = "SELECT * FROM memberTBL WHERE memberId = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
//			preparedStatement.setString(1, "jsa");
//			resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				System.out.println(resultSet.getString("memberId"));
//				System.out.println(resultSet.getString("memberName"));
//				System.out.println(resultSet.getString("memberAddress"));
//			}
			System.out.println("-----------------");
			String selectQuery2 = "SELECT * FROM memberTBL WHERE memberId IN(?  ,?) ";
			preparedStatement = connection.prepareStatement(selectQuery2);
			preparedStatement.setString(1, "questzz");
			preparedStatement.setString(2, "Han");

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("memberId"));
				System.out.println(resultSet.getString("memberName"));
				System.out.println(resultSet.getString("memberAddress"));
			}
			System.out.println("---------------");
//			// insert 데이터 등록
//			String insertQuery = "INSERT INTO membertbl VALUES(?, ?, ?)";
//            preparedStatement = connection.prepareStatement(insertQuery);
//            preparedStatement.setString(1, "boot1");
//            preparedStatement.setString(2, "개발자1");
//            preparedStatement.setString(3, "서울판교1");
//
//            int resultCount = 0;
//            resultCount = preparedStatement.executeUpdate();
//
//            if (resultCount >= 1) {
//                System.out.println("정상 등록 되었습니다.");
//            } else {
//                System.out.println("동일한 아이디가 존재하거나, 잘못된 입력입니다.");
//            }
//
			// update 데이터 수정
            String updateQuery = "UPDATE membertbl SET memberName = ? WHERE memberId = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, "이름변경1");
            preparedStatement.setString(2, "boot1");
            int updateCount = preparedStatement.executeUpdate();
            System.out.println("updateCount : " + updateCount);

            //delete 데이터 삭제
            // 내부적으로 이 쿼리는 메모리에 띄워나져있고 ... ?만 바인딩 함
            // 버튼에 이벤트리스너 달아서 getText가져오는등..활용가능 
            String deleteQuery = "DELETE FROM memberTBL WHERE memberID = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, "boot1");
            
            int deleteCount = preparedStatement.executeUpdate();
            System.out.println(deleteCount);
            
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
