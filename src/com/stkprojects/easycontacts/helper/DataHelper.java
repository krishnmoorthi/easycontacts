package com.stkprojects.easycontacts.helper;

public interface DataHelper<T> {

    public void add(long contact_id,T t);
    public void delete(T t);
    public void edit(T old,T t);

}