package com.stkprojects.easycontacts.helper.impl;

import java.io.FileNotFoundException;

import com.stkprojects.easycontacts.common.Constants;
import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;
import com.stkprojects.easycontacts.utils.TypeConversionUtil;

public class StoreDataHelper {

    public Contact LoadContactData(String line) {
        Contact contact = new Contact();
        String[] fieldValue = getFields(line);
        contact.setId(TypeConversionUtil.stringToLong(fieldValue[0]));
        contact.setFirstname(fieldValue[1]);
        contact.setLastname(fieldValue[2]);
        contact.setEmail(fieldValue[3]);
        contact.setTitle(fieldValue[4]);
        contact.setWebsite(fieldValue[5]);
        contact.setCompany(fieldValue[6]);
        contact.setDate_of_birth(fieldValue[7]);
        return contact;
    }

    public Phone LoadPhoneData(String line)  {
        Phone phone = new Phone();
        String[] fieldValue = getFields(line);
        phone.setId(TypeConversionUtil.stringToLong(fieldValue[0]));
        phone.setContact_id(TypeConversionUtil.stringToLong(fieldValue[1]));
        phone.setType(fieldValue[2]);
        phone.setNumber(TypeConversionUtil.stringToLong(fieldValue[3]));
        return phone;
    }

    public Address LoadAddressData(String line) throws FileNotFoundException {
        Address address = new Address();
        String[] fieldValue = getFields(line);
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

    private String[] getFields(String line){
        return line.split(Constants.FIELD_SEPARATOR);
    }

}
