package repositories;

import Pojos.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriesRepository {
    public static void insertCategories(ArrayList<Category> newCategories) {

        //conectamos a la base de datos y preparamos las consultas de inserción y comprobación:
        try (java.sql.Connection con = DataBase.Connection.conectar()) {
            PreparedStatement insCategory = con.prepareStatement("INSERT INTO CATEGORY (CatName, ShortCat) VALUES (?, ?)");
            PreparedStatement checkCategory = con.prepareStatement("SELECT id FROM CATEGORY WHERE CatName LIKE ?");

            for (Category cat : newCategories) {
                //comprobamos que la categoría no exista y hacemos los insert
                checkCategory.setString(1, cat.getCatName());
                ResultSet rs = checkCategory.executeQuery();
                if (!rs.next()) {
                    insCategory.setString(1, cat.getCatName());
                    insCategory.setString(2, cat.getShortCat());
                    insCategory.executeUpdate();
                }
                rs.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
