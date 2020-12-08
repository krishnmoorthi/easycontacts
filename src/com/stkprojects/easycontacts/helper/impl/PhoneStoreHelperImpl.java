package com.stkprojects.easycontacts.helper.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.helper.StoreHelper;
import com.stkprojects.easycontacts.model.Phone;

public class PhoneStoreHelperImpl  implements StoreHelper<List<Phone>, String> {
	
    private StoreDataHelper storeDataHelper;
    private DataHelper<Phone> phoneDataHelper;

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
    public void commitDataToStore(List<Phone> phoneList, String file) {
    	StringBuilder data = new StringBuilder("");
		for (Phone phone : phoneList) {
			data.append(phoneDataHelper.prepareRecord(phone)).append(
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
