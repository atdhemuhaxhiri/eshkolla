package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by hotelkey on 2/24/17.
 */
public class AbstractService {
    public static PreparedStatement preparedStatement;
    public static Connection connection;
    public static ResultSet resultSet = null;
    public static Statement statement = null;

    public static void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }
}
