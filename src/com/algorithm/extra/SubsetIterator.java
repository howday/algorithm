package com.algorithm.extra;

import java.util.Scanner;

public class SubsetIterator {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int divider = s.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		int maxCount = 0;
		long maxSum = 0;

		for (int i = 0; i < (1 << arr.length); i++) {

			long sum = 0;
			int intCount = 0;
			int temp = i;
			int prev = -1;
			boolean okay = true;

			for (int j = 0; j < arr.length; j++) {

				int k = temp & 1;

				if (k == 1) {

					
					
					if (prev != -1) {
						boolean flag = (prev + arr[j]) % divider == 0;
						if (flag) {
							okay = false;
						}else{
							sum += (long) arr[j];
							intCount++;
						}

					}

					prev = arr[j];
				}
				temp = temp >> 1;

			}
			if (sum > maxSum && okay) {
				maxSum = sum;
				maxCount = intCount;
			}
		}
		System.out.println(maxCount);
		s.close();

	}

}
