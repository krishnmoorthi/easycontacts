package com.stkprojects.easycontacts.helper.impl;

import java.util.List;

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
	public void add(long contact_id,Phone phone) {
		phone.setId(sequence.getNext());
		phone.setContact_id(contact_id);
		phoneList.add(phone);
	}

	@Override
	public void delete(Phone phone) {
		phoneList.remove(phone);
	}

	@Override
	public void edit(Phone oldPhone, Phone newPhone) {
		int index = 0;
		if((index = phoneList.indexOf(oldPhone)) > 0) {
			phoneList.set(index, newPhone);
		}
	}

}
