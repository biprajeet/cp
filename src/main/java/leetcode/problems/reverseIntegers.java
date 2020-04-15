package leetcode.problems;

public class reverseIntegers {
	public static int reverse(int x) {

		if (x >= 0) {

			long res = 0;

			while (x > 0) {

				res = res * 10 + x % 10;
				if (res > Integer.MAX_VALUE)
					return 0;
				x /= 10;
			}

			return (int) res;
		} else {
			
			x = - x;
			
			long res = 0;

			while (x > 0) {

				res = res * 10 + x % 10;
				if (-res <  Integer.MIN_VALUE)
					return 0;
				x /= 10;
			}

			return -(int) res;
		}
	}

	public static void main(String[] args) {
		System.out.println(reverse(123));
	}
}
