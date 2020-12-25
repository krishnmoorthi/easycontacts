/**
 * 
 */
package com.stkprojects.easycontacts.model;

import java.util.List;

/**
 * @author kthangav
 *
 */
public class SearchSortView {
	
	private List<Contact> contactList;
	private List<Phone> phoneList;
	private List<Address> addressList;
	
	/**
	 * @return the contactList
	 */
	public List<Contact> getContactList() {
		return contactList;
	}
	/**
	 * @param contactList the contactList to set
	 */
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
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