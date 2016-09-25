package com.milestone1.DbService;

/**
 * Created by soumya on 9/19/16.
 */
import java.sql.*;

public class DataService {
    private Connection con = null;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/logs";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "science";


    public Connection getConnection() throws ClassNotFoundException,
            SQLException {
        Class.forName(JDBC_DRIVER);
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        return con;
    }

    public void closeConnection() throws SQLException {
        if (isConnectionOpen()) {
            con.close();
            con = null;
        }
    }
    public boolean isConnectionOpen() {
        return (con != null);
    }

    public void executeQuery(String query) throws SQLException, ClassNotFoundException {
        System.out.println("Executing query " + query);
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        stmt.execute(query);
        closeConnection();
    }
    public ResultSet executeQueryAndGet(String query) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = stmt.executeQuery(query);
        return resultSet;
    }


}