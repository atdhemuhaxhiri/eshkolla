package entities;

/**
 * Created by Admin on 2/22/2017.
 */
public class UserType extends AbstractEntity {
    String name;
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserType(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public UserType() {
    }
}
