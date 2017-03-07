package services;


/**
 * Created by Admin on 3/3/2017.
 */
public class UserQueries {
    public static String INSERT = "INSERT INTO `users`\n" +
            "(`id`,\n" +
            "`name`,\n" +
            "`surname`,\n" +
            "`username`,\n" +
            "`password`,\n" +
            "`birthday`,\n" +
            "`gender`,\n" +
            "`address`,\n" +
            "`email`,\n" +
            "`user_type_id`,\n" +
            "`mob`)\n" +
            "VALUES\n" +
            "(?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?)\n" +
            ";";
    public static String UPDATE = "UPDATE `users`\n" +
            "SET\n" +
            "`name` = ?,\n" +
            "`surname` = ?,\n" +
            "`username` = ?,\n" +
            "`password` = ?,\n" +
            "`birthday` = ?,\n" +
            "`gender` = ?,\n" +
            "`address` = ?,\n" +
            "`email` = ?,\n" +
            "`user_type_id` = ?,\n" +
            "`mob` = ?\n" +
            "WHERE id = ?;";

    public static String DELETE = "DELETE FROM `users`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `users`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `users`\n" +
            "WHERE id = ?;";

}
