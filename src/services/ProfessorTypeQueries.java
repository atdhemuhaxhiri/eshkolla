package services;

/**
 * Created by Admin on 3/8/2017.
 */
public class ProfessorTypeQueries {
    public static String INSERT = "INSERT INTO `professor_type`\n" +
            "(`id`,\n" +
            "`type`,\n" +
            "`description`)\n" +
            "VALUES\n" +
            "(?,\n" +
            " ?,\n" +
            " ?)\n" +
            ";";
    public static String UPDATE = "UPDATE `professor_type`\n" +
            "SET\n" +
            "`type` = ?,\n" +
            "`description` = ?\n" +
            "WHERE `id` = ?;";

    public static String DELETE = "DELETE FROM `professor_type`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `professor_type`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `professor_type`\n" +
            "WHERE id = ?;";
}
