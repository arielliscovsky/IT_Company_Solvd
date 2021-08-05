package com.solvd.itcompany.runner;

import com.solvd.itcompany.classes.employee.Employee;
import com.solvd.itcompany.classes.location.Address;
import com.solvd.itcompany.classes.location.City;
import com.solvd.itcompany.classes.location.Country;
import com.solvd.itcompany.connectionPool.ConnectionPool;
import com.solvd.itcompany.dao.mysql.jdbc.CityDAO;
import com.solvd.itcompany.dao.mysql.jdbc.CountryDAO;
import com.solvd.itcompany.dao.mysql.jdbc.EmployeeDAO;
import com.solvd.itcompany.services.impl.CityService;
import com.solvd.itcompany.services.impl.EmployeeService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public final static void main(String[] args) throws SQLException {

        Connection c = ConnectionPool.getInstance().getConnection();

        /*Employee employee1 = new EmployeeService().getEmployeeById(4);
        LOGGER.debug("The employee selected is: " + employee1.toString());*/

        /*Country country = new CountryDAO().getItemById(1);*/

        /*City city = new City(1,"Cordoba",5000.0,country);
        new CityDAO().updateItem(city);*/

        /*City city1 = new City(4,"Buenos Aires",1000.0,country);
        new CityDAO().createItem(city1);*/

        /*City city2 = new CityDAO().getItemById(1);
        LOGGER.debug(city2.toString());*/

        City city3 = new CityService().getCityById(1);
        LOGGER.debug(city3.toString());

        c.close();
    }
}
