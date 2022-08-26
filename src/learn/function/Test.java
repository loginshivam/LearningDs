package learn.function;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello");
		// ArrayList<Integer> in = new ArrayList<Integer>();
		allPermutation(new int[] { 1, 2, 3 }, new boolean[] { false, false, false }, new ArrayList<Integer>());

		List<Integer> l = List.of(1, 2, 3, 4);
		List.of(l);

	}

	public static void allPermutation(int arr[], boolean taken[], ArrayList<Integer> list) {

		if (list.size() == arr.length) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!taken[i]) {
				list.add(arr[i]);
				taken[i] = true;
				allPermutation(arr, taken, list);
				taken[i] = false;
				list.remove(list.size() - 1);

			}
		}

	}

}
