package services;

import entities.Professor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 3/9/2017.
 */
public class ProfessorService extends AbstractService {
    public static int insert(Professor professor){

        try {
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(ProfessorQueries.INSERT);
            preparedStatement.setString(1, professor.getId());
            preparedStatement.setString(2, professor.getUser().getId());
            preparedStatement.setString(3, professor.getSubject().getId());
            preparedStatement.setInt(4, professor.getYear());
            preparedStatement.setBoolean(5, professor.isActive());
            preparedStatement.setString(6, professor.getProfessorType().getId());
            return preparedStatement.executeUpdate();


        }catch (SQLException | ClassNotFoundException w){
            w.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static int update(Professor professor){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(ProfessorQueries.UPDATE);

            preparedStatement.setString(1, professor.getUser().getId());
            preparedStatement.setString(2, professor.getSubject().getId());
            preparedStatement.setInt(3, professor.getYear());
            preparedStatement.setBoolean(4, professor.isActive());
            preparedStatement.setString(5, professor.getProfessorType().getId());
            preparedStatement.setString(6, professor.getId());
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static int delete(String id){

        try {
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(ProfessorQueries.UPDATE);

            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException w){
            w.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static List<Professor> getAll(){
        try{
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ProfessorQueries.GET_ALL);
            return writeResultSet(resultSet);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }finally {
            close();
        }
    }
    public static entities.Professor getById(String id){
        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(ProfessorQueries.GET_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.getResultSet();
            return writeResultSet(resultSet).get(0);

        }catch (SQLException | ClassNotFoundException qkemi){
            qkemi.printStackTrace();
            return null;
        }finally {
            close();
        }

    }
    public static List<entities.Professor> writeResultSet(ResultSet resultSet) throws SQLException{
        List<entities.Professor> items = new ArrayList<>();

        while (resultSet.next()){
            entities.Professor item = new entities.Professor();
            item.setId(resultSet.getString("id"));
            item.setYear(resultSet.getInt("year"));
            item.setActive(resultSet.getBoolean("active"));
            //item.setUser();
            items.add(item);
        }
        return items;
    }
}
