package learn.ds;

import java.util.HashSet;

public class KadansAlgo {
	public static void main(String[] args) {
		System.out.print("Kadan's Algorithm -> ");
		System.out.print(" First Array " + maxSumInAsubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
		System.out.println(" Second Array -> " + maxSumInAsubArray(new int[] { 1 }));
		System.out.print("Buy and Sell -> ");
		System.out.println(buyAndSellProfit(new int[] { 7, 6, 4, 3, 1 }));
		System.out.print("Longest consecutive sequence -> ");
		System.out.print(longestConsecutiveSequence(new int[] { 4, 3, 8, 5, 7, 6 }));
	}

	public static int maxSumInAsubArray(int arr[]) {

		int max = arr[0];
		int sum = 0;

		for (int val : arr) {
			sum = sum + val;
			max = Math.max(max, sum);
			if (sum < 0) {
				sum = 0;
			}
		}

		return max;

	}

	public static int buyAndSellProfit(int arr[]) {

		int max = 0;
		int index = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[index] > arr[i]) {
				index++;
			}
			max = Math.max(max, arr[i] - arr[index]);
		}
		return max;
	}

	// x-1 value exists continue as we want to start from lowest x
	public static int longestConsecutiveSequence(int arr[]) {
		HashSet<Integer> set = new HashSet<Integer>();
		int max = Integer.MIN_VALUE;
		for (int var : arr) {
			set.add(var);
		}

		for (int var : arr) {
			if (set.contains(var - 1)) {
				continue;
			} else {
				int count = 1;
				while (set.contains(var + count)) {
					count++;
				}
				max = Math.max(max, count);
			}

		}
		return max;

	}

	// pending topics matrix

}
