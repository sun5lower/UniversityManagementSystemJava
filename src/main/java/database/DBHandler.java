package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {
    String connectionUrl = "jdbc:mysql://localhost:3306/shop?serverTimeZone=UTC ";
    String user = "";
    String password = "";

    private Connection connection;

    public DBHandler(){
        try {
            connection  = DriverManager.getConnection(connectionUrl,user,password);
        } catch (SQLException e) {
            System.out.println("Shop is unable to connect to data storage system");
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }

}