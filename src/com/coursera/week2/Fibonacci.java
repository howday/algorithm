package com.coursera.week2;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int nthNumber = s.nextInt();
		// long startTime = new Date().getTime();
		// System.out.println("Slow----> " + getNFibonacciNumber(nthNumber));
		// System.out.println("Slow----> " + getNFibonacciNumber(nthNumber));
		// long endTime = new Date().getTime();
		// logTimeConsumed(startTime, endTime);
		// startTime = new Date().getTime();
		// print("Fast---->" + getNFibonacciNumberFast(nthNumber));
		// endTime = new Date().getTime();
		// logTimeConsumed(startTime, endTime);
		System.out.println(calc_fib(nthNumber));

	}

	// private static long calc_fib(int n) {
	// if (n <= 1)
	// return n;
	//
	// return calc_fib(n - 1) + calc_fib(n - 2);
	// }

	// public static int getNFibonacciNumber(int n) {
	// System.out.println("now n = " + n);
	// if (n <= 1)
	// return n;
	// else
	// return getNFibonacciNumber(n - 1) + getNFibonacciNumber(n - 2);
	// }

	public static long calc_fib(int n) {
		
		if (n <= 1)
			return n;

		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;

		for (int k = 2; k <= n; k++) {
			arr[k] = arr[k - 1] + arr[k - 2];
		}
		return arr[n];
	}
}
