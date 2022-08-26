package learn.ds;

import java.util.HashMap;
import java.util.Map;

public class Recursion {

	public static void main(String args[]) {
		System.out.println("Print something N time ->");
		printSomethingNTime(5);
		System.out.println("Print 1 to N -> ");
		print1ToN(5);
		System.out.println("Print N to 1 -> ");
		printNTo1(5);
		System.out.println("Print sum of n number ->");
		System.out.println(sumNNumber(5));
		System.out.println("Reverse Array -> ");
		int arr[] = new int[] { 10, 20, 30, 40, 50 };
		reverseArray(0, arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\nPrint Factorail ->");
		printFactorial(1, 1, 120);
		System.out.println("Check if palandrome ->");
		System.out.println(checkIfStringIsPalinDrome(0, "kayak".toCharArray()));
		System.out.println("Palindrome of a string check ->");
		System.out.println(checkPalindromeOfString(0, "kayak"));
		System.out.println("Print Fabonacci -> ");
		System.out.println(febonacci(6));
		System.out.println("Count Frequency in array -> ");
		Map<Integer, Integer> map = countFrequencyInArray(new int[] { 10, 20, 20, 30, 40, 50, 40, 10, 10, 30, 30,30,30,50,50,40 });

		for (int i : map.keySet()) {
			System.out.println(i + "   " + map.get(i));
		}
		System.out.println("High and low ->");
		arr = findHignAndLowFrequency(map);
		for (int i : arr) {
			System.out.println(i);
		}

	}

	public static void printSomethingNTime(int number) {
		if (number < 1) {
			return;
		}
		System.out.println("Something");
		printSomethingNTime(number - 1);
	}

	public static void print1ToN(int number) {
		if (number < 1) {
			return;
		}
		print1ToN(number - 1);
		System.out.println(number);
	}

	public static void printNTo1(int number) {
		if (number < 1) {
			return;
		}
		System.out.println(number);
		printNTo1(number - 1);
	}

	public static int sumNNumber(int number) {
		if (number <= 1) {
			return number;
		}
		return number + sumNNumber(number - 1);
	}

	public static void reverseArray(int index, int arr[]) {
		int length = arr.length;
		if (index > Math.abs(length / 2)) {
			return;
		}

		int tmp = arr[index];
		arr[index] = arr[length - 1 - index];
		arr[length - 1 - index] = tmp;
		reverseArray(index + 1, arr);
	}

	public static void printFactorial(int number, int fact, int factorial) {
		if (fact > factorial) {
			return;
		}
		System.out.println(fact);
		printFactorial(number + 1, fact * (number + 1), 120);
	}

	public static boolean checkIfStringIsPalinDrome(int ind, char st[]) {
		int length = st.length;
		if (ind > Math.abs(length / 2)) {
			return true;
		}
		if (!(st[ind] == st[length - 1 - ind])) {
			return false;
		}
		return checkIfStringIsPalinDrome(ind + 1, st);
	}

	public static boolean checkPalindromeOfString(int ind, String str) {
		int length = str.length();
		if (ind > Math.abs(length) / 2) {
			return true;
		}
		if (!(str.charAt(ind) == str.charAt(length - 1 - ind))) {
			return false;
		}

		return checkPalindromeOfString(ind + 1, str);
	}

	public static int febonacci(int number) {
		if (number <= 1) {
			return 1;
		}
		int num = febonacci(number - 1) + febonacci(number - 2);
		return num;
	}

	public static Map<Integer, Integer> countFrequencyInArray(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if (map.get(i) == null) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}

		return map;
	}

	public static int[] findHignAndLowFrequency(Map<Integer, Integer> map) {

		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		int low_index = -1;
		int high_index = -1;

		for (int i : map.keySet()) {

			int val = map.get(i);

			if (val > high) {
				high = val;
				high_index = i;
			}

			if (val < low) {
				low = val;
				low_index = i;
			}

		}

		return new int[] { low_index, high_index };
	}
}
//1 1 2 3 5 8
