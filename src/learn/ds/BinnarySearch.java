package learn.ds;

import java.text.DecimalFormat;

public class BinnarySearch {
	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat("#.00000");
		System.out.println("Find Root of a number -> " + df.format(findRoot(125, 3)));
		System.out.println(
				"last accurance on shorted array -> " + lastOccurance(new int[] { 3, 4, 13, 13, 13, 20, 40 }, 13));
		System.out
				.println("Count in sorted array -> " + occuranceOfKinSortedArray(new int[] { 1, 1, 2, 2, 2, 2, 2, 3 }, 2));
	}

	public static double findRoot(int number, int nthRoot) {

		double start = 1;
		double end = number / 2;
		double mid = 0;
		while (end - start > 1e-6) {
			mid = (start + end) / 2;
			double mul = multiply(mid, nthRoot);
			if (mul > number) {
				end = mid;
			} else if (mul < number) {
				start = mid;
			} else {
				return mid;
			}
		}

		return mid;
	}

	public static double multiply(double number, int times) {
		double mul = 1;
		for (int i = 1; i <= times; i++) {
			mul *= number;
		}
		return mul;
	}

	public static int lastOccurance(int arr[], int k) {

		int left = 0;
		int right = arr.length - 1;
		int result = -1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == k) {
				result = mid;
				left = mid + 1;
			} else if (arr[mid] > k) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return result;
	}

	public static int occuranceOfKinSortedArray(int arr[], int k) {
		int left = 0;
		int right = arr.length - 1;
		int index = -1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == k) {
				index = mid;
				break;
			} else if (arr[mid] > k) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		int count = 0;
		int dup = index;
		while (dup >= 0) {
			if (arr[dup] == k) {
				count++;
				dup--;
			} else {
				break;
			}
		}
		dup = index + 1;
		while (dup < arr.length) {
			if (arr[dup] == k) {
				count++;
				dup++;
			} else {
				break;
			}
		}

		return count;
	}
}
