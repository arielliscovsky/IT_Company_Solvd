package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.location.City;
import com.solvd.itcompany.classes.location.Country;
import com.solvd.itcompany.connectionPool.ConnectionPool;
import com.solvd.itcompany.dao.ICityDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDAO extends AbstractMysqlJdbcDAO implements ICityDAO {
    private final static Logger LOGGER = Logger.getLogger(CityDAO.class);
    private final static String GET_CITY_BY_ID = "SELECT * FROM Cities WHERE idCity = ?";
    private final static String UPDATE_CITY_BY_ID = "UPDATE Cities SET City_name=?, ZipCode=?, Country=? WHERE idCity=?";
    private final static String INSERT_CITY = "INSERT INTO Cities (idCity, City_name, ZipCode, Country) VALUES (NULL,?,?,?)";
    private final static String DELETE_CITY_BY_ID = "DELETE FROM Cities WHERE idCity=?";

    @Override
    public long createItem(City city) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps = connection.prepareStatement(INSERT_CITY)) {
            ps.setString(1,city.getName());
            ps.setDouble(2,city.getZipCode());
            ps.setLong(3,city.getCountry().getId());

            ps.executeUpdate();

            LOGGER.debug("City was created in DB with following details: " + city.toString());
        }
        catch (SQLException e) {
            LOGGER.debug(e);
        }
        return city.getId();
    }

    @Override
    public City getItemById(long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(GET_CITY_BY_ID)) {
            ps.setLong(1, id);

            try(ResultSet rs = ps.executeQuery()){
                rs.next();
                return buildCity(rs);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return null;
    }

    @Override
    public void updateItem(City city) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(UPDATE_CITY_BY_ID)) {
            ps.setString(1,city.getName());
            ps.setDouble(2,city.getZipCode());
            ps.setLong(3,city.getCountry().getId());
            ps.setLong(4,city.getId());
            ps.executeUpdate();

            LOGGER.debug("City with id " + city.getId() + " was updated in DB with following details: " + city.toString());
        }
        catch (SQLException e) {
            LOGGER.debug(e);
        }

    }

    @Override
    public void deleteItem(long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps = connection.prepareStatement(DELETE_CITY_BY_ID)){
            ps.setLong(1,id);
            if(ps.executeUpdate() == 1){
            LOGGER.debug("City with id: " + id + " was sucesfully deleted from DB");}
        }
        catch (SQLException e) {
            LOGGER.debug(e);
        }

    }

    private City buildCity (ResultSet rs) throws SQLException {

        City city = new City();

        city.setId(rs.getLong("idCity"));
        city.setName(rs.getString("City_name"));
        city.setZipCode(rs.getDouble("ZipCode"));
        Country country = new Country();
        country.setId(rs.getLong("Country"));
        city.setCountry(country);
        return city;
    }
}
