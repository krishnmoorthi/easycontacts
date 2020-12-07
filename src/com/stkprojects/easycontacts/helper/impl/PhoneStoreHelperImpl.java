package com.stkprojects.easycontacts.helper.impl;

import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.helper.StoreHelper;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PhoneStoreHelperImpl  implements StoreHelper<List<Phone>, String> {
    private StoreDataHelper storeDataHelper;

    public PhoneStoreHelperImpl(){
        storeDataHelper = new StoreDataHelper();
    }

    @Override
    public void LoadStoreData(List<Phone> phoneList, String file) throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        try(BufferedReader buffer = new BufferedReader(reader)){
            String line = buffer.readLine();
            while(null != line){
                phoneList.add(storeDataHelper.LoadPhoneData(line));
                line = buffer.readLine();
            }
        } catch (IOException e) {

        }
    }

    @Override
    public void commitDataToStore(List<Phone> contacts, String file) {

    }
}
