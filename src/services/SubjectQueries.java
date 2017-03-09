package services;

/**
 * Created by Admin on 3/8/2017.
 */
public class SubjectQueries {
    public static String INSERT = "INSERT INTO `subject`\n" +
            "(`id`,\n" +
            "`name`,\n" +
            "`institution_id`,\n" +
            "`syllabus_id`)\n" +
            "VALUES\n" +
            "(?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?)\n" +
            ";";
    public static String UPDATE = "UPDATE `subject`\n" +
            "SET\n" +
            "`name` = ?,\n" +
            "`institution_id` = ?,\n" +
            "`syllabus_id` = ?\n" +
            "WHERE `id` = ?;";

    public static String DELETE = "DELETE FROM `subject`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `subject`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `subject`\n" +
            "WHERE id = ?;";

}
