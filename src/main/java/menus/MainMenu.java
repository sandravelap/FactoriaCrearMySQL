package menus;

import static libs.Leer.pedirCadena;

public class MainMenu {

    private StructureMenu structureMenu = new StructureMenu();
    private DataLoadMenu dataLoadMenu = new DataLoadMenu();
    private DataShowMenu dataShowMenu = new DataShowMenu();
    private void processOption(String option){

        switch (option) {
            case "1" -> this.structureMenu.showMenu();
            case "2" -> this.dataLoadMenu.showMenu();
            case "4" -> this.dataShowMenu.showMenu();
            case "0" -> System.out.println("Hasta luego");
            default -> System.out.println("Opción incorrecta.");
        }
    }
    private String askForOption(){
        return pedirCadena("Introduce una opción: ");
    }
    public void showMenu(){
        String option;
        do {
            System.out.println("Elige una opción: \n" +
                    "1. Estructura de la base de datos \n" +
                    "2. Carga datos iniciales (reales) \n" +
                    "3. Carga datos de prueba (inventados) \n" +
                    "4. Consultas de datos\n" +
                    "0. Salir \n");
            option = this.askForOption();
            this.processOption(option);
        }while (!option.equals("0"));
    }
}
