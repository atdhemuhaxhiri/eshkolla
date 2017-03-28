package services;

import entities.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 3/3/2017.
 */
public class UserTypeService extends AbstractService{
    public static int insert(UserType usertype){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(UserTypeQueries.INSERT);

            preparedStatement.setString(1,usertype.getId());
            preparedStatement.setString(2,usertype.getName());
            preparedStatement.setString(3,usertype.getDescription());
            return preparedStatement.executeUpdate();

        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static int update(UserType usertype){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(UserTypeQueries.UPDATE);

            preparedStatement.setString(1,usertype.getId());
            preparedStatement.setString(2,usertype.getName());
            preparedStatement.setString(3,usertype.getDescription());
            return preparedStatement.executeUpdate();

        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static int delete(String id){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(UserTypeQueries.DELETE);

            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate();

        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static List<UserType> getAll(){

        try{
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(UserTypeQueries.GET_ALL);
            return writeResultSet(resultSet);

        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return null;
        }finally {
            close();
        }
    }

    public static entities.UserType getById(String id){

        try{
            connection = utilities.Connections.getConnection();
            preparedStatement = connection.prepareStatement(UserTypeQueries.GET_BY_ID);
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.getResultSet();
            return writeResultSet(resultSet).get(0);

        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return null;
        }finally {
            close();
        }
    }
    public static List<entities.UserType> writeResultSet(ResultSet resultset) throws SQLException{
        List<entities.UserType> items = new ArrayList<>();
        while (resultset.next()){
            entities.UserType item = new entities.UserType();

            item.setId(resultset.getString("id"));
            item.setName(resultset.getString("name"));
            item.setDescription(resultset.getString("description"));
            items.add(item);
        }
        return items;
    }

}


