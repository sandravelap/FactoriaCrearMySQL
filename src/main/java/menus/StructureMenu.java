package menus;

import DataBase.HandleDB;

import static libs.Leer.pedirCadena;

public class StructureMenu {
    public void showMenu(){
        String option;
        do {
            System.out.println("Elige una opción: \n" +
                    "1. Crear la base de datos \n" +
                    "2. Borrar la base de datos \n" +
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
            case "1" -> HandleDB.crear();
            case "2" -> HandleDB.borrar();
            case "0" -> System.out.println("Volvemos al menú principal.");
            default -> System.out.println("Opción incorrecta.");
        }
    }

}
