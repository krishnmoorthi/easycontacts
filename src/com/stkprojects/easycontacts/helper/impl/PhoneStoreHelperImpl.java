package com.stkprojects.easycontacts.helper.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.stkprojects.easycontacts.common.Constants;
import com.stkprojects.easycontacts.helper.StoreHelper;
import com.stkprojects.easycontacts.model.Phone;
import com.stkprojects.easycontacts.utils.StoreUtil;
import com.stkprojects.easycontacts.utils.TypeConversionUtil;

public class PhoneStoreHelperImpl  implements StoreHelper<List<Phone>, String> {
	
    public PhoneStoreHelperImpl(){
    }

    @Override
    public void LoadStoreData(List<Phone> phoneList, String file) throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        try(BufferedReader buffer = new BufferedReader(reader)){
            String line = buffer.readLine();
            while(null != line){
                phoneList.add(LoadPhoneData(line));
                line = buffer.readLine();
            }
        } catch (IOException e) {
			e.printStackTrace();
        }
    }

    @Override
    public String commitDataToStore(List<Phone> phoneList, String file) {
    	StringBuilder data = new StringBuilder("");
		for (Phone phone : phoneList) {
			data.append(prepareRecord(phone)).append(
					System.lineSeparator());
		}
		StoreUtil.checkAndCreateStoreFiles(file);
		try(FileWriter writer = new FileWriter(file)) {
			writer.write(data.toString());
			return "SUCCESS";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAILED";
		}
    }
    
    @Override
	public String deleteStoreData(String file) {
		File phoneFile = new File(file);
		if(phoneFile.exists()) {
			phoneFile.delete();
			return "SUCCESS";
		}else {
			return "FAILED";
		}
	}
    
    private Phone LoadPhoneData(String line)  {
        Phone phone = new Phone();
        String[] fieldValue = line.split(Constants.FIELD_SPLITTER);
        phone.setId(TypeConversionUtil.stringToLong(fieldValue[0]));
        phone.setContact_id(TypeConversionUtil.stringToLong(fieldValue[1]));
        phone.setType(fieldValue[2]);
        phone.setNumber(TypeConversionUtil.stringToLong(fieldValue[3]));
        return phone;
    }
    
	
	private String prepareRecord(Phone phone) {
		StringBuilder record = new StringBuilder("");
		record.append(phone.getId()).append(Constants.FIELD_SEPARATOR).append(phone.getContact_id())
				.append(Constants.FIELD_SEPARATOR).append(phone.getType()).append(Constants.FIELD_SEPARATOR)
				.append(phone.getNumber()).append(Constants.FIELD_SEPARATOR).append(Constants.RECORD_ENDER);
		return record.toString();

	}
}
