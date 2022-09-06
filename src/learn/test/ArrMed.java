package learn.test;

import java.util.HashMap;
import java.util.Map;

public class ArrMed {

	// 2,7,11,15 9
	public static int[] pairWithGivenSum(int arr[], int k) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(k - arr[i])) {
				return new int[] { map.get(k - arr[i]), i };
			} else {
				map.put(arr[i], i);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.print("key of index sum -> ");
		int arr[] = pairWithGivenSum(new int[] { 3, 2, 4, 6 }, 6);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		arr = SortArrayOf012(new int[] { 2, 0, 2, 1, 1, 0, 2, 0, 0, 0, 1, 1 });
		System.out.println("\n Sorted array of 0 ,1 ,2 -> ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\nMajority element -> " + majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));

	}

	public static int[] SortArrayOf012(int arr[]) {
		int ans[] = new int[arr.length];
		int tmp[] = new int[3];
		for (int i : arr) {
			tmp[i] += 1;
		}

		for (int i = 0; i < tmp.length - 1; i++) {
			tmp[i + 1] = tmp[i + 1] + tmp[i];
		}

		for (int i = tmp.length - 1; i > 0; i--) {
			tmp[i] = tmp[i - 1];
		}
		tmp[0] = 0;

		for (int i : arr) {
			ans[tmp[i]] = i;
			tmp[i] += 1;
		}
		return ans;
	}

	// [2,0,2,1,1,0]
	public static int majorityElement(int arr[]) {

		int count = 0;
		int ele = 0;

		for (int i : arr) {
			if (count == 0) {
				ele = i;
			}
			if (ele == i)
				count++;
			else
				count--;
		}
		return ele;
	}
}
