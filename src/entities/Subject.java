package entities;

import entities.AbstractEntity;
public class Subject extends AbstractEntity {

    String name;
    Institution institutionId;
    Syllabus SyllabusId;


    public Syllabus getSyllabusId() {
        return SyllabusId;
    }

    public void setSyllabusId(Syllabus syllabus) {
        SyllabusId = syllabus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Institution getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Institution institutionId) {
        this.institutionId = institutionId;
    }



}
