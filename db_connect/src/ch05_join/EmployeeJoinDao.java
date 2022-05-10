package ch05_join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeJoinDao implements IemployeeJoinDao {

	DBClient client = DBClient.getInstance();
	Connection connection = client.getConnection();
	ResultSet rs = null;

	// 직원별 salary뽑기
	@Override
	public ArrayList<Dto> selectSalary() {
		ArrayList<Dto> arrL = new ArrayList<>();
		String selectQuery1 = "select e.emp_no,e.first_name, s.salary from employees as e inner join salaries as s on e.emp_no = s.emp_no limit 10 ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
//			preparedStatement.setString(1, emp_no);
//			preparedStatement.setString(2, emp_no);
			rs = preparedStatement.executeQuery();
//			System.out.println(rs);
			while (rs.next()) {
				Dto dto = new Dto();
				dto.setEmployees_emp_no(rs.getInt("emp_no"));
				dto.setEmployees_first_name(rs.getString("first_name"));
				dto.setSalaries_salary(rs.getInt("salary"));
				arrL.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrL;
	}

	// 재직중인 직원별 부서조회
	@Override
	public ArrayList<Dto> selectDepartmentCurrentlyemployed() {
		ArrayList<Dto> arrL = new ArrayList<>();
		String selectQuery1 = "select de.emp_no, de.to_date, de.dept_no, dep.dept_name\r\n"
				+ "from dept_emp as de\r\n"
				+ "left join departments as dep\r\n"
				+ "on de.dept_no = dep.dept_no\r\n"
				+ "where de.to_date<>'9999-01-01' ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
//			preparedStatement.setString(1, emp_no);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Dto dto = new Dto();
				dto.setDeptmanager_emp_no(rs.getInt("emp_no"));
				dto.setDeptemp_to_date(rs.getString("to_date"));
				dto.setDeptmanager_dept_no(rs.getString("dept_no"));
				dto.setDept_dept_name(rs.getString("dept_name"));

				arrL.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrL;
	}

	// 매니저별 부서이름 뽑기
	@Override
	public ArrayList<Dto> selectManagerDepartment() {
		ArrayList<Dto> arrL = new ArrayList<>();
		String selectQuery1 = "select dm.emp_no as '매니저 직원번호', dep.dept_name\r\n"
				+ "from dept_manager as dm\r\n"
				+ "left join departments as dep\r\n"
				+ "on dm.dept_no = dep.dept_no ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Dto dto = new Dto();
				dto.setDeptmanager_emp_no(rs.getInt("emp_no"));
				dto.setDept_dept_name(rs.getString("dept_name"));
				arrL.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrL;
	}

	// 직원별 입사일과 부서 조회
	@Override
	public ArrayList<Dto> selectFromdateDepartment() {
		ArrayList<Dto> arrL = new ArrayList<>();
		String selectQuery1 = "select de.emp_no, de.from_date as 입사일, dep.dept_name\r\n"
				+ "from dept_emp as de\r\n"
				+ "inner join departments as dep\r\n"
				+ "on de.dept_no = dep.dept_no ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Dto dto = new Dto();
				dto.setDept_emp_emp_no(rs.getInt("emp_no"));
				dto.setDeptmanager_from_date(rs.getString("from_date"));
				dto.setDept_dept_name(rs.getString("dept_name"));
				arrL.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrL;
	}

	// 재직중인 매니저 뽑기
	@Override
	public ArrayList<Dto> selectCurrentlyemployedManager() {
		ArrayList<Dto> arrL = new ArrayList<>();
		String selectQuery1 = "select dm.emp_no, dm.to_date, dep.dept_name\r\n"
				+ "from dept_manager as dm\r\n"
				+ "right join departments as dep\r\n"
				+ "on dm.dept_no = dep.dept_no\r\n"
				+ "where dm.to_date <> '9999-01-01' ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Dto dto = new Dto();
				dto.setDeptmanager_emp_no(rs.getInt("emp_no"));
				dto.setDeptmanager_to_date(rs.getString("to_date"));
				dto.setDept_dept_name(rs.getString("dept_name"));
				arrL.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrL;
	}

	public static void main(String[] args) {
		EmployeeJoinDao employeeDao = new EmployeeJoinDao();
		System.out.println(employeeDao.selectSalary());
		System.out.println(employeeDao.selectDepartmentCurrentlyemployed());
		System.out.println(employeeDao.selectManagerDepartment());
		System.out.println(employeeDao.selectFromdateDepartment());
		System.out.println(employeeDao.selectCurrentlyemployedManager());

	}
}
