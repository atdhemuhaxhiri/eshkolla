package services;

/**
 * Created by PorositWeb on 07-Mar-17.
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
                    "`usertype`,\n" +
                    "`mob`,\n" +
                    "`user_type_id`)\n" +
                    "VALUES\n" +
                    "(?,\n" +
                    " ?,\n" +
                    " ?,\n" +
                    " ?,\n" +
                    " ?,\n" +
                    " ?,\n" +
                    " ?);\n" +
                    " ?);\n" +
                    " ?);\n" +
                    " ?);\n" +
                    " ?);\n" +
                    ";";

    public static String UPDATE = "UPDATE `user`\n" +
            "SET\n" +
            "`name` = ?,\n" +
            "`surname` = ?,\n" +
            "`username` = ?,\n" +
            "`password` = ?,\n" +
            "`birthday` = ?,\n" +
            "`gender` = ?,\n" +
            "`address` = ?,\n" +
            "`email` = ?,\n" +
            "`userType` = ?,\n" +
            "`mob` = ?,\n" +
            "`user_type_id` = ?\n" +
            "WHERE `id` = ?;";

    public static String DELETE = "DELETE FROM `user`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `user`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `user`\n" +
            "WHERE id = ?;";
}
