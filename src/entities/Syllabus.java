package entities;

/**
 * Created by Admin on 2/22/2017.
 */
public class Syllabus extends AbstractEntity {
    String literature;
    String institutionId;

    public String getLiterature() {
        return literature;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }
}

