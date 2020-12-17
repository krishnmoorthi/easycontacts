package com.stkprojects.easycontacts.helper.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.helper.SequenceGeneratorHelper;
import com.stkprojects.easycontacts.model.Contact;

public class ContactDataHelperImpl implements DataHelper<Contact> {

	private List<Contact> contacts;
	private SequenceGeneratorHelper<Contact> sequence;

	public ContactDataHelperImpl(List<Contact> contacts) {
		this.contacts = contacts;
		this.sequence = new ContactSequenceGeneratorHelperImpl(contacts);
	}

	@Override
	public void add(Contact contact) {
		contact.setId(sequence.getNext());
		contacts.add(contact);
	}

	@Override
	public void delete(Contact contact) {
		contacts.remove(contact);
	}

	@Override
	public void edit(Contact contact) {
		delete(contacts.stream().filter(contactLst -> contactLst.getId() == contact.getId())
				.collect(Collectors.toList()).get(0));
		contacts.add(contact);
	}
}
