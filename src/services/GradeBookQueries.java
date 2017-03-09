package services;

/**
 * Created by Admin on 3/9/2017.
 */
public class GradeBookQueries {
    public static String INSERT = "INSERT INTO `gradebook`" +
            "(`id`,\n" +
            "`student`,\n" +
            "`professor_id`,\n" +
            "`subject_id`,\n" +
            "`grade`\n" +
            "VALUES\n"+
            "(?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?)\n" +
            ";";

    public static String UPDATE = "UPDATE `gradebook`" +
            "SET\n" +
            "`student` = ?,\n" +
            "`professor_id` = ?,\n" +
            "`subject_id` = ?,\n" +
            "`grade` = ?\n" +
            "WHERE `id` = ?;";

    public static String DELETE = "DELETE FROM `gradebook`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `gradebook`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `gradebook`\n" +
            "WHERE id = ?;";
}
