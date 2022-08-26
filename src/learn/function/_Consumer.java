package learn.function;

import java.util.function.Consumer;

public class _Consumer {

	public static void main(String[] args) {

		printMyName.accept("KDB");

	}

	static Consumer<String> printMyName = name -> System.out.println("My name is = " + name);

}
