/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrador
 */
public class paqueteData {
    
    public static int getCostoEstadia(int id){
        return 1;
}
    
    public static int getCostoPasaje(int id){
    return pasajeData.getImporte(id);
}
}
