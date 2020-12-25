/**
 * 
 */
package com.stkprojects.easycontacts.operations;

import java.util.List;

import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;
import com.stkprojects.easycontacts.model.SearchSortView;

/**
 * @author kthangav
 *
 */
public class SearchSortOperation {

	private List<Contact> contactList;
	private List<Phone> phoneList;
	private List<Address> addressList;
	private SearchSortView searchSortView;

	public SearchSortOperation(List<Contact> contactList, List<Phone> phoneList, List<Address> addressList) {
		this.contactList = contactList;
		this.phoneList = phoneList;
		this.addressList = addressList;
		searchSortView = new SearchSortView();
	}

	public SearchSortView getAllContacts() {
		searchSortView.setContactList(contactList);
		searchSortView.setPhoneList(phoneList);
		searchSortView.setAddressList(addressList);
		return searchSortView;
	}

	public SearchSortView searchContactByFirstnameOrLastname(String firstOrLastNameString) {
		return null;
	}

	public SearchSortView searchContactByPhoneNumber(long longPhoneNumber) {
		return null;
	}

	public SearchSortView searchContactByEmail(String emailString) {
		return null;
	}

}
