package com.stkprojects.easycontacts.operations;

import java.io.FileNotFoundException;
import java.util.List;

import com.stkprojects.easycontacts.common.Constants;
import com.stkprojects.easycontacts.helper.StoreHelper;
import com.stkprojects.easycontacts.helper.impl.AddressStoreHelperImpl;
import com.stkprojects.easycontacts.helper.impl.ContactStoreHelperImpl;
import com.stkprojects.easycontacts.helper.impl.PhoneStoreHelperImpl;
import com.stkprojects.easycontacts.model.Address;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.model.Phone;

public class StoreOperation {

	private StoreHelper<List<Contact>, String> contactStoreHelper;
	private StoreHelper<List<Phone>, String> phoneStoreHelper;
	private StoreHelper<List<Address>, String> addressStoreHelper;

	public StoreOperation() {
		contactStoreHelper = new ContactStoreHelperImpl();
		phoneStoreHelper = new PhoneStoreHelperImpl();
		addressStoreHelper = new AddressStoreHelperImpl();
	}

	public void LoadStoreData(List<Contact> contacts, List<Phone> phone, List<Address> address)
			throws FileNotFoundException {
		contactStoreHelper.LoadStoreData(contacts, Constants.CONTACTS_STORE_FILE);
		phoneStoreHelper.LoadStoreData(phone, Constants.PHONE_STORE_FILE);
		addressStoreHelper.LoadStoreData(address, Constants.ADDRESS_STORE_FILE);
	}

	public String commitDataInStore(List<Contact> contacts, List<Phone> phone, List<Address> address) {
		if ("SUCCESS".equalsIgnoreCase(contactStoreHelper.commitDataToStore(contacts, Constants.CONTACTS_STORE_FILE))
				&& "SUCCESS".equalsIgnoreCase(phoneStoreHelper.commitDataToStore(phone, Constants.PHONE_STORE_FILE))
				&& "SUCCESS".equalsIgnoreCase(
						addressStoreHelper.commitDataToStore(address, Constants.ADDRESS_STORE_FILE))) {
			return "SUCCESS";
		} else {
			return "FAILURE";
		}
	}

	public String deleteDataInStore() {
		if ("SUCCESS".equalsIgnoreCase(contactStoreHelper.deleteStoreData(Constants.CONTACTS_STORE_FILE))
				&& "SUCCESS".equalsIgnoreCase(phoneStoreHelper.deleteStoreData(Constants.PHONE_STORE_FILE))
				&& "SUCCESS".equalsIgnoreCase(addressStoreHelper.deleteStoreData(Constants.ADDRESS_STORE_FILE))) {
			return "SUCCESS";
		} else {
			return "FAILURE";
		}

	}

}
