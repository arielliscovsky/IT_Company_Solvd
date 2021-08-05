package com.solvd.itcompany.dao;

import com.solvd.itcompany.classes.location.City;

public interface IBaseDAO <T> {
    long createItem(T item);
    T getItemById(long id);
    void updateItem(T item);
    void deleteItem(long id);
}
