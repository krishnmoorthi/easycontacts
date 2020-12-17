/**
 * 
 */
package com.stkprojects.easycontacts.operations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;
import com.stkprojects.easycontacts.model.SearchResults;
import com.stkprojects.easycontacts.utils.TypeConversionUtil;

/**
 * @author kthangav
 *
 */
public class SearchOperationTest {

	List<Contact> contactList;
	List<Phone> phoneList;
	List<Address> addressList;

	SearchOperation searchOperation;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		contactList = new ArrayList<>();
		phoneList = new ArrayList<>();
		addressList = new ArrayList<>();

		Contact contact_1 = new Contact();
		Phone phone_1 = new Phone();
		Address address_1 = new Address();
		Contact contact_2 = new Contact();
		Phone phone_2 = new Phone();
		Address address_2 = new Address();
		Contact contact_3 = new Contact();
		Phone phone_3 = new Phone();
		Address address_3 = new Address();

		contact_1.setId(1);
		contact_1.setFirstname("Krishnamoorthi");
		contact_1.setLastname("Thangavel");
		contact_1.setEmail("t.krishnamoorthi@gmail.com");
		contact_1.setDate_of_birth("18/09/1984");
		contact_1.setCompany("Publicis Sapient");
		contact_1.setTitle("Senior Associate Tech L2");
		contact_1.setWebsite("");
		phone_1.setContact_id(1);
		phone_1.setId(1);
		phone_1.setNumber(TypeConversionUtil.stringToLong("9739391449"));
		phone_1.setType("personal");
		address_1.setId(1);
		address_1.setAddress_line_1("63 Kudi Street");
		address_1.setAddress_line_2("T Salappalayam");
		address_1.setCity("Tiruchengode");
		address_1.setContact_id(1);
		address_1.setState("Tamilnadu");
		address_1.setType("home");
		address_1.setPin_or_zip_code("637205");

		contact_2.setId(2);
		contact_2.setFirstname("Thangavel");
		contact_2.setLastname("Kaalianna Gownder");
		contact_2.setCompany("Farmer");
		contact_2.setDate_of_birth("15/10/1956");
		contact_2.setEmail("skthangavel@gmail.com");
		contact_2.setTitle("Farmer");
		contact_2.setWebsite("");
		phone_2.setId(2);
		phone_2.setContact_id(2);
		phone_2.setNumber(TypeConversionUtil.stringToLong("9445896579"));
		phone_2.setType("personal");
		address_2.setId(2);
		address_2.setAddress_line_1("63 Kudi Street");
		address_2.setAddress_line_2("T Salappalayam");
		address_2.setCity("Tiruchengode");
		address_2.setContact_id(2);
		address_2.setState("Tamilnadu");
		address_2.setType("home");
		address_2.setPin_or_zip_code("637205");

		contact_3.setId(3);
		contact_3.setFirstname("Boopalan");
		contact_3.setLastname("Palaniyappan");
		contact_3.setEmail("baluskbs@gmail.com");
		contact_3.setDate_of_birth("12/02/1991");
		contact_3.setCompany("S.K.B.S Borewells");
		contact_3.setTitle("Manager");
		contact_3.setWebsite("");
		phone_3.setContact_id(3);
		phone_3.setId(3);
		phone_3.setNumber(TypeConversionUtil.stringToLong("9443128683"));
		phone_3.setType("personal");
		address_3.setId(1);
		address_3.setAddress_line_1("12 RR Complex");
		address_3.setAddress_line_2("Kokraayanpettai road");
		address_3.setCity("Tiruchengode");
		address_3.setContact_id(3);
		address_3.setState("Tamilnadu");
		address_3.setType("home");
		address_3.setPin_or_zip_code("637211");

		contactList.add(contact_1);
		contactList.add(contact_2);
		contactList.add(contact_3);

		phoneList.add(phone_1);
		phoneList.add(phone_2);
		phoneList.add(phone_3);

		addressList.add(address_1);
		addressList.add(address_2);
		addressList.add(address_3);

		searchOperation = new SearchOperation(contactList, phoneList, addressList);
	}

	/**
	 * Test method for
	 * {@link com.stkprojects.easycontacts.operations.SearchOperation#SearchOperation(java.util.List, java.util.List, java.util.List)}.
	 */
	@Test
	public void testSearchOperation() {
		assertNotNull(searchOperation);
	}

	/**
	 * Test method for
	 * {@link com.stkprojects.easycontacts.operations.SearchOperation#searchContacts(java.lang.String)}.
	 */
	@Test
	public void testSearchContactsByFirstname() {
		SearchResults results = searchOperation.searchContacts("Krishnamoorthi");
		assertEquals("Krishnamoorthi", results.getContactList().get(0).getFirstname());
	}
	
	/**
	 * Test method for
	 * {@link com.stkprojects.easycontacts.operations.SearchOperation#searchContacts(java.lang.String)}.
	 */
	@Test
	public void testSearchContactsByLastname() {
		SearchResults results = searchOperation.searchContacts("Thangavel");
		assertEquals("Thangavel",results.getContactList().get(0).getLastname());
		assertEquals("Thangavel",results.getContactList().get(1).getFirstname());
	}
	
	/**
	 * Test method for
	 * {@link com.stkprojects.easycontacts.operations.SearchOperation#searchContacts(java.lang.String)}.
	 */
	@Test
	public void testSearchContactsByEmail() {
		SearchResults results = searchOperation.searchContacts("t.krishnamoorthi@gmail.com");
		assertEquals("t.krishnamoorthi@gmail.com", results.getContactList().get(0).getEmail());
	}
	
	/**
	 * Test method for
	 * {@link com.stkprojects.easycontacts.operations.SearchOperation#searchContacts(java.lang.String)}.
	 */
	@Test
	public void testSearchContactsByTitle() {
		SearchResults results = searchOperation.searchContacts("Farmer");
		assertEquals("Farmer", results.getContactList().get(0).getTitle());
	}
	

}
