package services;

import entities.Institution;
import entities.InstitutionType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hotelkey on 2/24/17.
 */
public class InstitutionTypeService extends AbstractService{


    public static int insert(entities.InstitutionType institutionType) {

        try {
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(InstitutionTypeQueries.INSERT);
            //preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(1, institutionType.getId());
            preparedStatement.setString(2, institutionType.getName());
            preparedStatement.setString(3, institutionType.getDepartment());
            return preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } finally {
            close();
        }
    }

    public static int update(entities.InstitutionType institutionType) {

        try {
            connection = utilities.Connections.getConnection();

            preparedStatement = connection.prepareStatement(InstitutionTypeQueries.UPDATE);

            preparedStatement.setString(1, institutionType.getName());
            preparedStatement.setString(2, institutionType.getDepartment());
            preparedStatement.setString(3, institutionType.getId());
            return preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } finally {
            close();
        }
    }

    public static int delete(String id) {

        try {
            connection = utilities.Connections.getConnection();

            preparedStatement = connection.prepareStatement(InstitutionTypeQueries.DELETE);

            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } finally {
            close();
        }
    }

    public static List<InstitutionType> getAll() {

        try {
            connection = utilities.Connections.getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery(InstitutionTypeQueries.GET_ALL);
            return writeResultSet(resultSet);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            close();
        }
    }

    public static entities.InstitutionType getById(String id) {

        try {
            connection = utilities.Connections.getConnection();

            preparedStatement = connection.prepareStatement(InstitutionTypeQueries.GET_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            List<entities.InstitutionType> list = writeResultSet(resultSet);
            return null != list && !list.isEmpty() ? list.get(0) : null;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            close();
        }
    }

    public static entities.InstitutionType getById(String id
            , Connection con
    , PreparedStatement ps, ResultSet rs) {

        try {
//            connection = utilities.Connections.getConnection();

            ps = con.prepareStatement(InstitutionTypeQueries.GET_BY_ID);
            ps.setString(1, id);
            rs = ps.executeQuery();
            List<entities.InstitutionType> list = writeResultSet(rs);
            return null != list && !list.isEmpty() ? list.get(0) : null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static List<entities.InstitutionType> writeResultSet(
            ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set

        List<entities.InstitutionType> items =
                new ArrayList<>();

        while (resultSet.next()) {
            entities.InstitutionType item = new entities.InstitutionType();

            item.setId(resultSet.getString("id"));
            item.setName(resultSet.getString("name"));
            item.setDepartment(resultSet.getString("department"));

            items.add(item);
        }
        return items;
    }
}
