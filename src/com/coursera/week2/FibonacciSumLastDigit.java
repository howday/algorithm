package com.coursera.week2;
import java.util.Scanner;

public class FibonacciSumLastDigit {
	private static long getFibonacciLastDigitFast(long n) {
		if (n <= 1)
			return n;

		int m = (int) ((n + 2) % 60 + 60) % 60;
		long[] mem = new long[m + 1];
		for (int i = 1; i <= m; i++)
			mem[i] = -1;
		int res = (int) getFibonacciLastDigitTwoFast(m, mem);
		return (res - 1) % 10;
	}

	private static long getFibonacciLastDigitTwoFast(int n, long[] mem) {
		if (mem[n] != -1)
			return mem[n];
		if (n <= 1)
			return n;
		mem[n] = (getFibonacciLastDigitTwoFast(n - 1, mem) + getFibonacciLastDigitTwoFast(n - 2, mem)) % 100;
		return mem[n];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long x = scanner.nextLong();
		System.out.println(getFibonacciLastDigitFast(x));

	}
}
