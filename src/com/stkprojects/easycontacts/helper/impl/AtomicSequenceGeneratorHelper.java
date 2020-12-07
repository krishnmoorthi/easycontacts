package com.stkprojects.easycontacts.helper.impl;

import com.stkprojects.easycontacts.helper.SequenceGeneratorHelper;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicSequenceGeneratorHelper implements SequenceGeneratorHelper {

    private AtomicLong value = new AtomicLong(1);

    @Override
    public long getNext() {
        return value.getAndIncrement();
    }
}
