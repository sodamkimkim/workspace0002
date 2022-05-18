package ch03;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * 파싱하는 방법<br>
 * 1. 단일 오브젝트 <br>
 * 2. 배열 <br>
 * 3. ArrayList <br>
 * 
 * @author 소담
 *
 */
@AllArgsConstructor
@ToString
class Student {
	String name;
	int age;
	String address;
}

public class MainTest4 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		// 1. dto 1개, dto배열, dto arrayList로 저장
		// 2. gson-> json 으로 바꾸기
		// (1). 단일객체 -> json
		Student student1 = new Student("홍길동", 20, "부산");
		Student student2 = new Student("이순신", 20, "서울");
		Student student3 = new Student("세종대왕", 20, "세종시");
		String jsonStudent = gson.toJson(student1);
		System.out.println(jsonStudent);
		// (2). 배열 -> json
		Student[] students = new Student[3];
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		for (Student student : students) {
			System.out.println(student);
		}
		String jsonArr = gson.toJson(students);
		System.out.println(jsonArr);
		// (3) 어레이리스트 -> json
		// (json은 통신에 적합, gson은 자바에 적합한 데이터형태)
		ArrayList<Student> arrListStudents = new ArrayList<Student>();
		arrListStudents.add(student1);
		arrListStudents.add(student2);
		arrListStudents.add(student3);
		System.out.println(arrListStudents);
		String jsonArrList = gson.toJson(arrListStudents);
		System.out.println(jsonArrList);

		// 3. json -> gson형태로 변경
		// 1. 단일객체
		Student student = gson.fromJson(jsonStudent, Student.class);
		System.out.println(student);
		// 2. 배열
		Student[] studentsArr = gson.fromJson(jsonArr, Student[].class);
		System.out.println("-----");
		for (Student student4 : studentsArr) {
			System.out.println(student4);
		}
		System.out.println("--");
		Type studentType = new TypeToken<ArrayList<Student>>() {
		}.getType();
		ArrayList<Student> arrayList = gson.fromJson(jsonArrList, studentType);
		for (Student student4 : arrayList) {
			System.out.println(student4);
		}
		// 3. arraylist
		// 4. gson --> 배열, arraylist로 받아서 각 필드값 뽑아주기

	}
}
