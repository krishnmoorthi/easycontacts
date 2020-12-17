package com.stkprojects.easycontacts.helper.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.helper.SequenceGeneratorHelper;
import com.stkprojects.easycontacts.model.Phone;

public class PhoneDataHelperImpl implements DataHelper<Phone> {

	private List<Phone> phoneList;
	private SequenceGeneratorHelper<Phone> sequence;

	public PhoneDataHelperImpl(List<Phone> phoneList) {
		this.phoneList = phoneList;
		this.sequence = new PhoneSequenceGeneratorHelperImpl(phoneList);
	}

	@Override
	public void add(Phone phone) {
		phone.setId(sequence.getNext());
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

}
