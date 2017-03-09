package services;

/**
 * Created by Admin on 3/9/2017.
 */
public class ClassRoomQueries {
    public static String INSERT = "INSERT INTO `classroom`" +
            "(`id`,\n" +
            "`student`,\n" +
            "`subject_id`,\n" +
            "`professor_id`,\n" +
            "`assistant`,\n" +
            "`roomNumber`)\n" +
            "VALUES\n" +
            "(?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?)\n" +
            ";";

    public static String UPDATE = "UPDATE `classroom`" +
            "SET\n" +
            "`student` = ?,\n" +
            "`subject_id` = ?,\n" +
            "`professor_id` = ?,\n" +
            "`assistant` = ?,\n" +
            "`roomNumber` = ?\n" +
            "WHERE `id` = ?;";

    public static String DELETE = "DELETE FROM `classroom`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `classroom`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `classroom`\n" +
            "WHERE id = ?;";
}
