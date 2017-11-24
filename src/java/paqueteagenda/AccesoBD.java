/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteagenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class AccesoBD {
   static void insertarContacto(Contacto c) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
            Statement stmt=conexion.createStatement();
            String sql_insercion="INSERT INTO contactos(nombre, apellido, email) VALUES ('"+c.getNombre()+"', '"+c.getApellido()+"', '"+c.getEmail()+"');";
            stmt.executeUpdate(sql_insercion);
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public  static ArrayList<Contacto> devolverContactos() {
          ArrayList<Contacto> lista_contactos=new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
            Statement stmt=conexion.createStatement();
            String sql="SELECT * FROM contactos";
            ResultSet resultados= stmt.executeQuery(sql);
            while(resultados.next())
            {
             String nombre=resultados.getString("nombre");
             String apellido=resultados.getString("apellido");
             String email=resultados.getString("email");
             Contacto c=new Contacto(nombre, apellido, email);
             lista_contactos.add(c);
            }
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_contactos;
    }

    static ArrayList<Contacto> buscarPorNombre(String nombre_buscado) {
         ArrayList<Contacto> lista_contactos=new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
            Statement stmt=conexion.createStatement();
            String sql="SELECT * FROM contactos WHERE nombre LIKE '%"+nombre_buscado+"%';";
            ResultSet resultados= stmt.executeQuery(sql);
            while(resultados.next())
            {
             String nombre=resultados.getString("nombre");
             String apellido=resultados.getString("apellido");
             String email=resultados.getString("email");
             Contacto c=new Contacto(nombre, apellido, email);
             lista_contactos.add(c);
            }
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_contactos;
    }
}
