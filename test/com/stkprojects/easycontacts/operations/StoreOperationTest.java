/**
 * 
 */
package com.stkprojects.easycontacts.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
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

	StoreOperation storeOperation;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		contacts = new ArrayList<>();
		phoneList = new ArrayList<>();
		addressList = new ArrayList<>();

		storeOperation = new StoreOperation();

		Contact contact = new Contact();
		contact.setId(1);
		contact.setFirstname("Krishnamoorthi");
		contact.setLastname("Thangavel");
		contact.setCompany("Publicis Sapient");
		contact.setDate_of_birth("18/09/1984");
		contact.setEmail("t.krishnamoorthi@gmail.com");
		contact.setTitle("Senoir Associate L2");
		contact.setWebsite("");
		contacts.add(contact);

		Phone phone = new Phone();
		phone.setId(1);
		phone.setContact_id(1);
		phone.setNumber(TypeConversionUtil.stringToLong("9739391449"));
		phone.setType("personal");
		phoneList.add(phone);

		Address address = new Address();
		address.setId(1);
		address.setAddress_line_1("63 Kudi Street");
		address.setAddress_line_2("T Salappalayam");
		address.setCity("Tiruchengode");
		address.setContact_id(1);
		address.setState("Tamilnadu");
		address.setType("home");
		address.setPin_or_zip_code("637205");
		addressList.add(address);

	}

	/**
	 * Test method for
	 * {@link com.stkprojects.easycontacts.operations.StoreOperation#StoreOperation()}.
	 */
	@Test
	public void testStoreOperation() {
		assertNotNull(storeOperation);
	}

	/**
	 * Test method for
	 * {@link com.stkprojects.easycontacts.operations.StoreOperation#commitDataInStore(java.util.List, java.util.List, java.util.List)}.
	 */
	@Test
	public void testCommitDataInStore() {
		assertEquals("SUCCESS", storeOperation.commitDataInStore(contacts, phoneList, addressList));
	}

	/**
	 * Test method for
	 * {@link com.stkprojects.easycontacts.operations.StoreOperation#LoadStoreData(java.util.List, java.util.List, java.util.List)}.
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void testLoadStoreData() throws FileNotFoundException {
		List<Contact> contactList = new ArrayList<>();
		List<Phone> phone = new ArrayList<>();
		List<Address> address = new ArrayList<>();
		storeOperation.LoadStoreData(contactList, phone, address);
		assertTrue(contactList.get(0).equals(contacts.get(0)));
		assertTrue(phone.get(0).equals(phoneList.get(0)));
		assertTrue(address.get(0).equals(addressList.get(0)));
	}

	/**
	 * Test method for
	 * {@link com.stkprojects.easycontacts.operations.StoreOperation#deleteDataInStore()}.
	 */
	@Test
	public void deleteDataInStore() {
		assertEquals("SUCCESS", storeOperation.deleteDataInStore());
	}

}
