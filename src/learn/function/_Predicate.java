package learn.function;

import java.util.function.Predicate;

public class _Predicate {
	public static void main(String[] args) {

		System.out.println(testValidNumber.test(9));
	}

	static Predicate<Integer> testValidNumber = number -> number > 10;

}
