package ch02;

@FunctionalInterface // -> 가능한 써주는게 좋다.
public interface IStringCouncat {
	void makeString(String s1, String s2);
}
