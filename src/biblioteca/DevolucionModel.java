
package biblioteca;

import java.util.Date;

// CLASE MODELO PARA REALIZAR LA DEVOLUCION DE LOS LIBROS PRESTADOS
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
