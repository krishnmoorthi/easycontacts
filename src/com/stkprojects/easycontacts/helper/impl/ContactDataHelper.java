package com.stkprojects.easycontacts.helper.impl;

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
        contacts.replaceAll(contact);
    }

    @Override
    public void prepareRecord(Contact contact) {

    }
}
