import java.util.*;

public class FibonacciPartialSum {
	private static long getFibonacciPartialSumFast(long from, long to) {
		if (from == to) {
			return getFibonacciLastDigitFast(from % 60);
		}
		long m = getFibonacciLastDigitFast((from + 1) % 60);
		long n = getFibonacciLastDigitFast((to + 2) % 60);
		// System.out.println(m + " "+n);
		return ((n - m) % 10 + 10) % 10;
	}

	private static long getFibonacciLastDigitFast(long n) {
		if (n <= 1)
			return n;

		long previous = 0;
		long current = 1;

		for (int i = 0; i < n - 1; ++i) {
			long tmp_previous = previous;
			previous = current;
			current = (tmp_previous + current);
		}
		return (current) % 10;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long from = scanner.nextLong();
		long to = scanner.nextLong();
		System.out.println(getFibonacciPartialSumFast(from, to));
	}
}
