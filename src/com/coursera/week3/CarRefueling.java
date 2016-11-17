package com.coursera.week3;
/**
 * 
 * @author suresh
 *
 */
public class CarRefueling {

	public static void main(String[] args) {
		/**
		 * Start and end elements are added to array for convenience
		 */
		int[] x = { 0, 200, 375, 550, 750, 950 };
		int n = 4;
		int minDistance = 400;

		System.out.println("Min. number of refills is : " + minRefills(x, n, minDistance));

	}

	public static int minRefills(int[] x, int n, int minDistance) {

		int numRefills = 0;
		int currentRefills = 0;

		while (currentRefills <= n) {
			System.out.println("Current refill : " + currentRefills);
			int lastRefill = currentRefills;

			while (currentRefills <= n && (x[currentRefills + 1] - x[lastRefill]) <= minDistance) {

				currentRefills++;
			}

			if (currentRefills == lastRefill)
				return -1;

			if (currentRefills <= n)
				numRefills++;
		}

		return numRefills;
	}

}
