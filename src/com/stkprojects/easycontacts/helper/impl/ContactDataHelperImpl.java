package com.stkprojects.easycontacts.helper.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.stkprojects.easycontacts.common.Constants;
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

	@Override
	public String prepareRecord(Contact contact) {
		StringBuilder record = new StringBuilder("");
		record.append(contact.getId()).append(Constants.FIELD_SEPARATOR).append(contact.getFirstname())
				.append(Constants.FIELD_SEPARATOR).append(contact.getLastname()).append(Constants.FIELD_SEPARATOR)
				.append(contact.getEmail()).append(Constants.FIELD_SEPARATOR).append(contact.getTitle())
				.append(Constants.FIELD_SEPARATOR).append(contact.getWebsite()).append(Constants.FIELD_SEPARATOR)
				.append(contact.getCompany()).append(Constants.FIELD_SEPARATOR).append(contact.getDate_of_birth())
				.append(Constants.FIELD_SEPARATOR).append(Constants.RECORD_ENDER);
		return record.toString();
	}

}
