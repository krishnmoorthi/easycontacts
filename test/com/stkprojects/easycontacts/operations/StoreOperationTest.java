/**
 * 
 */
package com.stkprojects.easycontacts.operations;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;
import com.stkprojects.easycontacts.utils.TypeConversionUtil;

/**
 * @author vishwa
 *
 */
public class StoreOperationTest {
	
	List<Contact> contacts;
	List<Phone> phoneList;
	List<Address> addressList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		contacts = new ArrayList<>();
		phoneList = new ArrayList<>();
		addressList = new ArrayList<>();
		
		Contact contact = new Contact();
		contact.setFirstname("Krishnamoorthi");
		contact.setLastname("Thangavel");
		contact.setCompany("Publicis Sapient");
		contact.setDate_of_birth("18/09/1984");
		contact.setEmail("t.krishnamoorthi@gmail.com");
		contact.setTitle("Senoir Associate L2");
		contact.setWebsite("");
		contacts.add(contact);
		
		Phone phone = new Phone();
		phone.setContact_id(1);
		phone.setNumber(TypeConversionUtil.stringToLong("9739391449"));
		phone.setType("personal");
		phoneList.add(phone);
		
		
	}

	/**
	 * Test method for {@link com.stkprojects.easycontacts.operations.StoreOperation#StoreOperation()}.
	 */
	@Test
	public void testStoreOperation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.stkprojects.easycontacts.operations.StoreOperation#LoadStoreData(java.util.List, java.util.List, java.util.List)}.
	 */
	@Test
	public void testLoadStoreData() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.stkprojects.easycontacts.operations.StoreOperation#commitDataInStore(java.util.List, java.util.List, java.util.List)}.
	 */
	@Test
	public void testCommitDataInStore() {
		fail("Not yet implemented");
	}

}
