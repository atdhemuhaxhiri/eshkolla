package services;
import entities.Syllabus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 3/4/2017.
 */
public class SyllabusService extends AbstractService {
    public static int insert(Syllabus syllabus){
        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(SyllabusQueries.INSERT);
            preparedStatement.setString(1,syllabus.getId());
            preparedStatement.setString(2,syllabus.getLiterature());
            preparedStatement.setString(3,syllabus.getInstitution().getId());
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static int update(entities.Syllabus syllabus){
        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(SyllabusQueries.UPDATE);

            preparedStatement.setString(1,syllabus.getLiterature());
            preparedStatement.setString(2,syllabus.getInstitution().getId());
            preparedStatement.setString(3,syllabus.getId());
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException a){
            return -1;
        }finally {
            close();
        }
    }
    public static int delete(String id){

        try {
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(SyllabusQueries.DELETE);
            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static List<Syllabus> getAll(){
        try{
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SyllabusQueries.GET_ALL);
            return writeResultSet(resultSet);
        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return null;
        }finally {
            close();
        }
    }
    public static entities.Syllabus getById(String id){
        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(SyllabusQueries.GET_BY_ID);
            preparedStatement.setString(1, id);
            return writeResultSet(resultSet).get(0);
        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return null;
        }finally {
            close();
        }
    }
    private static List<entities.Syllabus> writeResultSet(ResultSet resultSet) throws SQLException{
        List<entities.Syllabus> items = new ArrayList<>();
        while (resultSet.next()){
            entities.Syllabus item = new entities.Syllabus();
            item.setId(resultSet.getString("id"));
            item.setLiterature(resultSet.getString("literature"));
            item.setInstitution(InstitutionService.getById(resultSet.getString("institution_id")));
//            item.setInstitution(resultSet.getString("Institution"));
            items.add (item);
        }
        return items;
    }

}
