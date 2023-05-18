package Pojos;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement(name="entities")
public class Entities {

    private ArrayList<Entity> listEntities;

    public Entities() {
    }

    @XmlElement(name="entity")
    public ArrayList<Entity> getListEntities() {
        return listEntities;
    }

    public void setListEntities(ArrayList<Entity> listEntities) {
        this.listEntities = listEntities;
    }

    @Override
    public String toString() {
        String output ="";
        for (Entity e: this.listEntities){
            output = output + (e.getName() + "\n");
        }
        return output;
    }
}
