package ch05;

public class UserInfoMysqlDao implements UserInfoDao {
	// Musql데이터 베이스 쓰는 방법과 오라클 쓰는 방법 다름
	// 코드를 좀 다르게 처리해야함
	// 그래서 클래스마다 인터페이스 구현

	@Override
	public void insertUserInfo(UserInfo info) {
		System.out.println("MYSQL : 저장하기 id " + info.getUserId());
		System.out.println("MYSQL : 저장하기 pw " + info.getPassword());
		System.out.println("MYSQL : 저장하기 name " + info.getUserName());
	}

	@Override
	public void updateUserInfo(UserInfo info) {
		System.out.println("MYSQL : 수정하기 id " + info.getUserId());
		System.out.println("MYSQL : 수정하기 pw " + info.getPassword());
		System.out.println("MYSQL : 수정하기 name " + info.getUserName());
	}

	@Override
	public void deleteUserInfo(String userId) {
		System.out.println("MYSQL : 동작");

		System.out.println("delete from dbName userId = ' " + userId + " ' ");
	}

}
