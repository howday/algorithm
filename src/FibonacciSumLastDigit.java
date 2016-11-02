import java.math.BigInteger;
import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {

	
    	if (n <= 1)
			return n;
    	
    	List<BigInteger> bigInts = new ArrayList<>();
    	bigInts.add(BigInteger.valueOf(0));
    	bigInts.add(BigInteger.valueOf(1));

		for (int k = 2; k <= n+2; k++) {
			BigInteger prev = bigInts.get(k-1);
			BigInteger prevPrev = bigInts.get(k-2);
			bigInts.add(prev.add(prevPrev));
		}
		BigInteger sum = bigInts.get(bigInts.size()-1).subtract(BigInteger.valueOf(1));
		System.out.println("Sum is : "+sum);
		return sum.mod(BigInteger.valueOf(10)).longValue();
    }
    
	    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println("Last digit : "+s);
    }
}

