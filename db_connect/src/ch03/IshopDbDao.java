package ch03;

import java.util.ArrayList;

public interface IshopDbDao {
	// user Tbl, buyTbl 결과 *
	ArrayList<ShopDto> innerJoin1(String colm, String value);

	// userTbl, buyTbl null 제거, 결과 *
	ArrayList<ShopDto> leftJoin1(String colm, String value);

	// buytbl, userTbl, 결과 *
	ArrayList<ShopDto> leftJonin2(String colm, String value);

	// 해당하는 user 정보 + 구매 내역 조회
	void selectBuyInfoByUserId(String userId);

	 
}
