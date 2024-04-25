package DataBase;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

/**********************************************************************************************************************************************
 *   APLICACIÓN: "Factoría de Proyectos"                                                                                                      *
 **********************************************************************************************************************************************
 *   FACTORÍA DE PROYECTOS  -  Intellij Ultimate IDE v2022.3.2                                                                                *
 **********************************************************************************************************************************************
 *   @author Sandra Vela Pardos - Dep. Informática IES San Alberto Magno                  										              *
 *   @since 11-05-2023                                                                                                                        *
 **********************************************************************************************************************************************
 *   COMENTARIOS:                                                                                                                             *
 *        - Clase ConexionMySQL.                                                                                                              *
 *        - Clase que contiene métodos para conectar con la base de datos MySQL para crear la estructura.                                     *
 **********************************************************************************************************************************************/

public class Connection {

    private static final String SERVER = "jdbc:mysql://54.37.220.4:3306/";
    private static final String BD = "pruebasFP2";
    private static final String USER = "fpuser";
    private static final String PSSWD = "FPuserp@ssw0rd";

    public static DataSource poolCon(){
        String URL = SERVER + BD;
        BasicDataSource connectionData = new BasicDataSource();
        connectionData.setUrl(URL);
        connectionData.setUsername(USER);
        connectionData.setPassword(PSSWD);
        connectionData.setInitialSize(5);
        return connectionData;

    }

    public static java.sql.Connection conectar() throws SQLException{
        return poolCon().getConnection();
    }

    public void desconectar(java.sql.Connection conexion){
        try{
            conexion.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
