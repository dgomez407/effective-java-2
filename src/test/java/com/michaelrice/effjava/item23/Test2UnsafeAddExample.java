package com.michaelrice.effjava.item23;

import org.junit.Test;

public class Test2UnsafeAddExample {

	UnsafeAddExample example = new UnsafeAddExample();
	
	/** 
	 * Refer to UnsafeAddExample.java for this test. Basically, even
	 * though we are using generics to catch cast exceptions at runtime
	 * we still have problems because somewhere in the method stack
	 * we don't deal with them safely and we still get the RuntimeException.
	 */
	@Test(expected=ClassCastException.class)
	public void test() {
		example.buildAnUnsafeCollection();
	}

}
