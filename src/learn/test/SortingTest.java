package learn.test;

public class SortingTest {

	public static void main(String[] args) {
		int ans[] = new int[] { 50, 3, 20, 10, 5 };
		mergeSort(ans, new int[5], 0, 4);
		for (int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println("\nBubble -> ");
		ans = bubbleSort(new int[] { 50, 3, 20, 10, 5 });
		for (int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println("\nselection ->");
		ans = selectionSort(new int[] { 50, 3, 20, 10, 5 });
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

	public static void mergeSort(int arr[], int tmp[], int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(arr, tmp, left, mid);
		mergeSort(arr, tmp, mid + 1, right);
		merge(arr, tmp, left, right, mid);

	}

	public static void merge(int arr[], int tmp[], int left, int right, int mid) {

		int i = left;
		int j = mid + 1;
		int k = left;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				tmp[k] = arr[i];
				i++;
			} else {
				tmp[k] = arr[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			tmp[k] = arr[i];
			i++;
			k++;
		}
		while (j <= right) {
			tmp[k] = arr[j];
			k++;
			j++;
		}

		for (int l = left; l <= right; l++) {
			arr[l] = tmp[l];
		}

	}

	public static int[] bubbleSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		return arr;
	}

	public static int[] selectionSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int minInd = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minInd]) {
					minInd = j;
				}
			}
			int tmp = arr[minInd];
			arr[minInd] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}
	
//50, 3, 20, 10, 5 
}
