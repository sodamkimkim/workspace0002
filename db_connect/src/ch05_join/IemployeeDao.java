package ch05_join;

import java.util.ArrayList;

public interface IemployeeDao {
	ArrayList<Dto> join1();

	ArrayList<Dto> join2(String dept_no);

	ArrayList<Dto> join3(String dept_no);

	ArrayList<Dto> join4(String dept_no);

	ArrayList<Dto> join5(String dept_no);
}
