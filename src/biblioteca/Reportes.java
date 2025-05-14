/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import jxl.write.Label;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class Reportes {
    
    

    static String filePath = "C:\\Users\\Oscar\\OneDrive\\Documentos\\prueba.xls";

  
    public static void reporteLibrosExcel() {
        try {
            Biblioteca biblioteca = new Biblioteca();
            ArrayList<Libro> libros = biblioteca.obtenerLibros();

            WritableWorkbook workbook = Workbook.createWorkbook(new File(filePath));
            WritableSheet sheet = workbook.createSheet("Libros", 0);

            String[] encabezados = {"ID", "Título", "Autor", "Categoría", "Fecha Publicación", "Stock"};

            for (int i = 0; i < encabezados.length; i++) {
                sheet.addCell(new Label(i, 0, encabezados[i]));
            }

            // 4. Escribir los datos
            for (int row = 0; row < libros.size(); row++) {
                Libro libro = libros.get(row);

                sheet.addCell(new Label(0, row + 1, String.valueOf(libro.getId())));
                sheet.addCell(new Label(1, row + 1, libro.getTitulo() != null ? libro.getTitulo() : ""));
                sheet.addCell(new Label(2, row + 1, libro.getAutor() != null ? libro.getAutor() : ""));
                sheet.addCell(new Label(3, row + 1, libro.getCategoria() != null ? libro.getCategoria() : ""));

                String fecha = (libro.getFechaPublicacion() != null) ? libro.getFechaPublicacion().toString() : "";
                sheet.addCell(new Label(4, row + 1, fecha));

                sheet.addCell(new Label(5, row + 1, String.valueOf(libro.getStock())));
            }

            workbook.write();
            workbook.close();

            System.out.println("Reporte de libros generado en: " + filePath);

        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }
    }
    
    
    public static void exportarLibrosMasPrestados() {
       

        try{
            Biblioteca biblioteca = new Biblioteca();
            ArrayList<Libro> libros = biblioteca.librosMasPrestados();
            
            WritableWorkbook workbook = Workbook.createWorkbook(new File(filePath));
            WritableSheet sheet = workbook.createSheet("Más Prestados", 0);

            String[] encabezados = {"ID", "Título", "Total de prestamos"};

            for (int i = 0; i < encabezados.length; i++) {
                sheet.addCell(new Label(i, 0, encabezados[i]));
            }
      
            for (int row = 0; row < libros.size(); row++) {
                Libro libro = libros.get(row);

                sheet.addCell(new Label(0, row + 1, String.valueOf(libro.getId())));
                sheet.addCell(new Label(1, row + 1, libro.getTitulo() != null ? libro.getTitulo() : ""));
                sheet.addCell(new Label(2, row + 1, String.valueOf(libro.getVecesPrestado()))); 
            }

            workbook.write();
            workbook.close();

            System.out.println("Reporte exportado exitosamente a: " + filePath);

        } catch (IOException | WriteException  e) {
            e.printStackTrace();
        }
    }
}
