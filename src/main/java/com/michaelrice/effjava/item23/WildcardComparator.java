package com.michaelrice.effjava.item23;

import java.util.Set;

/**
 * This shows how to use the wildcard operator
 * 
 * @author mrice
 *
 */
public class WildcardComparator {

	/*
	 * Notice we're using raw types on this one, so we have to contend with a 
	 * compiler warning
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	int numberOfElementsInCommon1(Set s1, Set s2) {
		int count=0;
		for (Object o1 : s1) 
			if (s2.contains(o1))
				count++;
		s2.add("test"); //this compiles, which creates an issue
		return count;
	}

	/*
	 * This method uses the wildcard operator, so no warnings.
	 * 
	 * What's the difference? You can't insert anything into
	 * s1 or s2, which makes them safer.
	 * 
	 */
	int numberOfElementsInCommon2(Set<?> s1, Set<?> s2) {
		int count=0;
		for (Object o1 : s1) 
			if (s2.contains(o1))
				count++;
		//s2.add("test"); <- this would FAIL TO COMPILE, which is good
		return count;
	}

}
