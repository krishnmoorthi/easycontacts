package com.stkprojects.easycontacts.helper.impl;

import com.stkprojects.easycontacts.common.Constants;
import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.model.Contact;

import java.util.List;

public class ContactDataHelper implements DataHelper<Contact> {

    private List<Contact> contacts;

    public ContactDataHelper(List<Contact> contacts){
        this.contacts = contacts;
    }

    @Override
    public void add(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void delete(Contact contact) {
        contacts.remove(contact);
    }

    @Override
    public void edit(Contact contact) {
        //TODO search for contact and replace
    }

    @Override
    public String prepareRecord(Contact contact) {
    	StringBuilder record = new StringBuilder("");
    	record.append(contact.getId()).append(Constants.FIELD_SEPARATOR)
    	.append(contact.getFirstname()).append(Constants.FIELD_SEPARATOR)
    	.append(contact.getLastname()).append(Constants.FIELD_SEPARATOR)
    	.append(contact.getEmail()).append(Constants.FIELD_SEPARATOR)
    	.append(contact.getTitle()).append(Constants.FIELD_SEPARATOR)
    	.append(contact.getWebsite()).append(Constants.FIELD_SEPARATOR)
    	.append(contact.getCompany()).append(Constants.FIELD_SEPARATOR)
    	.append(contact.getDate_of_birth()).append(Constants.FIELD_SEPARATOR)
    	.append(Constants.RECORD_ENDER);
    	return record.toString();
    }
}
