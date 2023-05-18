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

    private static final String SERVER = "jdbc:mysql://fp2.croh1mygfad5.eu-west-3.rds.amazonaws.com/";
    private static final String BD = "FactoriaSVP";
    private static final String USER = "admin";
    private static final String PSSWD = "FP2%SanAlberto";

    public static DataSource poolCon(){
        String URL = SERVER + BD;
        BasicDataSource connectionData = new BasicDataSource();
        connectionData.setUrl(URL);
        connectionData.setUsername(USER);
        connectionData.setPassword(PSSWD);
        connectionData.setInitialSize(10);
        return connectionData;

    }

    public static java.sql.Connection handleDB() throws SQLException {
        BasicDataSource conexionSGBD = new BasicDataSource();
        conexionSGBD.setUrl(SERVER);
        conexionSGBD.setUsername(USER);
        conexionSGBD.setPassword(PSSWD);
        conexionSGBD.setInitialSize(1);
        java.sql.Connection con =  conexionSGBD.getConnection();
        return con;
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
