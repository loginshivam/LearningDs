package learn.ds;

import java.util.ArrayList;

public class RecursionPattern {

	public static int count = 0;

	public static void main(String[] args) {
		printAllthePermutation(new int[] { 1, 2, 3 }, new boolean[] { false, false, false }, new ArrayList<Integer>());
		sumOfCombinationEqualsTOK(0, 9, new int[] { 5, 2, 3, 6, 7, 4 }, new ArrayList<Integer>());
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		combinationSumToTarget(0, 8, new int[] { 10, 1, 2, 7, 6, 1, 5 }, new ArrayList<Integer>(), list);
		System.out.println("output -> ");
		for (ArrayList<Integer> val : list) {
			for (int v : val) {
				System.out.print(v + " ");
			}
			System.out.print(" | ");
		}
		System.out.println();
		uniqueSubSequence(0, new int[] { 1, 1, 1, 2, 2 }, 4, new ArrayList<Integer>());
		ArrayList<Integer> sum = new ArrayList<Integer>();
		sumOfAllSubSequence(0, 0, new int[] { 3, 1, 2 }, sum);
		System.out.print("\nSum Of all the sum sequence ->");
		sum.sort(null);
		for (int val : sum) {
			System.out.print(val + " ");
		}
		System.out.println("Max profit -> ");
		stockBuySell(new int[] { 1, 7, 4, 5, 9, 2, 6 });
		System.out.println("");
		allPossibleNonDuplicateSubSet(0, new int[] { 1, 2, 2 }, new ArrayList<Integer>());
		int number = 4;
		int[][] arr2 = new int[number][number];
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < number; j++) {
				arr2[i][j] = 0;
			}
		}
		System.out.println("");
		nQueen(0, number, arr2);

	}

	public static void sumOfCombinationEqualsTOK(int ind, int target, int arr[], ArrayList<Integer> list) {

		if (ind >= arr.length) {
			return;
		}
		if (target == 0) {
			for (int i : list) {
				System.out.print(i);
			}
			System.out.print(" | ");
			return;
		}

		if (target >= arr[ind]) {
			list.add(arr[ind]);
			target -= arr[ind];
			sumOfCombinationEqualsTOK(ind, target, arr, list);
			list.remove(list.size() - 1);
			target += arr[ind];
		}
		sumOfCombinationEqualsTOK(ind + 1, target, arr, list);
	}

	public static void combinationSumToTarget(int ind, int k, int arr[], ArrayList<Integer> list,
			ArrayList<ArrayList<Integer>> ans) {
		if (ind >= arr.length) {
			if (k == 0) {
				ans.add(new ArrayList<Integer>(list));
			}
			return;
		}
		list.add(arr[ind]);
		combinationSumToTarget(ind + 1, k - arr[ind], arr, list, ans);
		list.remove(list.size() - 1);
		combinationSumToTarget(ind + 1, k, arr, list, ans);
	}

	public static void uniqueSubSequence(int ind, int arr[], int k, ArrayList<Integer> ans) {
		if (k == 0) {
			for (int i : ans) {
				System.out.print(i + " ");
			}
			System.out.print(" | ");
			return;
		}
		for (int i = ind; i < arr.length; i++) {
			if (i == ind || arr[i] != arr[i - 1]) { // i>0 && a[i]==a[i-1] continue;
				if (k >= arr[i]) {
					ans.add(arr[i]);
					uniqueSubSequence(i + 1, arr, k - arr[i], ans);
					ans.remove(ans.size() - 1);
				}
			}
		}
	}

	public static void sumOfAllSubSequence(int ind, int sum, int arr[], ArrayList<Integer> ans) {
		if (ind >= arr.length) {
			ans.add(sum);
			return;
		}
		sumOfAllSubSequence(ind + 1, sum + arr[ind], arr, ans);
		sumOfAllSubSequence(ind + 1, sum, arr, ans);
	}

	public static void stockBuySell(int arr[]) {
		int max = 0;
		int ind = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[ind] > arr[i]) {
				ind = i;
			}
			max = Math.max(max, arr[i] - arr[ind]);
		}
		System.out.println(max);

	}

	// https://leetcode.com/problems/subsets-ii/
	public static void allPossibleNonDuplicateSubSet(int ind, int arr[], ArrayList<Integer> ans) {
		for (int val : ans) {
			System.out.print(val + " ");
		}
		System.out.print("| ");
		for (int i = ind; i < arr.length; i++) {
			if (i != ind && arr[i] == arr[i - 1])
				continue;
			ans.add(arr[i]);
			allPossibleNonDuplicateSubSet(i + 1, arr, ans);
			ans.remove(ans.size() - 1);
		}
	}

	public static void printAllthePermutation(int arr[], boolean taken[], ArrayList<Integer> ans) {
		if (ans.size() == arr.length) {
			for (int var : ans) {
				System.out.print(var + " ");
			}
			System.out.print(" | ");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!taken[i]) {
				ans.add(arr[i]);
				taken[i] = true;
				printAllthePermutation(arr, taken, ans);
				ans.remove(ans.size());
				taken[i] = false;
			}
		}
	}

	// n Queen
	public static void nQueen(int column, int number, int chess[][]) {

		if (column == number) {
			System.out.println("solution");
			return;
		}

		for (int row = 0; row < number; row++)
			if (checkIfQueenWillAttack(row, column, chess, number)) {
				chess[row][column] = 1;
				nQueen(column + 1, number, chess);
				chess[row][column] = 0;
			}

	}

	public static boolean checkIfQueenWillAttack(int row, int column, int chess[][], int number) {

		int dupRow = row;
		int dupColumn = column;

		while (column >= 0) {
			if (chess[row][column] == 1) {
				return false;
			}
			column--;
		}
		row = dupRow;
		column = dupColumn;
		while (row >= 0 && column >= 0) {
			if (chess[row][column] == 1) {
				return false;
			}
			row--;
			column--;
		}
		row = dupRow;
		column = dupColumn;
		while (row < number && column >= 0) {
			if (chess[row][column] == 1) {
				return false;
			}
			row++;
			column--;
		}
		return true;
	}

}

//7, 4, 5, 6, 10, 3, 11 
//7 4 6 8 10 3 6
