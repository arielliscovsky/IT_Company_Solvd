package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.location.Country;
import com.solvd.itcompany.connectionPool.ConnectionPool;
import com.solvd.itcompany.dao.ICountryDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDAO extends AbstractMysqlJdbcDAO implements ICountryDAO {
    private final static Logger LOGGER = Logger.getLogger(CountryDAO.class);
    private final static String GET_COUNTRY_BY_ID = "SELECT * FROM Countries WHERE idCountry=?";
    private final static String UPDATE_COUNTRY_BY_ID = "UPDATE Countries SET idCountry=?, Country_name=?, AreaCode=? WHERE idCountry=?";
    private final static String INSERT_COUNTRY = "INSERT INTO Countries (idCountry, Country_name, AreaCode) VALUES (NULL,?,?)";
    private final static String DELETE_COUNTRY_BY_ID = "DELETE FROM Countries WHERE idCountry=?";

    @Override
    public long createItem(Country country) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps = connection.prepareStatement(INSERT_COUNTRY)) {
            ps.setString(1,country.getName());
            ps.setInt(2,country.getAreaCode());

            LOGGER.debug(ps.executeUpdate());

            LOGGER.debug("Country with id " + country.getId() + " was created in DB with following details: " + country.toString());
        }
        catch (SQLException e) {
            LOGGER.debug(e);
        }
        return country.getId();
    }

    @Override
    public Country getItemById(long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(GET_COUNTRY_BY_ID)) {
            ps.setLong(1, id);

            try(ResultSet rs = ps.executeQuery()){
                rs.next();
                Country country = new Country();

                country.setId(rs.getLong("idCountry"));
                country.setName(rs.getString("Country_name"));
                country.setAreaCode(rs.getInt("AreaCode"));

                return country;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void updateItem(Country country) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(UPDATE_COUNTRY_BY_ID)) {
            ps.setLong(1,country.getId());
            ps.setString(2,country.getName());
            ps.setInt(3,country.getAreaCode());
            ps.setLong(4,country.getId());
            ps.executeUpdate();

            LOGGER.debug("Country with id " + country.getId() + " was updated in DB with following details: " + country.toString());
        }
        catch (SQLException e) {
            LOGGER.debug(e);
        }
    }

    @Override
    public void deleteItem(long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps = connection.prepareStatement(DELETE_COUNTRY_BY_ID)){
            ps.setLong(1,id);
            if(ps.executeUpdate() == 1)
            {
                LOGGER.debug("Country with id: " + id + " was sucesfully deleted from DB");}
        }
        catch (SQLException e) {
            LOGGER.debug(e);
        }

    }
}
