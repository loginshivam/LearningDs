package learn.test;

import java.util.ArrayList;

public class RecursionPractice {

	public static void main(String arg[]) {
		printName(1, 5);
		print1ToN(10);
		System.out.println();
		printNTo1(10);
		System.out.println();
		printNTo1BackTrack(1, 10);
		System.out.println();
		System.out.println(sumOfFirstNNumber(3));
		sumOfFirstNNumberParam(3, 0);
		reverseArray(0, new int[] { 10, 20, 30, 40, 50 });
		System.out.println();
		reverseArray(0, new int[] { 10, 20, 30, 40 });
		System.out.println();
		System.out.println(checkPalindrome(0, "kayak", 5));
		System.out.println(checkPalindrome(0, "madsm", 4));
		System.out.println(checkPalindrome(0, "hello", 5));
		System.out.println(fabo(4));
		printAllSubSequence(0, new int[] { 1, 2, 3 }, new ArrayList<Integer>());
		System.out.println();
		printSubSequenceWhoseSumIsK(0, 2, new int[] { 1, 2, 1 }, new ArrayList<Integer>());
		System.out.print("\n-> ");
		printOnlyOneSubSeqWhoseSumIsK(0, 2, new int[] { 1, 2, 1 }, 0, new ArrayList<Integer>());
		System.out.print("Number Of Count -> ");
		System.out.print(countSubSequenceWithSumK(0, 2, 2, new int[] { 1, 2, 1 }));
		System.out.println();
		allPermutation(new int[] { 1, 2, 3 }, new boolean[] { false, false, false }, new ArrayList<Integer>());
		uniqueCombination(0, new int[] { 1, 1 ,2 }, new ArrayList<Integer>());
	}

	public static void printName(int start, int end) {
		if (start > end) {
			return;
		}
		System.out.println("Kdb");
		printName(start + 1, end);
	}

	public static void print1ToN(int number) {

		if (number <= 0) {
			return;
		}
		print1ToN(number - 1);
		System.out.print(number + " ");

	}

	public static void printNTo1(int number) {
		if (number <= 0) {
			return;
		}
		System.out.print(number + " ");
		printNTo1(number - 1);
	}

	public static void printNTo1BackTrack(int start, int end) {
		if (start > end) {
			return;
		}
		printNTo1BackTrack(start + 1, end);
		System.out.print(start + " ");

	}

	public static int sumOfFirstNNumber(int n) {
		if (n == 1) {
			return 1;
		}
		return n + sumOfFirstNNumber(n - 1);
	}

	public static void sumOfFirstNNumberParam(int n, int sum) {
		if (n < 1) {
			System.out.println(sum);
			return;
		}
		sumOfFirstNNumberParam(n - 1, sum + n);
	}

	public static void reverseArray(int ind, int arr[]) {
		int length = arr.length;
		if (ind >= Math.floor(length / 2)) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			return;
		}
		int tmp = arr[ind];
		arr[ind] = arr[length - 1 - ind];
		arr[length - 1 - ind] = tmp;
		reverseArray(ind + 1, arr);
	}

	public static boolean checkPalindrome(int ind, String str, int length) {
		if (ind >= Math.floor(length / 2)) {
			return true;
		}
		if (str.charAt(ind) != str.charAt(length - 1 - ind)) {
			return false;
		}

		return checkPalindrome(ind + 1, str, length);
	}

	public static int fabo(int number) {
		if (number <= 1) {
			return number;
		}
		return fabo(number - 1) + fabo(number - 2);
	}

	public static void printAllSubSequence(int ind, int arr[], ArrayList<Integer> ans) {
		if (ind >= arr.length) {
			for (int var : ans) {
				System.out.print(var + " ");
			}
			System.out.print(" | ");
			return;
		}
		ans.add(arr[ind]);
		printAllSubSequence(ind + 1, arr, ans);
		ans.remove(ans.size() - 1);
		printAllSubSequence(ind + 1, arr, ans);
	}

	public static void printSubSequenceWhoseSumIsK(int ind, int k, int arr[], ArrayList<Integer> ans) {
		if (ind >= arr.length) {
			int sum = 0;
			for (int i : ans) {
				sum += i;
			}
			if (sum == k) {
				for (int val : ans) {
					System.out.print(val + " ");
				}
				System.out.print(" | ");
			}

			return;
		}
		ans.add(arr[ind]);
		printSubSequenceWhoseSumIsK(ind + 1, k, arr, ans);
		ans.remove(ans.size() - 1);
		printSubSequenceWhoseSumIsK(ind + 1, k, arr, ans);
	}

	public static boolean printOnlyOneSubSeqWhoseSumIsK(int ind, int k, int arr[], int sum, ArrayList<Integer> ans) {
		if (ind >= arr.length) {
			if (sum == k) {
				for (int val : ans) {
					System.out.print(val + " ");
				}
				return true;
			} else {
				return false;
			}
		}
		sum += arr[ind];
		ans.add(arr[ind]);
		if (printOnlyOneSubSeqWhoseSumIsK(ind + 1, k, arr, sum, ans)) {
			return true;
		}
		sum -= arr[ind];
		ans.remove(ans.size() - 1);
		if (printOnlyOneSubSeqWhoseSumIsK(ind + 1, k, arr, sum, ans))
			return true;
		return false;
	}

	public static int countSubSequenceWithSumK(int ind, int sum, int k, int arr[]) {

		if (ind >= arr.length) {
			if (sum == k)
				return 1;
			else
				return 0;
		}
		sum += arr[ind];
		int select = countSubSequenceWithSumK(ind + 1, sum, k, arr);
		sum -= arr[ind];
		int notselect = countSubSequenceWithSumK(ind + 1, sum - arr[ind], k, arr);
		return select + notselect;
	}

	public static void allPermutation(int arr[], boolean taken[], ArrayList<Integer> ans) {
		if (ans.size() == arr.length) {
			for (int i : ans) {
				System.out.print(i + " ");
			}
			System.out.print(" | ");
		}
		for (int i = 0; i < arr.length; i++) {
			if (!taken[i]) {
				ans.add(arr[i]);
				taken[i] = true;
				allPermutation(arr, taken, ans);
				ans.remove(ans.size() - 1);
				taken[i] = false;
			}
		}
	}

	public static void uniqueCombination(int ind, int arr[], ArrayList<Integer> ans) {
		for (int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println(" | ");
		for (int i = ind; i < arr.length; i++) {
			if (i != ind && arr[i] == arr[i - 1])
				continue;
			ans.add(arr[i]);
			uniqueCombination(i + 1, arr, ans);
			ans.remove(ans.size() - 1);
		}

	}
	
	public static void uniqueCombinationSumEqualK(int ind, int arr[], ArrayList<Integer> ans) {
		for (int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println(" | ");
		for (int i = ind; i < arr.length; i++) {
			if (i != ind && arr[i] == arr[i - 1])
				continue;
			ans.add(arr[i]);
			uniqueCombination(i + 1, arr, ans);
			ans.remove(ans.size() - 1);
		}

	}
}
