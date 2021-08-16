package com.solvd.itcompany.xmlParser;

import com.solvd.itcompany.classes.employee.Employee;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {
    private List<Employee> employees;


    public Employees() {
        this.employees = new ArrayList<Employee>();
    }
    @XmlElement(name = "employee")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
