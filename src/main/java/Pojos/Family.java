package Pojos;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name="family")
@XmlType(propOrder = {"familyName","familyCode", "familyLaw"})
public class Family {
    private String familyName;
    private String familyCode;
    private String familyLaw;

    public Family() {
    }
    @XmlElement(name="name")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @XmlElement(name="code")
    public String getFamilyCode() {
        return familyCode;
    }

    public void setFamilyCode(String familyCode) {
        this.familyCode = familyCode;
    }
    @XmlElement(name="law")
    public String getFamilyLaw() {
        return familyLaw;
    }

    public void setFamilyLaw(String familyLaw) {
        this.familyLaw = familyLaw;
    }

}
