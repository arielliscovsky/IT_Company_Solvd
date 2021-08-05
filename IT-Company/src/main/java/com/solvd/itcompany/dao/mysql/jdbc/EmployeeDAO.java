package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.employee.Employee;
import com.solvd.itcompany.classes.employee.User;
import com.solvd.itcompany.classes.location.Address;
import com.solvd.itcompany.connectionPool.ConnectionPool;
import com.solvd.itcompany.dao.IEmployeeDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends AbstractMysqlJdbcDAO implements IEmployeeDAO {
    private final static Logger LOGGER = Logger.getLogger(EmployeeDAO.class);
    private final static String GET_EMPLOYEE_BY_ID = "SELECT * FROM Employees WHERE idEmployee = ?";

    @Override
    public long createItem(Employee item) {
        return 0;
    }

    @Override
    public Employee getItemById(long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(GET_EMPLOYEE_BY_ID)) {
            ps.setLong(1, id);

            try(ResultSet rs = ps.executeQuery()){
                rs.next();
                return  buildEmployee(rs);

            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return null;
    }

    @Override
    public void updateItem(Employee item) {

    }

    @Override
    public void deleteItem(long id) {

    }

    private Employee buildEmployee (ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getLong("idEmployee"));
        employee.setName(rs.getString("Emp_name"));
        employee.setLastName(rs.getString("LastName"));
        employee.setBirthDate(rs.getDate("BirthDate"));
        employee.setHireDate(rs.getDate("HireDate"));
        employee.setPhoneNumber(rs.getString("Phone"));
        employee.setEmail(rs.getString("Email"));
        User user = new User();
        user.setId(rs.getLong("User"));
        Address address = new Address();
        address.setId(rs.getLong("Addres"));
        Employee reportsTo = new Employee();
        reportsTo.setId(rs.getLong("ReportsTo"));

        return employee;
    }
}
