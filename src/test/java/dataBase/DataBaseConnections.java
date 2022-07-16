package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnections {
    public static void connectDataBase() throws SQLException {
        String urlInfo = System.setProperty("url", "jdbc:mysql://localhost:3306/app");
        String nameInfo = System.setProperty("password", "9mREsvXDs9Gk89E");
        String passwordInfo = System.setProperty("user", "app");

        String url = System.getProperty("url");
        String userName = System.getProperty("user");
        String password = System.getProperty("password");
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("We're connected");
        }
    }
}