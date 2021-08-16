package com.solvd.itcompany.runner;

import com.solvd.itcompany.classes.employee.Employee;
import com.solvd.itcompany.xmlParser.EmployeeHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class MainParserTest {
    private final static Logger LOGGER = Logger.getLogger(MainParserTest.class);

    public final static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        EmployeeHandler employeeHandler = new EmployeeHandler();
        saxParser.parse("./IT_Company_Solvd/IT-Company/src/main/resources/xml/employees.xml",employeeHandler );
        List<Employee> empList =employeeHandler.getEmployees().getEmployees();
        empList.forEach((employee) -> {
            LOGGER.debug(employee);});
    }


}
