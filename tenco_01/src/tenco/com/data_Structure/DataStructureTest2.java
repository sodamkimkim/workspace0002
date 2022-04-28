package tenco.com.data_Structure;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class DataStructureTest2 {

	public static void main(String[] args) {
		Map map;
		// key와 value구조로 데이터 저장

		HashMap<String, String> map1 = new HashMap<>();

		// null값을 허용하지 않는다.
		// = null에 대해 safty하다.
		Hashtable<String, String> map2 = new Hashtable<>();

		map1.put("A01", "김포공항정문");
		map1.put("A02", "김포공항후문");
		map1.put("A03", "김포공항로비");
		map1.put("B01", "인천공항정문");
		map1.put("B02", "인천공항후문");
		map1.put("B03", "인천공항로비");
		map1.put("C01", null);

		System.out.println(map1);
		System.out.println(map1.get("A03"));
		System.out.println(map1.get("C01"));

		// 삭제방법
		map1.remove("C01"); // 참고로 key값은 대소문자를 확실히 구분한다.

//		map1.clear();
		System.out.println(map1);

		// 사이즈 확인 방법
		System.out.println(map1.size());

// map계열에서 for문을 사용하는 방법
// 방법1. entrySet활용
		// java.util.Map.Entry 패키지가 있음
		for (Entry<String, String> entry : map1.entrySet()) {
			System.out.println("Key : "+ entry.getKey()) ;
			System.out.println("Value : " + entry.getValue());
		}
		// entrySet쓰면 key와 밸류 구분해서 뽑을 수 있어서 유용
		
		System.out.println("=================================");
		
//방법2. keyset()활용 ::: Map 계열의 메서드
		for (String key : map1.keySet()) {
			System.out.println("[key]" + key);
			System.out.println("[value]" + map1.get(key));
		}
		
		
		
		

	} // end of main

} // end of class
