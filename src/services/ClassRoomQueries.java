package services;

/**
 * Created by Admin on 3/9/2017.
 */
public class ClassRoomQueries {
    public static String INSERT = "INSERT INTO `classroom`" +
            "(`id`,\n" +
            "`subject_id`,\n" +
            "`professor_id`,\n" +
            "`assistant`,\n" +
            "`roomNumber`)\n" +
            "VALUES\n" +
            "(?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?,\n" +
            " ?)\n" +
            ";";

    public static String UPDATE = "UPDATE `classroom`" +
            "SET\n" +
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

    public static String GET_ALL_WITH_STUDENTS = "select cr.*, p.*, a.*, pu.*, au.*, s.*\n" +
            "from class_room cr \n" +
            "inner join proffesore p on cr.proffesore_id = p.id\n" +
            "inner join users pu on pu.id = p.user_id\n" +
            "inner join proffesore a on cr.assistent_id = a.id\n" +
            "inner join users au on au.id = a.user_id\n" +
            "inner join class_room_student crt on crt.class_room_id = cr.id\n" +
            "inner join users s on s.id = crt.student_id\n" +
            "order by cr.id;";

    public static String GET_ALL_WITH_STUDENTS_BY_ID = "select cr.*, p.*, a.*, pu.*, au.*, s.*\n" +
            "from class_room cr \n" +
            "inner join proffesore p on cr.proffesore_id = p.id\n" +
            "inner join users pu on pu.id = p.user_id\n" +
            "inner join proffesore a on cr.assistent_id = a.id\n" +
            "inner join users au on au.id = a.user_id\n" +
            "inner join class_room_student crt on crt.class_room_id = cr.id\n" +
            "inner join users s on s.id = crt.student_id\n" +
            "where cr.id = ?\n" +
            "order by cr.id;";
}
