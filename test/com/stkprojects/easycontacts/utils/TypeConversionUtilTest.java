/**
 * 
 */
package com.stkprojects.easycontacts.utils;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author vishwa
 *
 */
public class TypeConversionUtilTest extends TestCase {

	protected long longValue;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		longValue = 123;
	}

	/**
	 * Test method for
	 * {@link com.stkprojects.easycontacts.utils.TypeConversionUtil#stringToLong(java.lang.String)}.
	 */
	@Test
	public void testStringToLong() {
		assertEquals(longValue, TypeConversionUtil.stringToLong("123"));
	}

}
