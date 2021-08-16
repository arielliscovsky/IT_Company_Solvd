package com.solvd.itcompany.runner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.itcompany.classes.employee.Employee;
import com.solvd.itcompany.classes.employee.User;
import com.solvd.itcompany.xmlParser.Employees;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class MainJacksonTest {

    private final static Logger LOGGER = Logger.getLogger(MainJacksonTest.class);

    public final static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(df);
        try {
            Employee employee = objectMapper.readValue(new File("./IT_Company_Solvd/IT-Company/src/main/resources/json/employees.json"),Employee.class);
            LOGGER.debug(employee);
        } catch (IOException e) {
            LOGGER.debug(e.toString());
        }


        Employees employees = new Employees();
        Employee employee1 = new Employee();
        employee1.setId(3);
        employee1.setName("Adam");
        employee1.setLastName("Bird");
        User user = new User();
        user.setId(3);
        user.setUserName("abird");
        user.setPassword("abird123");
        employee1.setUser(user);
        employees.getEmployees().add(employee1);

        try {
            objectMapper.writeValue(new File("./IT_Company_Solvd/IT-Company/src/main/resources/json/employee.json"),employees);
        } catch (IOException e) {
            LOGGER.debug(e.toString());
        }


    }
}
