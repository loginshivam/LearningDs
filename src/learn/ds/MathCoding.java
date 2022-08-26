package learn.ds;

public class MathCoding {

	public static void main(String args[]) {

		System.out.println("Count Number ->");
		System.out.print(countNumber(10000));
		System.out.println("Reverse A number ->");
		System.out.println(reverseNumber(12345));
		System.out.println("Check Number palindrome");
		System.out.println(checkPalandromNumber(1234));
		System.out.println("Calculate GCD");
		System.out.println(calculateGCD(33, 66));
		System.out.println("Check ARM ->");
		System.out.println(checkARMStrongNumber(153));
		System.out.println("PrintAll Division ->");
		printAllDivisiver(97);
		System.out.println("Check For Prime");
		System.out.println(checkForPrime(51));
	}

	public static int countNumber(int number) {
		int count = 0;
		while (number > 0) {
			count++;
			number = Math.abs(number / 10);
		}

		return count;
	}

	public static int reverseNumber(int number) {

		int revNumber = 0;

		while (number > 0) {
			int mod = number % 10;
			revNumber = revNumber * 10 + mod;
			number = Math.abs(number / 10);
		}

		return revNumber;
	}

	public static boolean checkPalandromNumber(int number) {

		int tmp = number;
		int revNumber = 0;

		while (number > 0) {
			int mod = number % 10;
			revNumber = revNumber * 10 + mod;
			number = Math.abs(number / 10);
		}

		return tmp == revNumber;
	}

	public static int calculateGCD(int num1, int num2) {
		if (num1 == num2) {
			return num1;
		}
		if (num1 > num2) {
			return calculateGCD(num1 - num2, num2);
		} else {
			return calculateGCD(num1, num2 - num1);
		}
	}

	// ARM strong number is sum of cube of each digit
	public static boolean checkARMStrongNumber(int number) {

		int tmp = number;
		int arm = 0;

		while (number > 0) {
			int mod = number % 10;
			arm = arm + (int) Math.pow(mod, 3);
			number = Math.abs(number / 10);
		}

		return arm == tmp;
	}

	public static void printAllDivisiver(int number) {

		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				System.out.print(i + " ");
			}
		}
	}

	public static boolean checkForPrime(int number) {

		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
