package learn.function;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionInJava {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		List<Person> persons = List.of(new Person("Kdb", Gender.MALE), new Person("Java", Gender.FEMALE),
				new Person("Python", Gender.FEMALE), new Person("kafka", Gender.MALE));

		persons.stream().filter(person -> Gender.FEMALE.equals(person.gender)).collect(Collectors.toList())
				.forEach(System.out::println);
		System.out.println(checkValue.apply(20));
		System.out.println(finalFunction.apply(1));

		persons.stream().map(getPersonName).mapToInt(String::length).forEach(System.out::println);

		persons.stream().filter(filterGender).forEach(System.out::println);
		System.out.println(persons.stream().allMatch(filterGender));
		//noneMatch anyMatch

	}

	static Predicate<Person> filterGender = person -> Gender.FEMALE.equals(person.gender);
	static Function<Person, String> getPersonName = person -> person.name;

	static Function<Integer, Integer> multiplyBy10 = number -> number * 10;
	static Function<Integer, Boolean> checkValue = number -> number > 10;
	static Function<Integer, Boolean> finalFunction = multiplyBy10.andThen(checkValue);

	record Person(String name, Gender gender) {

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}

	}
//	static class Person {
//		public final String name;
//		public final Gender gender;
//
//		public Person(String name, Gender gender) {
//			super();
//			this.name = name;
//			this.gender = gender;
//		}
//
//	}

	enum Gender {
		MALE, FEMALE
	}

}
