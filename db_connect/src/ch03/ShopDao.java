package ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch02.DBClient;
import ch02.MemberDto;

public class ShopDao implements IshopDbDao {
	// preparedStatement 사용.
	// Join 사용
	DBClient client = DBClient.getInstance();
	Connection connection = client.getConnection();
	ResultSet rs = null;

	ArrayList<ShopDto> shopdtoArrlL;

	@Override
	public synchronized ArrayList<ShopDto> innerJoin1(String colm, String value) {
		// user Tbl, buyTbl 결과 *
		try {

			String selectQuery11 = "SELECT * FROM userTbl as a inner join buyTbl as b"
					+ " on a.userName = b.userName WHERE ? = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery11);
			preparedStatement.setString(1, colm);
			preparedStatement.setString(2, value);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				ShopDto shopDto = new ShopDto();
				shopDto.setUserName1(rs.getString("a.userName"));
				shopDto.setBirthYear(rs.getInt("birthYear"));
				shopDto.setAddr(rs.getString("addr"));
				shopDto.setMobile(rs.getString("mobile"));
				shopDto.setUserName2(rs.getString("b.userName"));
				shopDto.setProdName(rs.getString("prodName"));
				shopDto.setPrice(rs.getInt("price"));
				shopDto.setAmount(rs.getInt("amount"));
				shopdtoArrlL.add(shopDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shopdtoArrlL;
	}

	@Override
	public ArrayList<ShopDto> leftJoin1(String colm, String value) {
		return shopdtoArrlL;
		// userTbl, buyTbl null 제거, 결과 *

	}

	@Override
	public ArrayList<ShopDto> leftJonin2(String colm, String value) {
		return shopdtoArrlL;
		// buytbl, userTbl, 결과 *

	}

	@Override
	public void selectBuyInfoByUserId(String userId) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		ShopDao shopDao = new ShopDao();
		shopDao.innerJoin1("a.addr","대구");

	}

}
