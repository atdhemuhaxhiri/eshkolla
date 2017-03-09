package services;

import entities.ClassRoom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 3/9/2017.
 */
public class ClassRoomService extends AbstractService{
    public static int insert(ClassRoom classRoom){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(ClassRoomQueries.INSERT);
            preparedStatement.setString(1, classRoom.getId());
            preparedStatement.setString(2, classRoom.getStudent().getId());
            preparedStatement.setString(3, classRoom.getSubject().getId());
            preparedStatement.setString(4, classRoom.getProfessor().getId());
            preparedStatement.setString(5, classRoom.getAssistant().getId());
            preparedStatement.setInt(6, classRoom.getRoomNumber());
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static int update(ClassRoom classRoom){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(ClassRoomQueries.UPDATE);
            preparedStatement.setString(1, classRoom.getStudent().getId());
            preparedStatement.setString(2, classRoom.getSubject().getId());
            preparedStatement.setString(3, classRoom.getProfessor().getId());
            preparedStatement.setString(4, classRoom.getAssistant().getId());
            preparedStatement.setInt(5, classRoom.getRoomNumber());
            preparedStatement.setString(6, classRoom.getId());
            return preparedStatement.executeUpdate();

        }catch (SQLException | ClassNotFoundException haha){
            haha.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static int delete(String id){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(InstitutionQueries.DELETE);
            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static List<ClassRoom> getAll(){
        try{
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ClassRoomQueries.GET_ALL);
            return writeResultSet(resultSet);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            close();
        }
    }
    public static entities.ClassRoom getById(String id){
        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(ClassRoomQueries.GET_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.getResultSet();
            return writeResultSet(resultSet).get(0);
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            close();
        }
    }
    public static List<entities.ClassRoom> writeResultSet(ResultSet resultSet) throws SQLException{
        List<entities.ClassRoom> items = new ArrayList<>();
        while (resultSet.next()){
            entities.ClassRoom item = new entities.ClassRoom();
            item.setId(resultSet.getString("id"));
            item.setRoomNumber(resultSet.getInt("roomNumber"));

            items.add(item);
        }
        return items;
    }
}
