package com.stkprojects.easycontacts.helper.impl;

import com.stkprojects.easycontacts.helper.StoreHelper;
import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class AddressStoreHelperImpl implements StoreHelper<List<Address>, String> {

    private StoreDataHelper storeDataHelper;

    public AddressStoreHelperImpl() {
        storeDataHelper = new StoreDataHelper();
    }

    @Override
    public void LoadStoreData(List<Address> address, String file) throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        try (BufferedReader buffer = new BufferedReader(reader)) {
            String line = buffer.readLine();
            while (null != line) {
                address.add(storeDataHelper.LoadAddressData(line));
                line = buffer.readLine();
            }
        } catch (IOException e) {

        }
    }

    @Override
    public void commitDataToStore(List<Address> addressList, String file) {

    }
}
