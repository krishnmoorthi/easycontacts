package com.stkprojects.easycontacts.helper.impl;

import java.util.List;

import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.helper.SequenceGeneratorHelper;
import com.stkprojects.easycontacts.model.Address;

public class AddressDataHelperImpl implements DataHelper<Address> {
	
	private List<Address> addressList;
	private SequenceGeneratorHelper<Address> sequence;
	
	public AddressDataHelperImpl(List<Address> addressList){
		this.addressList = addressList;
		this.sequence = new AddressSequenceGeneratorHelperImpl(addressList);
	}

    @Override
    public void add(long contact_id, Address address) {
    	address.setId(sequence.getNext());
    	address.setContact_id(contact_id);
    	addressList.add(address);
    }

    @Override
    public void delete(Address address) {
    	addressList.remove(address);
    }

    @Override
    public void edit(Address oldAddress, Address newAddress) {
    	int index=0;
    	if((index = addressList.indexOf(oldAddress)) > 0) {
    		addressList.set(index, newAddress);
    	}
    }

   
}
