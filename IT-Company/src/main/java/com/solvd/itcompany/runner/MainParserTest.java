package com.solvd.itcompany.runner;

import com.solvd.itcompany.classes.employee.Employee;
import com.solvd.itcompany.classes.location.City;
import com.solvd.itcompany.connectionPool.ConnectionPool;
import com.solvd.itcompany.services.impl.CityService;
import com.solvd.itcompany.xmlParser.EmployeeHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class MainParserTest {
    private final static Logger LOGGER = Logger.getLogger(MainParserTest.class);

    public final static void main(String[] args) throws JAXBException, ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        EmployeeHandler employeeHandler = new EmployeeHandler();
        saxParser.parse("./src/main/resources/xml/employees.xml",employeeHandler );

        /*Employee employee = new Employee();
        JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(employee, new File("./src/main/resources/xml/employees"));
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Employee result = (Employee) unmarshaller.unmarshal( new File("./src/main/resources/xml/employees"));
*/

    }


}
