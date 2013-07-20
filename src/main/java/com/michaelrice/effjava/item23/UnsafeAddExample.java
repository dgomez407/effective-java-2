package com.michaelrice.effjava.item23;

import java.util.ArrayList;
import java.util.List;

public class UnsafeAddExample {

	/**
	 * This method looks good in that it uses a parameterized type,
	 * and it even appears to work when it calls unsafeAdd(), but then
	 * it blows up when you try to work with the parameterized list the
	 * way you expect it to work.
	 * 
	 */
	@SuppressWarnings("unused")
	void buildAnUnsafeCollection() {
		List<String> listOfStrings = new ArrayList<String>();
		unsafeAdd(listOfStrings, new Integer(-1));
		String s = listOfStrings.get(0); //should throw an error
	}

	/**
	 * This method is key to the test. Notice how parameter 1 uses a raw
	 * type even though the caller uses a parameterized type.
	 *  
	 * Luckily, the compiler and IDE throw warnings about this these days.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void unsafeAdd(List listOfStrings, Integer integer) {
		listOfStrings.add(integer);
	}
}
