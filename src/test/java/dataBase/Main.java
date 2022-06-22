package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/app";
        String userName = "app";
        String password = "9mREsvXDs9Gk89Ef";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("We're connected");
        }

    }

//    public static void postgresql() throws ClassNotFoundException, SQLException {
//        String url = "";
//        String userName = null;
//        String password = null;
//        Class.forName("com.postgresql.jdbc.Driver");
//        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
//            System.out.println("We're connected");
//        }
//    }
}
