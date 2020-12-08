/**
 * 
 */
package com.stkprojects.easycontacts.helper.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.stkprojects.easycontacts.helper.SearchHelper;
import com.stkprojects.easycontacts.model.Phone;
import com.stkprojects.easycontacts.utils.TypeConversionUtil;

/**
 * @author vishwa
 *
 */
public class PhoneSearchHelperImpl implements SearchHelper<Phone> {

	private List<Phone> phoneList;

	public PhoneSearchHelperImpl(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}

	@Override
	public List<Phone> search(String searchString) {
		return phoneList.parallelStream()
				.filter(phone -> phone.getNumber() == TypeConversionUtil.stringToLong(searchString))
				.collect(Collectors.toList());
	}

	@Override
	public Phone search(long id) {
		return phoneList.parallelStream().filter(phone -> phone.getContact_id() == id).collect(Collectors.toList())
				.get(0);
	}

}
