package learn.ds.stack;

import java.util.Stack;

public class BalancedParenthisis {

	public static void main(String[] args) {

		System.out.println(checkBalanced("{()}()[{}]"));
		System.out.println(checkBalanced("{})([]"));
		System.out.println(checkBalanced("}()[]"));
		System.out.println(checkBalanced("[]"));
		System.out.println(checkBalanced("{(})"));
		int arr[] = ngt(new int[] { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 });
		arr = ngt(new int[] { 2, 10, 12, 1, 11 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static boolean checkBalanced(String str) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if (!((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '['))) {
					return false;
				}
			}
		}
		if (!stack.isEmpty())
			return false;

		return true;
	}

	public static int[] ngt(int arr[]) {
		final int size = arr.length;
		int[] tmp = new int[size];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 2 * size - 1; i >= 0; i--) {
			while (!stack.empty() && stack.peek() <= arr[i % size]) {
				stack.pop();
			}
			if (i < size) {
				if (!stack.isEmpty()) {
					tmp[i] = stack.peek();
				} else {
					tmp[i] = -1;
				}
			}
			stack.push(arr[i % size]);
		}

		return tmp;
	}

}
