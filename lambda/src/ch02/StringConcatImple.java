package ch02;

public class StringConcatImple implements IStringCouncat {
	@Override
	public void makeString(String s1, String s2) {
		System.out.println("***" + s1 + "," + s2 + "***");
	}
}
