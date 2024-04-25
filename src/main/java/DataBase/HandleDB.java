package DataBase;

import java.sql.SQLException;
import java.sql.Statement;

/**********************************************************************************************************************************************
 *   APLICACIÓN: "Factoría de Proyectos"                                                                                                      *
 **********************************************************************************************************************************************
 *   FACTORÍA DE PROYECTOS  -  Intellij Ultimate IDE v2022.3.2                                                                                *
 **********************************************************************************************************************************************
 *   @author Sandra Vela Pardos - Dep. Informática IES San Alberto Magno                  										              *
 *   @since 11-05-2023                                                                                                                        *
 **********************************************************************************************************************************************
 *   COMENTARIOS:                                                                                                                             *
 *        - Clase HandleDB.                                                                                                                   *
 *        - Clase que contiene métodos para conectar con la base de datos MySQL y modificar la estructura.                                    *
 **********************************************************************************************************************************************/

public class HandleDB {
    public static void  crear() {
        String createTableFamily="CREATE TABLE FAMILY (Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "FamilyCode VARCHAR(20) UNIQUE, FamilyName VARCHAR(70) NOT NULL, FamilyLaw VARCHAR(8))";
        String createTableProject="CREATE TABLE PROJECT (Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "Title VARCHAR(50) NOT NULL UNIQUE, Logo BLOB, Web VARCHAR(100),ProjectDescription TEXT, " +
                "State VARCHAR(20) NOT NULL CHECK(STATE IN('Pendiente','Completado','En Curso')), InitDate DATE, EndDate DATE);";
        String createTableCategories="CREATE TABLE CATEGORY (Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "CatName VARCHAR(70) UNIQUE, ShortCat VARCHAR(7))";
        String createTableInstitution="CREATE TABLE INSTITUTION (Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "InstitutionName VARCHAR(70) NOT NULL, Category VARCHAR(70),ShortCat VARCHAR(7),InstitutionCode VARCHAR(20) UNIQUE, Web VARCHAR(100), Email VARCHAR(70))";
        String createTableUsers ="CREATE TABLE USERS (Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, \n" +
                "Login VARCHAR(50) UNIQUE NOT NULL, UserName VARCHAR(20), Surname VARCHAR(100), " +
                "Email VARCHAR(70), LinkedIn VARCHAR(30), IdInstitution INT UNSIGNED NOT NULL,\n" +
                "FOREIGN KEY (IdInstitution) REFERENCES INSTITUTION (Id))";
        String createTableTechnology="CREATE TABLE TECHNOLOGY (Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "Tag VARCHAR(50) UNIQUE NOT NULL, TechName VARCHAR(70))";
        String createTableFavourite="CREATE TABLE FAVOURITE (Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "IdProject INT UNSIGNED NOT NULL, IdUser INT UNSIGNED NOT NULL, FOREIGN KEY (IdProject) REFERENCES PROJECT (Id), " +
                "FOREIGN KEY (IdUser) REFERENCES USERS (Id))";
        String createTableImplement ="CREATE TABLE IMPLEMENT (Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "IdProject INT UNSIGNED NOT NULL, IdTechnology INT UNSIGNED NOT NULL," +
                "CONSTRAINT fvProjImp FOREIGN KEY (IdProject) REFERENCES PROJECT (Id), " +
                "CONSTRAINT fvTechImp FOREIGN KEY (IdTechnology) REFERENCES TECHNOLOGY (Id))";
        String createTableCollaboration ="CREATE TABLE COLLABORATION (Id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "IdProject INT UNSIGNED NOT NULL,IdUser INT UNSIGNED NOT NULL, IdFamily INT UNSIGNED NOT NULL, IsManager BOOLEAN, " +
                "CONSTRAINT fvProjCol FOREIGN KEY (IdProject) REFERENCES PROJECT (Id),\n" +
                "CONSTRAINT fvUserCol FOREIGN KEY (IdUser) REFERENCES USERS (Id), \n" +
                "CONSTRAINT fvFamCol FOREIGN KEY (IdFamily) REFERENCES FAMILY (Id))";

        try (java.sql.Connection con = Connection.conectar()) {
            if (con != null) System.out.println("conexión establecida");
            try(Statement stmt = con.createStatement()) {
                //stmt.execute("DROP TABLE IF EXISTS LIBRO");
                stmt.execute(createTableFamily);
                stmt.execute(createTableProject);
                stmt.execute(createTableCategories);
                stmt.execute(createTableInstitution);
                stmt.execute(createTableUsers);
                stmt.execute(createTableTechnology);
                stmt.execute(createTableFavourite);
                stmt.execute(createTableImplement);
                stmt.execute(createTableCollaboration);
            }catch(SQLException e){
                System.out.println("Excepción " + e);
            }
        } catch (SQLException e) {
            System.out.println("Excepción " + e);
        }
    }

    public static void borrar() {
        String deleteTableFamily = "DROP TABLE IF EXISTS FAMILY";
        String deleteTableProject="DROP TABLE IF EXISTS PROJECT";
        String deleteTableInstitution="DROP TABLE IF EXISTS INSTITUTION";
        String deleteTableUsers ="DROP TABLE IF EXISTS USERS";
        String deleteTableTechnology="DROP TABLE IF EXISTS TECHNOLOGY";
        String deleteTableFavourite="DROP TABLE IF EXISTS FAVOURITE";
        String deleteTableImplement ="DROP TABLE IF EXISTS IMPLEMENT";
        String deleteTableCollaboration ="DROP TABLE IF EXISTS COLLABORATION";
        try (java.sql.Connection con = Connection.conectar()) {
            if (con != null) System.out.println("conexión establecida");
            try(Statement stmt = con.createStatement()) {
                //stmt.execute("DROP TABLE IF EXISTS LIBRO");
                stmt.execute(deleteTableCollaboration);
                stmt.execute(deleteTableImplement);
                stmt.execute(deleteTableFavourite);
                stmt.execute(deleteTableTechnology);
                stmt.execute(deleteTableUsers);
                stmt.execute(deleteTableInstitution);
                stmt.execute(deleteTableProject);
                stmt.execute(deleteTableFamily);
            }catch(SQLException e){
                System.out.println("Excepción " + e);
            }
        } catch (SQLException e) {
            System.out.println("Excepción " + e);
        }
    }
}
