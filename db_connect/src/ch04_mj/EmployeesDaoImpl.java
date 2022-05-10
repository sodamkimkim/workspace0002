package ch04_mj;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesDaoImpl implements EmployeesDao {
	private DBClient db;
	private Connection connection;
	private ResultSet result;
	private QueryScript script;
	private View view;
	private Scanner sc;
	private boolean flag = true;

	public EmployeesDaoImpl() {
		db = DBClient.getinstance();
		connection = db.getConnection();
		script = new QueryScript();
		sc = new Scanner(System.in);
		view = new View();

		runService();
	}

	@Override
	public void runService() {
		while (flag) {
			int select = view.indexView();
			switch (select) {
			case 1:
				System.out.println("-----------------------");
				System.out.println("직원 정보 조회");
				System.out.println("-----------------------");
				System.out.print("직원 id를 입력하세요: ");
				checkEmployeeInfo(sc.next());
				System.out.println();
				System.out.println();
				System.out.println();
				break; 
			case 2:
				System.out.println("-----------------------");
				System.out.println("최고 연봉자 조회");
				System.out.println("-----------------------");
				searchHigherSalary(view.selectDepartView());
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			case 3:
				System.out.println("-----------------------");
				System.out.println("부서 직원 수 조회");
				System.out.println("-----------------------");
				countDepartStaff(view.selectDepartView());
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			case 4:
				System.out.println("-----------------------");
				System.out.println("직원 직급/월봉 조회");
				System.out.println("-----------------------");
				System.out.print("직원id를 입력하세요: ");
				searchStaffPositon(sc.next());
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			case 5:
				System.out.println("-----------------------");
				System.out.println("부서별 장기 근무자 수 조회");
				System.out.println("-----------------------");
				System.out.print("찾고자 하는 근무년수를 입력하세요: ");
				checkYearsOfStaff(sc.nextInt());
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			case 0:
				effectLoading();
				flag = false;
			}

		}

	}

	/**
	 * 직원 정보 조회 ( 직원번호, 이름, 성별, 근무부서, 직함 )
	 * 
	 * @param 직원 id
	 */
	@Override
	public void checkEmployeeInfo(String employeesid) {
		result = null;
		String q = script.getQuery1();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(q);
			preparedStatement.setString(1, employeesid);
			result = preparedStatement.executeQuery();
			result.next();

			EmployeeDto employee = new EmployeeDto();
			employee.setEmployeeid(result.getString("emp_no"));
			employee.setEmployeeName(result.getString("Name"));
			employee.setGender(result.getString("gender").charAt(0));
			employee.setDepart(result.getString("dept_name"));
			employee.setTitle(result.getString("title"));
			effectLoading();

			System.out.println(employee);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 부서별 최고 연봉자 조회
	 * 
	 * @param 부서 id
	 */
	@Override
	public void searchHigherSalary(String departCode) {
		result = null;
		String q = script.getQuery2();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(q);
			preparedStatement.setString(1, departCode);
			result = preparedStatement.executeQuery();
			result.next();
			effectLoading();

			System.out.println("직원 id: " + result.getString("emp_no"));
			System.out.println("직원 이름: " + result.getString("Name"));
			System.out.println("부서 명칭: " + result.getString("dept_name"));
			System.out.println("연봉: " + result.getString("max(salary)"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 부서별 직원수 출력
	 * 
	 * @param 부서 id
	 */
	@Override
	public void countDepartStaff(String departCode) {
		result = null;
		String q = script.getQuery3();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(q);
			preparedStatement.setString(1, departCode);
			result = preparedStatement.executeQuery();
			result.next();
			effectLoading();
			DepartNumberEmployeeDto countDto = new DepartNumberEmployeeDto();
			countDto.setDepartid(result.getNString("dept_no"));
			countDto.setCount(result.getString("직원 수"));
			System.out.println(countDto);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * salary를 연봉으로 생각했을 때 월봉, 직급 조회
	 * 
	 * @param 직원 id
	 */
	@Override
	public void searchStaffPositon(String employeesid) {
		result = null;
		String q = script.getQuery4();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(q);
			preparedStatement.setString(1, employeesid);
			result = preparedStatement.executeQuery();
			result.next();
			effectLoading();

			System.out.println("직원 id: " + result.getString("emp_no"));
			System.out.println("직급: " + result.getString("직급"));
			System.out.println("월봉: " + result.getString("month_salary"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 부서별 X년 근무자 조회
	 * 
	 * @param 근무 년수
	 */
	@Override
	public void checkYearsOfStaff(int year) {
		ArrayList<DepartNumberEmployeeDto> list = new ArrayList<DepartNumberEmployeeDto>();
		result = null;
		String q = script.getQuery5();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(q);
			preparedStatement.setString(1, Integer.toString(year));
			result = preparedStatement.executeQuery();
			result.next();

			while (result.next()) {
				DepartNumberEmployeeDto countDto = new DepartNumberEmployeeDto();
				countDto.setDepartid(result.getNString("dept_no"));
				countDto.setDepartName(result.getString("dept_name"));
				countDto.setCount(result.getString("인원 수"));
				list.add(countDto);
			}
			effectLoading();

			for (DepartNumberEmployeeDto cDepart : list) {
				System.out.println(cDepart);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void effectLoading() {

		for (int i = 0; i < 5; i++) {
			System.out.print(" . ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();

	}

}