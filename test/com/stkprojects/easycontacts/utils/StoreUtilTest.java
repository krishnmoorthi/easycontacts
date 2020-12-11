/**
 * 
 */
package com.stkprojects.easycontacts.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author vishwa
 *
 */
public class StoreUtilTest {
	
	String CONTACTS_STORE_FILE;
    String PHONE_STORE_FILE;
    String ADDRESS_STORE_FILE;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		CONTACTS_STORE_FILE = "store/contacts.ec";
	    PHONE_STORE_FILE = "store/phone.ec";
	    ADDRESS_STORE_FILE = "store/address.ec";
	}

	/**
	 * Test method for {@link com.stkprojects.easycontacts.utils.StoreUtil#checkAndCreateStoreFiles(java.lang.String)}.
	 */
	@Test
	public void testCheckAndCreateStoreFiles() {
		assertEquals("Store files created !",StoreUtil.checkAndCreateStoreFiles(CONTACTS_STORE_FILE));
		assertEquals("Store files created !",StoreUtil.checkAndCreateStoreFiles(PHONE_STORE_FILE));
		assertEquals("Store files created !",StoreUtil.checkAndCreateStoreFiles(ADDRESS_STORE_FILE));
		assertEquals("Files are exists !",StoreUtil.checkAndCreateStoreFiles(CONTACTS_STORE_FILE));
		assertEquals("Files are exists !",StoreUtil.checkAndCreateStoreFiles(PHONE_STORE_FILE));
		assertEquals("Files are exists !",StoreUtil.checkAndCreateStoreFiles(ADDRESS_STORE_FILE));
		
		
	}

}
