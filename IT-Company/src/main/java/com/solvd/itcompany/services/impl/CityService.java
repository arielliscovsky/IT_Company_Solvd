package com.solvd.itcompany.services.impl;

import com.solvd.itcompany.classes.location.City;
import com.solvd.itcompany.dao.ICityDAO;
import com.solvd.itcompany.dao.ICountryDAO;
import com.solvd.itcompany.dao.mysql.jdbc.CityDAO;
import com.solvd.itcompany.dao.mysql.jdbc.CountryDAO;
import com.solvd.itcompany.services.ICityService;
import org.apache.log4j.Logger;

public class CityService implements ICityService {
    private final static Logger LOGGER = Logger.getLogger(CityService.class);
    private ICityDAO cityDAO = new CityDAO();
    private ICountryDAO countryDAO = new CountryDAO();

    @Override
    public City getCityById(long id) {
        City city = cityDAO.getItemById(id);
        city.setCountry(countryDAO.getItemById(city.getCountry().getId()));

        return city;
    }
}
