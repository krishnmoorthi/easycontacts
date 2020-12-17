package com.stkprojects.easycontacts.helper.impl;

import java.util.List;

import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.helper.SequenceGeneratorHelper;
import com.stkprojects.easycontacts.model.Address;

public class AddressDataHelperImpl implements DataHelper<Address> {
	
	private List<Address> addresses;
	private SequenceGeneratorHelper<Address> sequence;
	
	public AddressDataHelperImpl(List<Address> addresses){
		this.addresses = addresses;
		this.sequence = new AddressSequenceGeneratorHelperImpl(addresses);
	}

    @Override
    public void add(Address address) {
    	address.setId(sequence.getNext());
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

   
}
