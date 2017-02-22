package entities;

/**
 * Created by Admin on 2/22/2017.
 */
public class UserType extends AbstractEntity {
    String name;
    String desctription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesctription() {
        return desctription;
    }

    public void setDesctription(String desctription) {
        this.desctription = desctription;
    }
}
