package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.customer.Costumer;
import com.solvd.itcompany.dao.ICostumerDAO;

public class CostumerDAO extends AbstractMysqlJdbcDAO implements ICostumerDAO {
    @Override
    public long createItem(Costumer item) {
        return 0;
    }

    @Override
    public Costumer getItemById(long id) {
        return null;
    }

    @Override
    public void updateItem(Costumer item) {

    }

    @Override
    public void deleteItem(long id) {

    }
}
