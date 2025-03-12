/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class NewClass {
    public static void main(String[] args) throws SQLException{
        Cconexion conexion =  new Cconexion();
        Biblioteca biblioteca =  new Biblioteca();
        ArrayList<Libro> libros = biblioteca.obtenerLibros();
        
        Libro libro = new Libro("spider-man5","oscar","12-13-24",true,false,false,false);
        
        biblioteca.guardarLibro(libro);
        
        biblioteca.obtenerLibros();
        
      System.out.println("-------------------------------------------------------------");
    System.out.printf("| %-4s | %-20s | %-15s | %-10s | %-10s | %-10s |%n", 
                      "ID", "TITULO", "AUTOR", "FECHA", "DISPONIBLE", "DAÑADO");
    System.out.println("-------------------------------------------------------------");

    for (Libro libross : libros) {
        System.out.printf("| %-4d | %-20s | %-15s | %-10s | %-10s | %-10s |%n",
                          libross.getId(), 
                          libross.getTitulo(), 
                          libross.getAutor(), 
                          libross.getfechaPublicacion(), 
                          libross.isDisponible() ? "Sí" : "No",
                          libross.isDaniado() ? "Sí" : "No");
    }
    System.out.println("-------------------------------------------------------------");

        
        
        
    }
}
