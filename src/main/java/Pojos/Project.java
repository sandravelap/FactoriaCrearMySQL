package Pojos;

import java.sql.Date;

public class Project {

    private String managerShortCat;
    private String managerInstName;
    private String title;
    private Date initDate;
    private String managerUserName;
    private String managerUserEmail;
    private String colabShortCat;
    private String colabInstName;

    public Project() {
    }

    public String getManagerShortCat() {
        return managerShortCat;
    }

    public void setManagerShortCat(String managerShortCat) {
        this.managerShortCat = managerShortCat;
    }

    public String getManagerInstName() {
        return managerInstName;
    }

    public void setManagerInstName(String managerInstName) {
        this.managerInstName = managerInstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public String getManagerUserName() {
        return managerUserName;
    }

    public void setManagerUserName(String managerUserName) {
        this.managerUserName = managerUserName;
    }

    public String getManagerUserEmail() {
        return managerUserEmail;
    }

    public void setManagerUserEmail(String managerUserEmail) {
        this.managerUserEmail = managerUserEmail;
    }

    public String getColabShortCat() {
        return colabShortCat;
    }

    public void setColabShortCat(String colabShortCat) {
        this.colabShortCat = colabShortCat;
    }

    public String getColabInstName() {
        return colabInstName;
    }

    public void setColabInstName(String colabInstName) {
        this.colabInstName = colabInstName;
    }
}
