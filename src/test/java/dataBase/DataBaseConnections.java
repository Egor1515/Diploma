package dataBase;

import java.sql.*;


public class DataBaseConnections {



    public static String getStatus() {
        String url = System.getProperty("url");
        String user = System.getProperty("USER");
        String password = System.getProperty("PASSWORD");

        String status = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select status from credit_request_entity");
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
        String user = System.getProperty("USER");
        String password = System.getProperty("PASSWORD");

        String amount = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select amount from payment_entity");
            while (resultSet.next()) {
                amount = resultSet.getString("amount");
                System.out.println(amount);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return amount;
    }
    public static void shouldClearTables()  {

        String url = System.getProperty("url");
        String user = System.getProperty("user");
        String password = System.getProperty("password");
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();

            statement.executeUpdate("delete from credit_request_entity");
            statement.executeUpdate("delete from order_entity");
            statement.executeUpdate("delete from payment_entity");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}