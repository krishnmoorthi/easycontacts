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
import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.utils.StoreUtil;
import com.stkprojects.easycontacts.utils.TypeConversionUtil;

public class AddressStoreHelperImpl implements StoreHelper<List<Address>, String> {

    public AddressStoreHelperImpl() {
    }

    @Override
    public void LoadStoreData(List<Address> address, String file) throws FileNotFoundException {
        FileReader reader = new FileReader(file);
        try (BufferedReader buffer = new BufferedReader(reader)) {
            String line = buffer.readLine();
            while (null != line) {
                address.add(LoadAddressData(line));
                line = buffer.readLine();
            }
        } catch (IOException e) {
			e.printStackTrace();
        }
    }

    @Override
    public String commitDataToStore(List<Address> addressList, String file) {
    	StringBuilder data = new StringBuilder("");
		for (Address address : addressList) {
			data.append(prepareRecord(address)).append(
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
		File addressFile = new File(file);
		if(addressFile.exists()) {
			addressFile.delete();
			return "SUCCESS";
		}else {
			return "FAILED";
		}
	}
    
    private Address LoadAddressData(String line) throws FileNotFoundException {
        Address address = new Address();
        String[] fieldValue = line.split(Constants.FIELD_SPLITTER);
        address.setId(TypeConversionUtil.stringToLong(fieldValue[0]));
        address.setContact_id(TypeConversionUtil.stringToLong(fieldValue[1]));
        address.setType(fieldValue[2]);
        address.setAddress_line_1(fieldValue[3]);
        address.setAddress_line_2(fieldValue[4]);
        address.setCity(fieldValue[5]);
        address.setState(fieldValue[6]);
        address.setPin_or_zip_code(fieldValue[7]);
        return address;
    }
    
    private String prepareRecord(Address address) {
    	StringBuilder record = new StringBuilder("");
    	record.append(address.getId()).append(Constants.FIELD_SEPARATOR)
    	.append(address.getContact_id()).append(Constants.FIELD_SEPARATOR)
    	.append(address.getType()).append(Constants.FIELD_SEPARATOR)
    	.append(address.getAddress_line_1()).append(Constants.FIELD_SEPARATOR)
    	.append(address.getAddress_line_2()).append(Constants.FIELD_SEPARATOR)
    	.append(address.getCity()).append(Constants.FIELD_SEPARATOR)
    	.append(address.getState()).append(Constants.FIELD_SEPARATOR)
    	.append(address.getPin_or_zip_code()).append(Constants.FIELD_SEPARATOR)
    	.append(Constants.RECORD_ENDER);
    	return record.toString();
    }
}
