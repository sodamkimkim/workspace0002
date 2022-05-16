package ch02;

public class MainTestFindMax {
	public static void main(String[] args) {
		IFindMax iFindMaxLamda = (a, b) -> {
			int max = b;
			if (a > b) {
				max = a;
				return max;
			}
			return max;
		};
		System.out.println(iFindMaxLamda.findMax(5, 6));
	}
}
