package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnections {

    public static void connectDataBase() {
        String url = System.getProperty("url");
        String user = System.getProperty("user");
        String password = System.getProperty("password");
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("We're connected");
        } catch (SQLException ex) {
            System.out.println("sql Ex");
        }
    }
}