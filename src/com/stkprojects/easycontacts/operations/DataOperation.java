/**
 * 
 */
package com.stkprojects.easycontacts.operations;

import java.util.List;

import com.stkprojects.easycontacts.helper.DataHelper;
import com.stkprojects.easycontacts.helper.SequenceGeneratorHelper;
import com.stkprojects.easycontacts.helper.impl.AddressDataHelperImpl;
import com.stkprojects.easycontacts.helper.impl.ContactDataHelperImpl;
import com.stkprojects.easycontacts.helper.impl.ContactSequenceGeneratorHelperImpl;
import com.stkprojects.easycontacts.helper.impl.PhoneDataHelperImpl;
import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;

/**
 * @author kthangav
 *
 */
public class DataOperation {

	private List<Contact> contactList;
	private List<Phone> phoneList;
	private List<Address> addressList;

	private DataHelper<Contact> contactDataHelper;
	private DataHelper<Phone> phoneDataHelper;
	private DataHelper<Address> addressDataHelper;

	public DataOperation(List<Contact> contactList, List<Phone> phoneList, List<Address> addressList) {
		this.contactList = contactList;
		this.phoneList = phoneList;
		this.addressList = addressList;
		intializeHelpers();
	}

	private void intializeHelpers() {
		contactDataHelper = new ContactDataHelperImpl(contactList);
		phoneDataHelper = new PhoneDataHelperImpl(phoneList);
		addressDataHelper = new AddressDataHelperImpl(addressList);
	}

	public String addContact(Contact contact, List<Phone> newPhoneList, List<Address> newAddressList) {
		SequenceGeneratorHelper<Contact> sequence = new ContactSequenceGeneratorHelperImpl(contactList);
		long new_contact_id = sequence.getNext();
		contactDataHelper.add(new_contact_id, contact);
		newPhoneList.forEach(phone -> phoneDataHelper.add(new_contact_id, phone));
		newAddressList.forEach(address -> addressDataHelper.add(new_contact_id, address));
		return "SUCCESS";
	}

	public String addPhone(long contact_id, Phone phone) {
		phoneDataHelper.add(contact_id, phone);
		return "SUCCESS";
	}

	public String addAddress(long contact_id, Address address) {
		addressDataHelper.add(contact_id, address);
		return "SUCCESS";
	}

	public String deleteContact(Contact contact, List<Phone> deletePhoneList, List<Address> deleteAddressList) {
		contactDataHelper.delete(contact);
		deletePhoneList.forEach(phone -> phoneDataHelper.delete(phone));
		deleteAddressList.forEach(address -> addressDataHelper.delete(address));
		return "SUCCESS";
	}

	public String deletePhone(Phone phone) {
		phoneDataHelper.delete(phone);
		return "SUCCESS";
	}

	public String deleteAddress(Address address) {
		addressDataHelper.delete(address);
		return "SUCCESS";
	}

}
