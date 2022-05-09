package ch05_join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDao implements IemployeeDao {

	DBClient client = DBClient.getInstance();
	Connection connection = client.getConnection();
	ResultSet rs = null;

	@Override
	public ArrayList<Dto> join1() {
		ArrayList<Dto> arrL = new ArrayList<>();
		String selectQuery1 = "select e.emp_no from employees as e inner join salaries as s on e.emp_no = s.emp_no limit 10";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
//			preparedStatement.setString(1, emp_no);
//			preparedStatement.setString(2, emp_no);
			rs = preparedStatement.executeQuery();
//			System.out.println(rs);
			while (rs.next()) {
				Dto dto = new Dto();
				dto.setEmployees_emp_no(rs.getInt("emp_no"));
//				dto.setEmployees_birth_date(rs.getString("birth_date"));
//				dto.setEmployees(rs.getString("emp_no"));

				arrL.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrL;
	}

	@Override
	public ArrayList<Dto> join2(String dept_no) {
		return null;
	}

	@Override
	public ArrayList<Dto> join3(String dept_no) {
		return null;
	}

	@Override
	public ArrayList<Dto> join4(String dept_no) {
		return null;
	}

	@Override
	public ArrayList<Dto> join5(String dept_no) {
		return null;
	}

	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDao();
		System.out.println(employeeDao.join1());

		
	}
}
