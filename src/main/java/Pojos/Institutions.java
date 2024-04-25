package Pojos;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement(name="institutions")
public class Institutions {

    private ArrayList<Institution> listInstitutions;

    public Institutions() {
    }

    @XmlElement(name="institution")
    public ArrayList<Institution> getListInstitutions() {
        return listInstitutions;
    }

    public void setListInstitutions(ArrayList<Institution> listInstitutions) {
        this.listInstitutions = listInstitutions;
    }

    @Override
    public String toString() {
        String output ="";
        for (Institution e: this.getListInstitutions()){
            output = output + (e.getName() + "\n");
        }
        return output;
    }
}
