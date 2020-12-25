package com.stkprojects.easycontacts.helper.impl;

import java.util.List;

import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.model.Contact;

public class ContactDataHelperImpl implements DataHelper<Contact> {

	private List<Contact> contacts;


	public ContactDataHelperImpl(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public void add(long id, Contact contact) {
		contacts.add(contact);
	}

	@Override
	public void delete(Contact contact) {
		contacts.remove(contact);
	}

	@Override
	public void edit(Contact oldContact, Contact newContact) {
		int index = 0;
		if((index = contacts.indexOf(oldContact)) > 0) {
			contacts.set(index, newContact);
		}
		
	}

}
