package services;

/**
 * Created by Admin on 3/8/2017.
 */
public class ProfessorTypeQueries {
    public static String INSERT = "INSERT INTO `professortype`\n" +
            "(`id`,\n" +
            "`type`,\n" +
            "`description`)\n" +
            "VALUES\n" +
            "(?,\n" +
            " ?,\n" +
            " ?)\n" +
            ";";
    public static String UPDATE = "UPDATE `professortype`\n" +
            "SET\n" +
            "`type` = ?,\n" +
            "`description` = ?\n" +
            "WHERE `id` = ?;";

    public static String DELETE = "DELETE FROM `professortype`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `professortype`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `professortype`\n" +
            "WHERE id = ?;";
}
