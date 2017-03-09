package entities;

/**
 * Created by Admin on 2/22/2017.
 */
public class Syllabus extends AbstractEntity {
    String literature;
    Institution institution;


    public String getLiterature() {
        return literature;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }


}

