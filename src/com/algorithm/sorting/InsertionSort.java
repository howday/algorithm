package com.algorithm.sorting;

public class InsertionSort implements Sort {

	private int[] array;

	public InsertionSort(int[] array) {
		this.array = array;
	}

	@Override
	public int[] sort() {

		int temp;
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
		return array;
	}

}
