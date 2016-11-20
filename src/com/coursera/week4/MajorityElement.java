package com.coursera.week4;
import java.util.*;
import java.io.*;

public class MajorityElement {

	/**
	 * This method is implemented using Moore's voting algorithm which reduces
	 * the time space complexity to O(n) instead of O(n.logn) which is expected
	 * when using Divide and Conquer algorithm
	 * 
	 * @param a
	 * @param left
	 * @param right
	 * @return 1 or 0 depending on condition
	 */
	private static int getMajorityElementLinear(int[] a, int left, int right) {

		int maxIndex = 0;
		int count = 1;

		for (int i = 1; i < a.length - 1; i++) {
			if (a[maxIndex] == a[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				maxIndex = i;
				count = 1;
			}
		}

		count = 0;
		for (int j = 0; j < a.length; j++) {
			if (a[j] == a[maxIndex])
				count++;
		}
		return (count > (a.length / 2)) ? 1 : 0;
	}

	/**
	 * Divide and Conquer algorithm with O(n.logn) time.
	 * 
	 * @param a
	 * @param left
	 * @param right
	 * @return
	 */

	private static int getMajorityElement(int[] a, int left, int right) {
		if (left == right) {
			return -1;
		}
		if (left + 1 == right) {
			return a[left];
		}
		return major(a, left, right - 1);
	}

	private static int major(int[] a, int low, int high) {
		// Base case: if n==1, single element is major.
		if (low == high)
			return a[low];
		int mid = (high - low) / 2 + low;
		int left_major = major(a, low, mid);
		int right_major = major(a, mid + 1, high);
		if (left_major == right_major)
			return left_major;
		// Return the majority with larger counts
		int left_count = getFrequency(a, left_major);
		int right_count = getFrequency(a, right_major);
		// No majority case: neither frequency > n/2...
		// BZ: check the larger of left count & right count?
		return left_count > a.length / 2 ? left_major : (right_count > a.length / 2 ? right_major : -1);
	}

	private static int getFrequency(int[] a, int major) {
		// Scan the element in a[1..n] in every recursive call,
		int count = 0;
		for (int ele : a) {
			if (ele == major)
				count++;
			if (count > a.length / 2)
				break;
		}
		return count;
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
//		if (getMajorityElement(a, 0, a.length) != -1) {
//			System.out.println(1);
//		} else {
//			System.out.println(0);
//		}
		System.out.println(getMajorityElementLinear(a, 0, a.length));
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
