package repositories;

import Pojos.Families;
import Pojos.Family;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FamiliesRepository {
    public static void insertFamilies(Families newFamilies){
        //conectamos a la base de datos y preparamos las consultas de inserción y comprobación:
        try (java.sql.Connection con = DataBase.Connection.conectar()) {
            PreparedStatement insFamily = con.prepareStatement("INSERT INTO FAMILY (FamilyCode, FamilyName, FamilyLaw) VALUES (?, ?, ?)");
            PreparedStatement checkCode = con.prepareStatement("SELECT FamilyName FROM FAMILY WHERE FAMILY.FamilyCode LIKE ?");
            for (Family f : newFamilies.getFamilies()) {
                //comprobamos que el código no exista y hacemos los insert
                checkCode.setString(1, f.getFamilyCode());
                ResultSet rs = checkCode.executeQuery();
                if (!rs.next()) {
                    insFamily.setString(1, f.getFamilyCode());
                    insFamily.setString(2, f.getFamilyName());
                    insFamily.setString(3, f.getFamilyLaw());
                    insFamily.executeUpdate();
                }
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showFamilies() {
        try (java.sql.Connection con = DataBase.Connection.conectar()) {
            PreparedStatement showFamilies = con.prepareStatement("SELECT * FROM FAMILY");
            ResultSet rs = showFamilies.executeQuery();
            System.out.println(rs.getString("FamilyName"));
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
