package com.algorithm.extra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NikitaProblem {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long t = s.nextInt();

		for (int i = 0; i < t; i++) {
			long len = s.nextLong();
			List<Long> arr = new ArrayList<>();

			long sum = 0;
			for (int j = 0; j < len; j++) {
				long a = s.nextLong();
				arr.add(a);
				sum += a;

			}
			System.out.println(getMaximumPoints(arr, sum));
		}
		s.close();
	}

	public static long getMaximumPoints(List<Long> arr, long sum) {

		System.out.println("sum  = " + sum + " size  = " + arr.size());
		System.out.println(arr);

		if (!isArrayDivisionPossible(arr, sum))
			return 0;

		long halfSum = 0;

		List<Long> leftList = new ArrayList<>();
		List<Long> rightList = new ArrayList<>();

		for (int i = 0; i < arr.size(); i++) {
			long a = arr.get(i);

			if (sum == 0) {
				if (leftList.isEmpty())
					leftList.add(a);
				else
					rightList.add(a);
			} else {
				if (halfSum < sum / 2) {
					halfSum += a;
					leftList.add(a);
				} else {
					rightList.add(a);

				}
			}

		}

		List<Long> newList = leftList.size() > rightList.size() ? leftList : rightList;
		return 1 + getMaximumPoints(newList, halfSum);

	}

	public static boolean isArrayDivisionPossible(List<Long> arr, long sum) {

		if (sum == 0) {
			if (arr.size() > 1)
				return true;
			else
				return false;
		}

		boolean flag = false;
		long halfSum = 0;
		for (int i = 0; i < arr.size(); i++) {
			halfSum += arr.get(i);
			if (halfSum == sum / 2 && sum >= 2)
				flag = true;

		}
		return flag;
	}
}
