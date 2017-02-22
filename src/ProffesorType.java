import entities.AbstractEntity;

/**
 * Created by LENOVO on 2/22/2017.
 */
public class ProffesorType extends AbstractEntity {
    String type;
    String descripion;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }
}
