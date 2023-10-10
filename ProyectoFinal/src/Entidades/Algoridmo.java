package Entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
import java.util.List;
public class Algoridmo {
    
    
        public static List<Object> crearListaPorCondicion( List<Object> lista,Object entidad, Boolean Condicion){
            //crea la lista de objectos segun la condicion
            //import java.util.List;
            if( Condicion==true){
                lista.add(entidad);
            }
            return lista; 
       }
        
       public static void MostrarList(List<Object> entidad) {
        for (Object obj : entidad) {
            System.out.print(obj);
        }
       }

        
        
        
        
        
}
