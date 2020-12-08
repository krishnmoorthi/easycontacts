/**
 * 
 */
package com.stkprojects.easycontacts.model;

import java.util.List;

import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;

/**
 * @author vishwa
 *
 */
public class SearchResults {
	
	private List<Contact> ContactList;
	private List<Phone> phoneList;
	private List<Address> addressList;
	
	/**
	 * @return the contactList
	 */
	public List<Contact> getContactList() {
		return ContactList;
	}
	/**
	 * @param contactList the contactList to set
	 */
	public void setContactList(List<Contact> contactList) {
		ContactList = contactList;
	}
	/**
	 * @return the phoneList
	 */
	public List<Phone> getPhoneList() {
		return phoneList;
	}
	/**
	 * @param phoneList the phoneList to set
	 */
	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	/**
	 * @return the addressList
	 */
	public List<Address> getAddressList() {
		return addressList;
	}
	/**
	 * @param addressList the addressList to set
	 */
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

}
