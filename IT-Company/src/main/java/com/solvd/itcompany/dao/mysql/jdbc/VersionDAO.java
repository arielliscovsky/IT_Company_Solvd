package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.product.Version;
import com.solvd.itcompany.dao.IVersionDAO;

public class VersionDAO extends AbstractMysqlJdbcDAO implements IVersionDAO {
    @Override
    public long createItem(Version item) {
        return 0;
    }

    @Override
    public Version getItemById(long id) {
        return null;
    }

    @Override
    public void updateItem(Version item) {

    }

    @Override
    public void deleteItem(long id) {

    }
}
