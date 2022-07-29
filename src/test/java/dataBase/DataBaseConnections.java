package dataBase;

import java.sql.*;


public class DataBaseConnections {

    public static void getStatus()  {
        String url = System.getProperty("url");
        String user = System.getProperty("USER");
        String password = System.getProperty("PASSWORD");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(`status`) FROM payment_entity");
            while (resultSet.next()) {
                String status = resultSet.getString("status");
                System.out.println(status);
            }
        }
        catch (SQLException ex){
            System.out.println("SQL EXCEPTION");
        }
    }

    public static void getAmount() {
        String url = System.getProperty("url");
        String user = System.getProperty("USER");
        String password = System.getProperty("PASSWORD");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(`amount`) FROM payment_entity");
            while (resultSet.next()) {
                String status = resultSet.getString("status");
                System.out.println(status);
            }
        }
        catch (SQLException ex){
            System.out.println("SQL EXCEPTION");
        }
    }
}