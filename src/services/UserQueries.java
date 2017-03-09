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

    public static String GET_ALL_BY_TYPE = "select u.*\n" +
            "from users u\n" +
            "inner join user_type ut\n" +
            "on ut.id = u.user_type_id and ut.name = '[ut]'\n" +
            "inner join institution_student ins\n" +
            "on ins.user_id = u.id and ins.institution_id = '[it]';";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `users`\n" +
            "WHERE id = ?;";

}
