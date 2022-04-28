package ch07;

import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) {

		Car[] cars = new Car[5];

		cars[0] = new Car(1, "BMW");
		cars[1] = new Car(2, "폭스바겐");
		cars[2] = new Car(3, "현대");
		cars[3] = new Car(4, "현대");
		cars[4] = new Car(5, "현대");
		Scanner scanner =new Scanner(System.in);
		System.out.println("자동차 id를 입력하세요");
		int tempNum = scanner.nextInt();
		
		
		for (int i = 0; i < cars.length; i++) {
			
			if(cars[i].equals(cars[tempNum])){
				System.out.println(i + "번째 차와 같은 종류 차입니다.");
			}else {
				System.out.println(i + "번째 차와 다른 종류 입니다.");
			}
			
		}

	}
}
