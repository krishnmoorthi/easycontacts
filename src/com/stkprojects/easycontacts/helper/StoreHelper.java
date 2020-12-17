package com.stkprojects.easycontacts.helper;

import java.io.FileNotFoundException;

public interface StoreHelper<T,U> {

    public void LoadStoreData(T t,U u) throws FileNotFoundException;
    public String commitDataToStore(T t,U u);
    public String deleteStoreData(String file);
}