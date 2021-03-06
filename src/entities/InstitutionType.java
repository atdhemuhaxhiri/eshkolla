package entities;

/**
 * Created by hotelkey on 2/16/17.
 */
public class InstitutionType extends AbstractEntity {
    String name;
    String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public InstitutionType(String id) {
        this.id = id;
    }

    public InstitutionType() {
    }

    @Override
    public String toString() {
        return "InstitutionType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}