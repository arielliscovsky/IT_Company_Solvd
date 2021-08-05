package com.solvd.itcompany.services.impl;

import com.solvd.itcompany.classes.employee.Employee;
import com.solvd.itcompany.dao.IAddressDAO;
import com.solvd.itcompany.dao.IEmployeeDAO;
import com.solvd.itcompany.dao.IUserDAO;
import com.solvd.itcompany.dao.mysql.jdbc.AddressDAO;
import com.solvd.itcompany.dao.mysql.jdbc.EmployeeDAO;
import com.solvd.itcompany.dao.mysql.jdbc.UserDAO;
import com.solvd.itcompany.services.IEmployeeService;

public class EmployeeService implements IEmployeeService {
    private IEmployeeDAO employeeDAO = new EmployeeDAO();
    private IUserDAO userDAO = new UserDAO();
    private IAddressDAO addressDAO = new AddressDAO();
    private IEmployeeDAO reportsTo = new EmployeeDAO();

    @Override
    public Employee getEmployeeById(long id) {
        Employee employee = employeeDAO.getItemById(id);
        employee.setUser(userDAO.getItemById(employee.getUser().getId()));
        employee.setAddress(addressDAO.getItemById(employee.getAddress().getId()));
        employee.setReportsTo(reportsTo.getItemById(employee.getReportsTo().getId()));
        return employee;
    }
}
