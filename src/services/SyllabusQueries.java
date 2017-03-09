package services;

/**
 * Created by Admin on 3/4/2017.
 */
public class SyllabusQueries {
    public static String INSERT = "INSERT INTO `syllabus`\n" +
            "(`id`,\n" +
            "`literature`,\n" +
            "`institution`)\n" +
            "VALUES\n" +
            "(?,\n" +
            " ?,\n" +
            " ?)\n" +
            ";";
    public static String UPDATE = "UPDATE `syllabus`" +
            "SET\n" +
            "`literature` = ?,\n" +
            "`institution` = ?,\n" +
            "WHERE `id` = ?;";
    public static String DELETE = "DELETE FROM `syllabus`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `syllabus`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `syllabus`\n" +
            "WHERE id = ?;";

}
