/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diaz.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juan_
 */
public class MensajeDAO {
    public static void crearMensajeDB(Mensaje mensaje){
         Conexion db_connect = new Conexion();
    
       try(Connection conexion = db_connect.get_connection()){
           PreparedStatement ps= null;
           try{
               String query ="INSERT INTO mensaje (mensaje, autor_mensaje) VALUES (?,?)";
               ps = conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setString(2, mensaje.getAutor_mensaje());
              
               ps.executeUpdate();
               System.out.println("Mensaje creado");

           }catch(SQLException ex){
               System.out.println(ex);
           }
       }catch(Exception e) {
           System.out.println(e);
       }
    }
    
    public static void leerMensajeDB(){
         Conexion db_connect = new Conexion();
           PreparedStatement ps= null;
           ResultSet rs = null;
           
       try(Connection conexion = db_connect.get_connection()){
           String query = "SELECT * FROM mensaje";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: "+ rs.getInt("id_mensaje"));
                
                System.out.println("Mensaje: "+ rs.getString("mensaje"));
                
                System.out.println("Autor: "+ rs.getString("autor_mensaje"));
                
                System.out.println("Fecha: "+ rs.getString("fecha_mensaje"));
                
                System.out.println("-----------------------------------------");
            }
       }catch(Exception e) {
           System.out.println(e);
       }
    }
    
    public static void borrarMensajeDB(int id_mensaje){
           Conexion db_connect = new Conexion();
    
       try(Connection conexion = db_connect.get_connection()){
           PreparedStatement ps= null;
           try{
               String query ="DELETE FROM mensaje WHERE id_mensaje = ?";
               ps = conexion.prepareStatement(query);
               ps.setInt(1, id_mensaje);
              
               ps.executeUpdate();
               System.out.println("Mensaje eliminado");

           }catch(SQLException ex){
               System.out.println(ex);
           }
       }catch(Exception e) {
           System.out.println(e);
       }
    }
    
    public static void actualizarMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();
    
       try(Connection conexion = db_connect.get_connection()){
           PreparedStatement ps= null;
           try{
               String query ="UPDATE mensaje SET mensaje = ? WHERE id_mensaje = ?";
               ps = conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setInt(2, mensaje.getId_mensaje());
              
               ps.executeUpdate();
               System.out.println("Mensaje actualizado");

           }catch(SQLException ex){
               System.out.println(ex);
           }
       }catch(Exception e) {
           System.out.println(e);
       }
    }
}
