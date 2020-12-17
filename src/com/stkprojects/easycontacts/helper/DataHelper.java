package com.stkprojects.easycontacts.helper;

public interface DataHelper<T> {

    public void add(T t);
    public void delete(T t);
    public void edit(T t);
}