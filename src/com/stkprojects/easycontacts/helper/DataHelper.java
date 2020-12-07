package com.stkprojects.easycontacts.helper;

import com.stkprojects.easycontacts.model.Contact;

public interface DataHelper<T> {

    public void add(T t);
    public void delete(T t);
    public void edit(T t);
    public void prepareRecord(T t);
}
