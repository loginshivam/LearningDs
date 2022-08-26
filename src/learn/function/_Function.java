package learn.function;

import java.util.function.Function;

public class _Function {
	public static void main(String[] args) {
		System.out.println(multiplyBy10.apply(10));
	}

	static Function<Integer, Integer> multiplyBy10 = number -> number * 10;

}
