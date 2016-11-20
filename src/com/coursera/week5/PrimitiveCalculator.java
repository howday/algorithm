package com.coursera.week5;
import java.util.*;

public class PrimitiveCalculator {
	private static List<Integer> naive_sequence(int n) {
		List<Integer> sequence = new ArrayList<Integer>();
		while (n >= 1) {
			sequence.add(n);
			if (n % 3 == 0) {
				n /= 3;
			} else if (n % 2 == 0) {
				n /= 2;
			} else {
				n -= 1;
			}
		}
		Collections.reverse(sequence);
		return sequence;
	}

	private static List<Integer> optimal_sequence(int n) {
		List<Integer> sequence = new ArrayList<Integer>();
		int[] table = new int[n + 1];
		table[1] = 0;
		for (int i = 2; i <= n; i++) {
			int a = (i % 2) == 0 ? table[i / 2] : Integer.MAX_VALUE;
			int b = (i % 3) == 0 ? table[i / 3] : Integer.MAX_VALUE;
			int c = table[i - 1];
			table[i] = Math.min(a, Math.min(b, c)) + 1;
		}
		sequence.add(n);
		while (n > 1) { // BZ: n > 0? when n==1, falls in no cases
			if (n / 2 >= 1 && table[n] - 1 == table[n / 2]) {
				sequence.add(n / 2);
				n /= 2;
			} else if (n / 3 >= 1 && table[n] - 1 == table[n / 3]) {
				sequence.add(n / 3);
				n /= 3;
			} else if (n - 1 >= 1 && table[n] - 1 == table[n - 1]) {
				sequence.add(n - 1);
				n -= 1;
			}
		}
		Collections.reverse(sequence);
		return sequence;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> sequence = optimal_sequence(n);
		System.out.println(sequence.size() - 1);
		for (Integer x : sequence) {
			System.out.print(x + " ");
		}
		scanner.close();
	}
}
