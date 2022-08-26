package learn.ds;

import java.util.HashMap;

public class ArrayDS {

	public static void main(String args[]) {
		System.out.println("Largest element in array ->");
		System.out.println(largestEleInArray(new int[] { 10, 20, 40, 30, 100, 50, 60, 45, 200, 35, 65, 78, 98 }));
		System.out.println("Second Largest in array -> ");
		System.out.println(secondLargestEleInArray(new int[] { 10, 50, 20, 60, 30, 80, 100, 200 }));
		System.out.println("Is array sorted ->");
		System.out.println(isArraySorted(new int[] { 10, 20, 30, 40, 50 }));
		System.out.println("Remove Duplicate from sorted array ->");
		removeDuplicateFromSortedArray(new int[] { 1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 5, 6, 7, 8, 9, 9, 10 });
		System.out.println("\nRotate arry by 1 to left");
		rotateArrayToLeftByOne(new int[] { 10, 20, 30, 40, 50, 60 });
		System.out.println("\nRotae by k right");
		rotateArrayByNToRight(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 2);
		System.out.println("\n Move zeros to end");
		moveZerosToEnd(new int[] { 1, 0, 2, 3, 0, 4, 0, 1 });
		System.out.println("\nLinear Search ->");
		System.out.println(linearSearch(new int[] { 20, 40, 50, 60, 70 }, 10));
		System.out.println("Find Missing value and repeat value -> ");
		int arr[] = findMissingAndRepeat(new int[] { 3, 1, 2, 5, 4, 6, 7, 5 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\nMax consitive Count of 1 ->");
		System.out.println(maxConsecutiveOne(new int[] { 1, 0, 1, 1, 0, 1 }));
		System.out.println("Search in 2D array ->");
		int array2D[][] = new int[][] { { 10, 20, 30, 40 }, { 50, 60, 70, 80 }, { 90, 100, 110, 120 },
				{ 130, 140, 150, 160 } };
		System.out.println(searchEleIn2DArray(array2D, 1500));
		System.out.println("Max 1 count in row ->");
		int[][] arr1 = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		rowWithMaxNumberOfOne(arr1);
		int[][] arr2 = {{0, 0}, {1, 1}};
		rowWithMaxNumberOfOne(arr2);
	}

	public static int largestEleInArray(int arr[]) {
		int tmp = arr[0];

		for (int val : arr) {
			if (val > tmp) {
				tmp = val;
			}
		}
		return tmp;
	}

	public static int secondLargestEleInArray(int arr[]) {
		int first = arr[0];
		int second = Integer.MIN_VALUE;

		for (int val : arr) {
			if (val > first) {
				second = first;
				first = val;
			}
			if (val < first && val > second) {
				second = val;
			}
		}
		return second;
	}

	public static boolean isArraySorted(int arr[]) {
		int tmp = arr[0];

		for (int val : arr) {
			if (val < tmp) {
				return false;
			} else {
				tmp = val;
			}
		}

		return true;
	}

	public static void removeDuplicateFromSortedArray(int arr[]) {

		int ind = 0;

		for (int i = 1; i < arr.length; i++) {
			if (!(arr[i] == arr[ind])) {

				ind++;
				arr[ind] = arr[i];

			}
		}
		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	public static void rotateArrayToLeftByOne(int arr[]) {

		int tmp = arr[0];

		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}

		arr[arr.length - 1] = tmp;

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void rotateArrayByNToRight(int arr[], int k) {
		int tmp[] = new int[k];
		int index = k - 1;
		for (int i = arr.length - k - 1; i >= 0; i--) {
			if (index >= 0) {
				tmp[index] = arr[i + k];
				index--;
			}
			arr[i + k] = arr[i];

		}

		for (int i = 0; i < k; i++) {
			arr[i] = tmp[i];
		}
		for (int var : arr) {
			System.out.print(var + " ");
		}
	}

	public static void moveZerosToEnd(int arr[]) {
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[index] = arr[i];
				index++;

			}
		}

		while (index < arr.length) {
			arr[index] = 0;
			index++;
		}

		for (int i : arr) {
			System.out.print(i + " ");
		}

	}

	public static boolean linearSearch(int arr[], int k) {
		for (int i : arr) {
			if (i == k) {
				return true;
			}
		}
		return false;
	}

	public static int[] findMissingAndRepeat(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int sum = 0;
		int actualSum = 0;

		for (int i = 0; i < arr.length; i++) {
			actualSum = actualSum + i + 1;
			int value = arr[i];
			sum = sum + value;
			if (map.containsKey(value)) {
				map.put(value, map.get(value) + 1);
			} else {
				map.put(value, 1);
			}
		}

		int dup = 0;

		for (int val : map.keySet()) {
			if (map.get(val) == 2) {
				dup = val;
				break;
			}
		}

		return new int[] { dup, dup + actualSum - sum };
	}

	public static int maxConsecutiveOne(int arr[]) {
		int curruntCount = 0;
		int maxCount = 0;
		for (int i : arr) {
			if (i == 1) {
				curruntCount++;
				if (curruntCount > maxCount) {
					maxCount = curruntCount;
				}
			} else {
				curruntCount = 0;
			}
		}
		return maxCount;
	}

	public static boolean searchEleIn2DArray(int arr[][], int k) {

		for (int[] values : arr) {
			for (int val : values) {
				if (val == k) {
					return true;
				}
			}
		}
		return false;
	}

	public static int[] rowWithMaxNumberOfOne(int arr[][]) {

		int maxCount = 0;
		int row = -1;
		for (int i = 0; i < arr.length; i++) {
			int localCount = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 1) {
					localCount++;
				}
			}
			if (localCount > maxCount) {
				maxCount = localCount;
				row = i;
			}
		}
		System.out.println("Row " + row + " count= " + maxCount);
		return new int[] { row, maxCount };
	}

}
