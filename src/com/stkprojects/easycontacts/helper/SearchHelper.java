package com.stkprojects.easycontacts.helper;

import java.util.List;

public interface SearchHelper<T> {

    public List<T> search(String searchString);
    public T search(long id);
}
