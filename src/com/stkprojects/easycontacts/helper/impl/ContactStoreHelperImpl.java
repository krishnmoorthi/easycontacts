package com.stkprojects.easycontacts.helper.impl;

import com.stkprojects.easycontacts.common.Constants;
import com.stkprojects.easycontacts.helper.StoreHelper;
import com.stkprojects.easycontacts.model.Contact;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ContactStoreHelperImpl implements StoreHelper<List<Contact>, String> {
    private StoreDataHelper storeDataHelper;

    public ContactStoreHelperImpl(){
        storeDataHelper = new StoreDataHelper();
    }

    @Override
    public void LoadStoreData(List<Contact> contacts, String file) throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        try(BufferedReader buffer = new BufferedReader(reader)){
            String line = buffer.readLine();
            while(null != line){
                contacts.add(storeDataHelper.LoadContactData(line));
                line = buffer.readLine();
            }
        } catch (IOException e) {

        }
    }

    @Override
    public void commitDataToStore(List<Contact> contacts, String file) {

    }
}
