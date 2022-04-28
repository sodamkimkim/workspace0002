package tenco.com.data_Structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataStructureTest1 {
	public static void main(String[] args) {
		List list0; // list util에 있는거 가져오기
		// 중간에 데이터를 추가하거나 삭제하는 것이 용이
		// List는 인터페이스라서 new가 안된다.
		// 하지만 다형성이 존재하기 때문에 list데이터 타입으로
//		List list1 = new ArrayList(); // 이런거 가능

		// 순서가 있고(인덱스) 중복이 가능하다.
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<>();

		// 선언과 동시에 초기화
		ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));

		// 값 추가 방법
		list3.add(4);
		list3.add(null);
		System.out.println(list3);

		list3.add(1, 10);
		System.out.println(list3);

		// 삭제방법
		list3.remove(5);
		System.out.println(list3);

//		//전체삭제
//		list3.clear();
//		System.out.println(list3);

		// 출력 방법
//		System.out.println(list3.get(30)); // index out of bounds

		
		// 추가적인 메서드 확인
		System.out.println(list3.size());
		System.out.println(list3.isEmpty());

		// for
		for (Integer i : list3) {
			System.out.println("i : " + i);
		}

		// while
		// 요소 순회(반복자 사용) --> 컬렉션 프레임워크에 저장된 요소들을 하나씩 차례로 참조한다.
		Iterator<Integer> iter = list3.iterator(); // java.util에 있음
		while (iter.hasNext()) {// 다음에 값이 있으면 true반환
			System.out.println("while : " + iter.next());
		}

		//
		System.out.println(list3.contains(500)); // 500이라는 값없기때문에 false나온다. 마치 검색기능임
		System.out.println(list3.contains(10)); // 10은 있기때문에 true나옴.

		
		// indexof
	    /**
	     * Returns the index of the first occurrence of the specified element
	     * in this list, or -1 if this list does not contain the element.
	     * More formally, returns the lowest index {@code i} such that
	     * {@code Objects.equals(o, get(i))},
	     * or -1 if there is no such index.
	     */
		System.out.println(list3.indexOf(300)); // 300이라는 값은 없기때문에 -1나옴
		System.out.println(list3.indexOf(1)); // 1의 인덱스값은 0


	}
} // end of class
