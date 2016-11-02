package com.algorithm.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PowerSet {

	//
	// Algorithm: PowerSet(X)
	// Input: A list X of elements
	// Output: A list P consisting of all subsets of X – elements of P are Sets
	// P ← new list
	// S ← new Set //S is the empty set
	// P.add(S) //P is now the set { S }
	// T ← new Set
	// while (!X.isEmpty() ) do
	// f ← X.removeFirst()
	// for each x in P do
	// T ← x U {f} // T is the set containing f & all elements of x
	// P.add(T)
	// return P

	public static <T> Set<Set<T>> powerSet2(Set<T> originalSet) {
		Set<Set<T>> sets = new HashSet<Set<T>>();
		if (originalSet.isEmpty()) {
			sets.add(new HashSet<T>());
			return sets;
		}
		List<T> list = new ArrayList<T>(originalSet);
		T head = list.get(0);
		Set<T> rest = new HashSet<T>(list.subList(1, list.size()));
		for (Set<T> set : powerSet2(rest)) {
			Set<T> newSet = new HashSet<T>();
			newSet.add(head);
			newSet.addAll(set);
			sets.add(newSet);
			sets.add(set);
		}
		return sets;
	}

	public static void main(String[] args) {
		
		 Set<Integer> mySet = new HashSet<Integer>();
		 mySet.add(1);
		 mySet.add(2);
		 mySet.add(3);
		
		for (Set<Integer> s : powerSet2(mySet)) {
		     System.out.println(s);
		 }
	}

}
