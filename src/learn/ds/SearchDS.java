package learn.ds;

public class SearchDS {
	public static void main(String[] args) {
		System.out.println("Binary Search");

		System.out.println(binarySearch(new int[] { 10, 20, 30, 40, 50, 60 }, 400, 0, 5));
		System.out.println(floorInshortedArray(new int[] { 1, 2, 8, 10, 11, 12, 19 }, 0, 6, 0));
		System.out.println(floorInshortedArray(new int[] { 1,2,8,10,11,12,19 }, 0, 6, 5));

	}

	static boolean binarySearch(int arr[], int search, int start, int end) {
		int mid = (start + end) / 2;

		if (start > end) {
			return false;
		}

		if (search == arr[mid]) {
			return true;
		} else if (search < arr[mid]) {
			return binarySearch(arr, search, start, mid - 1);
		} else {
			return binarySearch(arr, search, mid + 1, end);
		}

	}

	static int floorInshortedArray(int arr[], int start, int end, int k) {

		if (start > end) {
			return end;
		}
		int mid = (start + end) / 2;

		if (k == arr[mid]) {
			return mid - 1;
		} else if (k > arr[mid]) {
			return floorInshortedArray(arr, mid + 1, end, k);
		} else {
			return floorInshortedArray(arr, start, mid - 1, k);
		}

	}

}
