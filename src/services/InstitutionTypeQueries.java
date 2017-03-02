package services;

/**
 * Created by hotelkey on 2/24/17.
 */
public class InstitutionTypeQueries {
    public static String INSERT = "INSERT INTO `institution_type`\n" +
            "(`id`,\n" +
            "`name`,\n" +
            "`department`)\n" +
            "VALUES\n" +
            "(?,\n" +
            " ?,\n" +
            " ?);";

    public static String UPDATE = "UPDATE `institution_type`\n" +
            "SET\n" +
            "`name` = ?,\n" +
            "`department` = ?\n" +
            "WHERE `id` = ?;";

    public static String DELETE = "DELETE FROM `institution_type`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT *\n" +
            "FROM `institution_type`;";

    public static String GET_BY_ID = "SELECT *\n" +
            "FROM `institution_type`\n" +
            "WHERE id = ?;";
}
