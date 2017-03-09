package entities;

import java.util.List;

/**
 * Created by hotelkey on 2/16/17.
 */
public class Institution extends AbstractEntity {
    String name;
    String address;
    String email;
    String mob;
    String website;
    InstitutionType institutionType;
    List<User> students;
    List<User> professors;
    List<User> assistants;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public InstitutionType getInstitutionType() {
        return institutionType;
    }

    public void setInstitutionType(InstitutionType institutionType) {
        this.institutionType = institutionType;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> students) {
        this.students = students;
    }

    public List<User> getProfessors() {
        return professors;
    }

    public void setProfessors(List<User> professors) {
        this.professors = professors;
    }

    public List<User> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<User> assistants) {
        this.assistants = assistants;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", mob='" + mob + '\'' +
                ", website='" + website + '\'' +
                ", institutionType=" + institutionType +
                ", students=" + students +
                ", professors=" + professors +
                ", assistants=" + assistants +
                '}';
    }
}
