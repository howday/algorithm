import java.util.*;

public class LCM {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println(lcm_naive(a, b));
	}

	private static long lcm_naive(int a, int b) {

		long gcd = gcd_naive(a, b);
		
		long aRem = a / gcd;
		long bRem = b / gcd;

		return aRem * bRem * gcd;
	}

	public static long gcd_naive(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd_naive(b, a % b);
	}
}
