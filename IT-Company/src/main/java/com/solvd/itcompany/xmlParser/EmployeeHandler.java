package com.solvd.itcompany.xmlParser;

import com.solvd.itcompany.classes.employee.Employee;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.bind.annotation.XmlElementWrapper;

public class EmployeeHandler extends DefaultHandler {
    @XmlElementWrapper(name = "employees")
    private static final String EMPLOYEES = "employees";
    private static final String EMPLOYEE = "employee";
    private static final String NAME = "name";
    private static final String LASTNAME = "lastName";
    private static final String BIRTHDATE = "birthdate";
    private static final String HIREDATE = "hiredate";

    private StringBuilder elementValue;


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch (qName) {
            case EMPLOYEE:
                new Employee();
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
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case NAME:
                elementValue.toString();
                break;
            case LASTNAME:
                elementValue.toString();
                break;
            case BIRTHDATE:
                elementValue.toString();
                break;
            case HIREDATE:
                elementValue.toString();
                break;

        }
    }
}
