package menus;

import controllers.families.InsertFamilies;
import controllers.institutions.InsertCategories;
import controllers.institutions.InsertInstitutions;

import static libs.Leer.pedirCadena;

public class DataLoadMenu {

    private InsertInstitutions insertInstitutions = new InsertInstitutions();
    private InsertFamilies insertFamilies = new InsertFamilies();
    private InsertCategories insertCategories = new InsertCategories();

    public void showMenu(){
        String option;
        do {
            System.out.println("Elige una opción: \n" +
                    "1. Cargar categorías de instituciones. \n" +
                    "2. Cargar institutos con CFGM y/o CFGS. \n" +
                    "3. Cargar familias profesionales de FP. \n" +
                    "0. Salir \n");
            option = this.askForOption();
            this.processOption(option);
        }while (!option.equals("0"));
    }

    private String askForOption(){
        return pedirCadena("Introduce una opción: ");
    }

    private void processOption(String option) {
        switch (option) {
            case "1" -> this.insertCategories.insertCategories();
            case "2" -> this.insertInstitutions.InsertInstitutions();
            case "3" -> this.insertFamilies.InsertFamilies();
            case "0" -> System.out.println("Volvemos al menú principal. ");
            default -> System.out.println("Opción incorrecta.");
        }
    }
}
