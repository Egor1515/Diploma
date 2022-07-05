package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnections {
    public static void connectDataBase(String host, String user, String pass, String driver) throws ClassNotFoundException, SQLException {
        String url = System.getProperty(host);
        String userName = System.getProperty(user);
        String password = System.getProperty(pass);
        Class.forName(System.getProperty(driver));
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("We're connected");
        }
    }
}