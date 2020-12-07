package com.stkprojects.easycontacts.operations;

import com.stkprojects.easycontacts.common.Constants;
import com.stkprojects.easycontacts.helper.StoreHelper;
import com.stkprojects.easycontacts.helper.impl.ContactStoreHelperImpl;
import com.stkprojects.easycontacts.helper.impl.StoreDataHelper;
import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class StoreOperation {

        public void LoadStoreData(List<Contact> contacts,List<Phone> phone, List<Address> address) throws FileNotFoundException {
            StoreHelper contactStoreHelper = new ContactStoreHelperImpl();
            contactStoreHelper.LoadStoreData(contacts,Constants.CONTACTS_STORE_FILE);


        }



}
