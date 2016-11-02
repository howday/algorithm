import java.util.*;

public class LCM {

	public static void main(String args[]) {
	    Scanner scanner = new Scanner(System.in);
	    int a = scanner.nextInt();
	    int b = scanner.nextInt();

	    System.out.println(lcm_naive(a, b));
		
	}

	private static long lcm_naive(int a, int b) {

		int gcd = gcd_naive(a, b);
		if (gcd == 1)
		   return a * b;

		int aRem = a / gcd;
		int bRem = b / gcd;
		int multiplier = 1;

		multiplier = aRem < bRem ? aRem : bRem;
		return (a > b ? a : b) * multiplier;
	}

	public static int gcd_naive(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd_naive(b, a % b);
	}
//Input:
//14159572 63967072

//Your output:
//1619590880

//Correct output:
//226436590403296
// (Time used: 0.16/1.50, memory used: 24059904/536870912.)
}
