package dataBase;

import java.sql.*;


public class DataBaseConnections {

    public static void connectDataBase() {
        String url = System.getProperty("url");
        String user = System.getProperty("user");
        String password = System.getProperty("password");
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            System.out.println("We're connected");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String getStatus() {
        String url = System.getProperty("url");
        String user = System.getProperty("user");
        String password = System.getProperty("password");

        String status = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(`status`) FROM payment_entity");
            while (resultSet.next()) {
                status = resultSet.getString("status");
                System.out.println(status);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static String getAmount() {
        String url = System.getProperty("url");
        String user = System.getProperty("user");
        String password = System.getProperty("password");

        String amount = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(`amount`) FROM payment_entity");
            while (resultSet.next()) {
                amount = resultSet.getString("amount");
                System.out.println(amount);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return amount;
    }
}