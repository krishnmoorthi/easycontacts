package com.stkprojects.easycontacts.helper.impl;

import java.util.List;

import com.stkprojects.easycontacts.common.Constants;
import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.model.Address;

public class AddressDataHelperImpl implements DataHelper<Address> {
	
	private List<Address> addresses;
	
	public AddressDataHelperImpl(List<Address> addresses){
		this.addresses = addresses;
	}

    @Override
    public void add(Address address) {
    	addresses.add(address);
    }

    @Override
    public void delete(Address address) {
    	addresses.remove(address);
    }

    @Override
    public void edit(Address address) {
    	//TODO: Search and modify address
    }

    @Override
    public String prepareRecord(Address address) {
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
