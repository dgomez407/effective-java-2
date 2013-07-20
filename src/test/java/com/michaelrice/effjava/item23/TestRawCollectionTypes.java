package com.michaelrice.effjava.item23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestRawCollectionTypes {

	/**
	 * This is a completely unremarkable test, but it proves that the first point of
	 * Joshua Bloch's Item 23 regarding generics works as he says it does. By now, 
	 * on the eve of Java 1.8, this is really uninteresting. A subtle thing to 
	 * notice on this @Test is that it's expecting the ClassCastException.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Test(expected=ClassCastException.class)
	public void testThatRawCollectionTypesAreDangerous() {
		List uncheckedListOfStrings = new ArrayList();
		
		//unsurprisingly, this is fine
		uncheckedListOfStrings.add("this is cool");
		
		//this compiles fine because we're using the raw type
		//but we should hit an exception while we iterate what
		//we think are only strings in here
		uncheckedListOfStrings.add(new Integer(232));
		
		for (Iterator it=uncheckedListOfStrings.iterator(); it.hasNext(); ) {
			//This should run flawlesslessly on the first iteration and 
			//explode on the next pass
			String testString = (String)it.next();
		}
		
	}

}
