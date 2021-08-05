package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.employee.User;
import com.solvd.itcompany.connectionPool.ConnectionPool;
import com.solvd.itcompany.dao.IUserDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractMysqlJdbcDAO implements IUserDAO {
    private final static Logger LOGGER = Logger.getLogger(UserDAO.class);
    private final static String GET_USER_BY_ID = "SELECT * FROM Users WHERE idUser = ?";

    @Override
    public long createItem(User item) {
        return 0;
    }

    @Override
    public User getItemById(long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(GET_USER_BY_ID)) {
            ps.setLong(1, id);

            try(ResultSet rs = ps.executeQuery()){
                rs.next();
                User user = new User();

                user.setId(rs.getLong("idUser"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));

                return user;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public void updateItem(User item) {

    }

    @Override
    public void deleteItem(long id) {

    }
}
