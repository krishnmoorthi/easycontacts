/**
 * 
 */
package com.stkprojects.easycontacts.helper.impl;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.stkprojects.easycontacts.helper.SequenceGeneratorHelper;
import com.stkprojects.easycontacts.model.Phone;

/**
 * @author vishwa
 *
 */
public class PhoneSequenceGeneratorHelperImpl implements SequenceGeneratorHelper<Phone> {
	
	private AtomicLong value;
	
	public PhoneSequenceGeneratorHelperImpl(List<Phone> phoneList) {
		long value = getMax(phoneList);
		if (0 == value) {
			this.value = new AtomicLong(0);
		} else {
			this.value = new AtomicLong(value);
		}
	}

	@Override
	public long getNext() {
		return value.getAndIncrement();
	}

	private long getMax(List<Phone> phoneList) {
		if (phoneList.isEmpty()) {
			return 0;
		} else {
			Comparator<Phone> comparator = Comparator.comparing(Phone::getId);
			return phoneList.stream().max(comparator).get().getId();
		}
	}
}
