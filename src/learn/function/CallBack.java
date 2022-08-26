package learn.function;

import java.util.function.Consumer;

public class CallBack {

	public static void main(String[] args) {
		System.out.println("Running callback function");
		functionWithCallback("Java", null, value -> {
			System.out.println(value + "  - Do Not have a last name");
		});
	}

	public static void functionWithCallback(String firstName, String lastName, Consumer<String> callback) {
		System.out.println(firstName);
		if (lastName != null) {
			System.out.println(lastName);
		} else {
			callback.accept(firstName);
		}

	}
}
