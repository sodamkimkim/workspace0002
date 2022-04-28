package tenco.com.data_Structure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class DataStructureTest3 {

	public static void main(String[] args) {
		Set set;
		// set은 순서 없고, 중복된 데이터 담을 수 없다
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(1); // 중복값
		set1.add(2);
		set1.add(3);
		set1.add(3); // 중복값
		set1.add(3); // 중복값
		set1.add(4);

		System.out.println(set1.size()); // 7개 입력했지만 사이즈는 4.

		// 로또 만들때처럼 인덱스 밀어가면서 중복값을 안찾아도 된다.
		// 그냥 set써서 setSize확인해서 6개가 아니면 다시 뽑아라 하면 간단.

		// 값을 삭제하는 방법
		set1.remove(1);
//		set1.clear();
		System.out.println(set1);

		// while 활용해서 요소순회하기
		Iterator<Integer> iter = set1.iterator();
		while (iter.hasNext()) {
			System.out.println("값 확인 :" + iter.next());
		}

		System.out.println("==================================");
		HashSet<Integer> set2 = new HashSet<>();
		set2.add(getRandom());
		set2.add(getRandom());
		set2.add(getRandom());
		set2.add(getRandom());
		set2.add(getRandom());
		set2.add(getRandom());
		System.out.println(set2);

		// Q. 무조건 6개의 번호가 저장된 set2를 완성하시오. ~for, while, if else 자유

		boolean flag = true;
		if (set2.size() == 6) {

			while (flag) {

				System.out.println(set2);
				break;
			}
			flag = false;

		} else {
			flag = false;
			System.out.println("값이 중복됩니다.");
		}

	} // end of main

	// 렌덤 메서드에 활용해보기
	public static int getRandom() {
		Random rd = new Random();
		int value = rd.nextInt(45) + 1;
		return value;
	}

} // end of class

