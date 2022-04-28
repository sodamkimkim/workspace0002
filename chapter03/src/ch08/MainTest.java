package ch08;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		Book book1 = new Book(1, "흐르는 강물처럼", "파울로코엘로");
		Book book2 = new Book(1, "플러터UI실전", "김근호");
		Book book3 = new Book(1, "무궁화꽃이 피었습니다.", "김진명");
		Book book4 = new Book(1, "리딩으로리드하라", "이지성");
		Book book5 = new Book(1, "사피엔스", "유발하라리");

		// 자바 문법 공부할 때 how, why. 어떻게 쓰는지, 왜 쓰는지기준으로 공부!!!!

		// 사용방법 (generic-- 어떠한 데이터 타입을 받을 지 미리 지정해 둔다.)
		ArrayList<Book> cart = new ArrayList<>();
		// ArrayList에는 Book타입만 가넝. 다형성도 가능
		// 배열과 다르게 크기 지정하지 않았음

		// 데이터를 추가하는 방법
		cart.add(book1);
		cart.add(book2);
		cart.add(book3);
		
		// 데이터를 꺼내는 방법
//		System.out.println(cart.get(0)); //cart.get(0)안에 주소값들어있다.
//		System.out.println(cart.get(1).getTitle());
//		System.out.println(cart.get(2));
		
		for (Book book : cart) {
			System.out.println(book);
		} // ctrl space -> foreach
		
		cart.remove(0);
		System.out.println(cart.size());
		System.out.println("--------------");
		System.out.println(cart.get(0)); // 0번삭제되고나서 자동으로 1번이 0번으로 올라감
		
		
		// 수정하기
		cart.set(0, book5);
		System.out.println("--------------");

		System.out.println(cart.size());
		System.out.println(cart.get(0));
		System.out.println(cart.isEmpty());
		
		for (Book book : cart) {
			System.out.println(book);
		}
		
		// 데이터를 전부 삭제하고 싶다면
		cart.removeAll(cart); // 데이터 한번에 다 지운다.
		System.out.println("--------------");
		for (Book book : cart) { // 이 포문에는 결과값이 없다
			System.out.println(book);
		}
		
		// C R U D
		

	}

}
