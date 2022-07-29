/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diaz.mensajes_app;

import java.util.Scanner;


/**
 *
 * @author juan_
 */
public class ServicioMensaje {
    public static void crearMensaje(){
       Scanner sc = new Scanner(System.in);
        System.out.println("Escriba su mensaje");
        String mensaje = sc.nextLine();
        
        System.out.println("Digite su nombre");
        String nombre = sc.nextLine();
        
        Mensaje registro = new Mensaje();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajeDAO.crearMensajeDB(registro);       
    }
    public static void listarMensaje(){
        MensajeDAO.leerMensajeDB();
    }
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el id que desea eliminar");
        int id_mensaje = sc.nextInt();
        MensajeDAO.borrarMensajeDB(id_mensaje);
    }
    public static void editarMensaje(){
         Scanner sc = new Scanner(System.in);
         System.out.println("Digite el ID que desea actualizar");
       
        int id_mensaje = Integer.parseInt(sc.nextLine());
        
        System.out.println("Digite el mensaje");
        String mensaje = sc.nextLine();
        
        Mensaje actualizacion = new Mensaje();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajeDAO.actualizarMensajeDB(actualizacion);  
    }
}
