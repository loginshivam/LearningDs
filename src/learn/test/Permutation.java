package learn.test;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {

		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		allPermutation(new int[] { 1, 2, 3 }, new boolean[] { false, false, false }, new ArrayList<Integer>(), ans);

		for (List<Integer> val : ans) {
			for (int i : val) {
				System.out.print(i + " ");
			}
			System.out.print(" | ");
		}
		ans = new ArrayList<List<Integer>>();
		allSubSequence(0, new int[] { 1, 2, 3 }, new ArrayList<Integer>(), ans);
		System.out.println();
		for (List<Integer> val : ans) {
			for (int i : val) {
				System.out.print(i + " ");
			}
			System.out.print(" | ");
		}
	}

	public static void allPermutation(int arr[], boolean taken[], ArrayList<Integer> list, List<List<Integer>> ans) {

		if (list.size() == arr.length) {
			ans.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!taken[i]) {
				list.add(arr[i]);
				taken[i] = true;
				allPermutation(arr, taken, list, ans);
				list.remove(list.size() - 1);
				taken[i] = false;
			}
		}
	}

	public static void allSubSequence(int ind, int arr[], ArrayList<Integer> list, List<List<Integer>> ans) {
		if (ind >= arr.length) {
			ans.add(new ArrayList<Integer>(list));
			return;
		}
		list.add(arr[ind]);
		allSubSequence(ind + 1, arr, list, ans);
		list.remove(list.size() - 1);
		allSubSequence(ind + 1, arr, list, ans);
	}

}
