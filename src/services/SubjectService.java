package services;

import entities.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 3/8/2017.
 */
public class SubjectService extends AbstractService {

    public static int insert(Subject subject) {

        try {
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(SubjectQueries.INSERT);
            preparedStatement.setString(1, subject.getId());
            preparedStatement.setString(2, subject.getName());
            preparedStatement.setString(3, subject.getInstitution().getId());
            preparedStatement.setString(4, subject.getSyllabus().getId());
            return preparedStatement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 1;
        } finally {
            close();
        }
    }

    public static int update(entities.Subject subject) {

        try {
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(SubjectQueries.UPDATE);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setString(2, subject.getInstitution().getId());
            preparedStatement.setString(3, subject.getSyllabus().getId());
            preparedStatement.setString(4, subject.getId());
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
            preparedStatement = connection.prepareStatement(SubjectQueries.DELETE);
            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } finally {
            close();
        }
    }
    public static List<Subject> getAll(){
        try {
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SubjectQueries.GET_ALL);
            return writeResultSet(resultSet);

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            close();
        }
    }

    public static entities.Subject getById(String id) {

        try {
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(SubjectQueries.GET_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.getResultSet();
            return writeResultSet(resultSet).get(0);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<entities.Subject> writeResultSet(ResultSet resultSet) throws SQLException {
        List<entities.Subject> items = new ArrayList<>();

        while (resultSet.next()) {
            entities.Subject item = new entities.Subject();

            item.setId(resultSet.getString("id"));
            item.setName(resultSet.getString("name"));
            item.setInstitution(InstitutionService.getById(resultSet.getString("institution_id")));
            item.setSyllabus(SyllabusService.getById(resultSet.getString("syllabus_id")));

            items.add(item);

        }
        return items;
    }
}



