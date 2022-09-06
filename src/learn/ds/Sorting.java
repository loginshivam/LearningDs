package learn.ds;

public class Sorting {
	public static void main(String[] args) {
		int ans[] = selectionSort(new int[] { 15, 28, 17, 12, 18, 9, 6 });
		for (int val : ans) {
			System.out.print(val + " ");
		}
		System.out.println();
		ans = bubbleSort(new int[] { 8, 2, 4, 1, 3 });
		for (int val : ans) {
			System.out.print(val + " ");
		}
		System.out.println();
		ans = insertionSort(new int[] { 8, 2, 4, 1, 3 });
		for (int val : ans) {
			System.out.print(val + " ");
		}
		int[] result = new int[10];
		mergeSort(new int[] { 60, 40, 20, 5, 10 ,100,300,120,140,80}, result, 0, 9);
		System.out.println("-------");
		for (int a : result) {
			System.out.print(a + " ");
		}
		
	}

//15 28 17 12 18 9 6
	public static int[] selectionSort(int arr[]) {
		int minIndex;
		int tmp;
		for (int i = 0; i < arr.length; i++) {
			minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		}
		return arr;
	}

	// 8 2 4 1 3
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

	public static int[] insertionSort(int arr[]) {

		for (int i = 1; i < arr.length; i++) {
			int current = arr[i];
			int j = i - 1;
			while (j >= 0 && current < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = current;
		}

		return arr;
	}

	// 0 1 2 3 4 5 6 7 8 9
	// 10 5 2 7 4 9 12 1 8 6
	public static void mergeSort(int arr[], int tmp[], int left, int right) {
		if (left >= right)
			return;

		int mid = (left + right) / 2;
		mergeSort(arr, tmp, left, mid);
		mergeSort(arr, tmp, mid + 1, right);
		merge(arr, tmp, left, right);
	}

	public static void merge(int arr[], int tmp[], int left, int right) {

		int mid = (left + right) / 2;
		int i = left, j = mid + 1, k = left;

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
			k++;
			i++;
		}
		while (j <= right) {
			tmp[k] = arr[j];
			k++;
			j++;
		}
		
		for (int l=left;l<=right;l++) {
			arr[l]=tmp[l];
		}
		
	}
}
