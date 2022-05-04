package ch02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberInfoDao implements IMemberInfoDao {

	private static final String TABLE_NAME = "membertbl";
	// DBClient 를 통해서 DB접속 처리를 하자!!
	private DBClient dbClient;
	private Connection conn;

	public MemberInfoDao() {
		dbClient = DBClient.getInstance();
		conn = dbClient.getConnection();
	}

	@Override
	public synchronized ArrayList<MemberDto> select() {
		// 여러사람들이 접근할 때
		// 동기화처리..
		ArrayList<MemberDto> dataResult = new ArrayList<MemberDto>();
		String sqlFormat;
		String sql;

		sqlFormat = "SELECT * FROM %s";
		sql = String.format(sqlFormat, TABLE_NAME);
		// select호출했을때
		// 필요한건 statement , resultSet
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 여기서도 dto개념 적용가능
				// 뽑아낸 결과를 클래스 생성해서 넣을거임
				// MemberDto class 생성할게

				MemberDto dto = new MemberDto();
				dto.setMemberId(rs.getString("memberId"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberAddress(rs.getString("memberAddress"));
				// member dto 전체 담는 자료구조 필요 -> arraylist
				dataResult.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} // end of finally
		return dataResult;

	}

	@Override
	public synchronized int insert(MemberDto dto) { // dto를 통째로 받으면 줄줄줄 멤버변수들 안받아도 된다.
		// insert는 몇개 행 return => 리턴타입 int
		String sqlFormat = "INSERT INTO %s VALUES('%s', '%s', '%s')";
		String sql = String.format(sqlFormat, TABLE_NAME, dto.getMemberId(), dto.getMemberName(),
				dto.getMemberAddress());
		Statement stmt = null;
		int result = 0;
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql); // select 할 때는,, rs = stmt.executeQuery(sql);
//			stmt.executeQuery(sql);
			System.out.println("result : 행(레코드) 갯수 " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 생성 역순으로 닫아줘야 한다.
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public synchronized int update(MemberDto dto) {
// 해당 레코드 존재 여부 검사 먼저 해야한다.
//		if(dto.get) --> 방어적 코드 작성할 수 있다.
		String sqlFormat = "UPDATE %s SET memberName = '%s' WHERE memberId = '%s' ";
		String sql = String.format(sqlFormat, TABLE_NAME, dto.getMemberName(), dto.getMemberId());
		int result = 0;

		try (Statement stmt = conn.createStatement()) {
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public synchronized int delete(String memberId) {
		String sqlFormat = "DELETE FROM %s WHERE memberId = '%s'";
		String sql = String.format(sqlFormat, TABLE_NAME, memberId);
		int result = 0;
		try (Statement stmt = conn.createStatement()) {
			result = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
