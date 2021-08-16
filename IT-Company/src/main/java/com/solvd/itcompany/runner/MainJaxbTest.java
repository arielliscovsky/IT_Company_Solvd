package com.solvd.itcompany.runner;

import com.solvd.itcompany.classes.employee.Employee;
import com.solvd.itcompany.classes.employee.User;
import com.solvd.itcompany.xmlParser.Employees;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MainJaxbTest {

    private final static Logger LOGGER = Logger.getLogger(MainJaxbTest.class);

    public final static void main(String[] args) {

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
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Employees result = (Employees) unmarshaller.unmarshal(new File("./IT_Company_Solvd/IT-Company/src/main/resources/xml/employees.xml"));
            result.getEmployees().forEach((employee) -> {
                LOGGER.debug(employee);});

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(employees, new File("./IT_Company_Solvd/IT-Company/src/main/resources/xml/test.xml"));
        }
        catch (JAXBException e){
            LOGGER.debug(e.toString());
        }
    }
}
