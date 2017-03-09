package services;

import entities.Institution;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hotelkey on 2/24/17.
 */
public class InstitutionService extends AbstractService{
    public static int insert(Institution institution) {

        try {
            connection = utilities.Connections.getConnection();

            preparedStatement = connection.prepareStatement(InstitutionQueries.INSERT);
            //preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(1, institution.getId());
            preparedStatement.setString(2, institution.getName());
            preparedStatement.setString(3, institution.getAddress());
            preparedStatement.setString(4, institution.getEmail());
            preparedStatement.setString(5, institution.getMob());
            preparedStatement.setString(6, institution.getWebsite());
            preparedStatement.setString(7, institution.getInstitutionType().getId());
            return preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } finally {
            close();
        }
    }

    public static int update(entities.Institution institution) {

        try {
            connection = utilities.Connections.getConnection();

            preparedStatement = connection.prepareStatement(InstitutionQueries.UPDATE);

            preparedStatement.setString(1, institution.getName());
            preparedStatement.setString(2, institution.getAddress());
            preparedStatement.setString(3, institution.getEmail());
            preparedStatement.setString(4, institution.getMob());
            preparedStatement.setString(5, institution.getWebsite());
            preparedStatement.setString(6, institution.getInstitutionType().getId());
            preparedStatement.setString(7, institution.getId());
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
            preparedStatement = connection.prepareStatement(InstitutionQueries.DELETE);

            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } finally {
            close();
        }
    }

    public static List<Institution> getAll() {

        try {
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(InstitutionQueries.GET_ALL);
            return writeResultSet(resultSet);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            close();
        }
    }

    public static entities.Institution getById(String id) {

        try {
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(InstitutionQueries.GET_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.getResultSet();
            return writeResultSet(resultSet).get(0);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            close();
        }
    }


    private static List<entities.Institution> writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set

        List<entities.Institution> items =
                new ArrayList<>();

        while (resultSet.next()) {
            entities.Institution item = new entities.Institution();

            item.setId(resultSet.getString("id"));
            item.setName(resultSet.getString("name"));
            item.setAddress(resultSet.getString("address"));
            item.setEmail(resultSet.getString("email"));
            item.setMob(resultSet.getString("mob"));
            item.setWebsite(resultSet.getString("website"));
//            item.setInstitutionType(resultSet.getString("hourdescription"));

            items.add(item);
        }
        return items;
    }
}