package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnections {
    public static void mysql() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/app";
        String userName = "app";
        String password = "9mREsvXDs9Gk89Ef";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("We're connected");

        }

    }

    public static void postgresql() throws ClassNotFoundException, SQLException {
        String url = "";
        String username = null;
        String password = null;
        Class.forName("com.postgresql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("We're connected");
        }
    }
}
