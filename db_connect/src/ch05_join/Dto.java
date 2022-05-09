package ch05_join;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor // 빈생성자
@ToString
public class Dto {
	// employees
	int employees_emp_no;
	String employees_birth_date;
	String employees_first_name;
	String employees_last_name;
	String employees_gender;
	String employees_hire_date;
	// Dept_emp
	int emp_no;
	String dept_no1;
	String from_date;
	String to_date;
	// Departments
	String dept_no2;
	String dept_name;
	// salaries
	int salaries_emp_no2;
	int salaries_salary;
	String salaries_from_date;
	String salaries_to_date;
	// dept_manager
	String dept_manager_dept_no;
	int dept_manager_emp_no;
	String dept_manager_from_date;
	String dept_manager_to_date;
}
