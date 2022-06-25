package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnections {
    public static void mysql() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/app";
        String userName = "app";
        String password = "9mREsvXDs9Gk89Ef";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("We're connected mysql");
        }
    }

    public static void postgresql() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "root";
        String password = "root";
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("We're connected postgresql");
        }
    }
}