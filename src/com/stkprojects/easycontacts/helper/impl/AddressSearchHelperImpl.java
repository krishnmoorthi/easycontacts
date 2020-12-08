/**
 * 
 */
package com.stkprojects.easycontacts.helper.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.stkprojects.easycontacts.helper.SearchHelper;
import com.stkprojects.easycontacts.model.Address;

/**
 * @author vishwa
 *
 */
public class AddressSearchHelperImpl implements SearchHelper<Address> {

	private List<Address> addressList;

	public AddressSearchHelperImpl(List<Address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public List<Address> search(String searchString) {
		return addressList.parallelStream()
				.filter(address -> address.getAddress_line_1().equalsIgnoreCase(searchString))
				.filter(address -> address.getAddress_line_2().equalsIgnoreCase(searchString))
				.filter(address -> address.getPin_or_zip_code().equalsIgnoreCase(searchString))
				.collect(Collectors.toList());
	}

	@Override
	public Address search(long id) {
		return addressList.parallelStream().filter(address -> address.getContact_id() == id)
				.collect(Collectors.toList()).get(0);
	}

}
