package com.solvd.itcompany.runner;

import com.solvd.itcompany.connectionPool.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainThreadTest {
    private static final Logger LOGGER = Logger.getLogger(MainThreadTest.class);

    public static void main(String[] ags){

        ExecutorService es = Executors.newFixedThreadPool(6);

        Future<ResultSet> passengerName = es.submit(
                () -> result("SELECT Emp_name FROM Employees WHERE idEmployee = 2"));
        Future<ResultSet> passengerLastName = es.submit(
                () -> result("SELECT Emp_name FROM Employees WHERE idEmployee = 3"));
        Future<ResultSet> passengerAge = es.submit(
                () -> result("SELECT Emp_name FROM Employees WHERE idEmployee = 4"));
        Future<ResultSet> passengerGender = es.submit(
                () -> result("SELECT Emp_name FROM Employees WHERE idEmployee = 6"));
        Future<ResultSet> passengerTrain = es.submit(
                () -> result("SELECT Emp_name FROM Employees WHERE idEmployee = 7"));
        Future<ResultSet> passengerName1 = es.submit(
                () -> result("SELECT Country_name FROM Countries WHERE idCountry = 1"));

        es.shutdown();

        try {
            LOGGER.debug("FirstNameEmp2: " + passengerName.get().getString("Emp_name")
                    + "\n FirstNameEmp3: " + passengerLastName.get().getString("Emp_name")
                    + "\n FirstNameEmp4: " + passengerAge.get().getString("Emp_name")
                    + "\n FirstNameEmp6: " + passengerGender.get().getString("Emp_name")
                    + "\n FirstNameEmp7: " + passengerTrain.get().getString("Emp_name")
                    + "\n Country " + passengerName1.get().getString("Country_name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static ResultSet result (String query) {
        String thread = Thread.currentThread().getName();
        ResultSet r = null;

        try {
            Connection c = ConnectionPool.getInstance().getConnection();
            Statement s = c.createStatement();
            r = s.executeQuery(query);
            r.next();

        } catch (SQLException e){
            LOGGER.error(e);
        }

        return r;
    }
}
