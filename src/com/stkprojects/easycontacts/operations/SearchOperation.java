/**
 * 
 */
package com.stkprojects.easycontacts.operations;

import java.util.ArrayList;
import java.util.List;

import com.stkprojects.easycontacts.helper.SearchHelper;
import com.stkprojects.easycontacts.helper.impl.AddressSearchHelperImpl;
import com.stkprojects.easycontacts.helper.impl.ContactSearchHelperImpl;
import com.stkprojects.easycontacts.helper.impl.PhoneSearchHelperImpl;
import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;
import com.stkprojects.easycontacts.model.SearchResults;

/**
 * @author vishwa
 *
 */
public class SearchOperation {

	private SearchHelper<Contact> contactSearchHelper;
	private SearchHelper<Phone> phoneSearchHelper;
	private SearchHelper<Address> addressSearchHelper;

	public SearchOperation(List<Contact> contactList, List<Phone> phoneList, List<Address> addressList) {
		contactSearchHelper = new ContactSearchHelperImpl(contactList);
		phoneSearchHelper = new PhoneSearchHelperImpl(phoneList);
		addressSearchHelper = new AddressSearchHelperImpl(addressList);
	}

	public SearchResults searchContacts(String searchString) {
		List<Contact> contactsFiltered = new ArrayList<>();
		List<Phone> phoneFiltered = new ArrayList<>();
		List<Address> addressFiltered = new ArrayList<>();
		SearchResults results = new SearchResults();
		contactsFiltered.addAll(contactSearchHelper.search(searchString));
		if (contactsFiltered.isEmpty()) {
			addressFiltered.addAll(addressSearchHelper.search(searchString));
			if (addressFiltered.isEmpty()) {
				phoneFiltered.addAll(phoneSearchHelper.search(searchString));
				if (phoneFiltered.isEmpty()) {
					results.setContactList(contactsFiltered);
					results.setPhoneList(phoneFiltered);
					results.setAddressList(addressFiltered);
				} else {
					for (Phone phone : phoneFiltered) {
						contactsFiltered.add(contactSearchHelper.search(phone.getContact_id()));
						addressFiltered.add(addressSearchHelper.search(phone.getContact_id()));
					}
				}
			} else {
				for (Address address : addressFiltered) {
					contactsFiltered.add(contactSearchHelper.search(address.getContact_id()));
					phoneFiltered.add(phoneSearchHelper.search(address.getContact_id()));
				}
			}
		} else {
			for (Contact contact : contactsFiltered) {
				phoneFiltered.add(phoneSearchHelper.search(contact.getId()));
				addressFiltered.add(addressSearchHelper.search(contact.getId()));
			}
		}
		results.setContactList(contactsFiltered);
		results.setPhoneList(phoneFiltered);
		results.setAddressList(addressFiltered);
		return results;
	}

}
