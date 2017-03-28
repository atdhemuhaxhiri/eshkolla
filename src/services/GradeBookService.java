package services;

import entities.GradeBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 3/9/2017.
 */
public class GradeBookService extends AbstractService {
    public static int insert(GradeBook gradeBook){
        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(GradeBookQueries.INSERT);
            preparedStatement.setString(1, gradeBook.getId());
            preparedStatement.setString(2, gradeBook.getStudent().getId());
            preparedStatement.setString(3, gradeBook.getProfessor().getId());
            preparedStatement.setString(4, gradeBook.getSubject().getId());
            preparedStatement.setInt(5, gradeBook.getGrade());
            return preparedStatement.executeUpdate();

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static int update(GradeBook gradeBook){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(GradeBookQueries.UPDATE);
            preparedStatement.setString(1, gradeBook.getStudent().getId());
            preparedStatement.setString(2, gradeBook.getProfessor().getId());
            preparedStatement.setString(3, gradeBook.getSubject().getId());
            preparedStatement.setInt(4, gradeBook.getGrade());
            preparedStatement.setString(5, gradeBook.getId());
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static int delete(String id){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(GradeBookQueries.DELETE);
            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }finally {
            close();
        }

    }
    public static List<GradeBook> getAll(){

        try{
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GradeBookQueries.GET_ALL);
            return writeResultSet(resultSet);
        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return null;
        }finally {
            close();
        }
    }
    public static entities.GradeBook getById(String id){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(GradeBookQueries.GET_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.getResultSet();
            return writeResultSet(resultSet).get(0);

        }catch (SQLException | ClassNotFoundException jungle){
            jungle.printStackTrace();
            return null;
        }finally {
            close();
        }
    }
    public static List<entities.GradeBook> writeResultSet (ResultSet resultSet) throws SQLException{
        List<entities.GradeBook> items = new ArrayList<>();

        while (resultSet.next()){
            entities.GradeBook item = new entities.GradeBook();

            item.setId(resultSet.getString("id"));
            item.setGrade(resultSet.getInt("grade"));
            item.setStudent(UserService.getById(resultSet.getString("student")));
            item.setProfessor(ProfessorService.getById(resultSet.getString("professor")));
            item.setSubject(SubjectService.getById(resultSet.getString("subject")));



            items.add(item);
        }
        return items;
    }
}
