/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.*;
import javax.swing.*;

public class Conexion {
    
    private static final String URL="jdbc:mysql://localhost/";
    private static final String DB=""; //nombre de la base de datos
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    
    private static Connection connection;

    public Conexion() {
    }
    
    public static Connection getConexion() {
    
        if (connection == null){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(URL+DB+"?useLegacyDatetimeCode=false&serverTimezone=UTC"+"&user="+USUARIO+"&password="+PASSWORD);
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null , "Error al conectarse a la BD "+ex.getMessage());
            }
            catch(ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null , "Error al cargar los Drivers "+ex.getMessage());
            }
        }
        return connection;
    }
}

