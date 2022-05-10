package ch04_subQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor // 빈생성자
@ToString
public class SQDto {
	// employees
	int employees_emp_no;
	String employees_birth_date;
	String employees_first_name;
	String employees_last_name;
	String employees_gender;
	String employees_hire_date;
	// Dept_emp
	int dept_emp_emp_no;
	String deptemp_dept_no;
	String deptemp_from_date;
	String deptemp_to_date;
	// Departments
	String dept_dept_no;
	String dept_dept_name;
	// salaries
	int salaries_emp_no2;
	int salaries_salary;
	String salaries_from_date;
	String salaries_to_date;
	// dept_manager
	String deptmanager_dept_no;
	int deptmanager_emp_no;
	String deptmanager_from_date;
	String deptmanager_to_date;
	//titles
	int titles_emp_no;
	String titles_title;
	String titles_from_date;
	String titles_to_date;
}
