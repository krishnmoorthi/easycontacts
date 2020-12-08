/**
 * 
 */
package com.stkprojects.easycontacts.helper.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.stkprojects.easycontacts.helper.SearchHelper;
import com.stkprojects.easycontacts.model.Contact;

/**
 * @author vishwa
 *
 */
public class ContactSearchHelperImpl implements SearchHelper<Contact> {

	private List<Contact> contactList;

	public ContactSearchHelperImpl(List<Contact> contactList) {
		this.contactList = contactList;
	}

	@Override
	public List<Contact> search(String searchString) {
		return contactList.parallelStream().filter(contact -> contact.getFirstname().equalsIgnoreCase(searchString))
				.filter(contact -> contact.getLastname().equalsIgnoreCase(searchString))
				.filter(contact -> contact.getTitle().equalsIgnoreCase(searchString))
				.filter(contact -> contact.getEmail().equalsIgnoreCase(searchString)).collect(Collectors.toList());
	}

	@Override
	public Contact search(long id) {
		return contactList.parallelStream().filter(contact -> contact.getId() == id)
		.collect(Collectors.toList()).get(0);
	}

}
