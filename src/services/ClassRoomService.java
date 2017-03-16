package services;

import entities.ClassRoom;
import entities.Professor;
import entities.User;

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
            preparedStatement.setString(2, classRoom.getSubject().getId());
            preparedStatement.setString(3, classRoom.getProfessor().getId());
            preparedStatement.setString(4, classRoom.getAssistant().getId());
            preparedStatement.setInt(5, classRoom.getRoomNumber());
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
            preparedStatement.setString(1, classRoom.getSubject().getId());
            preparedStatement.setString(2, classRoom.getProfessor().getId());
            preparedStatement.setString(3, classRoom.getAssistant().getId());
            preparedStatement.setInt(4, classRoom.getRoomNumber());
            preparedStatement.setString(5, classRoom.getId());
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

    public static List<ClassRoom> getAllWithStudents(){
        try{
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(ClassRoomQueries.GET_ALL_WITH_STUDENTS);
            return writeResultSetWithStudents(resultSet);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            close();
        }
    }

    public static entities.ClassRoom getWithUsersById(String id){
        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(ClassRoomQueries.GET_ALL_WITH_STUDENTS_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.getResultSet();
            return writeResultSetWithStudents(resultSet).get(0);
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
            item.setProfessor(new Professor(resultSet.getString("proffesore_id")));
            item.setAssistant(new Professor(resultSet.getString("assistent_id")));

            items.add(item);
        }
        return items;
    }

    public static List<entities.ClassRoom> writeResultSetWithStudents(ResultSet resultSet) throws SQLException{
        List<entities.ClassRoom> items = new ArrayList<>();
        String currentId = "";
        while (resultSet.next()){
            if (!currentId.equalsIgnoreCase(resultSet.getString("cr.id"))){
                currentId = resultSet.getString("cr.id");
                entities.ClassRoom item = new entities.ClassRoom();
                item.setId(resultSet.getString("cr.id"));
                item.setRoomNumber(resultSet.getInt("cr.roomNumber"));

                Professor professor = new Professor();
                professor.setId(resultSet.getString("p.id"));
                User pUser = new User();
                pUser.setId(resultSet.getString("pu.id"));
                pUser.setName(resultSet.getString("pu.name"));
                //vazhdo me te tjerat...
                professor.setUser(pUser);
                item.setProfessor(professor);

                Professor assistent = new Professor();
                assistent.setId(resultSet.getString("a.id"));
                User aUser = new User();
                aUser.setId(resultSet.getString("au.id"));
                aUser.setName(resultSet.getString("au.name"));
                //vazhdo me te tjerat...
                assistent.setUser(aUser);
                item.setAssistant(assistent);
                item.setStudents(new ArrayList<>());
                items.add(item);
            }

            User student = new User();
            student.setId(resultSet.getString("s.id"));
            student.setName(resultSet.getString("s.name"));
            student.setSurname(resultSet.getString("s.surname"));
            //...

            items.get(items.size() - 1).getStudents().add(student);
        }
        return items;
    }
}
