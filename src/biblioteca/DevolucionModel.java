/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.util.Date;


public class DevolucionModel{
    private String isbn, documentoUsuario;
    private Date fechaDevolucion;

    public DevolucionModel() {
    }

    public DevolucionModel(String isbn, String documentoUsuario, Date fechaDevolucion) {
        this.isbn = isbn;
        this.documentoUsuario = documentoUsuario;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
    
    
    
    
    

    
    
   
}
