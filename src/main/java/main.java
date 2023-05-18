import DataBase.HandleDB;
import DataLoad.CsvToXml;

import java.nio.file.Paths;
import java.util.Scanner;

public class main {
    public static Scanner sc = new Scanner(System.in);
    public static String option;

    public static void main(String[] args) {

        option = showMenu();
        while (!option.equals("fin")) {
            switch (option) {
                case "1":
                    HandleDB.crear();
                    option = showMenu();
                    break;
                case "2":
                    HandleDB.borrar();
                    option = showMenu();
                    break;
                case "3":
                    String pathCsv="src/main/resources/CentrosCFGMyS.csv";
                    CsvToXml.csvTransform(Paths.get(pathCsv));
                    option = showMenu();
                    break;

                default:
                    System.out.println("Opción incorrecta.");
                    option = showMenu();
                    break;
            }
        }
    }
    public static String showMenu(){
        System.out.println("Elige una opción: \n" +
                "1. Crear Base de Datos Factoria \n" +
                "2. Borrar la base de datos FactoriaSVP \n"+
                "3. Cargar centros \n"+
                "Fin. Teclea fin para salir. \n");
        return sc.next();
    }
}
