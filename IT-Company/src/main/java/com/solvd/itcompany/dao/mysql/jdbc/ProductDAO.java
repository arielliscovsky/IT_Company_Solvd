package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.location.Country;
import com.solvd.itcompany.classes.product.Product;
import com.solvd.itcompany.connectionPool.ConnectionPool;
import com.solvd.itcompany.dao.IProductDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends AbstractMysqlJdbcDAO implements IProductDAO {
    private final static Logger LOGGER = Logger.getLogger(ProductDAO.class);
    private final static String GET_PRODUCT_BY_ID = "SELECT * FROM Products WHERE idProduct = ?";

    @Override
    public long createItem(Product item) {
        return 0;
    }

    @Override
    public Product getItemById(long id) {
        Connection connection = ConnectionPool.getInstance().getConnection();

        try(PreparedStatement ps = connection.prepareStatement(GET_PRODUCT_BY_ID)) {
            ps.setLong(1,id);

            try(ResultSet rs = ps.executeQuery()){
                rs.next();
                Product product = new Product();

                product.setId(rs.getLong("idProduct"));
                product.setName(rs.getString("Prod_name"));

                return product;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }

        return null;
    }

    @Override
    public void updateItem(Product item) {

    }

    @Override
    public void deleteItem(long id) {

    }
}
