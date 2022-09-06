package learn.test;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
//		List<List<Integer>> list = new List<ArrayList<Integer>>();

		allPermutation(new int[] { 1, 2, 3 }, new boolean[] { false, false, false }, new ArrayList<Integer>());
		int a = 1 / 2;
		System.out.println();
		System.out.println(a);
		int[] arr = new int[] { 1, 3, 5, 6 };
		System.out.println("Binary search " + binnarySearch(new int[] { 10, 20, 30, 40, 50, 50, 60, 70 }, 0, 7, 60));
		System.out.println("Find floor " + findFloor(arr, 0, 7, 9));
		System.out.println("Find Position -> " + findPosition(arr, 0, 7, 4));
		arr = new int[] { 90, 80, 100, 70, 40, 30 };
		System.out.println("Is array sorted -> " + isSorted(arr));
		System.out.println(
				"While Binnary search -> " + binnarySearchWhile(new int[] { 10, 20, 30, 40, 50, 50, 60, 70 }, 65));
		

	}

	public static void allPermutation(int arr[], boolean taken[], ArrayList<Integer> list) {

		if (list.size() == arr.length) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.print(" | ");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!taken[i]) {
				list.add(arr[i]);
				taken[i] = true;
				allPermutation(arr, taken, list);
				list.remove(list.size() - 1);
				taken[i] = false;
			}
		}

	}

	public static int binnarySearch(int arr[], int left, int right, int k) {

		if (left > right)
			return -1;
		int mid = (left + right) / 2;
		if (arr[mid] == k)
			return mid;
		else if (arr[mid] > k)
			return binnarySearch(arr, left, mid - 1, k);
		else
			return binnarySearch(arr, mid + 1, right, k);
	}

	public static int findFloor(int arr[], int start, int end, int k) {

		if (end < 0)
			return -1;
		else if (start >= arr.length)
			return arr[arr.length - 1];
		else if (start > end)
			return arr[end];

		int mid = (start + end) / 2;
		if (arr[mid] >= k)
			return findFloor(arr, start, mid - 1, k);
		else
			return findFloor(arr, mid + 1, end, k);
	}

	public static int findPosition(int arr[], int start, int end, int k) {

		if (end < 0 || start >= arr.length || start > end)
			return start;
		int mid = (start + end) / 2;
		if (arr[mid] == k)
			return mid;
		else if (arr[mid] > k)
			return findPosition(arr, start, mid - 1, k);
		else
			return findPosition(arr, mid + 1, end, k);
	}

	public static boolean isSorted(int arr[]) {

		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i])
				return false;
		}

		return true;
	}

	public static boolean binnarySearchWhile(int arr[], int k) {
		int left = 0;
		int right = arr.length - 1;

		while (right > left) {
			int mid = (left + right) / 2;
			if (arr[mid] == k)
				return true;
			else if (arr[mid] > k)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
	}

	//{3,4,13,13,13,20,40}
	

}
