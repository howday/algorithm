package com.timelog;

public class TimeLog {

	public static void logTimeConsumed(long startTime, String output, long endTime) {
		System.out.println("Time consumed :" + (endTime - startTime) + " milliseconds");

	}

	public static void print(String s) {
		System.out.println(s);
	}

}
