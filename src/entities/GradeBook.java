package entities;

/**
 * Created by Lanti on 23/2/2017.
 */
public class GradeBook extends AbstractEntity {
    String student_id;
    String proffesore_id;
    String subject_id;
    int    grade;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getProffesore_id() {
        return proffesore_id;
    }

    public void setProffesore_id(String proffesore_id) {
        this.proffesore_id = proffesore_id;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }




}
