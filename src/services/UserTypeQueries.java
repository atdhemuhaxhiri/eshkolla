package services;

/**
 * Created by Admin on 3/3/2017.
 */
public class UserTypeQueries {
    public static String INSERT = "INSERT INTO `usertype`\n" +
            "(`id`, \n" +
            "`name`,\n" +
            "`description`), \n" +
            "VALUES\n" +
            "(?, \n" +
            "?, \n" +
            "?,); \n" +
            ";";
    public static String UPDATE = "UPDATE `usertype`\n" +
            "SET\n" +
            "`name` = ?, \n" +
            "`description` = ?, \n" +
            "WHERE `id` = ?,\n";
    public static String DELETE = "DELETE FROM `usertype`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `usertype`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `usertype`\n" +
            "WHERE id = ?;";



}
