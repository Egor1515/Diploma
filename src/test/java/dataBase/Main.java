package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

<<<<<<< HEAD:src/test/java/dataBase/Main.java
public class Main {
    public static void main(String[] args)  throws ClassNotFoundException, SQLException {
=======
public class DbConnections {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
>>>>>>> 323b71b01234edee38f38ab7714d210ac582cfad:src/test/java/dataBase/DbConnections.java
        String url = "jdbc:mysql://localhost:3306/app";
        String userName = "app";
        String password = "9mREsvXDs9Gk89Ef";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("We're connected");
        }
    }

    public static void postgresql() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String userName = "root";
        String password = "root";
        Class.forName("com.postgresql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("We're connected");
        }
    }
}