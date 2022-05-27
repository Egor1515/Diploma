import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.codeborne.selenide.Selenide.open;

public class DiplomaAutoTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        try {
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/?user=root&password=9mREsvXDs9Gk89Ef");
            Statement s = (Statement) conn.createStatement();
            int result = s.executeUpdate("CREATE DATABASE mysql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    void shouldOpen() {

        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }
}
