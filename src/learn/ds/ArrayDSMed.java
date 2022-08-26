package learn.ds;

import java.util.ArrayList;
import java.util.HashMap;

// count sort  - when repeated value like sort array of 0 1 2
// moor's voting algorithm - if any number has a frequency more then n/2
/* count = 0 , e =0  
 * for i 0-n-1 
 *   if count == 0 
 *      e =a[i]
 *   if e == a[i] count++
 *   else count--
 * */
// kadane's algorithm - for maximum sub array sum
/* sum =0, max =a[i]
 * for i 0-n-1
 * sum = sum + a[i]
 * max = max(sum,max)
 * if sum < 0 
 * sum = 0
 * */
/* all the sub array of array 
 * select element or not select element with recursion
 * */

public class ArrayDSMed {

	public static void main(String args[]) {

		System.out.println("Pair with given sum ->");
		int arr[] = pairWithGivenSum(new int[] { 3, 2, 4, 6 }, 6);
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println("\nSort array of 0 1 ,2  , a counting sort as well-> ");
		arr = sortArrayOf012(new int[] { 2, 0, 2, 1, 1, 0 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("\nmajority element");
		System.out.println(majorityElement(new int[] { 4, 4, 2, 4, 3, 4, 4, 3, 2, 4 }));
		System.out.println("Moors voting algorithm ->");
		System.out.println(moorsVotingAlgo(new int[] { 3, 2, 3 }));
		System.out.println("Max sum in sub array boot force ->");
		System.out.println(maxSumInSubArray(new int[] { 4, -1, 2, 1 }));
		System.out.println("Array Subarray equals to value ->");
		sumArrayWithGivenSum(0, new int[] { 2, 1, 3, 4, 5, 6 }, new ArrayList<Integer>(), 10);
		System.out.println("All Permutation -> ");
		allPermutation(new int[] { 3, 2, 1 }, new boolean[] { false, false, false }, new ArrayList<Integer>());
		System.out.println("Leader In array ->");
		ArrayList<Integer> list = leaderInArray(new int[] { 10, 22, 12, 3, 0, 6 });
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println("\nLeader in arraylist in order of n -> ");
		list = leaderInArrayInNofNComplexity(new int[] { 10, 22, 12, 3, 0, 6 });
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println("\nBuy and Sell stock max profit-> ");
		int result = buyAndSellStock(new int[] { 7,6,4,3,1 });
		System.out.println(result);

	}

	public static int[] pairWithGivenSum(int arr[], int k) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == k) {
					System.out.println("");
					return new int[] { i, j };

				}
			}
		}
		return null;
	}

	// counting sort example
	// There will limited number of element in array.
	// e.g. array with 0 1 2
	// count and store frequency of each element by index
	// then do a running sum like sums in KDB
	// then move the running sum by 1 to right e.g 1 2 4 6 final 0 1 24
	// now we have element start location in array
	// iterate the original array get index from tmp array store values in new array
	// and update value with 1 in tmp array.
	public static int[] sortArrayOf012(int arr[]) {
		int[] tmp = new int[] { 0, 0, 0 };

		for (int val : arr) {
			tmp[val] = tmp[val] + 1;
		}

		for (int i = 0; i < tmp.length - 1; i++) {
			tmp[i + 1] = tmp[i + 1] + tmp[i];
		}

		for (int i = tmp.length - 1; i > 0; i--) {
			tmp[i] = tmp[i - 1];
		}

		tmp[0] = 0;

		int[] result = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int index = arr[i];
			int tmpIndex = tmp[index];
			result[tmpIndex] = index;
			tmp[index] = tmp[index] + 1;
		}
		return result;
	}

	// majority element algorithm for log n use moors voting algorithm
	public static int majorityElement(int arr[]) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int val : arr) {
			if (map.containsKey(val)) {
				map.put(val, map.get(val) + 1);
				if (map.get(val) + 1 > Math.floor(arr.length / 2)) {
					return val;
				}
			} else {
				map.put(val, 1);
			}
		}

		return -1;
	}

	// Moors voting algorithm as we know an ele exists more then half the length of
	// array
	// majority element
	public static int moorsVotingAlgo(int arr[]) {

		int count = 0;
		int ele = 0;
		for (int i = 0; i < arr.length; i++) {
			if (count == 0) {
				ele = arr[i];
			}
			if (ele == arr[i]) {
				count++;
			} else {
				count--;
			}
		}
		return ele;

	}

	// boot force force n2 complexity
	public static int maxSumInSubArray(int arr[]) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {

				sum = sum + arr[j];

				max = Math.max(max, sum);

			}
		}
		return max;
	}

	// Kadane'S
	public static int maxSumInArrayKadanesAlgo(int arr[]) {
		int sum = 0;
		int max = arr[0];
		for (int val : arr) {
			sum = sum + val;
			if (sum > max) {
				max = sum;
			}
			if (sum < 0) {
				sum = 0;
			}

		}
		return 0;
	}

	// recursive approach
	// Pending sliding window technique
	public static boolean sumArrayWithGivenSum(int ind, int arr[], ArrayList<Integer> list, int k) {

		if (ind >= arr.length) {
			int sum = 0;

			for (int val : list) {
				sum += val;
			}
			if (sum == k) {
				for (int val : list) {
					System.out.print(val + " ");
				}
				System.out.println("");
				return true;
			}
			return false;
		}
		list.add(arr[ind]);
		if (sumArrayWithGivenSum(ind + 1, arr, list, k))
			return true;
		list.remove(list.size() - 1);
		if (sumArrayWithGivenSum(ind + 1, arr, list, k))
			return true;
		return false;
	}

	// generating all the permutation
	public static void allPermutation(int arr[], boolean[] taken, ArrayList<Integer> array) {

		if (array.size() == arr.length) {
			for (int i : array) {
				System.out.print(i + " ");
			}
			System.out.println(" ");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!taken[i]) {
				taken[i] = true;
				array.add(arr[i]);
				allPermutation(arr, taken, array);
				taken[i] = false;
				array.remove(array.size() - 1);
			}

		}
	}

	// boot force for check leader in array
	public static ArrayList<Integer> leaderInArray(int arr[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			boolean leader = true;
			for (int j = i + 1; j < length; j++) {
				if (arr[j] > arr[i]) {
					leader = false;
					break;
				}
			}
			if (leader) {
				list.add(arr[i]);
			}
		}
		return list;
	}

	// o(n) complexity check for leader

	public static ArrayList<Integer> leaderInArrayInNofNComplexity(int arr[]) {
		int length = arr.length;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(arr[length - 1]);
		for (int i = length - 2; i >= 0; i--) {
			if (arr[i] > list.get(list.size() - 1)) {
				list.add(arr[i]);
			}
		}
		return list;
	}

//7,1,5,3,6,4
	public static int buyAndSellStock(int arr[]) {
		int length = arr.length;
		int max = 0;
		int index = 0;
		for (int i = 1; i < length; i++) {
			if (arr[index] > arr[i]) {
				index++;
			} else {
				max = Math.max(max, arr[i] - arr[index]);
			}
		}
		return max;
	}

}
