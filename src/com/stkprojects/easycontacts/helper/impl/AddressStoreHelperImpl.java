package com.stkprojects.easycontacts.helper.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.helper.StoreHelper;
import com.stkprojects.easycontacts.model.Address;

public class AddressStoreHelperImpl implements StoreHelper<List<Address>, String> {

    private StoreDataHelper storeDataHelper;
    private DataHelper<Address> addressDataHelper;

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
    	StringBuilder data = new StringBuilder("");
		for (Address address : addressList) {
			data.append(addressDataHelper.prepareRecord(address)).append(
					System.lineSeparator());
		}
		try(FileWriter writer = new FileWriter(file)) {
			writer.write(data.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
