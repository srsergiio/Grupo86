/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import java.util.Date;
import Entidades.*;
import Entidades.Alojamiento;
import Entidades.Ciudad;
import Entidades.Paquete;

public class main {
    Date f1 = new Date(2023, 11, 23);
    Date f2 = new Date(2024,2,23);
   Ciudad c1 = new Ciudad(1,"Ciudad de Buenos Aires","Argentina",true,"buenos Aires"); 
   Ciudad c2 = new Ciudad(1,"Ciudad de Cordoba","Argentina",true,"Cordoba");
   Alojamiento depto= new Alojamiento(098,f1,f2,true,"ninguno",16,c2);
   
   Paquete p1 = new Paquete(001,c1,c2,);
   //holap
   //hola 
}
