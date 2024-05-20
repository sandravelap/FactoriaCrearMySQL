package controllers.families;

import repositories.FamiliesRepository;

public class ShowFamilies {


    public void showFamilies() {
        System.out.println("Mostrando familias profesionales de FP. ");
        FamiliesRepository.showFamilies();
    }
}
