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
import model.vo.ProyectosCasaCampestre;

public class ProyectosCasaCampestreDao {
    //Obtener los proyectos por Tipo en la ciudad de Montería
    public ArrayList<ProyectosCasaCampestre> rankingProyectosCasaCampestre() throws SQLException {

        ArrayList<ProyectosCasaCampestre> respuesta = new ArrayList<ProyectosCasaCampestre>();
        Connection conexion = JDBCUtilities.getConnection();

        try{       

            String consulta =   "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad " +
                                "FROM Proyecto p " +
                                "WHERE ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla') " +
                                "AND Clasificacion = 'Casa Campestre'";
                                
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registros en los VO específicos
            while (resultSet.next()){
                ProyectosCasaCampestre proyectosCasaCampestre = new ProyectosCasaCampestre();
                    proyectosCasaCampestre.setIdProyecto(resultSet.getInt("Id_Proyecto"));
                    proyectosCasaCampestre.setConstructora(resultSet.getString("Constructora"));
                    proyectosCasaCampestre.setNumeroHabitaciones(resultSet.getDouble("Numero_Habitaciones"));
                    proyectosCasaCampestre.setCiudad(resultSet.getString("Ciudad"));

                //Se agrega cada registro como un objeto del ArrayList que contiene la consulta
                respuesta.add(proyectosCasaCampestre);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){
            System.err.println("Error consultando los proyectos de tipo Apartaestudio en Quibdo: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }

    //Retornar la colección de vo's
    return respuesta;
    }     
}
