package services;

/**
 * Created by Admin on 3/9/2017.
 */
public class ProfessorQueries {

    public static String INSERT = "INSERT INTO `professr`\n" +
            "(`id`,\n" +
            "`user`,\n" +
            "`subject_id`,\n" +
            "`year`,\n" +
            "`active`,\n" +
            "`professor_type_id`)\n" +
            "VALUES\n" +
            "(?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?)\n" +
            ";";

    public static String UPDATE = "UPDATE `professor`" +
            "SET\n" +
            "`user` = ?,\n" +
            "`subject_id` = ?,\n" +
            "`year` = ?,\n" +
            "`active` = ?,\n" +
            "`professor_type_id` = ?\n" +
            "WHERE `id` = ?;";

    public static String DELETE = "DELETE FROM `professor`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `professor`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `professor`\n" +
            "WHERE id = ?;";
}
