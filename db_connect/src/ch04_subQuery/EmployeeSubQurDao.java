package ch04_subQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch05_join.Dto;

public class EmployeeSubQurDao implements IemployeeSubQurDao {

	DBClient client = DBClient.getInstance();
	Connection connection = client.getConnection();
	ResultSet rs = null;

	// senior engineer 뽑기
	@Override
	public ArrayList<ch04_subQuery.SQDto> selectSeniorEngineers() {
		ArrayList<SQDto> arrL = new ArrayList<>();
		String selectQuery1 = "select a.emp_no as 'senior E'\r\n" + "from employees as a\r\n"
				+ "where a.emp_no in (select emp_no from titles where title = 'Senior Engineer') ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SQDto dto = new SQDto();
				dto.setEmployees_emp_no(rs.getInt("emp_no"));
				arrL.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrL;
	}

	// 직원별 이름과 직함 뽑기
	@Override
	public ArrayList<SQDto> selectEmployeeTitle() {
		ArrayList<SQDto> arrL = new ArrayList<>();
		String selectQuery1 = "select e.emp_no, e.first_name, t.title\r\n"
				+ "from employees as e, (select title, emp_no from titles) as t\r\n" + "where e.emp_no = t.emp_no ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SQDto dto = new SQDto();
				dto.setEmployees_emp_no(rs.getInt("emp_no"));
				dto.setEmployees_first_name(rs.getString("first_name"));
				dto.setTitles_title(rs.getString("title"));
				arrL.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrL;
	}

	// 직원별 이름, 직함, 부서번호 뽑기
	@Override
	public ArrayList<SQDto> selectEmployeeTitleDepno() {
		ArrayList<SQDto> arrL = new ArrayList<>();
		String selectQuery1 = "select e.emp_no, e.first_name, t.title, (select d.dept_no from dept_emp as d where e.emp_no=d.emp_no group by emp_no) as 부서번호\r\n"
				+ "from employees as e, (select title, emp_no from titles) as t\r\n" + "where e.emp_no = t.emp_no ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SQDto dto = new SQDto();
				dto.setEmployees_emp_no(rs.getInt("emp_no"));
				dto.setEmployees_first_name(rs.getString("first_name"));
				dto.setTitles_title(rs.getString("title"));
				dto.setDeptemp_dept_no(rs.getString("dept_no"));
				arrL.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrL;
	}

	// 직원별 이름, 직함, 부서번호, 부서이름 뽑기
	@Override
	public ArrayList<SQDto> selectEmployeeTitleDepname() {
		ArrayList<SQDto> arrL = new ArrayList();
		String selectQuery1 = "select e.emp_no, e.first_name, t.title, (select d.dept_no from dept_emp as d where e.emp_no=d.emp_no group by emp_no) as 부서번호, (select dn.dept_name from departments as dn where dn.dept_no = d.dept_no group by dept_no) as 부서명\r\n"
				+ "from employees as e, (select title, emp_no from titles) as t, (select dept_no, emp_no from dept_emp) as d\r\n"
				+ "where e.emp_no = t.emp_no and e.emp_no = d.emp_no ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SQDto dto = new SQDto();
				dto.setEmployees_emp_no(rs.getInt("emp_no"));
				dto.setEmployees_first_name(rs.getString("first_name"));
				dto.setTitles_title(rs.getString("title"));
				dto.setDeptemp_dept_no(rs.getString("dept_no"));
				arrL.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrL;

	}

	// staff 생일 뽑기
	@Override
	public ArrayList<SQDto> selectstaffBirth() {
		ArrayList<SQDto> arrL = new ArrayList();
		String selectQuery1 = "select a.emp_no, a.birth_date\r\n" + "from employees as a\r\n"
				+ "where a.emp_no in (select emp_no from titles where title = 'Staff') ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SQDto dto = new SQDto();
				dto.setEmployees_emp_no(rs.getInt("emp_no"));
				dto.setEmployees_birth_date(rs.getString("birth_date"));
				arrL.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrL;
	}
}
