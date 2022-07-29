/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package diaz.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author juan_
 */
public class Mensajes_app {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int opcion=0;
      do{
          System.out.println("-----------------");
          
          System.out.println("Aplicación de mensajes");
          
          System.out.println("1.crear mensaje");
          
          System.out.println("2. listar mensajes");
          
          System.out.println("3. editar mensaje");
          
          System.out.println("4. eliminar mensaje");
          
          System.out.println("5. Salir");
          
          //leemos la opcion del usuario
          opcion = Integer.parseInt(sc.nextLine());
          
          switch (opcion) {
              case 1:
                  ServicioMensaje.crearMensaje();
                  break;
              case 2:
                  ServicioMensaje.listarMensaje();
                  break;
              case 3:
                  ServicioMensaje.editarMensaje();
                  break;    
              case 4:
                  ServicioMensaje.borrarMensaje();
                  break;
                  
              default:
                  throw new AssertionError();
          }
      }while(opcion!=5);
      
    }
}
