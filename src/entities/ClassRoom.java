package entities;

/**
 * Created by Admin on 2/23/2017.
 */
public class ClassRoom extends AbstractEntity {
    User student;
    Subject subject;
    Professor professor;
    Professor assistant;
    int roomNumber;

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Professor getAssistant() {
        return assistant;
    }

    public void setAssistant(Professor assistant) {
        this.assistant = assistant;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
