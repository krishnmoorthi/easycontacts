package com.stkprojects.easycontacts.operations;

import com.stkprojects.easycontacts.model.Contact;

import java.util.List;

public class EasyContactsOperation {

    public void create(Contact contact) {
        //ToDo: save contact
    }

    public void delete(long contact_id) {
        //ToDo: delete contact
    }

    public void edit(Contact contact) {
        //ToDo: save contact
    }

    public List<Contact> selectContactByName(String... names) {
        //ToDo: search contacts by first and last name
        return null;
    }

    public List<Contact> selectContactByAddress(String... address) {
        //ToDo: search contacts by first and last name
        return null;
    }

    public List<Contact> listAllContacts() {
        return null;
    }

    public Contact selectContactByPhoneNumber(long number) {
        return null;
    }
}
