package com.coursera.week4;
import java.util.*;

public class DotProduct {
    private static long minDotProduct(int[] a, int[] b) {
        //write your code here
    	
        long result = 0;
        for (int i = 0; i < a.length; i++) {
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
       
        System.out.println(minDotProduct(a, b));
    }
}

