package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hotelkey on 2/23/17.
 */
public class Connections {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/eschool", "root", "koke");
    }
}
