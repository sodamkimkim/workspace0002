package ch02_findMax;

public class MainTest1 {
	public static void main(String[] args) {
		IFindMax findMax = (a, b) -> a > b ? a : b;

		System.out.println(findMax.findMax(50, 200));
	}
}
