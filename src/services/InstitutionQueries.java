package services;

/**
 * Created by hotelkey on 2/24/17.
 */
public class InstitutionQueries {
    public static String INSERT = "INSERT INTO `institution`\n" +
            "(`id`,\n" +
            "`name`,\n" +
            "`address`,\n" +
            "`email`,\n" +
            "`mob`,\n" +
            "`website`,\n" +
            "`institution_type_id`)\n" +
            "VALUES\n" +
            "(?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?);\n" +
            ";";

    public static String UPDATE = "UPDATE `institution`\n" +
            "SET\n" +
            "`name` = ?,\n" +
            "`address` = ?,\n" +
            "`email` = ?,\n" +
            "`mob` = ?,\n" +
            "`website` = ?,\n" +
            "`institution_type_id` = ?\n" +
            "WHERE `id` = ?;";

    public static String DELETE = "DELETE FROM `institution`\n" +
            "WHERE id = ?;";

    public static String GET_ALL = "SELECT `institution`.`id`,\n" +
            "    `institution`.`name`,\n" +
            "    `institution`.`address`,\n" +
            "    `institution`.`email`,\n" +
            "    `institution`.`mob`,\n" +
            "    `institution`.`website`,\n" +
            "    `institution`.`institution_type_id`\n" +
            "FROM `institution`;";

    public static String GET_BY_ID = "SELECT `institution`.`id`,\n" +
            "    `institution`.`name`,\n" +
            "    `institution`.`address`,\n" +
            "    `institution`.`email`,\n" +
            "    `institution`.`mob`,\n" +
            "    `institution`.`website`,\n" +
            "    `institution`.`institution_type_id`\n" +
            "FROM `institution`\n" +
            "WHERE id = ?;";
}
