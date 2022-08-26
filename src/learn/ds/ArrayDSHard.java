package learn.ds;

public class ArrayDSHard {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		pascalTringle(6);
	}

	public static void pascalTringle(int row) {
		int arr[] = new int[] { 1 };
		for (int i = 0; i < row; i++) {
			for (int var : arr) {
				System.out.print(var + " ");
			}
			System.out.println();
			int tmp[] = new int[arr.length + 1];
			for (int j = 0; j < arr.length - 1; j++) {
				tmp[j + 1] = arr[j] + arr[j + 1];
			}
			tmp[0] = 1;
			tmp[tmp.length - 1] = 1;
			arr = tmp;
		}

	}

}
