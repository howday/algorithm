package com.algorithm.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingTest {

	public static void main(String[] args) {

		System.out.println("Enter the number of random numbers to be sorted:");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Enter the maximum value :");
		int max = s.nextInt();

		int[] arr = new int[n];
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt(max);
		}
		

		Sort[] sort = { new BubbleSort(arr.clone()),
				new SelectionSort(arr.clone()),
				new InsertionSort(arr.clone()),
//				new QuickSort(arr.clone()),
				new MergeSort(arr.clone())};

		for (Sort sorter : sort) {
			long startTime = System.currentTimeMillis();
			int[] a = sorter.sort();
			long endTime = System.currentTimeMillis();
			System.out.printf(
					"==================================\n" + "Time Consumed (%s) : " + (endTime - startTime)
							+ " milliseconds\n" + "==================================\n\n",
					sorter.getClass().getSimpleName());
			System.out.println(Arrays.toString(a));

		}

		s.close();
	}

}
