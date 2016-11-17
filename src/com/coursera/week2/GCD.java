package com.coursera.week2;
import java.util.Scanner;

public class GCD {

	public static void main(String[] args) {
//		
//		long num1 = 357;
//		long num2 = 234;
//
//		long startTime = new Date().getTime();
//		print("Slow---->" + naiveGCD(num1, num2));
//		long endTime = new Date().getTime();
//		logTimeConsumed(startTime, endTime);
//		
//		
//		startTime = new Date().getTime();
//		print("Fast---->" + fastGCD(num1, num2));
//		endTime = new Date().getTime();
//		logTimeConsumed(startTime, endTime);
		Scanner scanner = new Scanner(System.in);
	    int a = scanner.nextInt();
	    int b = scanner.nextInt();

	    System.out.println(gcd_naive(a, b));
		
		
	}

	public static long naiveGCD(long a, long b) {

		long gcd = 1;
		int n = 1;
		while (n < a + b) {
			if (a % n == 0 && b % n == 0) {
				gcd = n;
			}
			n++;
		}
		return gcd;
	}
	
	public static long gcd_naive(long a , long b){
		 if(b == 0){
			 return a;
		 } 
		 return gcd_naive(b, a % b);
	}

}
