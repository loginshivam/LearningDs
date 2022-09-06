package learn.ds;

import java.util.ArrayList;
import java.util.List;

public class ArrayDS {

	public static int largestElement(int arr[]) {
		int max = Integer.MIN_VALUE;
		for (int val : arr) {
			max = Math.max(val, max);
		}
		return max;
	}

	public static int largestElementM(int arr[]) {
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			max = (i > max) ? i : max;
		}
		return max;
	}

	public static int secondLargest(int arr[]) {
		int first = arr[0];
		int second = Integer.MIN_VALUE;
		for (int val : arr) {
			if (val > first) {
				second = first;
				first = val;
			} else if (second < val && val < first) {
				second = val;
			}
		}
		return second;
	}

	public static boolean isArraySorted(int arr[]) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;

	}

	public static int[] removeDuplicate(int arr[]) {

		int ind = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				ind++;
				arr[ind] = arr[i];
			}
		}
		return arr;
	}

	// 2 2 4 5 5 5 6 7 8 9 9

	public static int[] rotateArrayByOne(int arr[]) {

		int tmp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[arr.length - 1] = tmp;

		return arr;
	}

	public static int[] moveZeroTOend(int arr[]) {
		int ind = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[ind] = arr[i];
				ind++;
			} else
				count++;
		}

		for (int i = arr.length - count; i < arr.length; i++) {
			arr[i] = 0;
		}

		return arr;
	}
	// 0, 1, 0, 0, 2, 3, 0, 0, 0, 4, 5

	public static int linearSearch(int arr[], int k) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == k) {
				return i;
			}
		}
		return -1;
	}

	public static List<Integer> unionOfArray(int arr1[], int arr2[]) {
		int i = 0;
		int j = 0;
		List<Integer> tmp = new ArrayList<Integer>();
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) {
				if (tmp.size() == 0 || tmp.get(tmp.size() - 1) != arr1[i])
					tmp.add(arr1[i]);
				i++;
			} else {
				if (tmp.size() == 0 || tmp.get(tmp.size() - 1) != arr2[j])
					tmp.add(arr2[j]);
				j++;
			}

		}

		while (i < arr1.length) {
			if (tmp.get(tmp.size() - 1) != arr1[i])
				tmp.add(arr1[i]);
			i++;
		}

		while (j < arr2.length) {
			if (tmp.get(tmp.size() - 1) != arr2[j])
				tmp.add(arr2[j]);
			j++;
		}
		return tmp;
	}

	// 1 2 3 4 5 6 3 3 5 7
	public static List<Integer> intersectionOfArray(int arr1[], int arr2[]) {
		int i = 0;
		int j = 0;
		List<Integer> arr = new ArrayList<Integer>();
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] == arr2[j]) {
				arr.add(arr1[i]);
				i++;
				j++;
			} else if (arr1[i] < arr2[j])
				i++;
			else
				j++;
		}
		return arr;

	}

	public static void main(String[] args) {
		System.out.println("largest element -> " + largestElement(new int[] { 10, 100, 500, 30, 4, 99 }));
		System.out.println("Largest element code -> " + largestElementM(new int[] { 10, 100, 500, 30, 4, 99 }));
		System.out.println("Second Largest -> " + secondLargest(new int[] { -10, -200, -500, -30, -4, -99 }));
		System.out.println("Check array Sorted -> " + (isArraySorted(new int[] { -10, -200, -500, -30, -4, -99 })));
		System.out.println("Check array Sorted -> " + (isArraySorted(new int[] { 10, 20, 30, 40, 50 })));
		int ans[] = removeDuplicate(new int[] { 1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 7, 7, 7, 7, 8, 9 });
		System.out.print("Remove duplicate from sorted array -> ");
		for (int val : ans) {
			System.out.print(val + " ");
		}
		System.out.print("\nRotate Array by one -> ");
		ans = rotateArrayByOne(new int[] { 1, 2, 3, 4, 5 });
		for (int val : ans) {
			System.out.print(val + " ");
		}
		System.out.print("\nMove Zero to end -> ");
		ans = moveZeroTOend(new int[] { 0, 1, 0, 0, 2, 3, 0, 0, 0, 4, 5 });
		for (int val : ans) {
			System.out.print(val + " ");
		}
		System.out.println("\nLenear Search -> Index = " + linearSearch(new int[] { 10, 2, 30, 4, 15 }, 4));
		System.out.print("Union Of Array -> ");
		List<Integer> result = unionOfArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 3, 4, 4, 5 });
		for (int val : result) {
			System.out.print(val + " ");
		}
		System.out.print("\nIntersection Of array -> ");
		result = intersectionOfArray(new int[] { 1, 2, 3, 4, 5 }, new int[] { 2, 3, 4, 4, 6 });
		for (int val : result) {
			System.out.print(val + " ");
		}
	}
	
}

