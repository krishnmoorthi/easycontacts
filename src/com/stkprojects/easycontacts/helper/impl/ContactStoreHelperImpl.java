package com.stkprojects.easycontacts.helper.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.stkprojects.easycontacts.common.Constants;
import com.stkprojects.easycontacts.helper.StoreHelper;
import com.stkprojects.easycontacts.model.Contact;
import com.stkprojects.easycontacts.utils.StoreUtil;
import com.stkprojects.easycontacts.utils.TypeConversionUtil;

public class ContactStoreHelperImpl implements
		StoreHelper<List<Contact>, String> {

	public ContactStoreHelperImpl() {
	}
	
	@Override
	public void LoadStoreData(List<Contact> contacts, String file)
			throws FileNotFoundException {
		FileReader reader = new FileReader(file);
		try (BufferedReader buffer = new BufferedReader(reader)) {
			String line = buffer.readLine();
			while (null != line) {
				contacts.add(LoadContactData(line));
				line = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String commitDataToStore(List<Contact> contacts, String file) {
		StringBuilder data = new StringBuilder("");
		for (Contact contact : contacts) {
			data.append(prepareRecord(contact)).append(
					System.lineSeparator());
		}
		StoreUtil.checkAndCreateStoreFiles(file);
		try(FileWriter writer = new FileWriter(file)) {
			writer.write(data.toString());
			return "SUCCESS";
		} catch (IOException e) {
			e.printStackTrace();
			return "FAILED";
		}
	}


	private String prepareRecord(Contact contact) {
		StringBuilder record = new StringBuilder("");
		record.append(contact.getId()).append(Constants.FIELD_SEPARATOR).append(contact.getFirstname())
				.append(Constants.FIELD_SEPARATOR).append(contact.getLastname()).append(Constants.FIELD_SEPARATOR)
				.append(contact.getEmail()).append(Constants.FIELD_SEPARATOR).append(contact.getTitle())
				.append(Constants.FIELD_SEPARATOR).append(contact.getWebsite()).append(Constants.FIELD_SEPARATOR)
				.append(contact.getCompany()).append(Constants.FIELD_SEPARATOR).append(contact.getDate_of_birth())
				.append(Constants.FIELD_SEPARATOR).append(Constants.RECORD_ENDER);
		return record.toString();
	}
	
	private Contact LoadContactData(String line) {
        Contact contact = new Contact();
        String[] fieldValue = line.split(Constants.FIELD_SPLITTER);
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

	@Override
	public String deleteStoreData(String file) {
		File contactFile = new File(file);
		if(contactFile.exists()) {
			contactFile.delete();
			return "SUCCESS";
		}else {
			return "FAILED";
		}
	}

}
