package services;
import entities.Gender;
import entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService extends AbstractService {
    public static int insert(User user){

        try{
            connection = utilities.Connections.getConnection();

            preparedStatement = connection.prepareStatement(UserQueries.INSERT);
            preparedStatement.setString(1,user.getId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getSurname());
            preparedStatement.setString(4,user.getUsername());
            preparedStatement.setString(5,user.getPassword());
            preparedStatement.setDate(6, new java.sql.Date(user.getBirthday().getTime()));
            preparedStatement.setString(7, user.getGender().name());
            preparedStatement.setString(8,user.getAddress());
            preparedStatement.setString(9,user.getEmail());
            preparedStatement.setString(10,user.getUserType().getId());
            preparedStatement.setString(11,user.getMob());
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return -1;
        }finally {
            close();
        }
    }
    public static int update(entities.User user){
        try{
            connection = utilities.Connections.getConnection();

            preparedStatement = connection.prepareStatement(UserQueries.UPDATE);


            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setDate(5, new java.sql.Date(user.getBirthday().getTime()));
            preparedStatement.setString(6,user.getGender().name());
            preparedStatement.setString(7,user.getAddress());
            preparedStatement.setString(8,user.getEmail());
            preparedStatement.setString(9,user.getUserType().getId());
            preparedStatement.setString(10,user.getMob());
            preparedStatement.setString(11,user.getId());
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

            preparedStatement = connection.prepareStatement(UserQueries.DELETE);

            preparedStatement.setString(1, id);
            return preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return -1;
        }finally {
            close();
        }

    }
    public static List<User> getAll(String query){
        try{
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(null != query &&
                    !query.isEmpty() ? query : UserQueries.GET_ALL);
            return writeResultSet(resultSet);
        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return null;
        }finally {
            close();
        }
    }

    public static List<User> getAllByType(String institutionId, String type){
        try{
            connection = utilities.Connections.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    UserQueries.GET_ALL_BY_TYPE
                            .replace("[ut]", type)
            .replace("[it]", institutionId));
            return writeResultSet(resultSet);
        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return null;
        }finally {
            close();
        }
    }

    public static entities.User getById(String id){
        try{
            connection = utilities.Connections.getConnection();

            preparedStatement = connection.prepareStatement(UserQueries.GET_BY_ID);
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.getResultSet();
            return writeResultSet(resultSet).get(0);
        }catch (SQLException | ClassNotFoundException a){
            a.printStackTrace();
            return null;
        }finally {
            close();
        }
    }
    public static List<entities.User> writeResultSet(ResultSet resultset) throws SQLException{
        List<entities.User> items = new ArrayList<>();
        while (resultset.next()){
            entities.User item = new entities.User();

            item.setId(resultSet.getString("id"));
            item.setName(resultSet.getString("name"));
            item.setSurname(resultSet.getString("surname"));
            item.setUsername(resultSet.getString("username"));
            item.setPassword(resultSet.getString("password"));
            item.setBirthday(resultset.getDate("birthday"));
            if (resultset.getString("gender")
                    .equalsIgnoreCase("F")) {
                item.setGender(Gender.F);
            } else {
                item.setGender(Gender.M);
            }
            item.setAddress(resultSet.getString("address"));
            item.setEmail(resultSet.getString("email"));
            item.setMob(resultSet.getString("mob"));

            items.add(item);



        }
        return items;
    }
}
