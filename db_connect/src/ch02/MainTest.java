package ch02;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		MemberInfoDao memberInfoDao = new MemberInfoDao();
//		ArrayList<MemberDto> data = memberInfoDao.select();
//		System.out.println(data);

		MemberDto dto = new MemberDto("abc", "강감찬", "부산시 수영구");
//		memberInfoDao.insert(dto);
//		memberInfoDao.update(dto);
		int returnRow = memberInfoDao.delete("abc");
		System.out.println("returnRow : " + returnRow);
	}

}
