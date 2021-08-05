package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.product.Area;
import com.solvd.itcompany.dao.IAreaDAO;

public class AreaDAO extends AbstractMysqlJdbcDAO implements IAreaDAO {
    @Override
    public long createItem(Area item) {
        return 0;
    }

    @Override
    public Area getItemById(long id) {
        return null;
    }

    @Override
    public void updateItem(Area item) {

    }

    @Override
    public void deleteItem(long id) {

    }
}
