package com.solvd.itcompany.connectionPool;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private final static Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private final String DB="IT_Company_ArielL";
    private final String URL="jdbc:mysql://52.59.193.212:3306/"+DB;
    private final String USER="root";
    private final String PASS="devintern";
    private static ConnectionPool dataSource;
    private BasicDataSource basicDataSource = null;

    //Singleton Pattern in order to limit objects creation (just one instance)
    private ConnectionPool(){
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);

        basicDataSource.setMaxTotal(5);
    }

    //Checks that there is only one instance of this class
    public static ConnectionPool getInstance() {
        if (dataSource == null){
            dataSource = new ConnectionPool();
            return dataSource;
        }
        else {
            return dataSource;
        }
    }

    public Connection getConnection(){
        Connection connect = null;
        try{
            connect=this.basicDataSource.getConnection();
        }catch (SQLException ex) { LOGGER.debug(ex.getMessage());

        }
        return connect;
    }



    public void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }
}
