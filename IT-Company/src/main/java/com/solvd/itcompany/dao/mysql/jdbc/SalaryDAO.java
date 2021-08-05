package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.employee.Salary;
import com.solvd.itcompany.dao.ISalaryDAO;

public class SalaryDAO extends AbstractMysqlJdbcDAO implements ISalaryDAO {
    @Override
    public long createItem(Salary item) {
        return 0;
    }

    @Override
    public Salary getItemById(long id) {
        return null;
    }

    @Override
    public void updateItem(Salary item) {

    }

    @Override
    public void deleteItem(long id) {

    }
}
