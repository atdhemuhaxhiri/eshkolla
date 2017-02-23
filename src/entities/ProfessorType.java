package entities;

import entities.AbstractEntity;

/**
 * Created by LENOVO on 2/22/2017.
 */
public class ProfessorType extends AbstractEntity {
    String type;
    String description;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
