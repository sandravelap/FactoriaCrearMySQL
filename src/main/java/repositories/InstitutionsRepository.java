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
                PreparedStatement insInstitution = con.prepareStatement("INSERT INTO INSTITUTION (InstitutionName, IdCategory, InstitutionCode, Web, Email) VALUES (?, ?, ?, ?, ?)");
                //comprobamos que la institución no está insertada
                PreparedStatement checkCode = con.prepareStatement("SELECT InstitutionName FROM INSTITUTION WHERE InstitutionCode LIKE ?");
                //consulta para cambiar el nombre de la categoría por si id
                PreparedStatement getCategory = con.prepareStatement("SELECT Id FROM CATEGORY WHERE CatName LIKE ?");
                for (Institution e : newInstitutions.getListInstitutions()) {
                    //comprobamos que el código no exista y hacemos los insert
                    checkCode.setString(1, e.getCode());
                    ResultSet rs = checkCode.executeQuery();
                    if (!rs.next()) {
                        insInstitution.setString(1, e.getName());
                        insInstitution.setInt(2,getIdCat(e.getCategory(), getCategory));
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
    private static Integer getIdCat(String categoryName, PreparedStatement getCategory) {
        Integer idCat=0;
        try {
            getCategory.setString(1, categoryName);
            ResultSet rs = getCategory.executeQuery();
            if (rs.next()){
                idCat = rs.getInt("Id");
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idCat;
    }
}