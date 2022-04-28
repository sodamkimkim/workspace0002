package ch08_pr;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		Book book1 = new Book(1, "흐르는 강물처럼", "파울로코엘로");
		Book book2 = new Book(1, "플러터UI실전", "김근호");
		Book book3 = new Book(1, "무궁화꽃이 피었습니다.", "김진명");
		Book book4 = new Book(1, "리딩으로리드하라", "이지성");
		Book book5 = new Book(1, "사피엔스", "유발하라리");

		// ArrayList 생성, 타입은 Book
		ArrayList<Book> cart = new ArrayList<>();
		cart.add(book1);
		cart.add(book5);
		
		// 데이터를 꺼내는 방법
		System.out.println(cart.get(0));
		System.out.println(cart.get(1));
		System.out.println("-----------------");
		
		for(Book book : cart) { // 확장 for문 for(변수 : 배열이름)
			System.out.println();
		}

	}

}
