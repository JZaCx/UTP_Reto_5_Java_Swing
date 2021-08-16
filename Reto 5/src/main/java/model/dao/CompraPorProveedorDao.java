package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.CompraPorProveedor;

public class CompraPorProveedorDao {

    public ArrayList<CompraPorProveedor> rankingCompraPorProveedor() throws SQLException {
        //su codigo
        ArrayList <CompraPorProveedor> respuesta = new ArrayList <CompraPorProveedor>();
        Connection conexion = JDBCUtilities.getConnection();

        try {

            String consulta = "SELECT ID_Compra, Proveedor, Constructora, Banco_Vinculado, Ciudad "+
                                "FROM Compra " +
                                "INNER JOIN Proyecto ON Compra.ID_Proyecto = Proyecto.ID_Proyecto " + 
                                "WHERE Ciudad = 'Salento' AND Proveedor = 'Homecenter'";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO especificos
            while (resultSet.next()) {
                CompraPorProveedor compraPorProveedor = new CompraPorProveedor();
                    compraPorProveedor.setIdCompra(resultSet.getInt("Id_Compra"));
                    compraPorProveedor.setProveedor(resultSet.getString("Proveedor"));
                    compraPorProveedor.setConstructora(resultSet.getString("Constructora"));
                    compraPorProveedor.setBancoVinculado(resultSet.getString("Banco_Vinculado"));
                    compraPorProveedor.setCiudad(resultSet.getString("Ciudad"));
                
                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(compraPorProveedor);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error consultado las comprar por proveedor: " + e);
        } finally{
            if(conexion != null){     conexion.close();      }
        }

    return respuesta;
    }
        
}
