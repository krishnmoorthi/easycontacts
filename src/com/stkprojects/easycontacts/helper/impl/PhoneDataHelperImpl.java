package com.stkprojects.easycontacts.helper.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.stkprojects.easycontacts.common.Constants;
import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.model.Phone;

public class PhoneDataHelperImpl implements DataHelper<Phone> {

	private List<Phone> phoneList;

	public PhoneDataHelperImpl(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}

	@Override
	public void add(Phone phone) {
		phoneList.add(phone);
	}

	@Override
	public void delete(Phone phone) {
		phoneList.remove(phone);
	}

	@Override
	public void edit(Phone phone) {
		delete(phoneList.stream().filter(phoneLst -> phoneLst.getId() == phone.getId()).collect(Collectors.toList())
				.get(0));
		phoneList.add(phone);
	}

	@Override
	public String prepareRecord(Phone phone) {
		StringBuilder record = new StringBuilder("");
		record.append(phone.getId()).append(Constants.FIELD_SEPARATOR).append(phone.getContact_id())
				.append(Constants.FIELD_SEPARATOR).append(phone.getType()).append(Constants.FIELD_SEPARATOR)
				.append(phone.getNumber()).append(Constants.FIELD_SEPARATOR).append(Constants.RECORD_ENDER);
		return record.toString();

	}
}
