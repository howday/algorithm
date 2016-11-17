package com.coursera.week3;
import java.util.*;

public class LargestNumber {
	private static String largestNumber(String[] a) {

		/**
		 * For sorting the given String array of numbers as required
		 */
		Arrays.sort(a, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				int a = Integer.valueOf(o1 + o2);
				int b = Integer.valueOf(o2 + o1);

				return b - a;
			}
		});

		String result = "";
		for (int i = 0; i < a.length; i++) {
			result += a[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.next();
		}
		System.out.println(largestNumber(a));
		scanner.close();
	}
}
