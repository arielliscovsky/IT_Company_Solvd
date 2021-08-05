package com.solvd.itcompany.dao.mysql.jdbc;

import com.solvd.itcompany.classes.employee.Role;
import com.solvd.itcompany.dao.IRoleDAO;

public class RoleDAO extends AbstractMysqlJdbcDAO implements IRoleDAO {
    @Override
    public long createItem(Role item) {
        return 0;
    }

    @Override
    public Role getItemById(long id) {
        return null;
    }

    @Override
    public void updateItem(Role item) {

    }

    @Override
    public void deleteItem(long id) {

    }
}
