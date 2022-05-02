package ch03;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.AllArgsConstructor;
import lombok.ToString;

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
		// 방이 3개인 students배열 생성
		// Student 객체 3개 생성
		Student[] students = new Student[3];
		Student student1 = new Student("홍길동", 20, "부산");
		Student student2 = new Student("이순신", 20, "서울");
		Student student3 = new Student("세종대왕", 20, "세종시");

		// students배열에 Student객체 각각 넣어주기
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		// student1객체를 Json으로 변환.

		// 파싱하는 방법1 -> object클래스(Dto) 단일객체 이용
		String jsonStr = gson.toJson(student1);
		System.out.println("@ 단일 객체 -> json : "+jsonStr);
		Student objS1 = gson.fromJson(jsonStr, Student.class); // -> 리플렉션 기법
		System.out.println("@ Json -> Student.class : "+objS1);
		
		// studentArr이라는 String 생성해서
		// gson라이브러리를 이용해서 substring대신 Dto를 사용
		// gson.toJson( ) --> 괄호안의 것을 Json으로 파싱
		// 그 결과값을 String studentArr에 저장.
		// 찍어보면.. -> students가 배열이기 때문에
		// [{ }, { }, { }]이 형태로 찍힌걸 볼 수 있다.
		// { }는 각각 오브젝트고 리스트형태로 묶여있다.
		
		// 파싱하는 방법2 배열
		String studentsArr = gson.toJson(students); // 배열을,, json배열로 만들어 String에 저장
		System.out.println("@ 배열 students -> json,, 전체 studentsArr 찍어보기 : "+studentsArr);
		Student[] objArr1 = gson.fromJson(studentsArr, Student[].class); // json배열 묶음을 student오브젝트[]로 파싱
		for (Student student : objArr1) {
			//objArr1이 student의 연속이고(student타입 배열)
			// 전체 데이터 찍으려면
			// sysout(objArr1)이게 아니라 
			// for문 돌려야한다.
			System.out.println("@ Json -> Student[].class,, student각각 찍어보기 : "+student);
		}
		System.out.println(objArr1); // 얜 걍 주소값나온다.

		// 파싱하는 방법3 ArrayList
		ArrayList<Student> list = new ArrayList<>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		String jsonArrayStr = gson.toJson(list); // list를 json으로
		System.out.println("@ ArrayList -> Json으로 파싱 : "+jsonArrayStr); // arraylist -> json파싱한 값 담김.
		Type type = new TypeToken<ArrayList<Student>>() {
		}.getType();
		ArrayList<Student> arrayList = gson.fromJson(jsonArrayStr, type); // arraylistJson -> arraylist
		for (Student student : arrayList) {
			System.out.println("@ Json -> ArrayList<Student>,, student각각 찍어보기 : "+ student);
		}
		//arrayList는 오브젝트(Student)들 묶은 리스트로 출력
		//Json은 { }객체 묶은 리스트로 출력
		System.out.println("@ arrayList -> Json : "+jsonArrayStr);
		System.out.println("@ JsonArrayListStr -> arrayList : "+arrayList);
	}
}
