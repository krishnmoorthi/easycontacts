package com.stkprojects.easycontacts.helper.impl;

import com.stkprojects.easycontacts.common.Constants;
import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.model.Phone;

public class PhoneDataHelper implements DataHelper<Phone> {

    @Override
    public void add(Phone phone) {

    }

    @Override
    public void delete(Phone phone) {

    }

    @Override
    public void edit(Phone phone) {

    }

    @Override
    public String prepareRecord(Phone phone) {
    	StringBuilder record = new StringBuilder("");
    	record.append(phone.getId()).append(Constants.FIELD_SEPARATOR)
    	.append(phone.getContact_id()).append(Constants.FIELD_SEPARATOR)
    	.append(phone.getType()).append(Constants.FIELD_SEPARATOR)
    	.append(phone.getNumber()).append(Constants.FIELD_SEPARATOR)
    	.append(Constants.RECORD_ENDER);
		return record.toString();

    }
}
