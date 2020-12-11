/**
 * 
 */
package com.stkprojects.easycontacts.helper.impl;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.stkprojects.easycontacts.helper.SequenceGeneratorHelper;
import com.stkprojects.easycontacts.model.Address;

/**
 * @author vishwa
 *
 */
public class AddressSequenceGeneratorHelperImpl implements SequenceGeneratorHelper<Address> {

	private AtomicLong value;

	public AddressSequenceGeneratorHelperImpl(List<Address> addressList) {
		long value = getMax(addressList);
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

	private long getMax(List<Address> addressList) {
		if (addressList.isEmpty()) {
			return 0;
		} else {
			Comparator<Address> comparator = Comparator.comparing(Address::getId);
			return addressList.stream().max(comparator).get().getId();
		}
	}
}
