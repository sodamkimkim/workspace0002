package ch04_mj;


import lombok.Getter;

@Getter
public class QueryScript {
	/**
	 *  직원 정보 조회 ( 직원번호, 이름, 성별, 근무부서, 직함 ) 
	 *  @param 직원 id
	 */
	String Query1 = "SELECT e.emp_no, CONCAT(first_name,\" \",last_name) AS 'Name', gender, d.dept_name, title\r\n"
			+ "FROM employees AS e \r\n"
			+ "INNER JOIN dept_emp AS de\r\n"
			+ "ON e.emp_no = de.emp_no\r\n"
			+ "INNER JOIN departments AS d\r\n"
			+ "ON de.dept_no = d.dept_no\r\n"
			+ "INNER JOIN titles AS t\r\n"
			+ "ON e.emp_no = t.emp_no\r\n"
			+ "WHERE de.to_date = '9999-01-01'\r\n"
			+ "	AND e.emp_no = ? \r\n"
			+ "ORDER BY emp_no";
	
	/**
	 *  부서별 최고 연봉자 조회
	 *  @param 부서 id
	 */
	String Query2 = "SELECT s.emp_no, MAX(salary), de.dept_no, dept_name, e.e_name AS 'Name'\r\n"
			+ "FROM salaries AS s,\r\n"
			+ "	(SELECT dept_no, dept_name FROM departments) AS d,\r\n"
			+ "    (SELECT emp_no, dept_no FROM dept_emp) AS de,\r\n"
			+ "    (SELECT emp_no, CONCAT(first_name, \" \",last_name) AS e_name FROM employees) AS e\r\n"
			+ "WHERE s.to_date = '9999-01-01'\r\n"
			+ "	AND  s.emp_no = de.emp_no\r\n"
			+ "	AND de.dept_no = d.dept_no\r\n"
			+ "    AND s.emp_no = e.emp_no\r\n"
			+ "    AND de.dept_no = ?\r\n"
			+ "GROUP BY de.dept_no";
	
	/**
	 *  부서별 직원수 출력
	 *  @param 부서 id
	 */
	String Query3 = "SELECT dept_no, COUNT(de.emp_no) AS \"직원 수\"\r\n"
			+ "FROM employees AS e,\r\n"
			+ "	(SELECT emp_no, dept_no, to_date FROM dept_emp) AS de\r\n"
			+ "WHERE e.emp_no = de.emp_no\r\n"
			+ "	AND to_date = '9999-01-01'\r\n"
			+ "    AND dept_no = ?\r\n"
			+ "GROUP BY dept_no";
	
	/**
	 * salary를 연봉으로 생각했을 때 월봉, 직급 조회
	 * @param 직원 id
	 */
	String Query4 = "SELECT s.emp_no, ROUND((MAX(salary)/12), 0) AS 'month_salary' , t.title AS \"직급\"\r\n"
			+ "FROM salaries AS s\r\n"
			+ "INNER JOIN titles AS t\r\n"
			+ "ON s.emp_no = t.emp_no\r\n"
			+ "WHERE s.emp_no = ?;";
	
	/**
	 * 부서별 X년 근무자 조회
	 * @param 근무 년수
	 */
	String Query5 = "SELECT de.dept_no, COUNT(count_year) AS \"인원 수\", d.dept_name\r\n"
			+ "FROM dept_emp AS de,\r\n"
			+ "	(SELECT emp_no, COUNT(s.emp_no) AS count_year\r\n"
			+ "		FROM salaries AS s\r\n"
			+ "		GROUP BY s.emp_no\r\n"
			+ "		HAVING count_year >= ? ) AS year_table,\r\n"
			+ "	(SELECT dept_name, dept_no FROM departments) AS d\r\n"
			+ "WHERE de.emp_no = year_table.emp_no\r\n"
			+ "	AND de.dept_no = d.dept_no\r\n"
			+ "GROUP BY de.dept_no";
	
}