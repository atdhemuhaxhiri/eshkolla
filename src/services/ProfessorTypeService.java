package services;

import entities.ProfessorType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Admin on 3/9/2017.
 */
public class ProfessorTypeService extends AbstractService {
    public static int insert(ProfessorType professorType) {

        try {
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(ProfessorTypeQueries.INSERT);
            preparedStatement.setString(1, professorType.getId());
            preparedStatement.setString(2, professorType.getType());
            preparedStatement.setString(3, professorType.getDescription());
            return preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } finally {
            close();
        }
    }

    public static int update(ProfessorType professorType) {

        try {
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(ProfessorTypeQueries.UPDATE);
            preparedStatement.setString(1, professorType.getType());
            preparedStatement.setString(2, professorType.getDescription());
            preparedStatement.setString(3, professorType.getId());
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
            preparedStatement = connection.prepareStatement(ProfessorTypeQueries.DELETE);
            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;

        } finally {
            close();
        }
    }

    public static List<ProfessorType> getAll() {

        try {
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ProfessorTypeQueries.GET_ALL);
            return writeResultSet(resultSet);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            close();
        }
    }

    public static entities.ProfessorType getById(String id) {

        try {
            connection = utilities.Connections.getConnection();

            preparedStatement = connection.prepareStatement(ProfessorTypeQueries.GET_BY_ID);
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

    private static List<entities.ProfessorType> writeResultSet(ResultSet resultSet) throws SQLException {
        List<entities.ProfessorType> items = new ArrayList<>();

        while (resultSet.next()) {
            entities.ProfessorType item = new entities.ProfessorType();
            item.setId(resultSet.getString("id"));
            item.setType(resultSet.getString("type"));
            item.setDescription(resultSet.getString("description"));

            items.add(item);


        }
        return items;
    }
}