package com.coursera.week3;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {

	/**
	 * Key idea: Greedy. Save move: take the max vi/wi and fill the knapsack as
	 * much as possible. Sort the items with decreasing vi/wi. While there's
	 * still room/item left for knapsack, add total value by current max value
	 * per unit * the fraction available to take; update W, and delegate to
	 * subproblem w/ next max.
	 *
	 * @param capacity
	 * @param values
	 * @param weights
	 * @return
	 */
	private static double getOptimalValue(int capacity, int[] values, int[] weights) {
		
		double value = 0;
		/**
		 * Build value per unit
		 */
		Item[] items = new Item[values.length];
		for (int i = 0; i < items.length; i++) {
			items[i] = new Item(values[i], weights[i]);
		}

		/**
		 * sort items by vi/wi
		 */
		Arrays.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item i1, Item i2) {
				return i1.val_per_unit > i2.val_per_unit ? -1 : 1;
			}
		});

		int i = 0;
		/**
		 * either no items left or no room left
		 */
		while (i < items.length && capacity > 0) {

			/**
			 * if item fits into knapsack, take all of it o.w. take so much as
			 * to fill the knapsack
			 */
			int fraction = Math.min(items[i].weight, capacity);
			value += items[i].val_per_unit * fraction;
			capacity -= fraction;
			i++;
		}
		return value;
	}

	private static class Item {
		int weight;
		int value;
		double val_per_unit;

		public Item(int val, int wgt) {
			this.weight = wgt;
			this.value = val;
			val_per_unit = (double) val / (double) wgt;
		}
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int capacity = scanner.nextInt();
		int[] values = new int[n];
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = scanner.nextInt();
			weights[i] = scanner.nextInt();
		}
		System.out.printf("%.4f", getOptimalValue(capacity, values, weights));
		scanner.close();
	}
}