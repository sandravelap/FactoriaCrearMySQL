package repositories;

import Pojos.Institutions;
import Pojos.Institution;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstitutionsRepository {

    public static void insertInstitutions(Institutions newInstitutions) {

            //conectamos a la base de datos y preparamos las consultas de inserción y comprobación:
            try (java.sql.Connection con = DataBase.Connection.conectar()) {
                PreparedStatement insInstitution = con.prepareStatement("INSERT INTO INSTITUTION (InstitutionName, Category, InstitutionCode, Web, Email) VALUES (?, ?, ?, ?, ?)");
                PreparedStatement checkCode = con.prepareStatement("SELECT InstitutionName FROM INSTITUTION WHERE InstitutionCode LIKE ?");

                for (Institution e : newInstitutions.getListInstitutions()) {
                    //comprobamos que el código no exista y hacemos los insert
                    checkCode.setString(1, e.getCode());
                    ResultSet rs = checkCode.executeQuery();
                    if (!rs.next()) {
                        insInstitution.setString(1, e.getName());
                        insInstitution.setInt(2,e.getCategory());
                        insInstitution.setString(3, e.getCode());
                        insInstitution.setString(4, e.getWeb());
                        insInstitution.setString(5, e.getEmail());
                        insInstitution.executeUpdate();
                    }
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }

}