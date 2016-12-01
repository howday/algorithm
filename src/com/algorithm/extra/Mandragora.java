package com.algorithm.extra;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Mandragora {

	public static void main(String[] args) {

		PriorityQueue<Integer> enemies = new PriorityQueue<>();
		int strengthPoints;
		int experiencePoints;
		int numberOfMandra;
		long sum, maxSum, originalSum;

		Scanner s = new Scanner(System.in);

		int testCases = s.nextInt();

		for (int i = 0; i < testCases; i++) {
			strengthPoints = 2;
			experiencePoints = 0;
			numberOfMandra = s.nextInt();
			originalSum = 0;

			for (int j = 0; j < numberOfMandra; j++) {

				int health = s.nextInt();
				enemies.add(health);
				originalSum = originalSum + health;

			}
			System.out.println(enemies);
			maxSum = originalSum;

			// get the sum of each eat/battle combo and track the max
			for (int p = 0; p < numberOfMandra; p++) {

				// determines the new sum each time a mandragora is eaten
				originalSum -= enemies.poll();
				sum = originalSum * strengthPoints;

				if (sum > maxSum) {
					maxSum = sum;
					strengthPoints++;
				} else
					break; // all further will be lower than max, so we have a
							// solution
			}

			System.out.println(maxSum);
			enemies.clear();

		}
		s.close();
	}

}
