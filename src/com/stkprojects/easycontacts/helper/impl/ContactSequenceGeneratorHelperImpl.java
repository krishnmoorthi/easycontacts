/**
 * 
 */
package com.stkprojects.easycontacts.helper.impl;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.stkprojects.easycontacts.helper.SequenceGeneratorHelper;
import com.stkprojects.easycontacts.model.Contact;

/**
 * @author vishwa
 *
 */
public class ContactSequenceGeneratorHelperImpl implements SequenceGeneratorHelper<Contact> {

	private AtomicLong value;

	public ContactSequenceGeneratorHelperImpl(List<Contact> contacts) {
		long value = getMax(contacts);
		if (0 == value) {
			this.value = new AtomicLong(1);
		} else {
			this.value = new AtomicLong(value);
		}
	}

	@Override
	public long getNext() {
		return value.getAndIncrement();
	}

	private long getMax(List<Contact> contacts) {
		if (contacts.isEmpty()) {
			return 0;
		} else {
			Comparator<Contact> comparator = Comparator.comparing(Contact::getId);
			return contacts.stream().max(comparator).get().getId();
		}
	}

}
