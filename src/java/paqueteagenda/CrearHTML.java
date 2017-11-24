/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteagenda;

import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class CrearHTML {
     public static String crearTabla(ArrayList<Contacto> lista_contactos)
 {
     String html="<table><tr><th>Nombre</th><th>Apellido</th><th>Email</th></tr>";
     for(Contacto contacto: lista_contactos)
     {
         String nombre=contacto.getNombre();
         String apellido=contacto.getApellido();
         String email=contacto.getEmail();
         html+="<tr><td>"+nombre+"</td><td>"+apellido+"</td><td>"+email+"</td></tr>";
     }
     html+="</table>";
     return html;
 }
}
