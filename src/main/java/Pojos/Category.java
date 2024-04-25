package Pojos;

public class Category {
    private String CatName;
    private String ShortCat;

    public Category() {
    }

    public Category(String catName, String shortCat) {
        CatName = catName;
        ShortCat = shortCat;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String catName) {
        CatName = catName;
    }

    public String getShortCat() {
        return ShortCat;
    }

    public void setShortCat(String shortCat) {
        ShortCat = shortCat;
    }

}
