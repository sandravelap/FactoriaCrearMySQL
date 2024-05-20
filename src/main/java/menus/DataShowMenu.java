package menus;

import static libs.Leer.pedirCadena;
import controllers.families.ShowFamilies;

public class DataShowMenu {

    private ShowFamilies showFamilies = new ShowFamilies();

    public void showMenu(){
        String option;
        do {
            System.out.println("Elige una opción: \n" +
                    "1. Mostrar familias profesionales de FP. \n" +
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
            case "1" -> this.showFamilies.showFamilies();
            case "0" -> System.out.println("Volvemos al menú principal. ");
            default -> System.out.println("Opción incorrecta.");
        }
    }

}
