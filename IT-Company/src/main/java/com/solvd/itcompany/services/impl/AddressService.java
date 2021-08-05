package com.solvd.itcompany.services.impl;

import com.solvd.itcompany.classes.location.Address;
import com.solvd.itcompany.dao.IAddressDAO;
import com.solvd.itcompany.dao.ICityDAO;
import com.solvd.itcompany.dao.mysql.jdbc.AddressDAO;
import com.solvd.itcompany.dao.mysql.jdbc.CityDAO;
import com.solvd.itcompany.services.IAddressService;

public class AddressService implements IAddressService {
    private IAddressDAO addressDAO = new AddressDAO();
    private ICityDAO cityDAO = new CityDAO();


    @Override
    public Address getAddressById(long id) {
        Address address = addressDAO.getItemById(id);
        address.setCity(cityDAO.getItemById(address.getCity().getId()));
        return address;
    }
}
