package com.solvd.itcompany.xmlParser;

import com.solvd.itcompany.classes.employee.Employee;
import com.solvd.itcompany.classes.employee.User;
import com.solvd.itcompany.classes.location.Address;
import com.solvd.itcompany.runner.Main;
import org.apache.log4j.Logger;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.bind.annotation.XmlElementWrapper;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeHandler extends DefaultHandler {

    private final static org.apache.log4j.Logger LOGGER = Logger.getLogger(EmployeeHandler.class);

    private static final String EMPLOYEE = "employee";
    private static final String NAME = "name";
    private static final String LASTNAME = "lastname";
    private static final String BIRTHDATE = "birthdate";
    private static final String HIREDATE = "hiredate";
    private static final String USER = "user";
    //private static final String USERNAME = "username";
    //private static final String PASSWORD = "password";
    private static final String ADDRESS = "address";
    //private static final String STREET = "street";
    //private static final String NUMBER = "number";
    //private static final String CITY = "city";
    //private static final String CITYNAME = "cityname";
    //private static final String COUNTRY = "country";
    //private static final String COUNTRYNAME = "countryname";

    private Employee employee = null;
    private User user = null;
    private Address address = null;

    private Employees employees = null;
    private StringBuilder elementValue;
    private DateAdapter dateAdapter = null;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public Employees getEmployees() {
        return employees;
    }



    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
       employees = new Employees();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {

            case EMPLOYEE:
                String idEmp = attr.getValue("id");
                employee = new Employee();
                employee.setId(Long.parseLong(idEmp));
                break;
            case NAME:
                elementValue = new StringBuilder();
                break;
            case LASTNAME:
                elementValue = new StringBuilder();
                break;
            case BIRTHDATE:
                elementValue = new StringBuilder();
                break;
            case HIREDATE:
                elementValue = new StringBuilder();
                break;
            case USER:
                String idUser = attr.getValue("id");
                user = new User();
                user.setId(Long.parseLong(idUser));
                break;
            case ADDRESS:
                String idAddress = attr.getValue("id");
                address = new Address();
                address.setId(Long.parseLong(idAddress));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case NAME:
                employee.setName(elementValue.toString());
                break;
            case LASTNAME:
                employee.setLastName(elementValue.toString());
                break;
            case BIRTHDATE:
                try {
                    Date date = format.parse(elementValue.toString());
                    employee.setBirthDate(date);
                } catch (ParseException e) {
                    LOGGER.debug(e.toString());
                }
                /*try{employee.setBirthDate(dateAdapter.unmarshal(elementValue.toString()));}
                catch (NullPointerException e){ LOGGER.debug(e.toString());}*/
                break;
            case HIREDATE:
                try {
                    Date date = format.parse(elementValue.toString());
                    employee.setHireDate(date);
                } catch (ParseException e) {
                    LOGGER.debug(e.toString());
                }
                break;
            case USER:
                employee.setUser(user);
            case ADDRESS:
                employee.setAddress(address);
            case EMPLOYEE:
                employees.getEmployees().add(employee);

        }
    }
}
