package entities;

import entities.AbstractEntity;
public class Subject extends AbstractEntity {

    String name;
    String institutionId;
    String SyllabusId;


    public String getSyllabusId() {
        return SyllabusId;
    }

    public void setSyllabusId(String syllabus) {
        SyllabusId = syllabus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }



}
