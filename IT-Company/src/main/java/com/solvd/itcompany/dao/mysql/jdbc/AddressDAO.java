package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.location.Address;
import com.solvd.itcompany.classes.location.City;
import com.solvd.itcompany.connectionPool.ConnectionPool;
import com.solvd.itcompany.dao.IAddressDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO extends AbstractMysqlJdbcDAO implements IAddressDAO {
    private final static Logger LOGGER = Logger.getLogger(AddressDAO.class);
    private final static String GET_ADDRESS_BY_ID = "SELECT * FROM Addresses WHERE idAddress = ?";

    @Override
    public long createItem(Address item) {
        return 0;
    }

    @Override
    public Address getItemById(long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(GET_ADDRESS_BY_ID)) {
            ps.setLong(1, id);

            try(ResultSet rs = ps.executeQuery()){
                rs.next();
                return  buildAddress(rs);

            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return null;
    }

    @Override
    public void updateItem(Address item) {

    }



    @Override
    public void deleteItem(long id) {

    }

    private Address buildAddress (ResultSet rs) throws SQLException {
        Address address = new Address();

        address.setId(rs.getLong("idAddress"));
        address.setStreet(rs.getString("street"));
        address.setNumber(rs.getLong("number"));
        City city = new City();
        city.setId(rs.getLong("City"));
        address.setCity(city);
        return address;
    }
}
